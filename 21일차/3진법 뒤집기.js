function solution(n) {
  let answer = [];
  let ternary = "";
  let input = n;
  while (input > 0) {
    ternary += input % 3;
    input = Math.floor(input / 3);
  }
  let mul = 1;
  for (let i = ternary.length - 1; i >= 0; i--) {
    answer.push(ternary[i] * mul);
    mul *= 3;
  }
  return answer.reduce((acc, cur) => acc + cur, 0);
}
