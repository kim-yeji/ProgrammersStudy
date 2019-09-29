package com.company.Level1;

//문자열 내 p와 y의 개수(190929 일)

//대문자와 소문자가 섞여있는 문자열 s가 주어집니다.
// s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요.
// 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다.
// 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
//
//예를 들어 s가 pPoooyY면 true를 return하고 Pyy라면 false를 return합니다.

public class numPY {
    boolean solution(String s) {
        boolean answer = true;
        int pCnt=0;
        int yCnt=0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='p'||ch=='P') pCnt++;
            else if(ch=='y'||ch=='Y') yCnt++;
        }

        if(pCnt==yCnt) answer=true;
        else answer=false;


        return answer;
    }

}
