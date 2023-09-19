## 숫자 야구 기능 목록
### 1. 랜덤한 숫자 생성
- 서로 다른 세 자리 수
- 1부터 9까지의 수로 이루어 짐
- `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용

### 2. 사용자 숫자 입력
- 서로 다른 세 자리 수
- 1부터 9까지의 수로 이루어 짐
- `camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용

### 3. 입력한 수에 대한 결과 출력
- 같은 수가 같은 자리에 있으면 **스트라이크**
- 같은 수가 다른 자리에 있으면 **볼**
- 같은 수가 전혀 없으면 **낫싱**

### 4. 재시작 및 종료
- **3스트라이크** 일 때 게임 종료
- 잘못된 값을 입력할 경우 `IllegalArgumentException`발생 후 종료
- 1 입력 시 **재시작**
- 2 입력 시 **종료**