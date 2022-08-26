function solution(number) {
  let muskeeters = [];
  let answer = 0;
  for (let i = 0; i < number.length; i++){
    for (let j = i + 1; j < number.length; j++){
      for (let k = j + 1; k < number.length; k++){
        muskeeters.push(number[i]);
        muskeeters.push(number[j]);
        muskeeters.push(number[k]);
        if (muskeeters.reduce((a, b) => a + b) === 0) {
          answer++;
        }
        muskeeters = [];
      }
    }
  }
  return answer;
}