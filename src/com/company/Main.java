package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {

    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int i=0;i<d.length;i++){
            budget-=d[i];
            if(budget<0) break;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args)  {
        int[][] arr1 = {{1,2}, {2,3}};
        int[][] arr2 = {{3,4}, {4,5}};

        int[] array = {1,3,2,5,4};

        int n=2;
        int m=9;
        String s = "01033334444";

        String[] name = {"jane", "kim", "dragonfly", "ant", "dragonfly"};


        Main main = new Main();
        main.solution(array,m);
    }
}