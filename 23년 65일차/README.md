## 🌀 친구

- 문제 유형(목록): 최단경로, 플로이드-워셜(백준)
- Solution
  - 2-친구 수 여부를 판단하기 위한 `friends`배열을 생성
  - i, j가 서로 친구(`input[i][j] == "Y"`)이거나 i, k가 친구고, k, j가 친구
    (`input[i][k] == "Y" && input[k][j] == "Y"`)라면 i, j가 2-친구 관계이므로
    `friends[i][j] = 1`
  - friends 배열을 반복하면서 각 행에 대해 2-친구 수를 저장해서 가장 2-친구 수가
    큰 경우를 출력

## 🌀 접두사

- 문제유형(목록): 그리디, 정렬(백준)
- 초기 구현
  - 완전탐색을 통해 부분집합을 구함
  - 부분집합 배열을 반복문을 돌면서 a가 b에 포함되는지 또는 b가 a에 포함되는지확
    인
    - 포함된다면 접두사 집합이므로 `return true` 아니면 `return false`
    - 접두사 X집합이라면 부분집합 배열의 길이를 메모이제이션하면서 가장 큰 부분
      집합 크기를 출력
  - 코드
    ```js
    // 재귀를 통한 부분집합 생성
    function subset(idx, depth, arr) {
      if (arr.length === depth) {
        if (!isPrefix(arr)) {
          len = Math.max(len, arr.length);
        }
      }
      for (let i = idx; i < input.length; i++) {
        arr.push(input[i]);
        subset(i + 1, depth + 1, arr);
        arr.pop();
      }
    }
    // 접두사X 집합인지 판단
    function isPrefix(arr) {
      for (let i = 0; i < arr.length; i++) {
        for (let j = i + 1; j < arr.length; j++) {
          if (arr[i].includes(arr[j]) || arr[j].includes(arr[i])) return true;
        }
      }
      return false;
    }
    ```
  - **시간초과**
- Solution
  - 스택을 이용함
  - 입력받는 문자열들을 오름차순 정렬
  - 입력 첫번째 문자열을 스택에 넣고
  - 다음 문자열부터 반복하면서 스택의 가장 상단에 있는 문자열 길이만큼 `slice`하
    고 스택의 가장 상단에 있는 문자열과 비교
    - 서로 같다면 스택에 있는 값을 빼고 해당 문자열을 넣음
    - 다르다면 문자열을 스택에 넣음
  - 반복이 완료되면 스택의 길이를 출력
