## 🌀 숫자고르기

- 문제 유형(목록): 그래프, 깊이 우선 탐색(백준)
- solution
  - 초기 구현
    - dfs를 이용해서 정수 집합에서 숫자를 뽑음
    - 뽑은 숫자들의 인덱스 리스트와 숫자 리스트(`list2`)를 따로 저장해놓고 두 배열이 같은지 비교
      - 숫자 리스트를 오름차순 정렬한 뒤, `Arrays.equals` 메서드를 통해 같은지 비교함
    - 두 배열이 같다면 `maxChoice`에 숫자 리스트를 할당
    - 위 과정을 반복하면서 `maxChoice` 길이보다 `list2`의 길이가 더 길다면 더 긴 리스트를 `maxChoice`에 할당
    - 탐색이 끝나면 `maxChoice`의 길이와 리스트 요소를 출력
    - **초기 구현 결과 메모리 초과! 발생**
  - 해결 방법
    - 뽑힌 숫자들이 싸이클을 이룸
      - (1 → 3, 3 → 1, 1 → 3) 사이클
      - (5 → 5) 사이클
    - dfs 탐색도 숫자 → `table[숫자]` → `table[table[숫자]]` 이렇게 한 방향으로 진행을 하면서 사이클인 숫자(`인덱스 == table[숫자]`)라면 choice 리스트에 저장 후 탐색이 끝나면 choice리스트 길이와 요소를 출력
