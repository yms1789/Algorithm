function solution(sequence, k) {
  let answer = [0, 1000000];
  let [left, right] = [0, 0];
  let sum = sequence[0];
  while (right < sequence.length) {
    if (sum === k) {
      if (answer[1] - answer[0] > right - left) {
        answer[0] = left;
        answer[1] = right;
      }
      sum -= sequence[left];
      left++;

      right++;
      sum += sequence[right]
    } else if (sum < k) {
      right++;
      sum += sequence[right];
    } else {
      sum -= sequence[left];
      left++;
    }
  }
  return answer;
}