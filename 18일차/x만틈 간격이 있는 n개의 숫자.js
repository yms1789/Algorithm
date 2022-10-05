function solution(x, n) {
  let answer = [];
  let input = 0;
  for (let i = 0; i < n; i++) {
    answer.push(input + x);
    input += x;
  }
  return answer;
}


// 다른 사람 풀이
function solution(x, n) {
  let answer = Array(n)
    .fill(x)
    .map((ele, idx) => ele * (idx + 1));
  return answer;
}
