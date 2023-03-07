function solution(dirs) {
  let visited = {};
  let cur = [0, 0];
  for (let i = 0; i < dirs.length; i++) {
    let next = [];
    if (dirs[i] == "U") {
      next = [cur[0] - 1, cur[1]];
    } else if (dirs[i] == "L") {
      next = [cur[0], cur[1] - 1];
    } else if (dirs[i] == "D") {
      next = [cur[0] + 1, cur[1]];
    } else if (dirs[i] == "R") {
      next = [cur[0], cur[1] + 1];
    }
    if (next[0] < -5 || next[1] < -5 || next[0] > 5 || next[1] > 5) {
      continue;
    }

    visited[[cur, next]] = true;
    visited[[next, cur]] = true;
    cur = next;
  }
  return Object.keys(visited).length / 2;
}
