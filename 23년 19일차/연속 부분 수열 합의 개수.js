function solution(elements) {
  let answer = 0;
  let total = new Set();
  for (let i = 1; i <= elements.length; i++) {
    let sum = 0;
    for (let j = 0; j < elements.length; j++) {
      if (j === 0) {
        for (let k = 0; k < i; k++) {
          sum += elements[k];
        }
      } else {
        sum -= elements[j - 1];
        sum += elements[(j + i - 1) % elements.length];
      }
      total.add(sum);
    }
  }
  return answer;
}

solution([7, 9, 1, 1, 4]);
