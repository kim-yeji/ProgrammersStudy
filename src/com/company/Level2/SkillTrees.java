package com.company.Level2;
//스킬트리 191005 토요일
//**********문제 설명**********
//선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.
//
//예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때,
// 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고,
// 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.
//
//위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다.
// 따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만,
// 썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.
//
//선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때,
// 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.
//
//**********제한 조건**********
//스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
//스킬 순서와 스킬트리는 문자열로 표기합니다.
//예를 들어, C → B → D 라면 CBD로 표기합니다
//선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
//skill_trees는 길이 1 이상 20 이하인 배열입니다.
//skill_trees의 원소는 스킬을 나타내는 문자열입니다.
//skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.
public class SkillTrees {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length; //불가능한 스킬트리를 삭제해나가기 위해서 스킬트리의 길이 만큼 잡아둔다.
        int  beforeIdx=0, currentIdx=0; //스킬트리의 순서를 확인하기 위한 변수들

        for(int i=0;i<skill_trees.length;i++){ // skill_trees 배열에 있는 요소를 다 확인해야겠지요
            beforeIdx = skill_trees[i].indexOf(skill.charAt(0)); // skill_trees[i]의 문장에서 첫 번째 순서의 스킬을 beforeIdx 에 담아둔다.

            for(int j=1;j<skill.length();j++){ //skill의 길이만큼 beforeIdx와 비교하는 포문
                currentIdx = skill_trees[i].indexOf(skill.charAt(j)); //skill의 다음 글자를 저장해서 인덱스 숫자비교로 걸러낼 것
                //if문: 만약 현재 구하고자 하는 스킬이 스킬트리에 있고 이전 스킬의 인덱스가 현재 스킬의 인덱스보다 크다면 불가능한 스킬트리이다.
                if((beforeIdx>currentIdx && currentIdx!= -1) || (beforeIdx == -1 && currentIdx != -1)){
                    answer--;
                    break;
                }
                beforeIdx=currentIdx; //지금까지 skill순서가 같았다면 남은 순서도 같은지 계속 비교를 위해서 현재 인덱스를 비포인덱스에 저장
            }
        }

        return answer;
    }
}
