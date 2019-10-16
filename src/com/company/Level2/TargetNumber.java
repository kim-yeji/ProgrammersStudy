package com.company.Level2;
//타겟넘버 191008 화요일

//***********문제 설명***********
//n개의 음이 아닌 정수가 있습니다.
// 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
// 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
//
//  -1+1+1+1+1 = 3
//  +1-1+1+1+1 = 3
//  +1+1-1+1+1 = 3
//  +1+1+1-1+1 = 3
//  +1+1+1+1-1 = 3

//사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때
// 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
//
//***********제한사항***********
//주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
//각 숫자는 1 이상 50 이하인 자연수입니다.
//타겟 넘버는 1 이상 1000 이하인 자연수입니다.

public class TargetNumber {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        //DFS 문제는 Stack 또는 재귀를 통해 풀이가 가능하다.
        //DFS에서는 점화식과 종료조건을 찾는 것이 가장 중요하다.
        //종료조건은 모든 깊이 즉, 배열에 모든 요소를 접근했을 때이다.
        //점화식은 해당 인덱스의 요소를 더할지, 혹은, 더하지 않을지의 모든 경우를 구하자! 이다.

        DFS(numbers,target,0);
        return answer;
    }

    public void DFS(int[] numbers, int target, int k){
        //연산과정을 하나의 트리로 생각해볼때,
        // '+'연산은 왼쪽 자식노드로, '-'연산은 오른쪽 자식노드로 내려가는 과정을 재귀형식으로


        if(k == numbers.length){
            int sum=0;
            for(int i=0; i<numbers.length;i++){
                sum+=numbers[i];
            }
            if(sum == target) answer++;
            return;
        }else{
            numbers[k]*=1;
            DFS(numbers,target,k+1);

            numbers[k]*=-1;
            DFS(numbers,target,k+1);
        }
    }

}
