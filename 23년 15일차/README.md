## 🌀 연구소

- 문제유형(목록): 스택(백준)
- Solution
  - 입력 받은 값이 여는 괄호("(")라면 stack에 삽입
  - 입력 받은 값이 닫는 괄호(")")라면 stack에서 여는 괄호 하나 `pop()`
    - 입력받은 값의 바로 이전 값이 "(" 라면? -> 레이저이므로 스택에 있는 여는 괄호만큼 result에 더해줌
    - 이전 값이 ")"라면 쇠막대기가 끝나는 지점임
      - 레이저로 잘렸으니 result + 1
  - 위 과정을 입력받은 문자열 길이만큼 반복

## 🌀

- 문제유형(목록): 스택(백준)
- Solution

  - 1부터 n까지 반복하면서 스택에 값을 삽입(+)
  - 수열의 인덱스를 저장할 `fill`
  - 삽입하면서 수열의 `fill`번째 값과 같다면 해당 값을 `pop()` 하고 `fill`을 1증가시킴(-)

    - `pop()`한 후 스택에 가장 상위에 있는 값이 수열의 다음 인덱스라면 해당 값도 같이 `pop()` 해줘야 함

      => While문을 통해 수열 다음 인덱스 값과 스택 최상단 값이 다를 때 까지 `pop()`

  - 위 과정을 거쳤을 때 stack에 남아 있는 값이 있다면 입력 받은 수열은 만들 수 없는 수열("NO")
  - 비어있다면 `push, pop` 순서 출력
