## 🌀 숫자 게임

- 문제 유형(목록): 그리디(프로그래머스)
- Solution
  - 초기 접근
    - B배열을 순열을 통해 모든 경우의 수를 도출
    - A배열과 비교해서 가장 많이 이겼을 때의 승점을 출력하고자 함
      ```js
      function perm(arr, index) {
        if (index === B.length) {
          let winPoint = 0;
          for (let i = 0; i < B.length; i++) {
            if (A[i] < B[i]) {
              winPoint++;
            }
          }
          answer = Math.max(answer, winPoint);
          return;
        }
        for (let i = index; i < A.length; i++) {
          [arr[index], arr[i]] = [arr[i], arr[index]];
          perm(arr, index + 1);
          [arr[index], arr[i]] = [arr[i], arr[index]];
        }
      }
      ```
    - 문제점: 입력받은 배열의 길이가 100,000이라서 해당 방법을 사용하면 시간초과가 발생
  - 해결방법
    - 그리디로 접근
    - A배열은 이미 순서가 정해져있음
    - B 배열에서 A배열의 순서에 해당하는 값과 가장 근접하면서 큰값을 해당 순서에 내면 승점을 가장 많이 챙길 수 있음
    - A 배열은 내림차순으로 정렬, B 배열은 오름차순으로 정렬
    - A의 원소와 B의 가장 큰 값(`B[B.length - 1]`)과 비교해서 A원소보다 B의 가장 큰 값이 더 크다면 B에서 가장 큰 값을 제거(`bIdx--`), 승점 1점 증가(`answer + 1`)
    - 위 과정을 A의 모든 원소가 순회할 수 있도록 반복한 후 `answer` return