package com.company.Level1;

//모의고사 (190922 일)
//        수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
//        수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
//
//        1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//        2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//        3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
//
//        1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
//                가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.



import java.util.ArrayList;
import java.util.List;

public class mockTest {

    class Solution {
        public int[] solution(int[] answers) {
            // 수포자의 찍기 패턴 수 st1 = 5, st2 = 8, st3 = 10
            int[] str1={ 1, 2, 3, 4, 5 };
            int[] str2={ 2, 1, 2, 3, 2, 4, 2, 5 };
            int[] str3={ 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
            int [] cnt = new int [3]; //3명의 학생이므로 정답을 체크하기 위한 배열 cnt 생성

            // 정답과 찍은답과 비교하여 동일한 경우 cnt ++
            for(int i=0;i<answers.length;i++){
                if(answers[i]==str1[i%5]) cnt[0]++;
                if(answers[i]==str2[i%8]) cnt[1]++;
                if(answers[i]==str3[i%10]) cnt[2]++;
            }
            int winner = cnt[0];
            for(int i=0;i<cnt.length;i++){
                if(winner<cnt[i]){
                    winner=cnt[i];
                }
            }

            List<Integer> win = new ArrayList<>(); // 가장 높은 점수를 받은 학생 List 생성


            // cnt 배열과 가장 높은 점수를 비교하여 동일한 경우 win List에 추가
            for (int i=0; i<cnt.length; i++){
                if (winner==cnt[i]){
                    win.add(i);
                }
            }

            int[] answer = {}; // 출력값
            answer = new int [win.size()]; // 출력값은 win List에 추가된 학생 수와 동일하도록 길이 조정

            // 출력할 배열 answer에 List에 있는 학생번호 입력
            for (int i=0; i<win.size();i++){
                answer[i]=win.get(i)+1; //index가 0부터 시작하므로 1씩 더해줌
            }

            return answer;
        }
    }
}
