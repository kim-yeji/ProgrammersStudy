package com.company.Level2;
//행렬의 곱셈 191029화요일

public class MatrixMultiplication {
    //먼저 새로운 배열은 몇 가지 특징이 있다.
    //1. 행의 크기는 arr1의 행의 크기와 같다.
    //2. 열의 크기는 arr2의 열의 크기와 같다.

    //결과 표를 자세히 보면
    //하나의 결과행을 구할 때 arr1 와 arr2의 행은 그대로지만 열이 바뀌면서 곱한 값을 더한다.
    //즉, 열의 개수만큼만 반복하면 된다.
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i=0;i< answer.length;i++){
            for (int j=0;j<answer[0].length;j++){
                for (int k=0;k<arr1[0].length;k++){
                    answer[i][j]+=arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
