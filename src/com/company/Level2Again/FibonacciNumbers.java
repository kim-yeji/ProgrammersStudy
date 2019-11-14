package com.company.Level2Again;
//191114 목요일
//피보나치 동적프로그래밍
public class FibonacciNumbers {
    public int solution(int n) {
        int answer=0;
        if (n<=1) return 1;

        int num1=1;
        int num2=1;
        for (int i=3; i<=n;i++){
            answer=num1+num2;
            answer%=1234567;// n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴
            num1=num2;
            num2=answer;
        }
        return answer;
    }
}
