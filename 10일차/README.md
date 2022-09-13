## 🌀 내적

- 문제 유형: 수학
- solution
  - a 배열의 각 요소들과 b 배열의 요소들을 곱해서 서로 더하면 되는 문제
  - 반복문을 사용해서 a, b의 i번째 인덱스끼리 곱한 값을 더해서 리턴
  
- 다른 사람 풀이
  ```jsx
  function solution(a, b) {
    return a.reduce((acc, _, i) => (acc += a[i] * b[i]), 0);
  }
  ```
  - `reduce` 메소드를 사용해서 변수 `acc`에 각 배열 요소들의 값을 더해서 리턴해줌
