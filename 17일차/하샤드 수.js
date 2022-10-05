function solution(x) {
  let sum = (x + "").split("").reduce((acc, cur) => acc + parseInt(cur), 0);
  return x % sum === 0 ? true : false;
}
