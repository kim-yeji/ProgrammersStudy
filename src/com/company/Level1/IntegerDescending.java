package com.company.Level1;
//정수 내림차순으로 배치하기 190930 월

//******문제 설명******
//함수 solution은 정수 n을 매개변수로 입력받습니다.
// n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
// 예를들어 n이 118372면 873211을 리턴하면 됩니다.

import java.util.Arrays;
import java.util.Comparator;

//인트형자료 분리 -> 문자열로 변환 -> 정렬 -> 인트형 자료변환
public class IntegerDescending {
    public long solution(long n) {
        String str = Long.toString(n);
        String strArr[] = str.split("");

        Arrays.sort(strArr, new Comparator<String>() {

            @Override
            public int compare(String arg0, String arg1) {
                int n1 = Integer.parseInt(arg0);
                int n2 = Integer.parseInt(arg1);

                if(n1 > n2)
                    return -1;
                else if(n1 < n2)
                    return 1;
                return 0;
            }
        });

        str = "";
        for(String s : strArr)
            str += s;

        return Long.parseLong(str);
    }

}
