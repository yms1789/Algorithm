const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

class MinHeap {
  constructor() {
    this.heap = [];
  }
  getLength = () => {
    return this.heap.length;
  };
  push = (node) => {
    this.heap.push(node);
    let i = this.heap.length - 1;
    let parentI = Math.floor((i - 1) / 2);
    while (i > 0 && this.heap[parentI] > this.heap[i]) {
      this.swap(i, parentI);
      i = parentI;
      parentI = Math.floor((i - 1) / 2);
    }
  };
  pop = () => {
    if (this.heap.length === 1) {
      return this.heap.pop();
    }
    const result = this.heap[0];

    this.heap[0] = this.heap.pop();
    let i = 0;
    while (true) {
      const leftI = i * 2 + 1,
        rightI = i * 2 + 2;
      if (leftI >= this.heap.length) {
        break;
      }
      let nextI = i;
      if (this.heap[nextI] > this.heap[leftI]) {
        nextI = leftI;
      }
      if (rightI < this.heap.length && this.heap[nextI] > this.heap[rightI]) {
        nextI = rightI;
      }
      if (nextI === i) {
        break;
      }
      this.swap(i, nextI);
      i = nextI;
    }
    return result;
  };
  swap = (a, b) => {
    const temp = this.heap[a];
    this.heap[a] = this.heap[b];
    this.heap[b] = temp;
  };
}

const minHeap = new MinHeap();
input = input.map((ele) => Number(ele));
for (let i = 1; i < input.length; i++) {
  minHeap.push(input[i]);
}

let answer = 0;
while (minHeap.getLength() > 1) {
  let a = minHeap.pop();
  let b = minHeap.pop();
  let hap = a + b;
  answer += hap;
  minHeap.push(hap);
}
console.log(answer);
