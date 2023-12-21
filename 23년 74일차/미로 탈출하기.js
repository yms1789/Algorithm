const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : 'test.txt';
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n");
const [N, M] = input[0].split(" ").map(Number);
const miro = input.slice(1);

const move = {
	"U": [-1, 0],
	"R": [0, 1],
	"D": [1, 0],
	"L": [0, -1]
};

let escapeCnt = 0;
let dp = Array.from({length: N}, () => Array.from({length: M}, () => -1));
function escape(r, c){
	if (r < 0 || c < 0 || r >= N || c >= M) return 1;
	if (dp[r][c] > -1) return dp[r][c];
	
	dp[r][c] = 0;
	let dir = miro[r][c];
	dp[r][c] = escape(r + move[dir][0], c + move[dir][1]);
	
	return dp[r][c];
	
}
for(let i = 0; i < N; i++){
	for(let j = 0; j < M; j++){
		escapeCnt += escape(i, j);
	}
}

console.log(escapeCnt);
