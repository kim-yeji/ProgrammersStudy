package com.company.Level2Again;
//191113 수요일
//행렬의 곱셈
public class MatrixMultiplication {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i=0;i<answer.length;i++){ //행을 정해줌
            for (int j=0; j<answer[0].length;j++){ //열을 정해줌
                for (int k=0; k<arr1[0].length;k++){ //곱해주는 부분을 스위치해주는 부분
                    answer[i][j]+=arr1[i][k]*arr2[k][j];
                }
            }
        }
        return answer;
    }
}
