package com.company.Level2;
//다음 큰 숫자 191021월요일
//------------문제 설명------------
//자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
//
//조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
//조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
//조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
//예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
//
//자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
//
//------------제한 사항------------
//n은 1,000,000 이하의 자연수 입니다.
public class NextBigNumber {
    public int solution(int n) {

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

/* 효율성 굉장히 쓰레기인 코드~!
*   public int solution(int n) {
        int tmp=n;
        String nBinary = "";
        while(tmp!=0){
            nBinary+=tmp%2;
            tmp/=2;
        }
        System.out.println(nBinary);

        //String nBinary = Integer.toBinaryString(n);
        int nCount=0;
        for(int i=0;i<nBinary.length();i++){
            if('1' == nBinary.charAt(i)) nCount++;
        }


        int j=0;
        int jCount=0;
        for (j=n+1;nCount!=jCount;j++){
           // String jBinary = Integer.toBinaryString(j);
            String jBinary = "";
            int tmp2=j;
            while(tmp2!=0){
                jBinary+=tmp2%2;
                tmp2/=2;
            }
            System.out.println(jBinary);
            jCount=0;
            for(int i=0;i<jBinary.length();i++){
                if(jBinary.charAt(i)=='1') jCount++;
            }
        }
        System.out.println(j-1);
        return j-1;
    }
    * */
