function solution(n, k) {
  let answer = 0;
  // 소수 판별기
  // 소수 = 1과 자기 자신만 약수로 갖는 수
  function isPrime(num) {
    
    if (num === 1) {
      return false;
    }
    for (i = 2; i < num; i++) {
      if (num % i === 0) {
        return false;
      }
    }
    return true;
  }

  // 진수 변환
  function traslation(num, k) {
    let kNum = [];
    while (n > k) {
      kNum.push(n % k);
      n = Math.floor(n / k);
    }
    kNum.push(n % k);
    return kNum.reverse();
  }

  let transNum = traslation(n, k).toString().split(/0+/).map(ele => ele.split(',').join(""));
  
  for (let i = 0; i < transNum.length; i++){
    isPrime(parseInt(transNum[i])) ? answer += 1 : answer;
  }
  return answer;
}

console.log(solution(437674, 3));
