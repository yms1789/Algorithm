## 🌀 최댓값과 최솟값

- 문제 유형: 문자열
- solution

  - 입력받은 문자열을 띄어쓰기를 기준으로 숫자 배열로 나눈다
  - 배열 내 값을 전개 구문을 사용해서 펼친 뒤 요소의 최소, 최댓값을 구한다.
  - 구한 최대, 최소를 문자열에 공백과 함께 추가한다.

- 다른 사람 풀이

  ```jsx
  function solution(s) {
    const arr = s.split(" ");

    return Math.min(...arr) + " " + Math.max(...arr);
  }
  ```

  - 문자열도 `min`, `max`가 된다!
