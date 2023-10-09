function solution(storey) {
  let answer = 0;
  let numberArray = (storey + "").split("").map(Number);
  for (let i = numberArray.length - 1; i > 0; i--) {
    if (numberArray[i] === 10) {
      // numberArray[i] % 10 === 0 -> 자릿수가 0인 경우도 해당함
      numberArray[i - 1]++;
      continue;
    }
    if (numberArray[i] === 5) {
      if (numberArray[i - 1] >= 5) {
        numberArray[i - 1]++;
      }
      answer += 5;
    }
    if (numberArray[i] < 5) {
      answer += numberArray[i];
    }
    if (numberArray[i] > 5) {
      answer += 10 - numberArray[i];
      numberArray[i - 1]++;
    }
  }
  return answer + Math.min(numberArray[0], 11 - numberArray[0]);
}
