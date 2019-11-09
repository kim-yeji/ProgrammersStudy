package com.company.Level2Again;
//191109 토요일
//더 맵겐
import java.util.PriorityQueue;
import java.util.Queue;

public class ScovilleScale {
    public int solution(int[] scoville, int K) {
        int answer = -1;
        int cnt=0;
        int s1, s2;
        Queue<Integer> queue = new PriorityQueue<>(scoville.length);
        for (int i=0;i<scoville.length;i++){
            queue.offer(scoville[i]);
        }
        while(queue.size()>0){
            if (queue.peek()>=K){
                answer=cnt;
                break;
            }
            s1=queue.poll();
            s2=queue.poll();
            int tmp = s1+(s2*2);
            queue.add(tmp);
            cnt++;

        }
        if (queue.peek()>=K) answer=cnt;


        return answer;
    }
}
