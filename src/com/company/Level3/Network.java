package com.company.Level3;
//네트워크 191009수요일  **DFS문제!!===>재귀함수**
//********문제 설명********
//네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다.
// 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고,
// 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
// 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
//
//컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때,
// 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
//
//********제한사항********
//컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
//각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
//i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
//computer[i][i]는 항상 1입니다.

//********입출력 예********
//n	                     computers	             return
//3	        [[1, 1, 0], [1, 1, 0], [0, 0, 1]]   	2
//3	        [[1, 1, 0], [1, 1, 1], [0, 1, 1]]	    1

public class Network {
    //DFS 문제는 Stack 또는 재귀를 통해 풀이가 가능하다.
    //DFS에서는 점화식과 종료조건을 찾는 것이 가장 중요하다.
    //종료조건은 모든 깊이 즉, 배열에 모든 요소를 접근했을 때이다.
    //점화식은 해당 인덱스의 요소를 더할지, 혹은, 더하지 않을지의 모든 경우를 구하자! 이다.

    private boolean[] visited;
    private int answer = 0;

    public int solution(int n, int[][] computers) {
        visited = new boolean[computers.length];
        for(int i=0;i<n;i++){
            if (!visited[i]){ //=visited[j]==false
                dfs(i,computers,n);
                answer++;
            }
        }
        return answer;
    }

    void dfs(int idx, int [][] computers, int n){
        visited[idx] = true;
        for(int j=1;j<n;j++){
            //다음거랑 연결이 되어있고 방문하지 않았다면 거기로 찾아간다. DFS니까!
            if (computers[idx][j]==1 && !visited[j]){ //=visited[j]==false
                dfs(j,computers,n);
            }
        }
    }
}
