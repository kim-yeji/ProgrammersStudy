package com.company.Level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

//기능개발 191002화
//**********문제 설명**********
//프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
//
//또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
// 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
//
//먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와
// 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
// 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
//
//**********제한 사항**********
//작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
//작업 진도는 100 미만의 자연수입니다.
//작업 속도는 100 이하의 자연수입니다.
//배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다.
// 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
public class FunctionDevelopment {

    //ConcurrentLinkedQueue는 큐에 꺼낼 원소가 없다면 즉시 리턴하고 다른 일을 수행하러 간다.
    //따라서, ConcurrentLinkedQueue는 생산자-소비자 producer-consumer 모델에서 소비자가 많고 생산자가 하나인 경우에 사용하면 좋다.
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ConcurrentLinkedDeque<>();

        //100-progresses[i] = 앞으로 남은 기능개발의 %(퍼센테이지)
        for(int i=0;i<progresses.length;i++){
            if((100-progresses[i])%speeds[i]==0){
                queue.add((100-progresses[i])/speeds[i]);
            }else{
                queue.add(((100 - progresses[i]) / speeds[i] )+ 1); //나누어 떨어지지않으면 1일 더 필요
            }
        }

        /* 삼항연산자를 사용한 포문
        * for(int i = 0; i < progresses.length; i++) {
            q.add((100-progresses[i])%speeds[i] == 0? (100 - progresses[i]) / speeds[i]
                    : (100 - progresses[i]) / speeds[i] + 1);
        }*/

        List<Integer> answerList = new ArrayList<>();
        //poll(): queue에서 젤 먼저 저장된 것 부터 반환하고 삭제
        int standard = queue.poll(); //첫번째 100-progresses[i]를 기준으로 삼는다. 중간에 100-progresses[i]가 더 큰놈있으면 그놈이 standard
        int cnt=1; //같은 날에 배포되는 기능의 개수
        while(!queue.isEmpty()){
            int num = queue.poll();
            if(standard>=num) cnt++; //standard가 걸리는 시간이 더 많으면 cnt+1 (같은 날 배포될 예정)
            else{
                answerList.add(cnt);
                cnt=1; //1로 초기화
                standard=num;
            }
        }
        answerList.add(cnt);
        int[] answer = new int[answerList.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=answerList.get(i);
        }
        return answer;
    }


}
