function solution(arr) {
  // 배열 내 가장 작은 수 찾기(Math.min(...arr))
  arr.splice(arr.indexOf(Math.min(...arr)), 1);
  return arr.length === 0 ? [-1] : arr;
}
