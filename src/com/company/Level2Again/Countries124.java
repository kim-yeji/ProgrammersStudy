package com.company.Level2Again;
//191108 금요일
//124의 나라
public class Countries124 {
    public String solution(int n) {
        String answer = "";
        int remain=0;
        while (n>0){
            remain=n%3;
            n/=3;
            if (remain==0){
                n-=1;
                remain=4;
            }
            answer=remain+answer;
        }
        System.out.println(answer);
        return answer;
    }
}
