## 🌀 A → B

- 문제 유형(목록): 그리디, 너비 우선 탐색(백준)
- 혼자 힘으로 풀었는지 여부: ⭕️
- Solution
  - 초기 구현
    - 큐에 [현재 값, 카운트]를 계속해서 저장해나감
    - 큐에서 현재 값을 빼서 현재 값의 가장 오른쪽에 1을 추가한 수, 현재 값에 2를 곱한 수를 `next`로 둠
    - 이 때, `next`값이 `B`랑 같으면 현재 `count`를 리턴
    - 만약 `B`보다 큰 수면 큐에 넣지 않고 작은 수인 경우만 큐에 계속해서 추가해나감
    - 큐가 빌 때까지 반복하는데 반복이 끝났는 데도 `B`랑 같은 값이 되지 않았더면 `A`는 `B`가 될 수 없는 숫자이므로 -1 출력

  - 다른 풀이(너비 우선 탐색 사용 X)
    - B에서 A를 만들기
      - 연산이 2가지(곱하거나, 끝자리에 1추가하거나)임
      - 반대로 하면서 `count`를 증가시키자!(2로 나누어 떨어지면 / 2, 끝자리가 1이면 1의자리 수 빼기)
      - B가 A보다 클 때까지 위 과정을 반복하면서 `A`랑 `_B`가 같아지면 `count`를 출력, 다르다면 -1

    ```js
      const fs = require("fs");
      const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
      const stdin = fs.readFileSync(filePath).toString().trim();

      const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

      let [A, B] = input[0];

      let _B = B + "";
      let count = 1;
      let flag = false;
      while (A <= Number(_B)) {
        if (A == _B) {
          flag = true;
          break;
        }
        _B = _B + "";
        if (_B % 2 === 0) {
          _B = parseInt(_B / 2);
        } else if (_B.at(-1) === "1") {
          _B = parseInt(_B / 10);
        } else {
          break;
        }
        count++;
      }

      console.log(flag ? count : -1);
    ```
