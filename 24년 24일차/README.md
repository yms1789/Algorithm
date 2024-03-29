## 🌀 회문

- 문제 유형(목록): 그리디, 투포인터(백준)
- 혼자 힘으로 풀었는지 여부: ❌
- Solution
  - 입력받는 문자열이 회문인지, 아니면 유사 회문(문자열 중 문자 1개를 제거했을 때 회문이 되는 문자열)인지, 둘 다 아닌지 찾는 문제
  - 초기 해결 방법
    - 투포인터로 풀려고 시도는 했음
    - 문자열을 왼쪽, 오른쪽 포인터를 두고 왼쪽 -> 오른쪽, 오른쪽 -> 왼쪽으로 이동하면서 해당 인덱스 문자가 같으면 넘어가고 다르다면 다른 횟수를 저장
      - 다른 횟수에 따라서 회문, 유사회문, X 여부를 출력
    - 당연히 오답!

    ➡︎ **결국엔 적절한 해답을 찾지 못함**
  
  - 다른 사람들의 해결 방식
    - 마찬가지로 투 포인터를 두고 양쪽의 문자가 다르다면 왼쪽, 오른쪽 문자를 각각 제거한 뒤에 해당 문자열이 회문인지 판단
      - _왼쪽, 오른쪽의 문자가 다른 순간만 판단하면 해당 인덱스 위치 안쪽 부분은 더 이상 판단할 필요가 X!_
    - 코드 해설
      - 입력 문자열 횟수만큼 반복하면서 입력받은 문자열이 이미 회문이라면 0출력
      - 아니라면, 포인터를 둠(왼쪽, 오른쪽)
      - 문자열의 절반만큼만 반복하면서 왼쪽과 오른쪽 문자가 서로 다르다면 왼쪽 문자를 뺐을 때, 오른쪽 문자를 뺐을 때 회문인지 판단
        - 회문이라면 `familiar = true`
      - `familiar = true` 면 유사회문이니까 1출력, 아니면 2출력
