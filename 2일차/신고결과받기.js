function solution(id_list, report, k) {
  let answer = new Array(id_list.length).fill(0);
  let reportCount = new Array(id_list.length).fill(0);
  report = [...new Set(report)]; // 중복 신고 제거
  let reportList = [];
  for (let i = 0; i < id_list.length; i++) {
    reportList.push([]);
  }
  for (let i = 0; i < report.length; i++) {
    const reporting = report[i].split(" ")[0];
    const reported = report[i].split(" ")[1];
    const reportingIdx = id_list.findIndex((element) => element === reporting);
    const reportedIdx = id_list.findIndex((element) => element === reported);
    reportCount[reportedIdx] += 1;
    reportList[reportingIdx].push(reported); // 유저가 신고한 ID
  }
  for (let i = 0; i < reportCount.length; i++) {
    if (reportCount[i] < k) {
      continue;
    }
    reportList.forEach((report, idx) => {
      if (report.includes(id_list[i])) {
        answer[idx]++;
      }
    });
  }
  return answer;
}
