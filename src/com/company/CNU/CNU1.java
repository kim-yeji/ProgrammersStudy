package com.company.CNU;

public class CNU1 {
    public int solution(int n, int m) {
        int answer = 0;

        int cnt=0;
        while(n!=0){
            n--;
            cnt++;
            answer++;


            if(cnt==m) {
                cnt=0;
                n++;
            }
            //  System.out.println("막판"+answer);
            if (n==0 && m==0) return answer+1;
        }

        return answer;
    }
}
