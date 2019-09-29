package com.company.Level1;

public class CaesarPassword {
    public String solution(String s, int n) {
        String answer = "";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i); //s에서 한 글자 떼와서 ch로 받고
            if(Character.isLowerCase(ch)){ //받은 ch가 소문자면
                ch = (char)((ch+n%26-'a')%26+'a'); //알파벳의 주기가 26이고 26으로 나눈 나머지를 통해 항상 26보다 작은 수를 만들려고
            }else if(Character.isUpperCase(ch)){
                ch = (char)((ch+n%26-'A')%26+'A');
            }
            answer+=ch;
        }

        return answer;
    }
}
