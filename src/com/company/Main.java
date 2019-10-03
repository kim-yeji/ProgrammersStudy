package com.company;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

class Main {

    public int solution(String arrangement) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<arrangement.length();i++){
            if(arrangement.charAt(i)=='('){
                stack.add(arrangement.charAt(i));
            }else{
                stack.pop(); //arrangement.charAt(i)==')'일 경우 팝 시킨다.
                if(arrangement.charAt(i-1)=='('){ //그 전에 있던게 '('였으면 레이저임
                    answer+=stack.size();
                }else{
                    answer++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] arr1 = {{1, 2}, {2, 3}};
        int[][] arr2 = {{3, 4}, {4, 5}};

        int[] array1 = {7, 4, 5, 6};
        int[] array2 = {6,9,5,7,4};
        int n = 3;
        int m = 10;
        String s = "()(((()())(())()))(())";

        String[] name = {"jane", "kim", "dragonfly", "ant", "dragonfly"};


        Main main = new Main();
        main.solution(s);
    }
}