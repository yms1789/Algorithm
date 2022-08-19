function solution(w, h) {
  let answer = 0;
  for (i = 1; i < w; i++) {
    let square = Math.floor((h * i) / w);
    answer += square;
  }
  return answer * 2;
}
