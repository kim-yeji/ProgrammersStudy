package com.company.Level1;

//같은 숫자는 싫어 (190928 토)
//배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다.
// 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다.
// 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,
//
//        arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
//        arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.

// 배열 arr에서 연속적으로 나타나는 숫자는 제거하고
// 남은 수들을 return 하는 solution 함수를 완성해 주세요.


import java.util.*;
public class iHateSameNum {
    public int[] solution(int []arr) {

        ArrayList<Integer> arrList = new ArrayList();

        for(int i=0;i<arr.length-1;i++){
            if(arr[i]!=arr[i+1]) arrList.add(arr[i]); //같은 숫자가 아니면 리스트에 추가
        }
        arrList.add(arr[arr.length-1]); //마지막은 같든 안같든 넣어야 맞는다!

        int[] answer = new int[arrList.size()]; //같은 값 솎아낸 크기만큼의 정답배열 설정

        for (int i=0;i<arrList.size();i++){ //리스트를 배열에 다시 담아내기
            answer[i]=arrList.get(i);
        }


        return answer;
    }
}
