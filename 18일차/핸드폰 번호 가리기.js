function solution(phone_number) {
  let backNum = phone_number.slice(-4);
  let empty = phone_number.substring(0, phone_number.length - 4);
  empty = empty.replaceAll(/\w/g, "*");
  return empty + backNum;
}

// 다른 사람 풀이
function solution(phone_number) {
  var result = "*".repeat(phone_number.length - 4) + phone_number.slice(-4);

  return result;
}