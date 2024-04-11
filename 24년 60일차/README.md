## 🌀 텀 프로젝트

- 문제 유형(목록): 깊이 우선 탐색, (백준)
- 혼자 힘으로 풀었는지 여부: ❌
- Solution
  - 초기 코드

    ```js
      for (let i = 0; i < input.length - 1; ) {
      let [N] = input[i + 1];
      let numbers = input[i + 2];
      i += 2;

      let result = [];

      for (let j = 1; j <= N; j++) {
        let visited = Array(N + 1).fill(false);
        visited[j] = true;
        dfs(j, team[j][0], team, [], visited, result);
      }

      console.log(N - [...new Set(result)].length);
    }
    function dfs(start, cur, team, arr, visited, result) {
      if (cur === start) {
        if (arr.length === 0) {
          result.push(cur);
        } else {
          result.push(start, ...arr);
        }
        return;
      }
      if (!visited[cur]) {
        arr.push(cur);
        visited[cur] = true;
        dfs(start, team[cur][0], team, arr, visited, result);
      }
    }
    ```

  - 1번 노드부터 N번 노드까지 방문하면서 더 이상 방문할 노드가 없을 때까지 반복
  - 시작 노드를 기점으로 다음 노드가 시작 노드와 같을 때
    - 배열의 길이가 0(자기 혼자 팀 하는 경우)이면 해당 노드 번호를 `result`에 `push`
    - 0이 아니라면 배열에 있는 모든 노드가 사이클을 이루고 있으므로 `result`에 `arr`과 시작노드 `push`
  - 결과: **메모리 초과**

  - 해결방법
    - 방문 처리(`visited`)를 위한 배열과 해당 노드의 인접 노드에 더 이상 방문할 곳이 없는(`finished`) 배열을 둠
    - 노드들을 방문하면서 다음 노드가 방문 조차 안했다면 다음 노드를 방문(`dfs` 재귀)
    - 다음 노드가 방문 처리는 되어있지만 인접 노드들이 아직 방문 처리가 안되어 있다면
      - 다음 노드가 현재 노드 번호랑 같을 때까지 반복(사이클 찾기)
      - 반복 끝나면 해당 노드는 완료 처리
    - 위 과정을 반복하면서 사이클에 포함되는 노드 숫자를 1씩 늘려간다.
