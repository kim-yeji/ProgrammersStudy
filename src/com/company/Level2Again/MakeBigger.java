package com.company.Level2Again;
//191111 월요일
//큰 수 만들기
public class MakeBigger {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx=0;
        char max;
        if (number.charAt(0)=='0') return "0";

        for (int i=0;i<number.length()-k;i++){
            max='0';
            for (int j=idx;j<=i+k;j++){
                if (max<number.charAt(j)){
                    max=number.charAt(j);
                    idx=j+1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }

}
