/** 1. sameFrequency */
function sameFrequency(num1, num2) {
  let freqCheck1 = {};
  let freqCheck2 = {};
  let answer = true;
  num1 = num1.toString();
  num2 = num2.toString();
  if (num1.length !== num2.length) {
    return false;
  }

  for (let i = 0; i < num1.length; i++) {
    freqCheck1[num1[i]] = (freqCheck1[num1[i]] || 0) + 1;
  }
  for (let i = 0; i < num2.length; i++) {
    freqCheck2[num2[i]] = (freqCheck2[num2[i]] || 0) + 1;
  }
  Object.keys(freqCheck2).forEach((element) => {
    if (
      !(element in freqCheck1) ||
      freqCheck2[element] !== freqCheck1[element]
    ) {
      answer = false;
    }
  });
  return answer;
}

/** 2. areThereDuplicates */
function areThereDuplicates() {
  // good luck. (supply any arguments you deem necessary.)
  let arr = [...arguments];
  arr = arr.sort();
  let i = 0;
  if (!arr.length) {
    return false;
  }
  for (let j = 1; j < arr.length; j++) {
    if (arr[i] !== arr[j]) {
      i++;
    }
  }
  return i + 1 === arr.length ? false : true;
}

/** 3. averagePair */
function averagePair(arr, avg) {
  // add whatever parameters you deem necessary - good luck!
  let last = arr.length - 1;
  let i = 0;
  let avg_arr = 0;

  if (arr.length === 0) {
    return false;
  }

  while (i < last) {
    avg_arr = (arr[i] + arr[last]) / 2;
    if (avg < avg_arr) {
      last--;
    } else if (avg > avg_arr) {
      i++;
    } else {
      return true;
    }
  }
  return false;
}

/** 4. isSubsequence */
function isSubsequence(str1, str2) {
  let str1_check = 0;
  for (let i = 0; i < str2.length; i++) {
    if (str1_check === str1.length - 1) {
      return true;
    }
    if (str1[str1_check] === str2[i]) {
      str1_check++;
    }
  }
  return false;
}