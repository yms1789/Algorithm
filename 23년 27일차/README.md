## 🌀 파일명 정렬

- 문제 유형(목록): 문자열, 정렬
- solution
  - 입력받은 문자열을 순회하면서 숫자가 나오기 전까지를 `head`로 떼넴
  - 문자열의 $n$번째 문자가 숫자라면 n번째부터 끝까지를 `rest`변수에 넣고 rest를 다시 순회
  - rest를 숫자가 아닐 때 까지 순회하면서 숫자는 `number` 변수에 추가, 나머지는 `tail` 변수에 할당
    - 이 때 `number`길이가 5보다 커지지 않아야 하므로 `numCount` 변수를 선언해서 길이를 판단(`number.length`로 판단해도 됐을 것 같음)
  - 파일명에서 떼넨 `head, number, tail`을 `headNum` 배열에 `[head, number, tail]` 형태로 저장
    - 만약 `tail`이 `undefined`라면 `[head, number]` 만 저장
  - `headNum`을 정렬
    - `head`가 같다면(대소 구분 X) `number`로 정렬
    - `head`가 다르다면 `head`를 오름차순 정렬
  - `headNum`의 요소들을 문자열로 묶어서 `answer` 배열에 `push`후 `answer` 리턴
