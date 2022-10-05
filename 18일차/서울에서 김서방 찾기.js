function solution(seoul) {
  // solution 1(for loop)
  for(let i = 0 ; i < seoul.length; i++){
      if(seoul[i] === "Kim"){
          return `김서방은 ${i}에 있다`;
      }
  }

  // solution 2(Array.indexOf())
  return `김서방은 ${seoul.indexOf("Kim")}에 있다`;
}
