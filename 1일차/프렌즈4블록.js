function solution(m, n, board) {
  var answer = 0;
  let init = [];
  for (let i = 0; i < m; i++) {
    init.push(Array.from(board[i]));
  }

  let compare = [];
  let cmpData = [];
  while (true) {
    let newData = [];
    for (let i = 0; i < m; i++) {
      newData.push([]);
      for (let j = 0; j < n; j++) {
        newData[i].push(1);
      }
    }
    // 같은 부분 찾기
    for (let i = 0; i < m - 1; i++) {
      for (let j = 0; j < n - 1; j++) {
        compare.push(init[init.length - (1 + i)][j]);
        compare.push(init[init.length - (1 + i)][j + 1]);
        compare.push(init[init.length - (2 + i)][j]);
        compare.push(init[init.length - (2 + i)][j + 1]);
        if (!compare.some((ele) => ele !== init[init.length - (1 + i)][j])) {
          newData[init.length - (1 + i)][j] = 0;
          newData[init.length - (1 + i)][j + 1] = 0;
          newData[init.length - (2 + i)][j] = 0;
          newData[init.length - (2 + i)][j + 1] = 0;
        }

        compare = [];
      }
    }
    const getResult = function (a1, a2) {
      let i = a1.flat().length;
      if (i != a2.flat().length) {
        return false;
      }

      for (let j = 0; j < a1.length; j++) {
        for (let k = 0; k < a1[j].length; k++) {
          if (a1[j][k] !== a2[j][k]) {
            return false;
          }
        }
      }
      return true;
    };

    for (let i = 0; i < newData.length; i++) {
      for (let j = 0; j < newData[i].length; j++) {
        if (!newData[i][j]) {
          init[i][j] = newData[i][j];
        }
      }
    }
    if (getResult(newData, cmpData)) {
      init.forEach((rowData, i) => {
        rowData.forEach((cellData, j) => {
          if (cellData <= 0) {
            answer += 1;
          }
        });
      });
      return answer;
    } else {
      cmpData = [...newData];
      // console.log(cmpData);
    }
    for (let i = init.length - 1; i >= 0; i--) {
      for (let j = 0; j < init[i].length; j++) {
        if (init[i][j]) continue;
        let rowIdx = i - 1;
        while (rowIdx > -1) {
          if (init[rowIdx][j]) {
            init[i][j] = init[rowIdx][j];
            init[rowIdx][j] = 0;
            break;
          }
          rowIdx--;
        }
      }
    }
  }
}
