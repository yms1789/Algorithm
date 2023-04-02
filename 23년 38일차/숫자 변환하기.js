function solution(x, y, n) {
  let visited = new Set();
  let queue = [];
  queue.push({ val: x, count: 0 });
  function bfs() {
    while (queue.length) {
      let cur = queue.splice(0, 1);
      visited.add(cur[0].val);
      if (cur[0].val == y) {
        return cur[0].count;
      }
      let next = [cur[0].val + n, cur[0].val * 2, cur[0].val * 3];
      for (let i = 0; i < 3; i++) {
        if (next[i] <= y && !visited.has(next[i].val)) {
          queue.push({ val: next[i], count: cur[0].count + 1 });
        }
      }
    }
    return -1;
  }
  let res = bfs();
  return res === -1 ? res : res;
}

console.log(solution(10, 40, 5));
