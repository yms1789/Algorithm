## 🌀 단지번호붙이기

- 문제 유형(목록): 그래프(백준)

- Solution
  - bfs를 통해 인접한 집들의 모임인 단지의 수를 구하자!
  - 입력값을 순회하면서 집이 있는 곳이라면 방문처리
    - 해당 지점부터 시작해서 더 이상 인접한 집이 없을 때 까지 반복
    - 방문한 집이 처음 시작한 집 번호랑 같은경우만 `queue`에 추가하자
      - 인접한 집의 단지번호가 다를 수 있으므로
  - 더 이상 방문할 곳이 없다면 단지 수와 단지 내 집의 수를 오름차순 정렬 후 출력
