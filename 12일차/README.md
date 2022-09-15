## 🌀 reverse

- 문제 유형: Udemy 코딩연습(재귀)
- 문제 내용
  - 재귀를 사용해서 입력받은 문자열을 역순으로 리턴하는 문제
  - ex)
    ```jsx
    reverse('awesome') // 'emosewa'
    reverse('rithmschool') //'loohcsmhtir'
    ```
- solution
  - 입력받은 문자열의 첫번째 문자를 맨 뒤로 돌리는 과정을 재귀를 사용해서 반복함

## 🌀 isPalindrome
- 문제 유형: Udemy 코딩연습(재귀)
- 문제 내용
  - 재귀를 사용해서 입력받은 문자열이 회문인지 아닌지를 리턴하는 문제
  - ex)
    ```jsx
    isPalindrome('awesome') // false
    isPalindrome('foobar') // false
    isPalindrome('tacocat') // true
    isPalindrome('amanaplanacanalpanama') // true
    isPalindrome('amanaplanacanalpandemonium') // false
    ```
- solution
  - 재귀를 이용해 문자열 앞 뒤를 1글자씩 잘라냄
  - 입력받은 문자열의 첫번째 문자와 마지막분자를 비교해서 같지 않으면 `false` 리턴
  - 문자열의 길이가 끝날 때 까지 문자열의 앞 뒤가 같다면 true 리턴

- 다른 사람 풀이
  ```jsx
  function isPalindrome(str){
    if(str.length === 1) return true;
    if(str.length === 2) return str[0] === str[1];
    if(str[0] === str.slice(-1)) return isPalindrome(str.slice(1,-1))
    return false;
  }
  ```

