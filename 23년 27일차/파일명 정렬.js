function solution(files) {
  let answer = [];
  let headNum = [];
  for (let file of files) {
    let head = "";
    let rest;
    let number = "";
    let tail;
    for (let i = 0; i < file.length; i++) {
      // head 떼네기
      if (Number.isInteger(Number.parseInt(file[i]))) {
        rest = file.substring(i, file.length);
        break;
      } else {
        head += file[i];
      }
    }
    let numCount = 0;
    for (let i = 0; i < rest.length; i++) {
      if (Number.isInteger(Number.parseInt(rest[i])) && numCount < 5) {
        number += rest[i];
        numCount++;
      } else {
        tail = rest.substring(i, rest.length);
        break;
      }
    }
    if (tail !== undefined) {
      headNum.push([head, number, tail]);
    } else { 
      headNum.push([head, number]);
    }
  }
  // head로 먼저 정렬
  headNum.sort(function (a, b) {
    if (a[0].toLowerCase() < b[0].toLowerCase()) {
      return -1;
    } else if (a[0].toLowerCase() > b[0].toLowerCase()) {
      return 1;
    } else {
      return parseInt(a[1]) - parseInt(b[1]);
    }
  });
  for (let i = 0; i < headNum.length; i++) {
    let str = headNum[i].join("");
    answer.push(str);
  }
  return answer;
}
