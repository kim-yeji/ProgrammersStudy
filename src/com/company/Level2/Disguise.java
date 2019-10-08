package com.company.Level2;
//위장 191007월요일
//*******문제 설명*******
//스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
//
//예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면
// 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
//
//종류	이름
//------------------------------
//얼굴	동그란 안경, 검정 선글라스
//상의	파란색 티셔츠
//하의	청바지
//겉옷	긴 코트
//스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
//
//*******제한사항*******
//clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
//스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
//같은 이름을 가진 의상은 존재하지 않습니다.
//clothes의 모든 원소는 문자열로 이루어져 있습니다.
//모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
//스파이는 하루에 최소 한 개의 의상은 입습니다.



//조합은 부분 집합처럼 이해하시면 됩니다. 여러 가지 방법이 있지만 핵심은 하나입니다.
//
//배열을 처음부터 마지막까지 돌며
//1) 현재 인덱스를 선택하는 경우
//2) 현재 인덱스를 선택하지 않는 경우
//이렇게 두가지로 모든 경우를 완전탐색 해주시면 됩니다.

//arr = 조합을 뽑아낼 배열
//visited = 조합에 뽑혔는지 체크하는 배열
//n = 배열의 길이
//r = 조합의 길이
//순열과 달리 조합은 r 을 유지할 필요가 없으므로 숫자를 하나 뽑을때마다 r 을 하나씩 줄여줍니다.
//r == 0 일 때가 r 개의 숫자를 뽑은 경우입니다.

// 백트래킹 사용
// 사용 예시 : combination(arr, visited, 0, n, r)

import java.util.HashMap;

//  static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
//    if(r == 0) {
//        print(arr, visited, n);
//        return;
//    } else {
//        for(int i=start; i<n; i++) {
//            visited[i] = true;
//            combination(arr, visited, i + 1, n, r - 1);
//            visited[i] = false;
//        }
//    }
public class Disguise { //HashMap에 containsKey 메소드에 키값을 넘겨주면 해당 키값이 HashMap에 있을경우 true를 없을 경우 false를 넘겨 줍니다.
    //HashMap에 containsValue 메소드에 값을 넘겨주면 해당 값이 HashMap에 있을경우 true를 없을 경우 false를 넘겨 줍니다.

    public int solution(String[][] clothes) {
        int answer = 1;
        int val=0;
        if(clothes == null) return answer;
        //입을 수 있는 옷 종류의 수는 각 종류별로 선택할지 안 할지 여부(+1)를 포함하여 아래와 같은 방식으로 구할 수 있습니다.
        //경우의 수 : (A종류 옷 가지수 + 1)*(B종류 옷 가지수 + 1)*(C종류 옷 가지수 + 1) - 1
        //마지막의 -1은 아무것도 선택하지 않은 경우는 없어야하므로 제외 해준 것입니다.
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            if(map.containsKey(clothes[i][1])){ //이미 있는 키라면
                map.replace(clothes[i][1], map.get(clothes[i][1])+1);// 기존에 있던 값에 +1
                /*
                val = map.get(clothes[i][1]); //기존에 있던 값에 +1하기위해 value가져오기
                map.put(clothes[i][1],++val); //그리고 다시 덮어쓰기
                */

            }else {
                map.put(clothes[i][1],1); //존재하지 않는 키라면 새로 생성
            }
        }

        //map을 순회하는 법!!
        //entrySet() 은 key 와 value 두 개 모두가 필요할 경우 사용하며,
        //keySet() 은 key 값만 필요할 경우 사용하고
        //values() 는 값들만 필요할 경우에 사용한다

        for(int value : map.values()){
            answer*=(value+1);
        }
        answer--; //아무것도 입지 않는 경우는 없으므로 1을 빼준다.


        return answer;
    }


}
