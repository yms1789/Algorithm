function solution(sticker) {
    let answer = 0;
    if(sticker.length === 1){
        return sticker[0];
    }
    let dp = Array(sticker.length).fill(0);
    dp[0] = sticker[0];
    dp[1] = Math.max(sticker[0], sticker[1]);

    for(let i = 2; i < sticker.length - 1; i++){
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
    }
    
    let dp2 = Array(sticker.length).fill(0);
    dp2[0] = 0;
    dp2[1] = sticker[1];
    
    for(let i = 2; i < sticker.length; i++){
        dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]); 
    }
    
    answer = Math.max(Math.max(...dp), Math.max(...dp2));
    return answer;
}