package baseball;

import camp.nextstep.edu.missionutils.Randoms;

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

    public static void main(String[] args) {
        generateRandomNumber();
    }
}
