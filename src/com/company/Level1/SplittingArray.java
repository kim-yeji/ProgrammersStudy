package com.company.Level1;

import java.util.ArrayList;
import java.util.Arrays;

/*나누어 떨어지는 숫자 배열 (190928 토)

<문제 설명>

array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

<제한사항>

arr은 자연수를 담은 배열입니다.
정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
divisor는 자연수입니다.
array는 길이 1 이상인 배열입니다

*/
public class SplittingArray {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        //나누어 떨어지는 숫자를 리스트에 추가
        for(int i=0;i<arr.length;i++){
            if(arr[i]%divisor==0) arrayList.add(arr[i]);
        }
        //divisor로 나누어 떨어지는 element가 하나도 없다면 -1담기
        if(arrayList.size()==0) arrayList.add(-1);

        //리턴 할 배열선언
        int[] answer = new int[arrayList.size()];

        //리스트 내용을 배열에 복사
        for (int i=0;i<arrayList.size();i++){
            answer[i]=arrayList.get(i);
        }

        Arrays.sort(answer);//정렬
        return answer;
    }

}
