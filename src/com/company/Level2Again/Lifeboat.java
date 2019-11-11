package com.company.Level2Again;

import java.util.Arrays;

//191111 월요일
//구명보트
public class Lifeboat {
    public int solution(int[] people, int limit) {
        int cnt=0;
        int j=0;
        Arrays.sort(people);
        for (int i=people.length-1;i>j;i--){
            if (people[i]+people[j]<=limit){
                cnt++;
                j++;
            }
        }
        System.out.println("people length:"+people.length+", answer"+(people.length-cnt));
        return people.length-cnt;
    }
}
