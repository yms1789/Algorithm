/**
 * 초기 접근 방법: 조합을 이용해서 number에서 k개를 제외한 나머지를 뽑은 후 가장 큰 값을 찾자!
 * number의 length(1 <= number.length <= 1,000,000) 이라서 해당 접근 방식 불가!
 * function solution(number, k) {
  let answer = 0;
  let visited = Array(number.length).fill(false);
  function dfs(idx, depth) {
    if (depth == k) {
      console.log(visited);
      calcNum();
      return;
    }
    for (let i = idx; i < number.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        dfs(i + 1, depth + 1);
        visited[i] = false;
      }
    }
  }
  function calcNum() {
    let nums = "";
    for (let i = 0; i < visited.length; i++) {
      if (!visited[i]) {
        nums += number[i];
      }
    }
    answer = Math.max(Number.parseInt(nums), answer);
  }
  for (let i = 0; i < number.length; i++) {
    dfs(i, 0);
  }
  return "" + answer;
} */

function solution(number, k) {
  let answer = [];
  for (let i = 0; i < number.length; i++) {
    if (answer.length == 0) {
      answer.push(number[i]);
      continue;
    }
    if (k > 0) {
      while (answer[answer.length - 1] < number[i]) {
        answer.pop();
        k -= 1;
        if (answer.length == 0 || k <= 0) break;
      }
    }
    answer.push(number[i]);
  }
  answer = answer.slice(0, answer.length - k);
  return answer.join("");
}
