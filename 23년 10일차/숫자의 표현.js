function solution(n) {
  if (n < 3) return 1;
  let answer = 1;
  let left = 1,
    right = 2;
  let sum = left + right;
  while (right < n) {
    if (sum < n) {
      sum += ++right;
      continue;
    }
    if (sum === n) {
      answer++;
    }
    sum -= left;
    left++;
  }
  return answer;
}
