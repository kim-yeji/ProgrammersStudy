package com.company.Level2;
//조이스틱 191005 토요일


//이 문제 이해 안되는 부분있음,,ㅠㅠ확실하게 이해한 문제는 아님


//**********문제 설명**********
//조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
//ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
//
//조이스틱을 각 방향으로 움직이면 아래와 같습니다.

//▲ - 다음 알파벳
//▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
//◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
//▶ - 커서를 오른쪽으로 이동

//예를 들어 아래의 방법으로 JAZ를 만들 수 있습니다.
//- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
//- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
//- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
//따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.

//만들고자 하는 이름 name이 매개변수로 주어질 때,
//이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

//**********제한 사항**********
//name은 알파벳 대문자로만 이루어져 있습니다.
//name의 길이는 1 이상 20 이하입니다.
public class Joystick {
    public int solution(String name) { //한쪽 방향만 하니까 통과 되네요 라는 댓글이 있었음,,ㅎ
        int answer = 0;

        //'A' 가 없는 경우 무조건 마지막 커서까지 움직이는 횟수가 커서조작횟수이기 때문에
        // exp = name.length()-1 이라는 값을 주고,
        // 이 값보다 작은 커서 조작횟수가 있다면 그 값을 exp 에 넣어서 총 조이스틱 조작횟수에 합계하였습니다.
        int exp = name.length()-1;

        for(int i=0;i<name.length();i++){
            char c = name.charAt(i);
            answer+= Math.min(('Z' - c + 1), c - 'A'); //▼,▲ 버튼 중 횟수가 적은 쪽으로 answer에 합하기.
            //answer+= ('Z'-c+1) > c-'A' ? c-'A' : ('Z'-c+1);
            if(c=='A'){
                int cntA = 0; //받은 string에서 A의 개수를 세주는 변수
                int nextIdx=i+1; //다음 철자
                //name의 길이만큼 다음 철자를 하나하나 확인 && 다음 철자가 A인 경우
                while(nextIdx < name.length() && name.charAt(nextIdx)=='A'){
                    cntA++; //A의 개수를 올리고
                    nextIdx++; //다음꺼 확인 할 준비
                }
                int tmp = (i-1)*2 + (name.length() -1 -i -cntA); //모든 경우의 수를 더한 후 <<이 부분 이해가 잘 되지 않는다.ㅠㅠ
                if(exp>tmp) exp = tmp; //그 값이 exp보다 작다면 exp에 tmp저장
            }
        }
        answer+=exp;
        System.out.println(answer);
        return answer;
    }
}
