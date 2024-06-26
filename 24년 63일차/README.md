## 🌀 아기상어

- 문제 유형(목록): BFS, 구현(백준)
- 혼자 힘으로 풀었는지 여부: ❌
- Solution
  - 아기 상어의 위치에서부터 주어진 방식대로 상하좌우로 움직이며 물고기를 먹으면서 더 이상 먹을 수 없을 때 까지 반복하는 문제
    - 물고기가 상어보다 크면 먹지 못하고 상어는 자기보다 작은 물고기만 먹을 수 있고 물고기를 먹은 숫자가 자신의 크기와 같다면 크기가 1커짐
    - 상어는 먹을 수 있는 물고기 중 가장 가까운 물고기를 먹음
      - 가장 가까운 물고기가 여러마리라면 가장 위, 왼쪽에 있는 물고기를 먹는다.
  - 어려웠던 부분은 최단 거리에 있는 물고기를 판단하는 건 BFS를 통해 가능하지만 최단 거리 물고기가 여러마리 일 때 가장 위왼쪽인지 판단하는 게 어려웠음
  - (x, y, 거리)가 최소인지 판단하는 `minX, minY, minR` 변수를 만들어서 상어 위치로부터 물고기가 최소거리일 때와 아닐 때를 판단해서 최소거리인 물고기가 여러마리라면 최소X, 최소Y를 판단해서 가장 위왼쪽 물고기를 먼저 먹도록 설정
  - 위 과정을 더 이상 먹을 물고기가 없을 때(BFS를 돌았는데도 minX, minY값이 초기 값과 그대로라면)까지 반복해서 상어가 물고기를 모두 먹을 때까지 이동한 숫자를 체크

- Solution2
  - 다른 풀이 중에서 bfs를 돌면서 먹을 수 있는 물고기를 전부 배열에 담고 배열을 거리가 가깝고 위에 있고 왼쪽에 있는 순으로 정렬한 다음 하나씩 먹어가면서 더 이상 먹을 물고기가 없을 때까지 반복하는 방법도 존재!
  [링크](https://ggarden.tistory.com/entry/%EB%B0%B1%EC%A4%80-16236-%EC%95%84%EA%B8%B0-%EC%83%81%EC%96%B4-JavaScript)