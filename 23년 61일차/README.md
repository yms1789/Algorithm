## 🌀 카드 정렬하기

- 문제 유형(목록): 우선순위 큐, 그리디(백준)

- 초기 구현

  ```js
  const fs = require("fs");
  const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
  const stdin = fs.readFileSync(filePath).toString().split("\n");

  const input = stdin.map((ele) => Number(ele));

  const N = input.shift();

  input.sort((a, b) => b - a);

  let answer = 0;
  while (input.length > 1) {
    let [a, b] = [input.pop(), input.pop()];
    answer += a + b;
    for (let j = input.length - 1; j >= 0; j--) {
      if (input[j] >= a + b) {
        input.splice(j, 0, a + b);
        break;
      }
    }
    input.splice(0, 0, a + b);
  }
  ```

  - 입력 값을 내림차순 정렬한 뒤 작은 값 두개를 pop해서 더한 값을 answer에 저장
  - input배열을 뒤쪽부터 순회하면서 빼낸 두 값을 더한 값보다 큰 값이 나왔을 때 그 뒤에 더한 값을 추가
  - 더한 값이 제일 크다면 배열의 첫번째에 더한 값 추가

  - 결과: 시간초과 (N이 최대 10만이라서 N^2의 알고리즘으로는 해결이 불가능)

- 해결 방법
  - 최소 힙을 직접 구현함
  - 나머지 로직은 위 코드랑 동일(작은 값 2개 빼서 더한 값 저장, 다시 더한 값을 힙에 추가)
