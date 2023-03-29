function solution(numbers) {
  let answer = Array(numbers.length).fill(-1);
  // 뒷 큰수 :  자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수
  let stack = [];
  for (let i = 0; i < numbers.length; i++) {
    let curNum = numbers[i];
    while (stack.length !== 0 && numbers[stack[stack.length - 1]] < curNum) {
      answer[stack[stack.length - 1]] = curNum;
      stack.pop();
    }
    stack.push(i);
  }
  return answer;
}

/**
 * 시간초과 코드
 * function solution(numbers) {
      let answer = [];
      // 뒷 큰수 :  자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수
      for(let i = 0; i < numbers.length; i++){
          let behindLargeNum = numbers.slice(i + 1).find(ele => ele > numbers[i]);
          answer.push(behindLargeNum ? behindLargeNum : -1);
      }
      return answer;
   }
 */
