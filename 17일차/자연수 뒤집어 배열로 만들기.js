function solution(n) {
  let answer = (n + "")
    .split("")
    .map((ele) => parseInt(ele))
    .reverse();
  return answer;
}
