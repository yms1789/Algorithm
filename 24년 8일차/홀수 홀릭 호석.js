const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n");

/**
 *
 * 1. 수의 각 자리 숫자 중에서 홀수의 개수를 종이에 적는다.
 * 2. 수가 한 자리이면 더 이상 아무것도 하지 못하고 종료한다.
 * 3. 수가 두 자리이면 2개로 나눠서 합을 구하여 새로운 수로 생각한다.
 * 4. 수가 세 자리 이상이면 임의의 위치에서 끊어서 3개의 수로 분할하고, 3개를 더한 값을 새로운 수로 생각한다.
 */
// 연산 종료 후 적힌 수들을 모두 더함
// 이렇게 만들 수 있는 최대, 최소를 구하기

const num = input[0].split("");

function dfs(len, depth, arr, _split) {
  if (arr.reduce((acc, cur) => acc + cur, 0) === len) {
    _split.push([...arr]);
    return;
  }
  for (let i = 0; i < 3; i++) {
    arr[i]++;
    dfs(len, i, arr, _split);
    arr[i]--;
  }
}

let result = [];

function solution(arr, oddCnt) {
  arr.forEach((ele) => {
    if (ele % 2 !== 0) oddCnt++;
  });
  if (arr.length === 1) {
    result.push(oddCnt);
    return;
  }
  if (arr.length === 2) {
    let splitTwoHap = (
      arr.map((ele) => Number(ele)).reduce((acc, cur) => acc + cur, 0) + ""
    ).split("");
    solution(splitTwoHap, oddCnt);
  }

  if (arr.length >= 3) {
    // 세부분으로 나누기
    let split = [];
    dfs(arr.length, 0, [1, 1, 1], split);
    split.forEach((ele) => {
      let [first, second, third] = ele;
      let firstSplit = Number(arr.slice(0, first).join(""));
      let secondSplit = Number(arr.slice(first, first + second).join(""));
      let thirdSplit = Number(
        arr.slice(first + second, first + second + third).join("")
      );
      let addAll = (firstSplit + secondSplit + thirdSplit + "").split("");
      solution(addAll, oddCnt);
    });
  }
}

solution(num, 0);

let minNum = Math.min(...result);
let maxNum = Math.max(...result);
console.log(minNum + " " + maxNum);
