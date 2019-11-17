package com.company.CNU;

import java.util.ArrayList;
import java.util.Arrays;

public class CNU2 {
    public int solution(int[] people, int[] tshirts) {
        int answer = people.length;
        Arrays.sort(tshirts);
        Arrays.sort(people);
        ArrayList<Integer> tList = new ArrayList<>();

        for (int i=0;i<tshirts.length;i++){
            tList.add(tshirts[i]);
        }

        for(int i=0;i<people.length;i++){
            for(int j=0;j<tList.size();j++){
                if(people[i]>=tList.get(j)){
                    tList.remove(j);
                    answer--;
                    System.out.println(people.length-answer);
                    if(answer==0) return people.length-answer;
                }
            }
        }
        return answer;
    }
}
