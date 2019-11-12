package com.company.Level2Again;

import java.util.Arrays;

//191112 화요일
//최솟값 만들기
public class MakeMinimun {
    public int solution(int []A, int []B){
        int answer=0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i=0;i<A.length;i++){
            answer+=(A[i]*B[B.length-1-i]);
        }
        return answer;
    }
}
