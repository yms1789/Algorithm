function solution(s) {
  let answer;
  answer =
    s.length % 2 === 0
      ? s.slice(Math.floor(s.length / 2) - 1, Math.floor(s.length / 2) + 1)
      : s.slice(Math.floor(s.length / 2), Math.floor(s.length / 2) + 1);
  return answer;
}

// 다른 사람 풀이(유사 배열 객체)

function solution(s) {
  const mid = Math.floor(s.length / 2);
  return s.length % 2 === 1 ? s[mid] : s[mid - 1] + s[mid];
}
