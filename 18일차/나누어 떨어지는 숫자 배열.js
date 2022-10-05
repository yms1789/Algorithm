function solution(arr, divisor) {
  let answer = [];
  arr.map((ele) => (ele % divisor === 0 ? answer.push(ele) : null));
  /* 다른 사람 해결 
  arr.forEach((ele) => (ele % divisor === 0 && answer.push(ele)));
  */
  return answer.length === 0 ? [-1] : answer.sort((a, b) => a - b);
}
