package com.company.Level1;
//최대공약수와 최소공배수 190930 월
//*********문제 설명*********
//두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
// 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
// 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
//
//*********제한 사항*********
//두 수는 1이상 1000000이하의 자연수입니다.

public class GCF_LCM {
    //유클리드 호제법
    //
    //- 최소공배수 = (n * m) / 최대공약수
    //- 최대공약수 두 수의 나머지를 이용해 순환

    public static int lcm(int a, int b){
        return (a*b)/gcf(a,b);
    }
    public static int gcf(int c, int d){
        int tmp;
        while(c!=0){
            tmp=d%c;
            d=c;
            c=tmp;
        }
        return d;
    }
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0]=gcf(n,m);
        answer[1]=lcm(n,m);
        System.out.println(answer[0]+", "+answer[1]);
        return answer;
    }
}
