function solution(n, computers) {
  let answer = 0;
  let visited = [];

  function dfs(computer) {
    for (let i = 0; i < n; i++) {
      if (computers[computer][i] === 1 && !visited.includes(i)) {
        visited.push(i);
        dfs(i);
      }
    }
  }

  for (let i = 0; i < n; i++) {
    if (!visited.includes(i)) {
      visited.push(i);
      answer += 1;
      dfs(i);
    }
  }

  return answer;
}
