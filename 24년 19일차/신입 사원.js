const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [T] = input.shift();

for (let i = 0; i < T; i++) {
  let [N] = input.shift();
  let persons = input.splice(0, N);
  // 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발
  // persons[i][0] = 서류, persons[i][1] = 면접

  // 서류 심사 석차 순으로 정렬
  persons.sort((a, b) => a[0] - b[0]);

  let interviewScore = persons[0][1];

  // 서류 석차 1등을 기준으로 해당 학생의 면접 석차보다 더 석차가 좋은 학생의 숫자를 구해서 count++
  // count한 뒤에는 면접 석차를 다음 학생의 석차로 바꿈
  let count = 1;
  for (let j = 1; j < persons.length; j++) {
    if (interviewScore >= persons[j][1]) {
      count++;
      interviewScore = persons[j][1];
    }
  }

  console.log(count);
}
