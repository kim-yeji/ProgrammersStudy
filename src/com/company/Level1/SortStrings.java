package com.company.Level1;

//문자열 내 마음대로 정렬하기 (190928 토)
/*
*********** 문제 설명 ***********
문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
예를 들어 strings가 [sun, bed, car]이고 n이 1이면 각 단어의 인덱스 1의 문자 u, e, a로 strings를 정렬합니다.

*********** 제한 조건 ***********
strings는 길이 1 이상, 50이하인 배열입니다.
strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
모든 strings의 원소의 길이는 n보다 큽니다.
인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
*
*
* */


import java.util.Arrays;
import java.util.Comparator;

public class SortStrings {
    public String[] solution(String[] strings, int n) {


        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //리턴값이 -1이면 내림차순, 0이면 같음, 1이면 오름차순
                if(o1.charAt(n)>o2.charAt(n)) return 1;
                    //n으로 추출한 인덱스 값이 같은 경우
                    //compareTo a와 b가 같으면 0 반환
                    //a가 크면 1 , 작으면 -1
                else if(o1.charAt(n)==o2.charAt(n)) return o1.compareTo(o2);//재비교
                else if(o1.charAt(n)<o2.charAt(n)) return -1;

                return 0;
            }
        });
        return strings;
    }

}
