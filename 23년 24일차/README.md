## 🌀 파이프 옮기기

- 문제 유형(목록): 그래프, DP(백준)
- solution
  - 파이프의 끝이 (N, N)에 도달할 수 있는 경우의 수를 모두 구해야 함
  - 경우의 수를 모두 구하기 위해 완전탐색을 통해 파이프를 이동시킬 수 있는 모든 경우의 수를 탐색함
  - type = 0(1)(가로(세로)) 인 경우 파이프를 이동시킬 수 있는 방향이 가로(세로), 대각선이므로
    재귀를 통해 현재 위치에서 가로방향과 대각선 방향으로 이동시킴
  - type = 2(대각선) 인 경우 파이프를 이동시킬 수 있는 방향이 가로, 세로, 대각선이므로
    재귀를 통해 현재 위치에서 가로방향과 세로방향, 대각선 방향으로 이동시킴
  - 재귀문을 반복하다가 파이프가 집을 벗어나거나, 벽에 부딪히는 경우 현재 재귀문을 `return`
  - (N, N) 위치에 파이프 끝이 도달한 경우 `res++` ⇒ 모든 경우의 수를 다 탐색한 뒤 `res` 출력

## 🌀 게리맨더링

- 문제 유형(목록): 그래프 탐색, 브루트포스(백준)
- solution
  - 주어진 도시를 두 선거구로 나누어야 함
    - dfs를 이용한 백트래킹으로 입력받은 도시를 두 구역으로 나눔
  - 나눈 뒤 같은 선거구 도시들끼리 서로 인접해있는지 확인
    - A 선거구끼리 인접해있는지 확인
      - A 선거구 도시 중 1개를 선택하고 `queue`에 삽입, 해당 도시에 인접해있는 도시들이 이미 체크처리 되어있거나, B도시(visited = false)에 있다면 `continue`, 둘 다 해당되지 않으면 `queue`에 넣고 해당 도시를 체크 처리함
      - A 선거구 관련 도시들이 모두 체크가 끝났을 때(`queue`가 비었을 때) 아직 체크안되어있는 도시가 있다면 `false` 다 체크처리 되어있다면 `true`
    - 마찬가지로 B 선거구도 A 선거구처럼 체크함
  - 각 선거구 도시들이 모두 인접해있는 도시들이라면 인구수 계산 ⇒ 차이가 최소가되는 값을 저장후 출력
