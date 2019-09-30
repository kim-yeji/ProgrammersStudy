package com.company.Level1;
//이상한 문자 만들기 190930월
//*******문제 설명*******
//문자열 s는 한 개 이상의 단어로 구성되어 있습니다.
// 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
// 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
//
//*******제한 사항*******
//문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
//첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.


//가장 중요한 포인트!! ★공백으로 구분된 단어를 읽어왔을때 각 단어의 첫문자를 어떻게 첫번째 문자로 인식하도록 프로그래밍을 할까?★
public class strangeCharacters {
    public String solution(String s) {

        String answer = "";
        int cnt=0;
        String[] array = s.split(""); //공백을 포함해서 array에 담는다!!

        for(int i=0;i<array.length;i++){
            if(array[i].contains(" ")) { cnt = 0;}
            else {cnt++;}

            if(cnt%2==0){
                array[i]=array[i].toLowerCase();
                answer+=array[i];
            }else{
                array[i]=array[i].toUpperCase();
                answer+=array[i];
            }
        }
        System.out.println(answer);
        return answer;
    }

    /*
    public String solution(String s) {

        String answer = "";
        int cnt = 0;
        String[] array = s.split("");

        for(String ss : array) {
            cnt = ss.contains(" ") ? 0 : cnt + 1;
            answer += cnt%2 == 0 ? ss.toLowerCase() : ss.toUpperCase();
        }
        return answer;
    }
  */
}


