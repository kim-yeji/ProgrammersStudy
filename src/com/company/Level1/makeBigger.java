package com.company.Level1;

        //큰 수 만들기  (190921토)
//        어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
//        예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다.
//        이 중 가장 큰 숫자는 94 입니다.
//        문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
//        number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중
//        가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

public class makeBigger {

    public String solution(String number, int k) {
        int idx = 0;
        char max;
        StringBuilder answer = new StringBuilder();  //StringBuilder : string과 문자열을 더할 때 새로운 객체를 생성하는게
                                                    //아니라 기존의 데이터에 더하면서 메모리 부하를 줄인다

        if(number.charAt(0) == '0') return "0";
        for(int i = 0; i < number.length() - k; i++) {
            max = '0';
            for(int j = idx; j <= k + i; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j); idx = j + 1;
                }
            }
            answer.append(max); //StringBuilder에 더하는 방법
        }
        return answer.toString();//StringBuilder 출력하는 방법
    }

}
