function solution(s) {
  function compareString(a, b) {
    let result;
    result = a > b ? -1 : 1;
    return result;
  }
  let answer = Array.from(s).sort(compareString);
  return answer.join("");
}
