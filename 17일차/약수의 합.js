function solution(n) {
  let idx = 1;
  let sum = 0;
  while (idx <= n) {
    if (n % idx === 0) {
      sum += idx;
    }
    idx++;
  }
  return sum;
}
