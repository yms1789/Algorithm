## 🌀 주식

- 문제 유형(목록): 그리디(백준)

- 초기 구현

  - 처음에는 주식이 떨어지기 전까지의 구간을 찾아서 그 구간의 마지막 날짜에 갖고
    있는 모든 주식을 파는 것을 주식 배열 끝까지 진행해 나갈 계획이었음(but, 상당
    히 어려워보임...)
  - 아이디어를 찾아보니 주식 배열 뒤부터 시작해서 앞까지 가면서 값을 판단하라고
    함

- Solution
  - 주식 배열의 가장 끝을 `maxNum`으로 둠
  - 배열의 0번째 인덱스까지 탐색하면서 `maxNum`보다 큰 값이 나오면 해당 값을
    `maxNum`으로 바꿔주고
  - `maxNum`보다 작거나 같다면 `maxNum - stock[i]`한 값(가장 이익이 큰 시점에 주
    식을 판 가격)을 `answer`에 더해줌
  - 배열 끝까지 탐색하면 `answer`를 출력
