## 🌀 유기농 배추

- 문제 유형(목록): 깊이 우선 탐색(백준)
- 혼자 힘으로 풀었는지 여부: ⭕️
- Solution
  - 기존에는 너비 우선 탐색으로 풀었지만 이번에는 깊이 우선 탐색으로 풀이함
  - 배추가 심어진 위치와 배추밭의 크기가 주어졌을 때 필요한 최소의 배추흰지렁이 마리 수를 구하는 문제
  - 입력 받은 밭 크기만큼의 배열을 만들고 배추의 위치에 1을 할당
  - 각 칸마다 방문 여부가 필요하므로 `visited` 배열 선언
  - 배추가 심어진 부분이 방문하지 않았다면
    - 해당 위치부터 시작해서 이동 가능한 방향에 더 이상 배추가 안 심어져있을 때까지 반복하면서 방문처리
    - count 1증가
  - 위 과정을 반복하면서 배추가 심어진 구역들의 개수를 구한 뒤 필요한 배추흰지렁이 수를 출력
