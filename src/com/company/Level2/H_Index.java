package com.company.Level2;

import java.util.Arrays;
//★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆문제이해 다시할 것!



//H-Index 191006 일
//*********문제 설명*********
//H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다.
// 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다.
// 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
//
//어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고
// 나머지 논문이 h번 이하 인용되었다면 h가 이 과학자의 H-Index입니다.
//
//어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때,
// 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
//
//*********제한사항*********
//과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
//논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
public class H_Index {

    public int solution(int[] citations) {

        //예시를 통해 보자면 내림차순 정렬한 배열 [6,5,3,1,0]에서
        //  6 > 0
        //  5 > 1
        //  3 > 2
        //-------------------return 3
        //  1 < 3
        //  0 < 4
        //인용된 논문 수가 i+1 (편)보다 작아질 때 i를 returng하는 방법
        // public int solution(int[] citations) {
        //        Integer[] cArr = new Integer[citations.length];
        //        for (int i = 0; i < citations.length; i++) {
        //            cArr[i] = citations[i];
        //        }
        //        Arrays.sort(cArr, Collections.reverseOrder());
        //        for (int i = 0; i < citations.length; i++) {
        //            if (cArr[i]<i+1) {
        //                return i;
        //            }
        //        }
        //        return citations.length;
        //    }

        int answer = 0;
        //[1,7,0,1,6,4]가 입력됐을 때 정답은 3이다!
        //정렬한 후에 인덱스에 해당하는 배열값이 인덱스보다 작거나 같으면 해당 인덱스가 정답이다.

        //전체 배열의 갯수와 요소의 값과 일치하는하는 것을 찾는 과정
        Arrays.sort(citations); //[3, 0, 6, 1, 5]오름차순 정렬 -> [0, 1, 3, 5, 6]
        for(int i=0;i<citations.length;i++){
            int smaller = Math.min(citations[i],citations.length-i); //첫 element와 끝 index와 비교하면서 둘 중 작은 수를 뽑는다.
            answer = Math.max(answer,smaller);
        }
        return answer;
    }
}
