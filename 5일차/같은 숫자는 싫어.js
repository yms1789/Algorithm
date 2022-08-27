function solution(arr) {
  let answer = [];
  answer.push(arr[0]);
  for (let i = 1; i <= arr.length - 1; i++) {
    let index = answer.length - 1;
    if (answer[index] !== arr[i]) {
      answer.push(arr[i]);
    }
  }
  return answer;
}
