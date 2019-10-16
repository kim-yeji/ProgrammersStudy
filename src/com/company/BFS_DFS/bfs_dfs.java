package com.company.BFS_DFS;
//191015 화요일 DFS + 191016 수요일 BFS
//백준 1260번 BFS DFS 기본문제
//문제
//그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
// 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
// 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
//
//입력
//첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
// 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
// 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
//
//출력
//첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class bfs_dfs {

    //인접행렬: 정점의 개수가 적을때만 유리하다. 시간이 오래걸린다.
    //인접리스트: 딸려있는 정점 식구들을 다 확인해야한다.
    //------------------------------------------------------------------
    //중복을 거르는 방법 (1) visit[]으로 확인, (2) hashMap사용
    //------------------------------------------------------------------
    //DFS: 재귀함수 or 스택
    //BFS: 큐
    //------------------------------------------------------------------
    public void solution() throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexNum = Integer.parseInt(st.nextToken()); //정점의 개수를 받음
        int edgeNum =  Integer.parseInt(st.nextToken()); //간선의 개수를 받음음
        int start =  Integer.parseInt(st.nextToken()); //탐색을 시작하는 꼭짓점

        boolean[] visited = new boolean[vertexNum+1]; //각 정점을 방문했는지 확인하는 배열(중복제거)


        //DFS 1. arraylist를 담는 배열을 만든다. 각각 arraylist에 연결된 노드의 정보가 들어간다.
        ArrayList<Integer>[] vList = new ArrayList[vertexNum+1];

        //DFS 2. 초기화를 해서 생성을 하지 않으면 오류가 생긴다!
        //   Arrays.fill() : vList 배열의 값을 모두 new ArrayList()로 초기화함  -->뭔가 이상함
        //   Arrays.fill(vList, new ArrayList<Integer>());

        for (int i=0;i<vList.length;i++){
            vList[i] = new ArrayList();
        }


        //DFS 3. 연결리스트에 각 정점을 추가하는 과정
        for (int i=0;i<edgeNum;i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            vList[v1].add(v2);
            vList[v2].add(v1);
        }



        //4. 자식이 여러개라면 노드 번호가 작은 것 먼저 방문하므로 오름차순으로 정렬
        for (int i=0;i<vList.length;i++){
            Collections.sort(vList[i]);
        }

        //첫째줄에 dfs 결과를, 둘째줄에 bfs결과를 출력
        dfs(vList, visited, start);
        System.out.println();
        Arrays.fill(visited, false); //bfs 결과를 얻기위해 다시 초기화
        bfs(vList, visited, start);

    }

    private static void dfs(ArrayList<Integer>[] vList, boolean[] visited, int v){

        // 5. 방문했다고 표시
        visited[v] = true;
        System.out.print(v+" ");

        for (int e : vList[v]){
            if(!visited[e]){
                dfs(vList, visited, e);
            }
        }
    }

    private static void bfs(ArrayList<Integer>[] vList, boolean[] visited, int v){
        //BFS 1. BFS는 Queue를 선언한다.
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(v); //받은 정점을 큐에 넣는다.
        visited[v]=true; //방문했다고 표시한다.

        while (!queue.isEmpty()){
            v = queue.poll(); //큐에서 제일 앞에 있는 (먼저 넣었던) 정점을 빼온다.
            System.out.print(v+" ");

            //for each문 사용 못할 때
            //순회하는 도중 특정한 원소를 찾을때나 그 값을 수정해야할 경우에는 일반 for문을 사용해야 하며
            //직렬이 아닌 병렬적으로 순회할 경우에도 사용할 수 없다
            for(int i: vList[v]){
                if(!visited[i]){
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }

    }
}
