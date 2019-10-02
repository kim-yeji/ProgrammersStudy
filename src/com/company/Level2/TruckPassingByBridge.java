package com.company.Level2;
//다리를 지나가는 트럭 191001월
//문제 설명
//트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다.
// 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
// 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
//※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.
//
//예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다.
// 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

import java.util.LinkedList;
import java.util.Queue;

public class TruckPassingByBridge {
    class Truck {
        int weight;
        int distance;

        public Truck(int weight, int distance) {
            this.weight = weight;
            this.distance = distance;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time=0; //1초에 1씩 움직이게 하는 기준
        int onBridgeWeight=0; //현재 다리위에 올려진 트럭들을 합친 무게
        Queue<Truck> inSide = new LinkedList<>(); //대기하는 트럭
        Queue<Truck> outSide = new LinkedList<>(); //다리 건너는 트럭

        for(int w : truck_weights){
            inSide.add(new Truck(w,0));
        }
        onBridgeWeight += inSide.peek().weight; //첫번째 트럭무게를 더함
        outSide.add(inSide.poll()); //대기중 -> 다리 건너는 중으로 옮겨줌

        while(!outSide.isEmpty()){
            time++;
            for(Truck t : outSide){
                t.distance++; //현재 다리위의 있는 트럭들을 이동시킴
            }

            if(outSide.peek().distance > bridge_length){//트럭이 다리끝에 다다르면
                onBridgeWeight-=outSide.poll().weight; //다리 다 건넜으니 빼줌
            }

            //대기중인 트럭을 다리에 올리는데, 다리가 버틸수 있는 무게인지 확인
            if(!inSide.isEmpty() && inSide.peek().weight+ onBridgeWeight <= weight){
                onBridgeWeight += inSide.peek().weight; //현재 다리위에 트럭무게를 더함
                inSide.peek().distance++; //거리 +1
                outSide.add(inSide.poll()); //대기중 -> 다리 건너는 중으로 옮겨줌
            }
        }

        answer = time;
        return answer;

    }
}
