function solution(str1, str2) {
  let str1Set = {};
  let str2Set = {};
  let regx = /([a-z]){2}/g;
  str1 = str1.toLowerCase();
  str2 = str2.toLowerCase();
  for (let i = 0; i < str1.length - 1; i++) {
    let subStr1 = "";
    subStr1 = str1[i] + str1[i + 1];
    if (!subStr1.match(regx)) {
      continue;
    }
    str1Set[subStr1] = (str1Set[subStr1] || 0) + 1;
  }
  for (let j = 0; j < str2.length - 1; j++) {
    let subStr2 = "";
    subStr2 = str2[j] + str2[j + 1];
    if (!subStr2.match(regx)) {
      continue;
    }
    str2Set[subStr2.toLowerCase()] = (str2Set[subStr2.toLowerCase()] || 0) + 1;
  }

  let intersection = 0;
  for (const ele in str1Set) {
    if (ele in str2Set) {
      intersection += Math.min(str1Set[ele], str2Set[ele]);
    }
  }
  let str1Sum = Object.values(str1Set).reduce((a, b) => a + b, 0);
  let str2Sum = Object.values(str2Set).reduce((a, b) => a + b, 0);
  // 합집합 = 집합 A + 집합 B - 교집합
  let union = str1Sum + str2Sum - intersection;
  return union ? Math.floor(65536 * (intersection / union)) : 65536;

}
