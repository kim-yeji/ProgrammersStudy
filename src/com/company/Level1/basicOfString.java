package com.company.Level1;
//문자열 다루기 기본 (190928 토)
//문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요.
// 예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.

public class basicOfString {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length()!=4 && s.length()!=6) return false;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c<'0'|| c>'9') return false;
        }

        return answer;
    }
}
