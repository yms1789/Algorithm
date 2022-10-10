function solution(price, money, count) {
  var answer = -1;

  for (let i = 1; i <= count; i++) {
    let usage = price * i;
    money -= usage;
  }
  answer = money < 0 ? Math.abs(money) : 0;
  return answer;
}
