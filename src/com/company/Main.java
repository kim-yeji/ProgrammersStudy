package com.company;

class Main {

    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1, 2}, {2, 3}};
        int[][] arr2 = {{3, 4}, {4, 5}};

        int[] array1 = {2, 1, 3, 2};
        int[] array2 = {6,9,5,7,4};
        int n = 2;
        int m = 10;
        String s = "CBD";

        String[] name = {"BACDE", "CBADF", "AECB", "BDA"};


        Main main = new Main();
        main.solution(s,name);
    }
}