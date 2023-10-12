const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map(Number);
const test = input.shift();

let apartment = Array.from({length: 15}, () =>
  Array.from({length: 15}, () => 0)
);
apartment[0].map((_, idx, apartment) => {
  apartment[idx] = idx;
});

for (let i = 1; i <= 14; i++) {
  for (let j = 0; j <= 14; j++) {
    apartment[i][j] += apartment[i - 1]
      .filter((_, idx) => idx <= j)
      .reduce((acc, curr) => acc + curr, 0);
  }
}
for (let i = 0; i < test; i++) {
  let [n, k] = input.splice(0, 2);
  console.log(apartment[n][k]);
}
// a층의 b호에 살려면 자신의 아래(a-1)층의
// 1호부터 b호까지 사람들 수 합만큼 데려와 살아야 함
