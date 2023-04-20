## 🌀 이중 우선순위 큐

- 문제 유형(목록): 자료구조(프로그래머스)
- solution
  - operation에서 명령어와 숫자를 나눔(`command = operation.slice(0, 1)`, `number = operation.slice(2)`)
  - command가 I면 큐에 삽입
  - command가 D일 때
    - 큐가 비었으면 넘김
    - 큐가 안비었다면
      - 숫자가 1이면
        - 큐에서 가장 큰 값을 찾아서 그 값을 큐에서 제거
      - -1이면
        - 큐에서 가장 작은 값을 찾아서 해당 값을 큐에서 제거
  - 큐에 남은 값이 없다면 `[0, 0]` return
  - 큐에 남은 값이 있다면 가장 작은 값과 큰 값을 return

## 🌀 이중 우선순위 큐(혼자서 해결 X)

- 문제 유형(목록): DFS/BFS(프로그래머스)
- Solution
  - 초기 접근
    - 이차원 배열 visited를 만들고 반복문을 통해서 1번 computer부터 n번 컴퓨터까지 탐색하면서
    - i번째 컴퓨터랑 j번째 컴퓨터랑 이어져있고 방문을 안했다면 해당 컴퓨터들을 방문처리 해줌(`visited[i][j], visited[j][i] = true`)
    - 이어진 부분을 다 방문처리 한 후 간접적으로 이어진 부분 체크
      - 3중 for문을 통해(`visited[i][j] == visited[j][k] == true면, visited[i][k] = true`)
    - 다 처리한 후 visited를 사용해서 네트워크의 개수를 return하려고 했는데 여기서 막힘...
  - 다른 사람들의 solution
    - visited를 통해서 네트워크 간 연결 정보를 저장함
      - 반복문을 통해서 i번 컴퓨터의 네트워크 상태를 확인(방문처리가 안되어있다면 방문처리, 네트워크 수 + 1)
      - `computers[컴퓨터1][컴퓨터2] === 1 and 컴퓨터가 아직 방문처리 X`라면 visited에 컴퓨터 2를 추가하고 컴퓨터2의 연결상태를 재귀(`dfs(컴퓨터2)`)를 통해 확인
