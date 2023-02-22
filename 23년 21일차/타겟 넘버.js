function solution(numbers, target) {
  let answer = 0;
  let visited = Array(numbers.length).fill(false);
  function dfs(idx) { 
    if (numbers.reduce((a, b) => a + b, 0) === target) { 
      answer++;
      return;
    }
    for (let i = idx; i < numbers.length; i++) { 
      if (!visited[i]) { 
        visited[i] = true;
        numbers[i] = -numbers[i];
        dfs(i + 1);
        numbers[i] = -numbers[i];
        visited[i] = false;
      }
    }
  }
  dfs(0);
  return answer;
}
solution([1, 1, 1, 1, 1], 3);
