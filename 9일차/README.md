## 🌀 Udemy JavaScript 알고리즘 & 자료구조 마스터클래스

## 섹션 6 도전과제 풀이 모음

**1. maxSubarraySum**

- 배열과 숫자가 입력 값으로 주어지고, 숫자만큼의 하위 배열 요소들의 합이 최대인 값을 리턴하는 문제(단, 하위 요소 집합은 요소들이 연속으로 구성된 집합이어야 함)
  ```jsx
  maxSubarraySum([100, 200, 300, 400], 2); // 700
  maxSubarraySum([1, 4, 2, 10, 23, 3, 1, 0, 20], 4); // 39
  maxSubarraySum([-3, 4, 0, -2, 6, -1], 2); // 5
  maxSubarraySum([3, -2, 7, -4, 1, -1, 4, -2, 1], 2); // 5
  maxSubarraySum([2, 3], 3); // null
  ```

**2. minSubArrayLen(스스로 해결 X)**

- 배열과 숫자가 입력 값으로 주어지고, 배열 내 하위 요소 집합들의 합이 숫자 이상인 하위 집합의 최소 길이를 구하는 문제
  ```jsx
  minSubArrayLen([2, 3, 1, 2, 4, 3], 7); // 2 -> because [4,3] is the smallest subarray
  minSubArrayLen([2, 1, 6, 5, 4], 9); // 2 -> because [5,4] is the smallest subarray
  minSubArrayLen([3, 1, 7, 11, 2, 9, 8, 21, 62, 33, 19], 52); // 1 -> because [62] is greater than 52
  minSubArrayLen([1, 4, 16, 22, 5, 7, 8, 9, 10], 39); // 3
  minSubArrayLen([1, 4, 16, 22, 5, 7, 8, 9, 10], 55); // 5
  minSubArrayLen([4, 3, 3, 8, 1, 2, 3], 11); // 2
  minSubArrayLen([1, 4, 16, 22, 5, 7, 8, 9, 10], 95); // 0
  ```
- solution
  - 배열의 합을 구하기위해 sliding window 생성(start~end)
  - 배열 요소들의 합이 num보다 작을때까지 더 함(total += arr[end++])
  - total이 num보다 커졌다면 start를 1씩 늘리면서 sliding window를 배열 오른쪽으로 점점 이동시키면서 최소길이를 구함
  - end 가 입력받은 배열 길이보다 크고, total이 입력받은 숫자보다 크다면 반복문 종료

**3. findLongestSubstring(스스로 해결 X)**

- 입력받은 문자열 중 중복되지 않는 가장 긴 부분 문자열의 길이를 구하는 문제
  ```jsx
    findLongestSubstring('') // 0
  findLongestSubstring('rithmschool') // 7
  findLongestSubstring('thisisawesome') // 6
  findLongestSubstring('thecatinthehat') // 7
  findLongestSubstring('bbbbbb') // 1
  findLongestSubstring('longestsubstring') // 8
  findLongestSubstring('thisishowwedoit') // 6
  ```
- solution
  - 문자열의 start 부터 각 문자까지를 저장 할 seen 객체를 생성
  - 문자열 길이만큼 반복하면서 해당 문자까지의 길이를 저장
  - 최대 길이는 지금까지 봤던 문자의 길이에서 시작 위치 뺀 값에 + 1을 한 값(현재 위치를 포함하기 위함)
  - 문자가 이미 봤던 문자라면, start값을 해당 문자로 옮김

