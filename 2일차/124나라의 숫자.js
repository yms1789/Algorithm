function solution(n) {
  let answer = [];
  let otf = ["4", "1", "2"];
  function recursive(n) {
    if (n < 1) return;
    const remain = n % 3;
    answer.unshift(otf[remain]); // 처음 들어가는 값이 끝 값이 되어야 함
    recursive(Math.floor((n - 1) / 3));
  }
  recursive(n);
  return answer.join("");
}
