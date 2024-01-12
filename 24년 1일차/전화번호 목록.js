function solution(pb) {
  let answer = true;
  pb.sort();
  for (let i = 0; i < pb.length - 1; i++) {
    let prefix = pb[i + 1].slice(0, pb[i].length);
    if (prefix === pb[i]) return false;
  }

  return true;
}
