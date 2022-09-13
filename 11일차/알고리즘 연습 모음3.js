/** 1. power */
function power(base, exp) {
  if (exp <= 0) {
    return 1;
  }
  return base * power(base, exp - 1);
}

/** 2. factorial */
function factorial(num) {
  if (num <= 1) {
    return 1;
  }
  if (num < 0) {
    return 0;
  }
  return num * factorial(num - 1);
}

/** 3. productOfArray */
function productOfArray(arr) {
  if (!arr.length) {
    return 1;
  }
  return arr[0] * productOfArray(arr.slice(1));
}

/** 4. recursiveRange */
function recursiveRange(num) {
  if (num === 1) {
    return 1;
  }
  return num + recursiveRange(num - 1);
}

/** 5. fib */
function fib(num) {
  if (num == 1 || num == 2) {
    return 1;
  }
  return fib(num - 1) + fib(num - 2);
}
