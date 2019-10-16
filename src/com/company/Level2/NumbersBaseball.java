package com.company.Level2;
//숫자야구 191008 화요일
//**********문제 설명**********
//숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다. 게임해보기
//
//각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다.
// 그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.
//
//* 숫자는 맞지만, 위치가 틀렸을 때는 볼
//* 숫자와 위치가 모두 맞을 때는 스트라이크
//* 숫자와 위치가 모두 틀렸을 때는 아웃

//예를 들어, 아래의 경우가 있으면
//
//A : 123
//B : 1스트라이크 1볼.
//A : 356
//B : 1스트라이크 0볼.
//A : 327
//B : 2스트라이크 0볼.
//A : 489
//B : 0스트라이크 1볼.
//이때 가능한 답은 324와 328 두 가지입니다.
//
//질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때,
// 가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.
//
//**********제한사항**********
//질문의 수는 1 이상 100 이하의 자연수입니다.
//baseball의 각 행은 [세 자리의 수, 스트라이크의 수, 볼의 수] 를 담고 있습니다.

import java.util.Stack;

public class NumbersBaseball {
//전체적ㅇ로 int로 하지않고 string으로 하는 이유는 한글자 한글자 대조하기가 간편하기때문!

    //해당 위치에 똑같은 숫자가 있으면 ++
    public static int getStrike(String chk, String num) {
        int cnt = 0;
        for(int i = 0; i < 3; i++)
            cnt += chk.charAt(i) == num.charAt(i) ? 1 : 0;

        return cnt;
    }

    //같은 숫자지만 *위치가 동일하지 않은 것!* ++
    public static int getBall(String chk, String num) {
        int cnt = 0;
        for(int i = 0; i < 3; i++) {
            if(chk.contains(String.valueOf(num.charAt(i))))
                cnt += chk.indexOf(num.charAt(i)) == i? 0 : 1;
        }

        return cnt;
    }

    public int solution(int[][] baseball) {
        int answer = 0, cnt;

        Stack<String> stack = new Stack<>();//모든 세자리 수를 담을 스택

        for(int i = 1; i < 10; i++) {
            for(int j = 1; j < 10; j++) {
                for(int k = 1; k < 10; k++) {
                    //중복을 담지 않으려는 if문
                    if(i != j && j != k && i != k) {
                        stack.add(String.valueOf(i*100 + j*10 + k));
                    }
                }
            }
        }

        while(!stack.isEmpty()) {
            String chNum = stack.pop();
            cnt = 0;
            for(int i = 0; i < baseball.length && cnt < baseball.length; i++) {
                int strike = getStrike(chNum, String.valueOf(baseball[i][0]));
                int ball = getBall(chNum, String.valueOf(baseball[i][0]));

                if(strike == baseball[i][1] && ball == baseball[i][2])
                    cnt++;
            }

            //cnt가 baseball의 길이와 일치하지 않으면,
            // stack에서 나온 수가 정답이 될 수 없다는 뜻이므로 (하나의 경우라도 맞지 않는다는 뜻이니까) skip!
            // 만약 일치하면, ‘오 이번에 stack에서 나온 숫자는 정답이 될 수 있군’ 하여 answer를 쁠쁠해준다.
            if(cnt == baseball.length)  answer++;
        }
        return answer;
    }
}
