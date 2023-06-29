function solution(order) {
  let answer = 0;

  let belt = Array.from({ length: order.length }, (_, i) => i++).map(ele => ele + 1);
  let bojo = [];
  for (let i = 0, j = 0; i < order.length;) {
    if (j >= belt.length) {
      if (bojo[bojo.length - 1] !== order[i])
        break;
      // 중단 조건
    }
    if (order[i] === belt[j]) {
      // 박스 번호가 벨트에 있는 번호랑 같은 경우
      i++;
      j++;
      answer++;
      continue;
    }
    if (order[i] === bojo[bojo.length - 1]) {
      // 박스 번호가 보조 벨트 끝 번호랑 같은 경우
      bojo.pop();
      i++;
      answer++;
      continue;
    }
    // 둘 다 아닌 경우
    bojo.push(belt[j]);
    j++
  }
  return answer;
}
