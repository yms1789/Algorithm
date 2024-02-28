## 🌀 주유소

- 문제 유형(목록): 그리디(백준)
- 혼자 힘으로 풀었는지 여부: ⭕️
- Solution
  - 가장 왼쪽 도시에서 오른쪽 도시까지 이동 할 때 주유 비용이 최소가 되는 경우를 찾는 문제
  - 현재위치와 다음 위치를 `[0, 1]`로 초기화 시켜준 후
  - 다음 위치를 한 칸씩 옮겨주면서 주유 비용을 계산하자
  - 현재위치의 주유 비용이 다음 위치의 주유 비용보다 크다면 현재 위치를 다음 위치로 옮긴 다음 해당 위치에서 주유하자(`cur = next`)
  - 위 과정을 마지막 도로 전까지 반복
  - 마지막 도로는 다음 도시의 비용과 관계 없이 이전 도시에서 주유해야 하므로
    `sum += 현재 위치 주유 비용 * 다음 도시 까지의 도로 길이`
  - but, "틀렸습니다"가 출력
  - 해결 방법
    - 도로 길이, 주유 가격이 최대 10억 이상임
    - 도시 개수가 최대 100,000이고 모든 도시에서 주유 비용이 10억, 도시 별 도로 길이도 모두 10억이면
      - $10억 * 10억 * 99,999 > 2^53 - 1$
    - js에서 $2^53 - 1$보다 큰 정수를 표현하려면 BigInt 내장 객체를 사용해야 함!
    - 단, BigInt변수를 출력하면 끝에 n이 붙으므로 출력 시에는 String으로 변경시켜서 출력!

- 다른 사람 풀이

  ```js
    let fs = require('fs');
    let input = fs.readFileSync('/dev/stdin').toString().split('\n');
    let n = Number (input[0]);
    let dist = input[1].split(' ').map(Number);
    let cost = input[2].split(' ').map(Number);
    let minCost = cost[0];

    // 해당 풀이는 아예 각 위치에서의 주유 비용을 계산해서 최소가 되게끔 바꿔줌
    // 주유 비용이 5, 2, 4, 1이라면
    // [5, 2, 4, 1] -> [5, 2, 2, 1]
    for (let i = 0; i < n; i++) {
    minCost = Math.min(minCost, cost[i]);
    cost [i] = minCost;
    }
    // 도로당 이동 비용의 합 계산
    let answer = BigInt(0);
    for (let i = 0; i < n - 1; i++) {
      answer += BigInt(dist[i]) * BigInt(cost[i]);
      console.log(String(answer));
    }
  ```
  