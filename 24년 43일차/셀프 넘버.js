let num = 1;
let visited = Array(10001).fill(false);

function d(num) {
  let sum = num;

  while (num > 0) {
    sum = sum + (num % 10);
    num = parseInt(num / 10);
  }
  return sum;
}

for (let i = 1; i <= 10000; i++) {
  let next = d(i);
  if (next <= 10000) {
    visited[next] = true;
  }
  num++;
}

for (let i = 1; i <= 10000; i++) {
  if (!visited[i]) console.log(i);
}
