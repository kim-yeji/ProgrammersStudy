package com.company.Level2;
//124 나라의 숫자 191003목
//********문제 설명********
//124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.
//
//124 나라에는 자연수만 존재합니다.
//124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
//예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.
//
//10진법	124 나라	10진법	124 나라
//  1	        1          	6	    14
//  2	        2       	7      	21
//  3        	4	        8   	22
//  4      	    11      	9	    24
//  5	        12	        10	    41
//자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.
public class Countries124 {
    //124의 나라이기 때문에 3으로 나눈 나머지가 3이 아니라 4가 나와야함.
    //(ex)n=3일때 나머지가 0이지만 4로 치환해준다.
    public String solution(int n) {
        String answer = "";
        int remain;
        while(n>0){
            remain = n%3;
            n/=3;
            if(remain==0){
                n-=1;   //몫에서 -1해주고
                remain=4;   //0을 4로 바꿔줌
            }
            answer=remain+answer; //answer+=remain 하면 41이 14가 되어 나옴!!! 여기서 틀렸었음
        }
        System.out.println(answer);
        return answer;
    }
}
