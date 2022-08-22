function solution(X, Y) {
  let len = Math.max(X.length, Y.length);
  X_arr = Array.from(X);
  Y_arr = Array.from(Y);
  let pairs = [];
  // X: 5525, Y: 1255
  for (let i = 0; i < len; i++) {
    if (X_arr.length <= 0 || Y_arr.length <= 0) {
      break;
    }
    if (X_arr.includes(Y[i])) {
      pairs.push(Y[i]);
      console.log(`pair: ${pairs}, y: ${i}`);
      Y_arr.splice(i, 1);
      let x_idx = X_arr.findIndex((ele) => ele === Y[i]);
      X_arr.splice(x_idx, 1);
    }
  }

  if (pairs.length <= 0) {
    return -1;
  } else if (pairs.reduce((a, b) => a + b) <= 0) {
    return 0;
  } else {
    pairs = pairs.sort((a, b) => b - a);
    pairs = pairs.join("");
    return pairs;
  }
}
// 1. X의 숫자 중 Y에 포함되는 값이 있는지 확인
// 2. 포함되나?
//  2.1. 된다면, 짝이 있는 지 판단
// 2.1.1. 짝이 있나?
//  짝이 있으면 pairs에 넣고 해당 값을 두 배열에서 제거
//  짝이 없으면 continue
//  2.2. 포함 안되면 continue
// 3. 위 과정을 두 배열 중 하나의 배열의 크기가 0이 될 때 까지 반복
// 4. pair을 내림차순으로 정렬 뒤 출력

const res = solution("33613123", "12316");
console.log(res);
