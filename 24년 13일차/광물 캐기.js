function solution(picks, minerals) {
  let answer = 0;
  let totalGok = picks.reduce((acc, cur) => acc + cur, 0);
  minerals = minerals.splice(0, totalGok * 5);

  let needGok = Math.ceil(minerals.length / 5);

  let order = [];
  for (let i = 0; i < needGok; i++) {
    let mObj = { diamond: 0, iron: 0, stone: 0 };
    let mining = minerals.splice(0, 5);
    mining.forEach((ele) => {
      mObj[ele]++;
    });
    let diaGok = mObj["diamond"] + mObj["iron"] + mObj["stone"];
    let ironGok = mObj["diamond"] * 5 + mObj["iron"] + mObj["stone"];
    let stoneGok = mObj["diamond"] * 25 + mObj["iron"] * 5 + mObj["stone"];

    order.push([diaGok, ironGok, stoneGok]);
  }

  order.sort((a, b) => {
    return b[2] - a[2];
  });

  for (let i = 0; i < 3; i++) {
    let pickCnt = picks[i];
    while (pickCnt > 0) {
      if (!order.length) return answer;
      answer += order.shift()[i];
      pickCnt--;
    }
  }
  return answer;
}
