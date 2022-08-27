## 🌀 같은 숫자는 싫어

- 문제 유형: 스택 / 큐
- Solution
  1. arr의 첫번째 값을 뽑아서 다른 배열에 넣는다.
  2. arr의 다음 값과 다른 배열의 마지막 값을 서로 비교
      - 같으면, 아무 것도 하지 않는다
      - 다르다면, 다른 배열에 해당 값을 집어 넣는다.
  ```jsx
  // filter를 이용한 다른 풀이
  function solution(arr) {
    return arr.filter((val,index) => val != arr[index+1]);
  }
  ```