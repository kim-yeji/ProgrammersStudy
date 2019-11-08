package com.company.Level2;
//191104 빡센 월요일
//=======================문제 설명=======================
//JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
// 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
//
//=======================제한 조건=======================
//s는 길이 1 이상인 문자열입니다.
//s는 알파벳과 공백문자(" ")로 이루어져 있습니다.
//첫 문자가 영문이 아닐때에는 이어지는 영문은 소문자로 씁니다. ( 첫번째 입출력 예 참고 )
public class JadenCaseString {
    //다른 사람이 작성한 간단코드
    public String solution(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }

        return answer;
    }


    /* 블로그에서 공부한 코드


       //마지막에" "공백이 있는 경우에 그 공백도 포함해야함
    public String solution(String s) {
        String answer = "";
        String str = s.toLowerCase();
        char[] arr = str.toCharArray();

        answer+=Character.toUpperCase(arr[0]);
        return getAnswer(answer, arr);
    }

    private String getAnswer(String answer, char[] arr) {
        for (int i=1; i<arr.length-1;i++){//맨 마지막이 공백 문자일때 예외처리
            if (arr[i]==' ') arr[i+1] = Character.toUpperCase(arr[i+1]);
            answer+=arr[i];
        }
        if (arr[arr.length-1]==' ') answer+=' '; //맨 마지막이 공백 문자일 경우 맨 뒤에 공백문자 추가
        else answer+=arr[arr.length-1]; //그냥 문자라면 그 문자만 추가

        return answer;
    }

     */
}
