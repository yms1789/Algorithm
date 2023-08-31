## 🌀 주식가격

- 기존 풀이

  ```js
  for (let i = 0; i < prices.length; i++) {
    if (stack.length > 0) {
      if (stack[stack.length - 1][0] > prices[i]) {
        let [price, idx] = stack.pop();
        answer[idx] = i - idx;
      }
      stack.push([prices[i], i]);
    }
    if (stack.length <= 0) {
      stack.push([prices[i], i]);
    }
  }

  stack.forEach((ele) => {
    answer[ele[1]] = prices.length - stack.length + ele[1];
  });
  ```

  - 문제점
    - 떨어진 주식 가격만 몇 초간 안떨어졌는지 판단 가능
    - 끝까지 가격이 안떨어진 주식에 대한 시간이 이상함

- Solution
  - `answer`배열에 prices 인덱스의 내림차순 배열 생성 ex) `prices`의 길이가 5라면 `answer = [4, 3, 2, 1, 0]`
  - 주식의 해당 시점에 떨어졌는지 안떨어졌는지를 판단해야 하므로 prices의 길이만큼 반복하면서 스택에 넣을 주식 판단
    - 스택에는 주식의 인덱스를 저장
    - 스택의 마지막에 있는 주식의 가격이 현재 시점의 주식 가격보다 크다면(주식 가격이 떨어졌다면)
      - 스택이 남아있고 스택 끝의 주식 가격이 현재 시점의 주식가격보다 클 때 까지 반복
        - 떨어진 시점을 저장(`answer[해당 인덱스] = 현재 인덱스 - 해당 인덱스`)
        - 스택에서 해당 주식의 인덱스 `pop()`
