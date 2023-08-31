function solution(prices) {
  const answer = Array.from(
    { length: prices.length },
    (_, i) => prices.length - i - 1
  );

  let stack = [];
  for (let i = 0; i < prices.length; i++) {
    while (stack.length && prices[stack[stack.length - 1]] > prices[i]) {
      const tempIndex = stack[stack.length - 1];
      answer[tempIndex] = i - tempIndex;
      stack.pop();
    }
    stack.push(i);
  }

  return answer;
}
