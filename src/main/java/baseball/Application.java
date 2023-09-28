package baseball;

import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        game();
    }

    public static void game() { // 게임 한 판
        boolean threeStrike = false;
        String answer = generateRandomNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (!threeStrike) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                String guess = readLine();

                boolean threeDigits = isGuessThreeDigits(guess);
                boolean oneToNine = areAllDigitsOneToNine(guess);
                boolean AllDistinct = areAllDigitsDistinct(guess);
                boolean isGuessValid = isGuessValid(threeDigits, oneToNine, AllDistinct);

                String hint = printHint(isGuessValid, answer, guess);
                System.out.println(hint);
                if (hint.equals("3스트라이크")) {
                    threeStrike = true;
                    endOfGame();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다.");
                System.exit(0);
            }
        }
    }

    public static String generateRandomNumber() { // 랜덤한 숫자 생성
        StringBuilder randomNumber = new StringBuilder();
        int n1 = pickNumberInRange(1, 9);
        int n2;
        int n3;
        while (true) {
            n2 = pickNumberInRange(1, 9);
            if (n1 != n2) {
                break;
            }
        }
        while (true) {
            n3 = pickNumberInRange(1, 9);
            if (n3 != n1 && n3 != n2) {
                break;
            }
        }
        randomNumber.append(n1);
        randomNumber.append(n2);
        randomNumber.append(n3);
        String answer = randomNumber.toString();
        return answer;
    }

    public static boolean isGuessThreeDigits(String guess) { // 입력이 세 자리 수인지 검사
        boolean threeDigits = (guess.length() == 3);
        return threeDigits;
    }

    public static boolean areAllDigitsOneToNine(String guess) { // 각 자리가 1과 9 사이의 수인지 검사
        boolean oneToNine = true;
        for (int i = 0; i < 3; i++) {
            if (Character.getNumericValue(guess.charAt(i)) < 1 || Character.getNumericValue(guess.charAt(i)) > 9) {
                oneToNine = false;
                break;
            }
        }
        return oneToNine;
    }

    public static boolean areAllDigitsDistinct(String guess) { // 서로 다른 수로 이뤄져 있는지 검사
        boolean AllDistinct = true;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (Objects.equals(guess.charAt(i), guess.charAt(j))) {
                    AllDistinct = false;
                    break;
                }
            }
        }
        return AllDistinct;
    }

    public static boolean isGuessValid(boolean threeDigits, boolean oneToNine, boolean AllDistinct) { // 세 조건을 모두 만족하는 입력인지 검사
        return threeDigits && oneToNine && AllDistinct;
    }

    public static String printHint(boolean isGuessValid, String answer, String guess) { // 입력에 따라 힌트 또는 에러메시지 출력
        String hint = "";
        if (isGuessValid) {
            hint = resultOfGuess(answer, guess);
        } else {
            throw new IllegalArgumentException();
        }
        return hint;
    }

    public static String resultOfGuess(String answer, String guess) { // 스트라이크, 볼 개수 계산
        int strike = 0;
        int ball = 0;
        String result = "";

        for (int i = 0; i < 3; i++) {
            int index = guess.indexOf(answer.charAt(i));
            if (answer.charAt(i) == guess.charAt(i)) {
                strike += 1;
            } else if (index != -1) {
                ball += 1;
            }
        }

        if (strike > 0 && ball > 0) {
            result = strike + "스트라이크 " + ball + "볼";
        } else if (strike > 0 && ball == 0) {
            result = strike + "스트라이크";
        } else if (strike == 0 && ball > 0) {
            result = ball + "볼";
        } else {
            result = "낫싱";
        }
        return result;
    }

    public static void endOfGame() { // 1을 입력하면 재시작, 2를 입력하면 종료
        System.out.println("3개 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String retryOrExit = readLine();
        if (retryOrExit.equals("1")) {
            game();
        }
        if (retryOrExit.equals("2")) {
            System.exit(0);
        }
    }
}
