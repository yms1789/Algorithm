function solution(s) {
  let answer = s.split(" ");
  answer = answer.map((ele) => parseInt(ele));

  let min = Math.min(...answer);
  min = min.toString();

  let max = Math.max(...answer);
  max = max.toString();

  min = min.concat(" ", max);

  return min;
}
