package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public int solution(int n) {
        int tmp=n;
        String nBinary = "";
        while(tmp!=0){
            nBinary+=tmp%2;
            tmp/=2;
        }
        System.out.println(nBinary);

        //String nBinary = Integer.toBinaryString(n);
        int nCount=0;
        for(int i=0;i<nBinary.length();i++){
            if('1' == nBinary.charAt(i)) nCount++;
        }


        int j=0;
        int jCount=0;
        for (j=n+1;nCount!=jCount;j++){
           // String jBinary = Integer.toBinaryString(j);
            String jBinary = "";
            int tmp2=j;
            while(tmp2!=0){
                jBinary+=tmp2%2;
                tmp2/=2;
            }
            System.out.println(jBinary);
            jCount=0;
            for(int i=0;i<jBinary.length();i++){
                if(jBinary.charAt(i)=='1') jCount++;
            }
        }
        System.out.println(j-1);
        return j-1;
    }

    public static void main(String[] args) throws Exception {
        int[][] arr1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] arr2 = {{1}};

        int[] array1 = {20,5,10};
        int[] array2 = {4,10,15};

        int n =78;
        int m = 4;

        String[] strArr={"hot", "dot", "dog", "lot", "log", "cog"};
        String s = "hit";
        String target = "cog";

        String[][] name = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};


        Main main = new Main();
        main.solution(n);
    }
}