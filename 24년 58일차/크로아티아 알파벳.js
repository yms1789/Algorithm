const fs = require("fs");
const filePath = process.platform !== "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n");

let alphabets = input[0];

const croatiaAlpha = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="];

let answer = 0;

for (let i = 0; i < croatiaAlpha.length; i++) {
  alphabets = alphabets.split(croatiaAlpha[i]).join("Z");
}

console.log(alphabets.length);
