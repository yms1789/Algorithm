function solution(s) {
  let answer = true;
  s = s.toLowerCase();
  let pyCounter = {
    p: 0,
    y: 0,
  };
  for (let ele of s) {
    pyCounter[ele]++;
  }
  answer = pyCounter.p === pyCounter.y ? true : false;
  return answer;
}
