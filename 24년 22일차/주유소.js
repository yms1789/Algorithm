const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n");

const N = parseInt(input[0]);
const roadLength = input[1].split(" ").map(Number);
const costs = input[2].split(" ").map(Number);

// 도시 개수는 최대 100,000
// 가장 왼쪽 도시에서 오른쪽 도시까지 갈 때 최소 비용으로 주유해서 가는 비용을 구하자

let [cur, next] = [0, 1];
let sum = BigInt(0);
while (next < roadLength.length) {
  sum += BigInt(roadLength[next - 1]) * BigInt(costs[cur]);
  if (costs[cur] >= costs[next]) {
    cur = next;
  }
  next++;
}
sum += BigInt(roadLength[next - 1]) * BigInt(costs[cur]);
console.log(String(sum));
