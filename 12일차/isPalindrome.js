function isPalindrome(str) {
  let len = str.length;
  if (str[0] !== str[str.length - 1]) {
    return false;
  }
  if (str.length <= 0) {
    return true;
  }
  return isPalindrome(str.slice(1, len - 1));
}
