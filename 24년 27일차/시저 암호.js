function solution(s, n) {
  let answer = "";
  let upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  let lower = "abcdefghijklmnopqrstuvwxyz";
  for (let i = 0; i < s.length; i++) {
    if (upper.includes(s[i])) {
      answer += upper[(upper.indexOf(s[i]) + n) % upper.length];
    } else if (lower.includes(s[i])) {
      answer += lower[(lower.indexOf(s[i]) + n) % lower.length];
    } else {
      answer += s[i];
    }
  }
  return answer;
}
