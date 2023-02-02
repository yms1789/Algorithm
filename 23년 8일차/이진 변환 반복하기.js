function solution(s) {
  let answer = [0, 0];
  while (s !== "1") {
    let one = "";
    for (let binary of s) {
      if (binary === "1") {
        one += binary;
      } else {
        answer[1] += 1;
      }
    }
    answer[0] += 1;
    s = one.length.toString(2);
  }
  console.log(answer);
}
