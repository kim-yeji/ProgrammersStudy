package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NHNTest2019 {
    static String CardName[];
    static void solve(int CardNum, int[] cardCnt) {
        int max=0;
        for(int i=0;i<cardCnt.length;i++){
            if(cardCnt[i]>max) max=cardCnt[i];

        }
    }
    public static void main(String[] args) throws Exception {
        int cardNum;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        cardNum = Integer.parseInt(st.nextToken());//카드개수
        CardName = new String[cardNum];

        int[] cardCnt=new int[cardNum];
        st = new StringTokenizer(br.readLine());
        CardName[0]=st.nextToken();
        cardCnt[0]++;

        for (int i = 1; i < cardNum; i++) {
            st = new StringTokenizer(br.readLine());
            if(!st.equals(CardName[i-1])){
                CardName[i]= st.nextToken();
            }else{
                cardCnt[i]++;
            }

        }
        solve(cardNum,cardCnt);
        for (int i = 0; i < cardNum; i++) {
            bw.write(CardName[i]+ " ");
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
