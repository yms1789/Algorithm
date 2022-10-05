function solution(s) {
  return s[0] === "-" ? parseInt(s.slice(1)) * -1 : parseInt(s);

  // 다른 사람 풀이(암묵적 형 변환)
  // return s / 1;
  // return +s;
}
