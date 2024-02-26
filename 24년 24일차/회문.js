const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

let input = stdin.split("\n");

const N = parseInt(input.shift());

function isPalindrome(str) {
  return str === str.split("").reverse().join("");
}

for (let i = 0; i < N; i++) {
  // 투포인터로
  let str = input[i];
  if (isPalindrome(str)) console.log(0);
  else {
    let [left, right] = [0, str.length - 1];
    let familiar = false;
    for (let j = 0; j < parseInt(str.length / 2); j++) {
      if (str[left + j] !== str[right - j]) {
        if (isPalindrome(str.slice(0, left + j) + str.slice(left + j + 1)))
          familiar = true;
        if (isPalindrome(str.slice(0, right - j) + str.slice(right - j + 1)))
          familiar = true;
        break;
      }
    }
    console.log(familiar ? 1 : 2);
  }
}
