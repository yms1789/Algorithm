function solution(keymap, targets) {
  let answer = [];

  for (let i = 0; i < targets.length; i++) {
    let total = 0;
    for (let t = 0; t < targets[i].length; t++) {
      let count = Infinity;
      for (let j = 0; j < keymap.length; j++) {
        let idx = keymap[j].indexOf(targets[i][t]);
        if (idx === -1) continue;
        else count = Math.min(idx + 1, count);
      }
      if (count === Infinity) {
        total = -1;
        break;
      } else total += count;
    }
    answer.push(total);
  }
  return answer;
}
