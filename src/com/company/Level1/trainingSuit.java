package com.company.Level1;


// 체육복 190926 목
//점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다.
//        다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
//        학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
//        예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
//        체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
//
//        전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost,
//        여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
//        체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.


//결국 체육복 입는 애들 수만 리턴하면 되는 것임. 거기에 집중해서 짜맞추면 됨


public class trainingSuit {
    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = n-lost.length; //잃어버린 애들 전체 수에서 빼기

            //잃어버린애가 두 벌 가진애인지 체크
            for(int i=0;i<reserve.length;i++){
                for(int j=0; j<lost.length; j++){
                    if(lost[j]==-1 && reserve[i]==-1){ //두벌가져온 애 아닌애들 거르기
                        continue;
                    }
                    if(lost[j]==reserve[i]){ //잃어버렸는데 두 벌 가져온 애들
                        lost[j]=-1;
                        reserve[i]=-1;
                        answer++; //수업들을 수 있는 인원수 +1
                    }
                }
            }

            for(int i=0;i<lost.length;i++){
                for(int j=0;j<reserve.length;j++){
                    if(lost[i]==-1 || reserve[j]==-1) continue;
                    if(Math.abs(lost[i]-reserve[j])==1){ //앞 뒤로만 빌려줄 수 있으므로 -1 혹은 1이 나와야 함(절대값 씌움)
                        answer++;
                        reserve[j]=-1;
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
