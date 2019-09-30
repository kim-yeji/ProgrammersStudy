package com.company.Level1;
//제일 작은 수 제거하기 190930월

import java.util.ArrayList;
import java.util.Collections;

//*********문제 설명*********
//정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
// 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
// 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
//
//*********제한 조건*********
//arr은 길이 1 이상인 배열입니다.
//인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
public class RemovingTheSmallestNum {

    //최솟값을 찾기위해서 min 변수를 만들어 for문을 돌면서 만들어도 되지만, Collections 을 이용하였다.
    // 또한 for문을 돌며 min과 원소값이 일치할 때 제거하는 것 대신 indexOf를 이용하여 index를 구하고
    // 바로 접근을 하여 제거하는 방법을 사용하였다.

    public int[] solution(int[] arr) {
        int[] answer = {};
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(arr.length<=1) return new int[]{-1};

        for(int i=0;i<arr.length;i++){
            arrayList.add(arr[i]);
        }
        //Collections 클래스의 max()나 min()는 리스트 타입의 인자만 받는다는 한계가 있습니다.
        // 예를 들어, 최대값을 찾으려는 대상이 배열이라면 리스트로 한 번 변환을 한 후 호출이 가능하기 때문에
        // 원소의 개수가 많을 경우 비효율적일 수 있습니다.
        int min= Collections.min(arrayList);
        int indexOfMin=arrayList.indexOf(min);
        arrayList.remove(indexOfMin);

        answer=new int[arrayList.size()];
        for(int i=0;i<arrayList.size();i++){
            answer[i]=arrayList.get(i);
        }
        return answer;
    }

}
