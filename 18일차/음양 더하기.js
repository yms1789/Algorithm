function solution(absolutes, signs) {
  let answer = 0;
  absolutes.forEach((ele, idx) =>
    signs[idx] ? (answer += ele) : (answer += ele * -1)
  );
  return answer;
}
