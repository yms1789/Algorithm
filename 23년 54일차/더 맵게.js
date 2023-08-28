class MinHeap {
  constructor() {
    this.heap = [];
  }
  size() {
    return this.heap.length;
  }
  peek() {
    return this.heap[0];
  }

  push(value) {
    this.heap.push(value);
    let idx = this.heap.length - 1;

    while (idx > 0 && this.heap[idx] < this.heap[Math.floor((idx - 1) / 2)]) {
      let temp = this.heap[idx];
      this.heap[idx] = this.heap[Math.floor((idx - 1) / 2)];
      this.heap[Math.floor((idx - 1) / 2)] = temp;
      idx = Math.floor((idx - 1) / 2);
    }
  }
  pop() {
    if (this.heap.length === 0) return null;
    if (this.heap.length === 1) return this.heap.pop();

    const minValue = this.heap[0];
    this.heap[0] = this.heap.pop();

    let idx = 0;
    while (idx * 2 + 1 < this.heap.length) {
      let minChildIndex =
        idx * 2 + 2 < this.heap.length &&
        this.heap[idx * 2 + 2] < this.heap[idx * 2 + 1]
          ? idx * 2 + 2
          : idx * 2 + 1;
      if (this.heap[idx] < this.heap[minChildIndex]) {
        break;
      }
      let temp = this.heap[idx];
      this.heap[idx] = this.heap[minChildIndex];
      this.heap[minChildIndex] = temp;
      idx = minChildIndex;
    }
    return minValue;
  }
}
function solution(scoville, K) {
  let answer = 0;

  let minHeap = new MinHeap();

  scoville.forEach((ele) => minHeap.push(ele));

  while (minHeap.size() >= 2 && minHeap.peek() < K) {
    let low1 = minHeap.pop();
    let low2 = minHeap.pop();

    let mixScovile = low1 + low2 * 2;
    minHeap.push(mixScovile);
    answer++;
  }
  if (minHeap.peek() < K) {
    return -1;
  } else {
    return answer;
  }
}
