// function solution(n, left, right) {
//   let answer = Array.from({ length: n }, () =>
//     Array.from({ length: n }, () => 0)
//   );

//   let dir = [
//     [1, 1],
//     [1, 0],
//     [0, 1],
//   ];
//   answer[0][0] = 1;
//   let queue = [];
//   queue.push([0, 0]);
//   while (queue.length) {
//     let [curx, cury] = queue.shift();
//     for (let move of dir) {
//       let nx = curx + move[0];
//       let ny = cury + move[1];
//       if (nx < n && ny < n) {
//         if (answer[nx][ny] === 0) {
//           answer[nx][ny] += answer[curx][cury] + 1;
//           queue.push([nx, ny]);
//         } else {
//           continue;
//         }
//       }
//     }
//   }
//   answer = answer.flat();
//   return answer.slice(left, right + 1);
// }

function solution(n, left, right) { 
  let answer = [];
  for (let i = left; i <= right; i++) { 
    console.log(Number.parseInt(i / n), i % n);
    answer.push(Math.max(Number.parseInt(i / n), i % n) + 1);
  }
}

solution(3, 2, 5);

// 0 1 2 3 4 5 6 7 8 , n = 3
// 1 2 3 2 2 3 3 3 3