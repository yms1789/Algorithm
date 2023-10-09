## 🌀 카드 정렬하기

- 문제 유형(목록): 우선순위 큐, 그리디(백준)

- 초기 구현

  ```js
  const fs = require("fs");
  const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
  const stdin = fs.readFileSync(filePath).toString().split("\n");

  const input = stdin.map((ele) => Number(ele));

  const N = input.shift();

  input.sort((a, b) => b - a);

  let answer = 0;
  while (input.length > 1) {
    let [a, b] = [input.pop(), input.pop()];
    answer += a + b;
    for (let j = input.length - 1; j >= 0; j--) {
      if (input[j] >= a + b) {
        input.splice(j, 0, a + b);
        break;
      }
    }
    input.splice(0, 0, a + b);
  }
  ```

  - 입력 값을 내림차순 정렬한 뒤 작은 값 두개를 pop해서 더한 값을 answer에 저장
  - input배열을 뒤쪽부터 순회하면서 빼낸 두 값을 더한 값보다 큰 값이 나왔을 때 그 뒤에 더한 값을 추가
  - 더한 값이 제일 크다면 배열의 첫번째에 더한 값 추가

  - 결과: 시간초과 (N이 최대 10만이라서 N^2의 알고리즘으로는 해결이 불가능)

- 해결 방법
  - 최소 힙을 직접 구현함
  - 나머지 로직은 위 코드랑 동일(작은 값 2개 빼서 더한 값 저장, 다시 더한 값을 힙에 추가)

## 🌀 마법의 엘리베이터

- 문제 유형(목록): dfs, 그리디(프로그래머스)

- 초기 구현

  ```js
  function solution(storey) {
    let answer = 0;
    let numberArray = (storey + "").split("").map(Number);
    for(let i = numberArray.length - 1; i > 0; i--){
        if(numberArray[i] % 10 === 0){
            numberArray[i - 1]++;
            continue;
        } 
        if(numberArray[i] === 5){
            answer += 5;
        }
        if(numberArray[i] < 5){
            answer += numberArray[i];
        }
        if(numberArray[i] > 5){
            answer += (10 - numberArray[i]);
            numberArray[i - 1]++;
        }
    }
    return answer + (numberArray[0] % 10 === 0 ? 1 : numberArray[0]);
  }
  ```

  - storey를 자릿수별로 나눠서 배열로 만듦
  - 배열의 길이만큼 반복(일의 자릿 수부터, 마지막 자릿수는 제외)
    - 숫자가 5라면 바로 answer에 저장
    - 숫자가 5보다 크다면 (10 - 현재 숫자)를 answer에 더하고 다음 자릿수에 1더함(ex) 현재가 1의자리 수면 10의 자리 수 + 1)
    - 숫자가 10의 배수면 다음 자릿 수 1더해줌
  - 문제점: 540 → 9지만 위 코드로 돌리면 10, 555 → 14지만 15, 75 → 8이지만 12
    - `numberArray[i] % 10 === 0`을 조건문으로 두면 10말고 0도 포함됨(540 -> 5 + 5)
    - `(numberArray[0] % 10 === 0 ? 1 : numberArray[0])`이면 75가 → 5 + 7(5 + 3이 되야함)이 되어버림
- 해결 방법
  1. 자릿수가 5일 때는 다음 자릿수가 5이상인지 아닌지 판단해줘야 함
  2. 자릿수가 10인지 아닌지 판단하는 건 나머지 연산자 말고 `numberArray[i] === 10` 이렇게 해주자
  3. 제일 앞 자리수도 5보다 큰 지 작은 지 판단해야 함
