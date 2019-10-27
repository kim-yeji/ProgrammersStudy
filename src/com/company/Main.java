
package com.company;


import java.util.Arrays;

class Main {
//    int solution(int[][] land) {
//
//        for (int i=1 ; i< land.length;i++){
//            for (int j=0;j<land[0].length;j++){
//                int sum=0;
//                for (int k=0;k<land[0].length;k++){
//                    if(k==j) continue;
//                    else sum=Math.max(sum, land[i-1][k]);
//                }
//                land[i][j]+=sum;
//            }
//        }
//
//        Arrays.sort(land[land.length-1]);
//
//        System.out.println("Hello Java");
//        return land[land.length-1][land[0].length-1];
//    }

    int solution(int[][] land) {
        for(int i = 1 ; i < land.length ; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }

        return Math.max(land[land.length-1][0], Math.max(land[land.length-1][1], Math.max(land[land.length-1][2], land[land.length-1][3])));
    }

    public static void main(String[] args) throws Exception {
        int[][] arr1 = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        int[][] arr2 = {{1}};

        int[] array1 = {20,5,10};
        int[] array2 = {4,10,15};

        int n =15;
        int m = 4;

        String[] strArr={"hot", "dot", "dog", "lot", "log", "cog"};
        String s = "-1 -2 -3 -4";
        String target = "cog";

        String[][] name = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};


        Main main = new Main();
        main.solution(arr1);
    }
}