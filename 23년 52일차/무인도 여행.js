function solution(maps) {
    let answer = [];
    let visited = Array.from({length: maps.length}, (_, i) => Array(maps[0].length).fill(false));
    let dx = [1, -1 , 0, 0];
    let dy = [0, 0, -1, 1];
    
    function bfs(row, col){
      let queue = [[row, col]];
      visited[row][col] = true;
      let stayDay = Number(maps[row][col]);
      while(queue.length){
          let [cx, cy] = queue.shift();
          for(let i = 0; i < 4; i++){
              let nx = cx + dx[i], ny = cy + dy[i];
              if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length || visited[nx][ny]){
                  continue;
              }
  
              if(maps[nx][ny] === 'X'){
                  continue;
              }
              queue.push([nx, ny]);
              visited[nx][ny] = true;
              stayDay += Number(maps[nx][ny]);
          }
      }
      answer.push(stayDay);
    }
  
    for(let i = 0 ; i < maps.length; i++){
      for(let j = 0; j < maps[0].length; j++){
          if(maps[i][j] !== 'X' && !visited[i][j]){
              bfs(i, j);
          }
      }
    }
    return answer.length ? answer.sort((a, b) => a - b) : [-1];
  }