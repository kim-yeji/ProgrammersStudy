package com.company;

import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class NHNtest {
    static String matrix[][];
    static int array[];
    static int N, W;

    static void solve(int w) {
        if (W == 0) return;

        boolean flag = false;

        String tmp1 = "";

        String tmp2 = "";

        for (int t = 0; t < array.length; t++) {
            w = Math.abs(W % array[t]);
            if (t % 2 == 0) flag = (W > 0) ? true : false;
            else flag = (W > 0) ? false : true;
            while (w-- > 0) {
                if (flag) {
                    tmp1 = matrix[t][t];
                    matrix[t][t] = matrix[t + 1][t];
                    tmp2 = tmp1;
                    for (int i = t + 1; i <= N - t - 1; i++) {
                        tmp1 = matrix[t][i];
                        matrix[t][i] = tmp2;
                        tmp2 = tmp1;
                    }
                    for (int i = t + 1; i <= N - t - 1; i++) {
                        tmp1 = matrix[i][N - t - 1];
                        matrix[i][N - t - 1] = tmp2;
                        tmp2 = tmp1;
                    }
                    for (int i = N - t - 2; i >= t; i--) {
                        tmp1 = matrix[N - t - 1][i];
                        matrix[N - t - 1][i] = tmp2;
                        tmp2 = tmp1;
                    }
                    for (int i = N - t - 2; i > t; i--) {
                        tmp1 = matrix[i][t];
                        matrix[i][t] = tmp2;
                        tmp2 = tmp1;
                    }
                } else if (!flag) {
                    tmp1 = matrix[t + 1][t];
                    matrix[t + 1][t] = matrix[t][t];
                    tmp2 = tmp1;
                    for (int i = t + 2; i <= N - t - 1; i++) {
                        tmp1 = matrix[i][t];
                        matrix[i][t] = tmp2;
                        tmp2 = tmp1;
                    }
                    for (int i = t + 1; i <= N - t - 1; i++) {
                        tmp1 = matrix[N - t - 1][i];
                        matrix[N - t - 1][i] = tmp2;
                        tmp2 = tmp1;
                    }

                    for (int i = N - t - 2; i >= t; i--) {
                        tmp1 = matrix[i][N - t - 1];
                        matrix[i][N - t - 1] = tmp2;
                        tmp2 = tmp1;
                    }

                    for (int i = N - t - 2; i >= t; i--) {
                        tmp1 = matrix[t][i];
                        matrix[t][i] = tmp2;
                        tmp2 = tmp1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        // System.in 으로 콘솔에서 입력하는 문자를 문자 스트림으로 변환하는 객체 생성
        // System.out 으로 콘솔에 출력하는 OutputStreamWriter 객체 생성
        // InputStreamReader 와 OutputStreamWriter는 문자(Character) 단위로 입출력을 하기 때문에 한글 처리도 문제가 없다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());//배열의 크기
        W = Integer.parseInt(st.nextToken());//회전수 (양수면 시계방향, 음수면 반시계)
        matrix = new String[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                matrix[i][j] = st.nextToken();
            }
        }
        if (N == 1) {
            W = 0;
        } else {

            array = new int[N / 2];
            for (int i = 0; i < array.length; i++) {
                array[i] = 4 * (N - (2 * i)) - 4;
            }
            solve(W);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(matrix[i][j] + " ");
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}



