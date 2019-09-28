package com.company.Level1;

//2016년 (190927금)
//2016년 1월 1일은 금요일입니다.
//        2016년 a월 b일은 무슨 요일일까요?
//        두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
//        요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT입니다.
//        예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 TUE를 반환하세요.

public class year2016 {

    public String solution(int a, int b) {
        String answer = "";
        int dayOfMonth=0; //달의 마지막
        int totalDay=0; //요일을 알아내기 위해 날짜 세는 변수

        for(int i=1;i<a;i++){
            if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8  || i == 10 || i == 12) dayOfMonth = 31;
            else if(i==2) dayOfMonth=29;
            else dayOfMonth=30;

            totalDay+=dayOfMonth;
        }
        totalDay+=b;

        switch (totalDay%7){ // 1월1일은 금요일이였으므로 7로 나눈 나머지가 1인 경우 금요일이다
            case 0:
                answer = "THU";
                break;
            case 1:
                answer = "FRI";
                break;
            case 2:
                answer = "SAT";
                break;
            case 3:
                answer = "SUN";
                break;
            case 4:
                answer = "MON";
                break;
            case 5:
                answer = "TUE";
                break;
            case 6:
                answer = "WED";
                break;
        }

        return answer;
    }
}
