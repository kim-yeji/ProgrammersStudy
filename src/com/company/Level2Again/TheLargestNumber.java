package com.company.Level2Again;
//191110 일요일
//가장 큰 수

import java.util.Arrays;
import java.util.Comparator;

public class TheLargestNumber {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strArr = new String[numbers.length];
        for (int i=0;i<strArr.length;i++){
            strArr[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if (strArr[0]=="0") return "0";
        for (int i=0;i<strArr.length;i++){
            answer+=strArr[i];
        }
        return answer;
    }
}

