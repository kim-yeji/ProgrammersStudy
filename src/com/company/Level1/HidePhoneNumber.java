package com.company.Level1;
//핸드폰 번호 가리기 191001월
//문제 설명
//프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
//전화번호가 문자열 phone_number로 주어졌을 때,
// 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.
//
//제한 조건
//s는 길이 4 이상, 20이하인 문자열입니다.

public class HidePhoneNumber {
    public String solution(String phone_number) {
        String answer = "";
        for(int i=0;i<phone_number.length();i++){
            answer += phone_number.length()-i <=4 ? phone_number.charAt(i) : "*";
        }
        System.out.println(answer);
        return answer;
    }

}
