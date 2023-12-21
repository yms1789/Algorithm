const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : 'test.txt';
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map(ele => ele.split(" "));

const N = Number(input[0][0]);

const words = input.slice(1);
const snippets = [' '];
let res = [];

for(let i = 0; i < words.length; i++){
	let check = false;
	for(let j = 0; j < words[i].length; j++){
		let wordArr = words[i][j].split("");
		if(!snippets.includes(wordArr[0].toLowerCase())){
			snippets.push(wordArr[0].toLowerCase());
			wordArr[0] = `[${wordArr[0]}]`;
			words[i][j] = wordArr.join("");
			check = true;
			break;
		}
	}
	if(!check){
		let wordArr = words[i].join(" ").split("");
		for(let j = 0; j < wordArr.length; j++){
			if(!snippets.includes(wordArr[j].toLowerCase())){
				snippets.push(wordArr[j].toLowerCase());
				wordArr[j] = `[${wordArr[j]}]`;
				words[i] = wordArr.join("").split(" ");
				break;
			}
		}
		
	}
	res.push(words[i]);
}

for(let i = 0; i < N; i++){
	console.log(res[i].join(" "));
}

