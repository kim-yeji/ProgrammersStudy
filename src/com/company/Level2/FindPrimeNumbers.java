package com.company.Level2;

import java.util.HashMap;
import java.util.Map;

//소수찾기
//*********문제 설명*********
//한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
//
//각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
// 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
//
//*********제한사항*********
//numbers는 길이 1 이상 7 이하인 문자열입니다.
//numbers는 0~9까지 숫자만으로 이루어져 있습니다.
//013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
public class FindPrimeNumbers {
    static Map<Integer, Integer> hash = new HashMap<>();

    public int solution(String numbers) {
        // 1.받아온 numbers를 배열에 넣는다
        String[] numStr = numbers.split("");

        // 2.numStr에 넣은 String을 int형으로 바꿔서 다시 배열에 저장하는 for문
        int[] nums = new int[numbers.length()];
        for(int i=0;i<numbers.length();i++){
            nums[i]=Integer.parseInt(numStr[i]);
        }
        for(int i=1;i<=numbers.length();i++){
            permutation(nums,0, nums.length, i);
        }

        return hash.size();
    }

    //숫자세트 만드는 함수 permutation  (n: nums.length, k:numbers의 길이만큼 한 개씩 돌아볼 i)
    public void permutation(int[]arr, int depth, int n, int k){

        // 3.한 번 depth가 k로 도달하면 사이클이 돈 것. 출력한다.
        if(depth==k){
            //arr중 k번째까지가 유효함
            checkPrime(makeIntNumber(arr, k));
            return;
        }

        for(int i=0;i<n;i++){
            swap(arr, depth, i);
            permutation(arr, depth+1, n, k);
            swap(arr, depth, i);//원상복귀
        }
    }

    //배열 안의 값을 k번째까지 이어붙여서 숫자로 만드는 함수 makeIntNumber
    public int makeIntNumber(int[] arr, int k){
        int result = 0;
        for(int i=0;i<k;i++){
            result += arr[i] * Math.pow(10, i);
        }
        return result;
    }

    //소수인지 체크하는 함수 checkPrime
    public void checkPrime(int number){
        if(number==0 || number==1) return;

        for(int i=0; i<number; i++){
            if(number%i==0) return;
        }
        //해쉬에 삽입(똑같은건 덮어씌워져서 중복체크 방지)
        hash.put(number, number);
    }


    public void swap(int[] arr, int depth, int i){
        int tmp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = tmp;
    }
}
