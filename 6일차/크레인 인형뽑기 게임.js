function solution(board, moves) {
  let answer = 0;
  let row = board[0].length;
  let col = board.length;
  let basket = [];
  let crane_idx = 0;

  while (crane_idx <= moves.length - 1) {
    let isDoll = null;
    let move = moves[crane_idx] - 1;
    for (let i = 0; i < row; i++) {
      if (board[i][move]) {
        isDoll = i;
        break;
      }
    }
    if (isDoll === null) {
      crane_idx++;
      continue;
    }
    basket.push(board[isDoll][move]);
    board[isDoll][move] = 0;
    if (basket.length >= 2) {
      if (basket[basket.length - 1] === basket[basket.length - 2]) {
        basket.pop();
        basket.pop();
        answer += 2;
      }
    }
    crane_idx++;
  }
  return answer;
}