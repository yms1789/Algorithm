function solution(left, right) {
  let answer = 0;

  for (let i = left; i <= right; i++) {
    let divisorCount = 1;
    for (let j = 2; j <= i; j++) {
      if (i % j === 0) {
        divisorCount++;
      }
    }
    if (divisorCount % 2) {
      answer -= i;
    } else {
      answer += i;
    }
  }
  return answer;
}

// 다른 사람 풀이(어떤 수의 제곱근이 정수면 약수의 개수가 홀수!)
function solution(left, right) {
  var answer = 0;
  for (let i = left; i <= right; i++) {
    if (Number.isInteger(Math.sqrt(i))) {
      answer -= i;
    } else {
      answer += i;
    }
  }
  return answer;
}