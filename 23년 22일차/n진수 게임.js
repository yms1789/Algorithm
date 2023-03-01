function solution(n, t, m, p) {
  let answer = "";
  let num = 0;
  let numList = "";
  while (numList.length <= t * m) {
    numList += num.toString(n);
    num++;
  }

  for (let i = 0; answer.length !== t; i++) {
    if (i + 1 == p) {
      answer += numList[i];
      p += m;
    }
  }
  return answer;
}
solution(2, 4, 2, 1);
