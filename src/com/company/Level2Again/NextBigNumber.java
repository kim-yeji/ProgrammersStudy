package com.company.Level2Again;
//191118 월요일
//다음 큰 숫자
public class NextBigNumber {
    public int solution(int n) {
        //마지막 반복문을 빠져나오기 전에 반복문의 증감부분을 실행하고 나오므로 내가 구하려는 값보다 1이 더해져 있는 상태이다.
        //그러므로 1을 빼서 반환한다.
        String nBinary = Integer.toBinaryString(n);
        int nCount=0;
        for(int i=0;i<nBinary.length();i++){
            if(nBinary.charAt(i)=='1') nCount++;
        }

        int j=0;
        int jCount=0;
        for (j=n+1;nCount!=jCount;j++){
            String jBinary = Integer.toBinaryString(j);
            jCount=0;
            for(int i=0;i<jBinary.length();i++){
                if(jBinary.charAt(i)=='1') jCount++;
            }
        }
        return j-1;
    }

}
