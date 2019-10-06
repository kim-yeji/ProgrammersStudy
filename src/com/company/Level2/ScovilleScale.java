package com.company.Level2;
//스코빌 지수

import java.util.PriorityQueue;
import java.util.Queue;

//*********문제 설명*********
//매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
// 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을
// 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
//
//---섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
//---Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
//---Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
//   모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
//
//*********제한 사항*********
//scoville의 길이는 1 이상 1,000,000 이하입니다.
//K는 0 이상 1,000,000,000 이하입니다.
//scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
//모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
public class ScovilleScale {
    public int solution(int[] scoville, int K) {
        //Heap은 데이터를 입력하면 자동으로 우선순위에 따라 정렬해주는 자료구조다.
        //우선순위큐는 이러한 Heap을 이용하여 구현한 자료구조다.
        //우선순위 큐에서 데이터를 poll()할 때 마다, 스코빌을 계산하여 offer()한다.
        //offer()할 때(Queue에 객체를 넣음), cnt를 늘린다.


        int answer = -1;//모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
        int cnt=0; //횟수를 측정해주는 변수
        int scov1=0, scov2=0; //섞은 음식의 스코빌 지수를 만들기 위한 변수 2개
        Queue<Integer> priorityQ = new PriorityQueue<Integer>(scoville.length);
        for(int i=0;i<scoville.length;i++){
            priorityQ.offer(scoville[i]); //스코빌 지수들을 priorityQ에 다 넣어준다.
        }

        while (priorityQ.size()>1){
            //if문 설명: peek()(가장 작은 값)을 리턴했을 때, 그 값이 k보다 크다면,
            //그 큐에 있는 모든 값이 k보다 크다는 뜻이므로 break한다.
            if(priorityQ.peek()>=K){
                answer=cnt;
                break;
            }
            scov1 = priorityQ.poll();
            scov2 = priorityQ.poll();
            int tmp = scov1 + (scov2*2);
            priorityQ.offer(tmp);
            cnt++;
        }

        //마지막 큐에 하나 남은 값이 K보다 큰지 확인
        if(priorityQ.poll()>=K){
            answer = cnt;
        }
        return answer;
    }

}
