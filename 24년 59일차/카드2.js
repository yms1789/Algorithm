const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map(Number);
const N = input[0];
// let queue = Array.from({ length: N }, (_, idx) => idx + 1);
// while (queue.length > 1) {
//   let slice = queue.splice(0, 2);
//   queue.push(slice[1]);
// }

// console.log(queue[0]);

class Node {
  constructor(val) {
    this.val = val;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }
  enqueue(val) {
    let newNode = new Node(val);
    if (!this.head) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      this.tail.next = newNode;
      this.tail = newNode;
    }
    queue.length++;
  }
  dequeue() {
    if (!this.head) {
      return null;
    }
    let temp = this.head;
    if (this.head === this.tail) {
      this.tail = null;
    }
    this.head = this.head.next;
    this.length--;

    return temp.val;
  }
}

let queue = new Queue();

for (let i = 1; i <= N; i++) {
  queue.enqueue(i);
}
while (queue.length > 1) {
  queue.dequeue();
  queue.enqueue(queue.dequeue());
}
console.log(queue.head.val);
