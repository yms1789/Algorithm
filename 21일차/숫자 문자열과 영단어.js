function solution(s) {
  let answer = "";
  let table = {
    zero: 0,
    one: 1,
    two: 2,
    three: 3,
    four: 4,
    five: 5,
    six: 6,
    seven: 7,
    eight: 8,
    nine: 9,
  };
  let findNum = "";
  for (let i = 0; i < s.length; i++) {
    if (parseInt(s[i]) >= 0 && parseInt(s[i]) <= 9) {
      answer += s[i];
    } else {
      findNum += s[i];
      if (Object.keys(table).includes(findNum)) {
        answer += table[findNum];
        findNum = "";
      }
    }
  }
  return parseInt(answer);
}
