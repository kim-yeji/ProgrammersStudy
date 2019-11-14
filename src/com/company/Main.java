package com.company;

import java.util.Arrays;
import java.util.Comparator;

class Main {
    public int solution(int n) {
        int answer = 0;
        if (n<=1) return 1;

        int num1=1;
        int num2=1;
        for (int i=3;i<=n;i++){
            answer=num1+num2;
            answer%=1234567;
            num1=num2;
            num2=answer;
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        int[][] arr1 = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        int[][] arr2 = {{1}};

        int[] array1 = {70, 50, 80, 50};
        int[] array2 = {4,10,15};

        int n =15;
        int m = 4;

        String[] strArr={"97674223", "119", "1195524421"};
        String s = "3people unFollowed me";
        String target = "cog";

        String[][] name = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};


        Main main = new Main();
        main.solution(strArr);
    }
}