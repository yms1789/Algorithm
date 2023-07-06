## 🌀 AC

- 문제 유형(목록): 구현(백준)
- Solution
  - 처음 문제 풀 때: 'R'일 때 입력받은 배열을 `reverse()`시켜 주고 'D'일 때 문자를 `pop()`해주는 식으로 문제를 해결함 → 시간초과
  - 다시 생각: 'R'일 때 `reverse()`를 해주지 말고 변수를 하나 생성해서 배열의 앞, 뒤의 값을 변경시켜주자!
      - `idx` 변수를 생성해서 수행할 함수 `p`가 동작할 때마다 1씩 증가시켜줌
      - `flag` 변수를 선언 후 뒤집혔을 때를 `true`, 그대로일 때를 `false`
        - 뒤집혀있다면 배열의 끝에서 `idx` 번째에 해당하는 값을 -1
        - 안뒤집혀있다면 배열의 앞에서 `idx` 번째에 해당하는 값을 -1
        - `p`함수가 끝나면 배열에서 -1을 필터링한 후 flag에 따라 배열을 `reverse`하거나 안하고 출력함
        → 틀렸습니다
  - 세번째 방식: 값을 -1하는 방식이 아니라 `slice()`를 이용해서 앞, 뒤의 값을 자른 배열을 재할당해줌 → 메모리 초과
  - 마지막 방식: `start = 0, end = n - 1` 을 두고 뒤집혔을 때는 `end--`, 안뒤집혔을 때는 `start++`를 해줘가면서 p 함수를 모두 실행함
    - `start > end`가 된다면 배열에 값이 없는데 `D`를 하는 것이므로 error!
    - `p`함수가 끝났을 때 `arr`을 (start, end)만큼 `slice` 하는 방식으로 문제를 해결

## 🌀 연속된 부분 수열의 합

- 문제 유형(목록): 투포인터(프로그래머스)
- Solution
  - 초기 코드
    ```js
    function solution(sequence, k) {
    let visited = Array(sequence.length).fill(false);
    let indexArr = [];
    function selIndex(idx, depth){
        if(depth === 2){
            let arr = [];
            for(let i = 0; i < visited.length; i++){
                if(visited[i]){
                    arr.push(i);
                }
            }
            indexArr.push(arr);
            return;
        }
        for(let i = idx; i < sequence.length; i++){
            visited[i] = true;
            selIndex(i + 1, depth + 1);
            visited[i] = false;
        }
    }
    let answer = [];
    let sumSeq = Array(sequence.length + 1).fill(0);
    for(let i = 1 ; i <= sequence.length; i++){
        sumSeq[i] += sequence[i - 1] + sumSeq[i - 1];
    }
    selIndex(0, 0);
    for(let i = 0; i < sequence.length; i++){
        if(sequence[i] === k){
            answer.push([i, i]);
        }
    }
    for(let index of indexArr){
        let [start, end] = index;
        let hap = sumSeq[end] - sumSeq[start];
        if(hap === k){
            answer.push([start, end - 1]);
        }
    }
    return answer[0];
    }
    ```
      - 문제점: 시간초과(`sequence`의 길이가 100만이라서 완전 탐색으로 풀면 안되는 문제)
  - 해결
    - `left, right`라는 투 포인터를 두고 문제를 해결해나감
    - `sum`을 `sequence`배열의 첫번째 값으로 두고, `left, right`를 0으로 초기화
      - `k`보다 `sum`이 크면  `sum -= sequence[left]`, `left`를 1증가
      - `k`가 더 크면  `right` 1증가시켜 주고 `sum += sequence[right]`
      - `k === sum`이면 부분 수열의 길이가 가장 작은 배열의 인덱스를 `return`해야 하므로 이전에 저장해놨던 부분수열 길이와 비교(`answer[1] - answer[0] > right - left`)
        - `left, right`를 1씩 증가시키고 `sum`에서 `left, right`에 해당했던 값을 더하고 빼줌(현재 부분수열보다 더 길이가 짧은 부분 수열이 있을 수도 있으므로 다 확인 해봐야 함)
