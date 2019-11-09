package com.company.Level2Again;
//191109 토요일
//프린터
import java.util.LinkedList;

public class Printer {
    public class Document{
        int idx;
        int priority;

        public Document(int idx, int priority){
            this.idx=idx;
            this.priority=priority;
        }
    }
    public int solution(int[] priorities, int location) {
        LinkedList<Document> linkedList = new LinkedList<>();

        for (int i=0;i<priorities.length;i++){
            linkedList.add(new Document(i,priorities[i]));
        }
        int answer=1;
        Document firstDoc = null;

        while (linkedList.size()>0){
            firstDoc = linkedList.getFirst();
            for (int i=1;i<linkedList.size();i++){
                if (firstDoc.priority<linkedList.get(i).priority){
                    linkedList.addLast(firstDoc);
                    linkedList.removeFirst();
                    break;
                }
                if ( i == linkedList.size()-1){
                    if (firstDoc.idx==location) return answer;
                    linkedList.removeFirst();
                    answer++;
                }
            }
        }
        return answer;
    }

}
