/**
 * <유클리드 호제법>
 * GCD(최대 공약수) pusedo code
 * GCD(A, B) = GCD(B, A % B)
 * if A % B = 0 -> GCD = B
 * else GCD(B, A % B)
 *
 * LCM(최소 공배수) psuedo code
 * LCM(A, B) = A * B  GCD(A, B)
 */

// recursive
function solution(n, m) {
  function gcd(a, b) {
    if (b === 0) return a;
    else return gcd(b, a % b);
  }
  function lcm(a, b) {
    return Math.round((a * b) / gcd(a, b));
  }
  let answer = [];
  answer.push(gcd(n, m));
  answer.push(lcm(n, m));
  return answer;
}

// 다른 사람 풀이(for loop)
function gcdlcm(a, b) {
  var r;
  for (var ab = a * b; (r = a % b); a = b, b = r) {}
  return [b, ab / b];
}
