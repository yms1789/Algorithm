const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : 'test.txt';
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map(ele => ele.split(" ").map(Number));

const N = input[0][0];

const tastes = input.slice(1);
let diff = Number.MAX_VALUE;
function dfs(index, depth, arr = []){
	if(depth > N){
		return;
	}	
	for(let i = index; i < N; i++){
		arr.push(tastes[i]);		
		diff = Math.min(diff, calcTaste(arr));
		dfs(i + 1, depth + 1, arr);
		arr.pop();
	}
}
function calcTaste(arr){
	let bitter = 0;
	let sour = 1;
	arr.forEach(ele => {
		sour *= ele[0];
		bitter += ele[1];
	});
	return Math.floor(Math.abs(bitter - sour));
}
dfs(0, 0)
console.log(diff);