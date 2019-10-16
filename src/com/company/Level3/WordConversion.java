package com.company.Level3;
//단어변환 191010목

//********문제 설명********
//두 개의 단어 begin, target과 단어의 집합 words가 있습니다.
// 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
//
//1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
//2. words에 있는 단어로만 변환할 수 있습니다.

//예를 들어 begin이 hit, target가 cog, words가 [hot,dot,dog,lot,log,cog]라면
// hit -> hot -> dot -> dog -> cog와 같이 4단계를 거쳐 변환할 수 있습니다.
//
//두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때,
// 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
//
//********제한사항********
//각 단어는 알파벳 소문자로만 이루어져 있습니다.
//각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
//words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
//begin과 target은 같지 않습니다.
//변환할 수 없는 경우에는 0를 return 합니다.

import java.util.LinkedList;

public class WordConversion {

    //최소값을 구할 때는 bfs알고리즘을 사용한다는 것 외워두세요~
    int answer = 0;
    boolean visited[];

    boolean str_match(String str1, String str2) {
        int total = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.substring(i, i + 1).compareTo(str2.substring(i, i + 1)) != 0)
                total++;

        }
        if (total == 1)
            return true;
        else
            return false;
    }

    void bfs(int index, String[] words, String begin, String target, int stage) {
        LinkedList<Integer> queue = new LinkedList<Integer>();

        if (index == 0) {
            for (int i = 0; i < words.length; i++) {
                if (str_match(begin, words[i]) == true) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.getFirst();
            queue.pollFirst(); // 맨 앞에 수 빼기
            stage++;
            //System.out.println(words[x]);
            if (words[x].compareTo(target)==0) {
                answer = stage;
                return;
            }
            for (int i = 0; i < words.length; i++) {
                if (visited[i] == false && str_match(words[x], words[i])) {
                    queue.push(i);
                    visited[i] = true;
                }
            }
        }
        answer = 0;
    }

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        bfs(0, words, begin, target, 0);

        return answer;
    }


}




//2번째 알고리즘

/*
*
*  static class Node {
        String next;
        int edge;

        public Node(String next, int edge) {
            this.next = next;
            this.edge = edge;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int n = words.length, ans = 0;

        // for (int i=0; i<n; i++)
        //  if (words[i] != target && i == n-1) return 0;

        Queue<Node> q = new LinkedList<>();


        boolean[] visit = new boolean[n];
        q.add(new Node(begin, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.next.equals(target)) {
                ans = cur.edge;
                break;
            }

            for (int i=0; i<n; i++) {
                if (!visit[i] && isNext(cur.next, words[i])) {
                    visit[i] = true;
                    q.add(new Node(words[i], cur.edge + 1));
                }
            }
        }

        return ans;
    }

    static boolean isNext(String cur, String n) {
        int cnt = 0;
        for (int i=0; i<n.length(); i++) {
            if (cur.charAt(i) != n.charAt(i)) {
                if (++ cnt > 1) return false;
            }
        }

        return true;
    }
    *
    * */