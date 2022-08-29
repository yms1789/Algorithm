## 🌀 크레인 인형뽑기 게임

- 문제 유형: 스택 / 큐
- Solution
  1. 크레인을 작동시킨다.(moves)
  2. moves에 해당하는 board의 열 중 가장 위에 있는 값을 탐색
    - 만약, 해당 열에 값이 아무것도 없다면, moves 인덱스를 1 더해주고, 다음 크레인 위치에서 다시 인형을 찾는다.
  3. 탐색한 값을 basket에 값을 push.
  - basket에 값이 2개 이상 들어있다면, push한 값과 바로 이전에 들어있는 값이 동일한지 확인
    - 동일하다면 두 값을 basket에서 제거하고 answer + 2
    - 다르다면 아무일도 일어나지 않는다.
  4. 위 과정을 moves의 끝까지 반복한다.
  5. answer를 리턴
- 다른 사람의 풀이
  ```jsx
  // board의 행, 열을 바꿔서 해결
  const transpose = matrix =>
    matrix.reduce(
        (result, row) => row.map((_, i) => [...(result[i] || []), row[i]]),
        []
    );

  const solution = (board, moves) => {
    const stacks = transpose(board).map(row =>
        row.reverse().filter(el => el !== 0)
    );
    const basket = [];
    let result = 0;

    for (const move of moves) {
        const pop = stacks[move - 1].pop();
        if (!pop) continue;
        if (pop === basket[basket.length - 1]) {
            basket.pop();
            result += 2;
            continue;
        }
        basket.push(pop);
    }

    return result;
  };
  ```
  - transpose
    - ```reduce```와 ```map```을 활용하여 board 배열의 행 값들을 열로 옮김
      - |바뀌기 전|바뀐 후|
        |:--:|:--:|
        |
        0 0 0 4 3 | 0 0 0 0 0
        0 0 2 2 5 | 0 0 1 0 3
        0 1 5 4 1 | 0 2 5 0 1
        0 0 0 4 3 | 4 2 4 4 2
        0 3 1 2 1 | 3 5 1 3 1
        |
    - 참고: [JS 2차원 배열 행, 열 바꾸기](https://velog.io/@dyongdi/JS-2%EC%B0%A8%EC%9B%90-%EB%B0%B0%EC%97%B4%EC%9D%98-%ED%96%89%EA%B3%BC-%EC%97%B4-%EB%B0%94%EA%BE%B8%EA%B8%B0-Transposing-a-2D-array-in-JavaScript)