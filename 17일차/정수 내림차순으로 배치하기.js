function solution(n) {
  return parseInt(
    (n + "")
      .split("")
      .sort((a, b) => b - a)
      .map((ele) => parseInt(ele))
      .join("")
  );
}
 