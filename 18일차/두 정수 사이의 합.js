function solution(a, b) {
  let answer;
  for (let i = Math.max(a, b); i >= Math.min(a, b); i--) {
    answer += i;
  }
  return answer;
}
