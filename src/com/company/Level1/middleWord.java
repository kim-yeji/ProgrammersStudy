package com.company.Level1;

//가운데 글자 가져오기 (190927 금)
//        단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요.
//        단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

public class middleWord {
    public String solution(String s) {
        String answer = "";
        //짝수인 경우 문자열.substring(시작, 끝)으로 가운데 글자들을 String 자료형으로 가져올 수 있다.
        if(s.length()%2==0) answer = s.substring(s.length()/2-1, s.length()/2+1);

            //이 경우 함수의 리턴 자료형이 String 이기 때문에 오류가 발생한다.
            //char -> String 으로 변환하는 가장 효율적인 방법은 Character.toString(대상) 이다.
        else answer=Character.toString(s.charAt(s.length()/2));
        return answer;
    }
}
