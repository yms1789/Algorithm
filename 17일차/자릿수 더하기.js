function solution(n) {
  let answer = 0;
  n = n + "";
  let numArr = Array.from(n);
  answer = numArr.reduce((acc, curr) => acc + parseInt(curr), 0);

  return answer;
}
