function solution(clothes) {
  let answer = 1;
  let count = {};
  for (let i = 0; i < clothes.length; i++) {
    count[clothes[i][1]] = (count[clothes[i][1]] || 0) + 1;
  }
  for (let i = 0; i < Object.values(count).length; i++) {
    answer *= 1 + Object.values(count)[i];
  }
  return answer - 1;
}
