package com.company.Level1;
//두 정수 사이의 합 (190927 금)

//두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
//        예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
//
//       - a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
//       - a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
//       - a와 b의 대소관계는 정해져있지 않습니다.
public class SumBetweenIntegers {

    public long solution(int a, int b) {
        long answer = 0;
        int big=0;
        int small;

        if(a==b){
            return a;
        }else if(a>b){
            big=a;
            small=b;
        }else{
            big=b;
            small=a;
        }

        for(int i=small; i<=big; i++){
            answer+=i;
        }

        return answer;
    }

    //다른사람 코드!! 더 깔끔하고 효율이 좋다.
//    public long solution(int a, int b) {
//        if(a!=b) { // @1
//            // @2
//            int start = a < b ? a : b;
//            int end = a < b ? b : a;
//            long sum = 0;
//            for(int i=start; i<=end; i++) // @3
//                sum += i;
//
//            return sum;
//
//        }
//        else return a;
//    }
}
