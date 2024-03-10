const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n");

const N = parseInt(input[0]);

const files = input.slice(1);

let extensions = {};
for (let i = 0; i < files.length; i++) {
  let extension = files[i].split(".")[1];
  extensions[extension] = (extensions[extension] || 0) + 1;
}
let extensionsArr = Object.entries(extensions);
extensionsArr.sort((a, b) => {
  if (a[0] > b[0]) return 1;
  return -1;
});

extensionsArr.forEach((ele) => {
  console.log(ele[0], ele[1]);
});
