function solution(a) {
  let answer = 1;

  // 인접한 두 풍선을 고른 뒤 하나를 터트림
  // 터진 풍선으로 풍선 사이에 빈 공간이 생기면 풍선을 중앙으로 밀착
  // 두 풍선 중 번호가 작은 풍선을 터트리는 행위는 최대 1번(나머지는 다 큰거 터트려야 함)
  // 어떤 풍선이 최후까지 남는지
  // 투포인터!
  let leftMin = a[0];
  let leftIdx = 0;

  let rightMin = a[a.length - 1];
  let rightIdx = a.length - 1;
  while (leftIdx < rightIdx) {
    if (leftMin > rightMin) {
      leftIdx++;
      if (leftMin > a[leftIdx]) {
        answer++;
        leftMin = a[leftIdx];
      }
    }
    if (leftMin < rightMin) {
      rightIdx--;
      if (rightMin > a[rightIdx]) {
        answer++;
        rightMin = a[rightIdx];
      }
    }
  }
  return answer;
}
