const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './test.txt';
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map(ele => ele.split(" ").map(Number));
const [N, M] = input[0];
const arr = input[1];

arr.sort((a, b) => a - b);

let res = [];

function dfs(idx, depth, subset = []){
	if(depth === M){
		let subsetString = subset.join(",");
		if(!res.includes(subsetString))
			res.push(subsetString);
	}
	
	for(let i = idx; i < N; i++){
		subset.push(arr[i]);
		dfs(i + 1, depth + 1, subset);
		subset.pop();
	}
}

dfs(0, 0);
res = res.map(ele => ele.split(",").join(" "));
res.forEach(ele => console.log(ele.trim()));
