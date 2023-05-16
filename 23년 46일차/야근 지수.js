function solution(n, works) {
  let answer = 0;

  let sum = works.reduce((acc, cur) => acc + cur, 0);
  if (sum <= n) {
    return answer;
  }
  let sortWorks = works.sort((a, b) => a - b);
  while (n) {
    let max = sortWorks[sortWorks.length - 1];
    for (let i = sortWorks.length - 1; i >= 0; i--) {
      if (sortWorks[i] >= max) {
        sortWorks[i] -= 1;
        n -= 1;
      }
      if (n <= 0) {
        break;
      }
    }
  }

  for (let work of sortWorks) {
    answer += work * work;
  }
  return answer;
}
