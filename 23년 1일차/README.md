## 🌀 최솟값 만들기

- 문제 유형: 배열
- solution
  - 문제에서 각 배열에서 k번째 숫자를 뽑았다면 다음에 k번째 숫자는 다시 뽑을 수 없다는 제한 존재
    - 즉, 각 배열에서 같은 인덱스의 숫자만 뽑을 수 있음
  - 그러므로 A 배열은 오름차순 정렬, B 배열은 내림차순 정렬을 했을 때 즉, _작은 숫자_ * _큰 숫자_ 끼리 더한 값이 최솟값이 됨
