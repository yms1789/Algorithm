const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './test.txt';
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map(ele => ele.split(" ").map(Number));
const [N] = input[0];
const arr = input[1];
function binarySearch(arr){
	let lis = [];	
	lis.push(arr[0]);
	
	for(let i = 1; i < N; i++){
		if(lis[lis.length - 1] < arr[i]){
			lis.push(arr[i]);
		} else {
			let lo = 0;
			let hi = lis.length - 1;
			while(lo < hi){
				let mid = Math.floor((lo + hi) / 2);
				if(lis[mid] < arr[i])
					lo = mid + 1;
				else
					hi = mid;
			}
			lis[hi] = arr[i];
		}
	}
	return lis.length;
}
console.log(binarySearch(arr));