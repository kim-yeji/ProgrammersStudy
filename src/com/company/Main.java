package com.company;


class Main {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i=0;i<prices.length;i++){
            for (int j=i+1;j<prices.length;j++){
                if (prices[i]>prices[j]){
                    answer[i]=j-i;
                    break;
                }
                if (j==prices.length-1) answer[i]=j-i;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        int[][] arr1 = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        int[][] arr2 = {{1}};

        int[] array1 = {1, 2, 3, 2, 3};
        int[] array2 = {4,10,15};

        int n =15;
        int m = 4;

        String[] strArr={"hot", "dot", "dog", "lot", "log", "cog"};
        String s = "3people unFollowed me";
        String target = "cog";

        String[][] name = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};


        Main main = new Main();
        main.solution(array1);
    }
}