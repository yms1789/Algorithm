## 🌀 보물

- 문제 유형(목록): 그리디(백준)
- 혼자 힘으로 풀었는지 여부: ❌
- Solution
  - 문제에서 B에 있는 수를 재배열하면 안된다! 라고 했어서 어떻게 적절하게 A를 분배해서 최소인 S를 만들까 고민함
    - 깊은 고민 끝에도 해답을 찾지 못함
  - 다른사람 풀이를 보니 A는 오름차순, B는 내림차순으로 정렬 후 두 배열에 대해 S의 최솟값을 구함
  - 막상 생각해보니 출력은 최소인 값만 출력하면 됨(A를 적절하게 재배열하는 건 신경 안써도 됨)
    - A가 오름차순, B가 내림차순일 때 S를 실행시키면 S가 최소가 될테고 다시 B에 맞게 재배열하면 그렇게 정렬된 A배열이 S가 최소가 될 때의 배열
