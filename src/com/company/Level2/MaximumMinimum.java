package com.company.Level2;
//최댓값과 최솟값 191026토요일

import java.util.Arrays;

//-------------------문제 설명-------------------
//문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
// str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 (최소값) (최대값)형태의 문자열을 반환하는 함수, solution을 완성하세요.
//예를들어 s가 1 2 3 4라면 1 4를 리턴하고, -1 -2 -3 -4라면 -4 -1을 리턴하면 됩니다.
//
//-------------------제한 조건-------------------
//s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
public class MaximumMinimum {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int[] iArr = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            iArr[i]=Integer.parseInt(arr[i]);
        }

        Arrays.sort(iArr);

        answer+=iArr[0];
        answer+=" "+iArr[iArr.length-1];
        System.out.println(answer);
        return answer;
    }
}
