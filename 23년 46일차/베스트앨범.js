function solution(genres, plays) {
    let answer = [];
    // 많이 재생된 노래를 두 개씩 모아야 함
    let album = {};
    for(let i = 0 ; i < genres.length; i++){
        album[genres[i]] = (album[genres[i]] || 0) + plays[i];
    }
    let sortAlbum = [];
    for (let genres in album) {
        sortAlbum.push([genres, album[genres]]);
    }
    
    sortAlbum.sort((a, b) => b[1] - a[1]);
    
    for(let i = 0; i < sortAlbum.length; i++){
        let genr = [];
        for(let j = 0; j < genres.length; j++){
            if(sortAlbum[i][0] === genres[j]){
                genr.push([j, plays[j]]);
            }
        }
        genr.sort((a, b) => b[1] - a[1]);
        answer.push(genr.map(ele => ele[0]).slice(0, 2));
    }
    
    return answer.flat();
}