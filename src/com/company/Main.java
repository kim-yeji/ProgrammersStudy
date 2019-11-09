package com.company;


import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {
    public class Document{
        int idx;
        int priority;

        public Document(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {
        LinkedList<Document> linkedList = new LinkedList<>();

        for(int i=0;i<priorities.length;i++){
            linkedList.add(new Document(i,priorities[i]));
        }
        int answer = 1; //인쇄순번
        Document firstDoc=null; //첫번째 문서

        while(linkedList.size()>1){
            firstDoc=linkedList.getFirst(); //리스트에서 맨 처음에 놓인애를 가져옴
            for(int i=1;i<linkedList.size();i++){

                //firstDoc의 순위가 i번째에 있는 문서보다 순위가 낮다면
                if(firstDoc.priority<linkedList.get(i).priority){
                    linkedList.addLast(firstDoc); //맨 끝에 합치고
                    linkedList.removeFirst(); //삭제한다.
                    break;
                }

                //인쇄
                if(i==linkedList.size()-1){
                    System.out.println(answer);
                    if(firstDoc.idx == location) return answer;
                    linkedList.removeFirst();
                    answer++;
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) throws Exception {
        int[][] arr1 = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        int[][] arr2 = {{1}};

        int[] array1 = {1,1,9,1,1,1};
        int[] array2 = {4,10,15};

        int n =15;
        int m = 4;

        String[] strArr={"hot", "dot", "dog", "lot", "log", "cog"};
        String s = "3people unFollowed me";
        String target = "cog";

        String[][] name = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};


        Main main = new Main();
        main.solution(array1,0);
    }
}