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

## 🌀 Udemy JavaScript 알고리즘 & 자료구조 마스터클래스

### 섹션 8 재귀 문제 집합

**1. power**

- 밑과 지수를 입력받아 거듭제곱한 결과를 리턴하는 문제(단, `Math.pow()` 사용 금지!)
  ```jsx
  power(2, 0); // 1
  power(2, 2); // 4
  power(2, 4); // 16
  ```
  **2. factorial**
- 숫자를 입력받아 숫자의 팩토리얼을 리턴하는 문제(단, `factorial(0)`은 항상 1)

  ```jsx
  factorial(1); // 1
  factorial(2); // 2
  factorial(4); // 24
  factorial(7); // 5040
  ```

- solution
  - 재귀를 이용해서 입력받은 값이 1 보다 클 때 까지 값을 1씩 빼면서 곱해나감
  - 입력 값이 1 이하의 값(0, 1)이면 1을 리턴, 0 보다 작으면 0을 리턴

**3. productOfArray**

- 배열을 입력받아 배열 내 요소를 모두 곱한 값을 리턴하는 문제(단, 재귀를 사용할 것!)

  ```jsx
  productOfArray([1, 2, 3]); // 6
  productOfArray([1, 2, 3, 10]); // 60
  ```

- solution
  - 배열의 길이가 0이 될 때 까지 재귀를 이용해서 배열의 끝을 1씩 잘라가면서 잘린 값을 더해나감

**4. recursiveRange**

- 숫자를 입력 받아서 0부터 해당 값까지의 수를 모두 더하는 문제

  ```jsx
  recursiveRange(6); // 21
  recursiveRange(10); // 55
  ```

**5. fib**

- 입력받은 숫자 번째 피보나치 수를 리턴하는 문제
  ```jsx
  fib(4); // 3
  fib(10); // 55
  fib(28); // 317811
  fib(35); // 9227465
  ```
- solution
  - 피보나치 수의 첫 번째 두번 째 수는 항상 1임을 이용
  - 입력 받은 숫자 - 2 과 입력 받은 숫자 - 2를 함수의 파라미터로 해서 값을 찾음
  - `return fib(num - 1) + fib(num - 2);`