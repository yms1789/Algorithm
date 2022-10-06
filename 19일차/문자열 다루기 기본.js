function solution(s) {
  let answer = false;
  if (s.length === 4 || s.length === 6) {
    answer = isNaN(s) ? false : s.includes("e") ? false : true;
  }

  return answer;
}


// 다른 사람 풀이(정규식)
function solution(s) {
  var regex = /^\d{6}$|^\d{4}$/;
  return regex.test(s);
}