## 🌀 외판원 순회 2

- 문제 유형(목록): 경우의 수, 백트래킹(백준)
- 혼자 힘으로 풀었는지 여부: ⭕️
- Solution
  - a → b로가는 비용과 도시의 개수가 주어졌을 때 어떤 도시에서부터 모든 도시를 순회해서 되돌아오는 최소 비용을 구하는 문제
  - 재귀를 통해 모든 도시를 경유해서 처음 도시까지 오는 경우의 수를 구해서 `arr`에 저장함
    - 이 때, 기존에 들렀던 도시는 더 이상 들르지 않아도 되므로 `visited` 배열을 통해 방문 여부 판단
  - 모든 도시를 다 경유했다면 도시 순서대로 이동했을 때 비용들을 모두 계산
    - 이 때, 이동하지 못하는 도시(`input[cc][nn](cc에서 nn으로 이동)`)가 중간에 끼어있다면 해당 경우의 수는 버림
  - 모든 경우의 수에서 최소가 되는 비용을 구해서 출력

- 더 좋은 풀이
  - 순회 가능한 경우로만 입력이 주어짐(즉, 내가 임의로 시작 노드를 지정해도 무방하다. 어차피 모든 노드를 순회해야 하므로)
    - if) 1번 노드부터 무조건 시작한다고 가정했을 때 2 ~ N까지의 수를 골라 나열하는 모든 순열을 계산하는 문제로 바뀜
  - 소스코드
    ```js
      let minCost = Number.MAX_VALUE;
      let visited = Array(N).fill(false);

      function dfs(depth, arr) {
        if (depth === N - 1) {
          let total = 0;
          let cur = 0;
          for (let i = 0; i < N - 1; i++) {
            let next = arr[i];
            let cost = input[cur][next];
            if (cost === 0) return;
            total += cost;
            cur = next;
          }
          let cost = input[cur][0];
          if (cost === 0) return;
          total += cost;
          minCost = Math.min(total, minCost);
        }

        for (let i = 1; i < N; i++) {
          if (visited[i]) continue;
          arr.push(i);
          visited[i] = true;
          dfs(depth + 1, arr);
          arr.pop();
          visited[i] = false;
        }
      }

      dfs(0, []);

      console.log(minCost);
    ```