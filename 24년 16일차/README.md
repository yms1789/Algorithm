## 🌀 랜선 자르기

- 문제 유형(목록): 이분탐색, 매개변수 탐색(백준)
- 혼자 힘으로 풀었는지 여부: ❌
- Solution
  - 초기 구현
    - 시작 지점을 1, 끝 지점을 입력된 랜선 길이 중 가장 큰 값으로 두고 이분 탐색을 시작
    - 주어진 랜선들을 잘랐을 때 N개 이상이되는 랜선 길이를 구해야 함
      - 현재 길이로 랜선들을 잘랐을 떄 N보다 작다면 `끝지점 = center - 1`
      - N보다 크거나 같다면 바로 리턴했음

    - 결과: 틀렸습니다!
    - 이유: N개의 랜선만 있으면 되므로 자를 랜선 길이를 최대로 더 늘렸을 때 N개가 되는 경우도 있으므로
      - 예제 입력에서 N을 15로 바꿔서 풀어보면 바로 이해됨!
  - 해결
    - N개 이상일 때 바로 리턴하는 것이 아니라 `시작지점 = center + 1`로 해서 N이상의 랜선을 자를 수 있는 최대 길이를 구함
