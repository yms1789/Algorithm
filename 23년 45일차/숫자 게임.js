function solution(A, B) {
  let answer = 0;

  A.sort((a, b) => b - a);
  B.sort((a, b) => a - b);
  let bIdx = B.length - 1;
  for (let num of A) {
    let max = B[bIdx];
    if (num < max) {
      answer++;
      bIdx--;
    }
  }
  return answer;
}
