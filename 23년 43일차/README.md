## 🌀 나무 자르기

- 문제 유형(목록): 이분 탐색(백준)
- Solution
  - 초기 접근
    - 배열의 인덱스를 이분탐색하려고 함
    - `start = 0, end = trees.length - 1`
    - `while(start <= end)`일 때 까지
      - `mid`를 `start + end / 2`로 할당
      - `mid`부터 `end`까지 `tree`를 벌목한 후 잘린 길이를 `sum`에 저장
      - `sum`이 `M`일 때 `break`하고 `mid` 출력
      - `sum`이 `M`보다 작으면 `end = mid - 1`
      - `sum`이 `M`보다 크면 `start = mid + 1`
    - 문제점: sum = M이 안되는 경우도 있음 ⇒ 출력이 안됨!
  - 해결
    - tree의 최소값을 start, tree의 최대값을 end로 설정!
      - `sum < M`일 때는 `end = mid - 1`
      - `sum >= M` 일 때는 `end = start + 1`
      - 반복문을 다 돌고 난 후에 `end`값 출력
