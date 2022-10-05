function solution(n) {
  let answer = 0;
  let x = Math.sqrt(n);
  answer = Number.isInteger(x) ? (answer = (x + 1) ** 2) : -1;
  return answer;
}
