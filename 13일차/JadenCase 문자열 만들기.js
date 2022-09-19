function solution(s) {
  let answer = "";
  let word = s.split(" ");
  word = word.map((ele) => ele.toLowerCase());
  for (let i = 0; i < word.length; i++) {
    let [upper, lower] = [word[i].slice(0, 1).toUpperCase(), word[i].slice(1)];
    let modWord = upper + lower;
    if (i === word.length - 1) answer = answer.concat(modWord);
    else answer = answer.concat(modWord + " ");
  }
  return answer;
}
