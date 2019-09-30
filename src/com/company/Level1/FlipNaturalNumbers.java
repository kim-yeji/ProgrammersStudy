package com.company.Level1;
//자연수 뒤집어 배열로 만들기 190930 월
//문제 설명
//자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
//배열 형태로 리턴해주세요!!
//
//제한 조건
//n은 10,000,000,000이하인 자연수입니다.


public class FlipNaturalNumbers {
    public int[] solution(long n) {
        String a = "" + n;
        int[] answer = new int[a.length()];
        int cnt=0;
        while(n>0) {
            answer[cnt]=(int)(n%10);
            n/=10;
            cnt++;
        }
        return answer;
    }

    //내가 짠건데 while이랑 for문 차이밖에 없는데 왜 내 거는 오류나나 했더니
    //(int)n%10 이라고 써서 틀린거였음
    //(int)(n%10) ((int)n)%10의 차이,,

    /*
    * public int[] solution(long n) {
        String a = "" + n;
        int[] answer = new int[a.length()];
        int cnt=0;
        for(int i=0;i<answer.length;i++){
            answer[i]=(int)(n%10);
            n/=10;
        }
        return answer;
    }
    * */

}
