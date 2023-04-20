function solution(operations) {
  let answer = [];
  for (let i = 0; i < operations.length; i++) {
    let type = operations[i].slice(0, 1);
    let num = Number(operations[i].slice(2));
    if (type === "I") {
      answer.push(num);
    } else if (type === "D") {
      if (!answer.length) continue;
      if (num === 1) {
        answer.splice(
          answer.findIndex((ele) => ele === Math.max(...answer)),
          1
        );
      } else {
        answer.splice(
          answer.findIndex((ele) => ele === Math.min(...answer)),
          1
        );
      }
    }
  }
  if (!answer.length) {
    return [0, 0];
  } else {
    let maxNum = Math.max(...answer) === null ? 0 : Math.max(...answer);
    let minNum = Math.min(...answer) === null ? 0 : Math.min(...answer);
    return [maxNum, minNum];
  }
}
