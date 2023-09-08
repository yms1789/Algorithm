function solution(input_string) {
  let answer = "";
  let dict = {};

  for (let i = 0; i < input_string.length; i++) {
    dict[input_string[i]] = (dict[input_string[i]] || 0) + 1;
  }
  Object.keys(dict).forEach((ele) => {
    if (dict[ele] > 1) {
      let fIndex = input_string.indexOf(ele);
      let spliceAlpha = input_string.slice(fIndex, fIndex + dict[ele]);

      if ([...new Set(spliceAlpha)].length > 1) {
        answer += ele;
      }
    }
  });
  if (answer.length <= 0) return "N";
  answer = answer.split("").sort();
  return answer.join("");
}
