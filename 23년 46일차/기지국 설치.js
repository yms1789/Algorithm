function solution(n, stations, w) {
    let answer = 0;

    let broadcasts = [];
    if(stations[0] - w - 1 >= 1){
        broadcasts.push([1, stations[0] - w - 1]);
    }
    for(let i = 0; i < stations.length - 1; i++){
        let start = stations[i] + w + 1;
        let end = stations[i + 1] - w - 1;
        if(start <= end){
            broadcasts.push([start, end]);
        }
    }
    if(stations[stations.length - 1] + w + 1 <= n){
        broadcasts.push([stations[stations.length - 1] + w + 1, n]);
    }
    for(let broadcast of broadcasts){
        let length = broadcast[1] - broadcast[0] + 1;
        if(length <= 2 * w + 1){
            answer++;
        } else{
            answer += Math.ceil(length / (2 * w + 1));
        }
        
    }
    return answer;
}