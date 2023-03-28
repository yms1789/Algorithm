function solution(bridge_length, weight, truck_weights) {
  let answer = 1;
  let bridge = [];
  let sum = 0;
  while (truck_weights.length || bridge.length) {
    // 다리 지나지 않은 트럭, 다리를 지나고 있는 트럭 모두 다리를 건널 때 까지
    if (sum + truck_weights[0] <= weight && bridge.length <= bridge_length) {
      let truck = truck_weights.shift();
      bridge.push([truck, answer + bridge_length]);
      sum += truck;
      answer++;
    } else {
      let [truck, time] = bridge.shift();
      if (answer < time) {
        // 시간 점프를 해주는 걸 생각 못함 -> 마냥 1초씩 더해나간다는 생각만 했음...
        answer = time;
      }
      sum -= truck;
    }
  }
  return answer;
}



/**
 * 다리가 트럭의 하중을 버틸 수 있을 때 까지 트럭을 다리 위에 세움
 * 1초 증가
 * 다리 위 트럭을 한 칸씩 움직임
 * 1초 증가
 * 다리 위 트럭 중에 도착한 트럭이 있다면 다리에서 제거
 * 1초 증가
 * 위 순서를 truck_weight가 빌 때 까지 반복
 * 다리 위에 아직 남아 있을 때는 bridge 길이만큼 시간을 더해주고 트럭이 이동할 때 걸린 시간(bridge[0][1])을 빼 줌
 * answer(시간) return
 *
 * 문제점: 1초에 1칸식 1동할텐데 위 코드는 하중만큼 트럭이 올라간 후 다리를 1칸 건널 떄 3초씩 더해짐
 *
 * */
/*
function solution(bridge_length, weight, truck_weights) {
  let answer = 0;
  let idx = 0;
  let bridge = [];
  while (truck_weights.length) {
    while (
      bridge.map((ele) => ele[0]).reduce((acc, cur) => acc + cur, 0) +
        truck_weights[0] <=
      weight
    ) {
      bridge.push([truck_weights.shift(), 1]);
    }
    answer++;
    for (let bTruck of bridge) {
      bTruck[1]++;
    }
    answer++;
    let len = bridge.length;
    for (let i = 0; i < len; i++) {
      if (bridge[0][1] == bridge_length) {
        bridge.shift();
      }
    }
    answer++;
  }
  if (bridge.length) {
    // console.log(bridge);
    answer += bridge_length + bridge.length - bridge[0][1];
  }
  return answer - 1;
} */
