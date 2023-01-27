function solution(s) {
  let answer = true;
  let flag;
  if (s[0] == "(") {
    flag = 1;
  } else {
    return false;
  }
  for (let idx = 1; idx < s.length; idx++) {
    if (s[idx] === "(") {
      flag += 1;
    }
    if (s[idx] === ")") {
      if (flag == 0) {
        flag -= 2;
      } else {
        flag -= 1;
      }
    }
  }
  flag === 0 ? (answer = true) : (answer = false);

  return answer;
}
