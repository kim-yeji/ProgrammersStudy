package com.company;

import java.util.*;

class Main {

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

    public static void main(String[] args) {
        int[][] arr1 = {{1, 2}, {2, 3}};
        int[][] arr2 = {{3, 4}, {4, 5}};

        int[] array1 = {1, 2, 3, 9, 10, 12};
        int[] array2 = {6,9,5,7,4};
        int n = 7;
        int m = 10;
        String s = "110";

        String[] name = {"BACDE", "CBADF", "AECB", "BDA"};


        Main main = new Main();
        main.solution(array1,n);
    }
}