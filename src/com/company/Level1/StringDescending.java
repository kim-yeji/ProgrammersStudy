package com.company.Level1;

import java.util.Arrays;
import java.util.Collections;

//문자열 내림차순으로 배치하기 (190929 일)
//문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
//s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
public class StringDescending {
    public String solution(String s) {
        String[] array = s.split("");
        Arrays.sort(array);

        //Arrays.asList: 사실 완벽히 변환(convert)한다기 보단,
        // 배열을 List처럼 .set() 등의 메소드를 이용해서 List처럼 편리하게 쓰도록 하겠다는 것이 더 정확하다.
        Collections.reverse(Arrays.asList(array));


        return String.join("", array);
    }
}
