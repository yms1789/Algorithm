## 🌀 프린터 큐

- 문제 유형(목록): 자료구조, 스택(백준)
- 혼자 힘으로 풀었는지 여부: ⭕️
- Solution
  - 스택의 각 메서드들을 실제 입력받는 명령어에 따라 구현하는 문제
  - `switch, case`문을 통해서 명령어를 구분
    - push라면 `result`에 입력받은 숫자를 `push`
    - pop이라면 `stack`의 가장 끝(위)부분을 `pop`하고 `result`에 `push`
    - top이면 `stack`의 마지막 값을 확인해서 `result`에 `push`
    - empty면 `stack`길이 확인 후 0 또는 1 `push`
    - size면 `stack` 길이를 `result`에 `push`
