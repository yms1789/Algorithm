const fs = require('fs');
const [T, ...input] = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let answer = [];

for (let i = 0; i < input.length; i += 3) {
  let p = input[i];
  let n = input[i + 1];
  let arr = JSON.parse(input[i + 2]);
  arr = arr.filter(ele => ele !== '').map(ele => Number(ele));
  let start = 0;
  let end = n - 1;
  let flag = false;
  let isError = false;
  for (let i = 0; i < p.length; i++) {
    if (p[i] === 'R') {
      // 뒤집기
      flag = !flag;
    }
    if (p[i] === 'D') {
      if (start > end) {
        isError = true;
        break;
      }
      if (flag) {
        // 뒤집혔을 때
        end--;
        // [1, 2, 3, 5, 8]
      }
      else {
        // 안뒤집혔을 때
        start++;
      }
    }
  }
  const answerArr = arr.slice(start, end + 1);
  answer.push(
    isError
      ? 'error'
      : JSON.stringify(flag ? answerArr.reverse() : answerArr)
  );
}
console.log(answer.join("\n"));

