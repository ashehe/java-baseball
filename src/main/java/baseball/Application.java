package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static String generateRandomNumber() { // 랜덤한 숫자 생성
        StringBuilder randomNumber = new StringBuilder("");
        randomNumber.append(pickNumberInRange(1, 9));
        randomNumber.append(pickNumberInRange(1, 9));
        randomNumber.append(pickNumberInRange(1, 9));
        String answer = randomNumber.toString();
        return answer;
    }

    public static boolean isGuessThreeDigits(String guess) { // 입력이 세 자리수인지 검사
        boolean threeDigits = false;
        if (guess.length() == 3) {
            threeDigits = true;
        }
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
        boolean isGuessValid = threeDigits && oneToNine && AllDistinct;
        if (!isGuessValid) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return isGuessValid;
    }

    public static void main(String[] args) {
        generateRandomNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String guess = readLine();
    }
}
