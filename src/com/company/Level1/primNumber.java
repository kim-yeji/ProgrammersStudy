package com.company.Level1;

//소수찾기 190928 토)

public class primNumber {
    public int solution(int n) {
        //에라토스테네스의 체 이용

        int answer = 0;
        int[] arr = new int[n+1];

        //2부터 n까지의 수를 배열에 넣는다.
        for(int i=2; i<=n; i++) {
            arr[i] = i;
        }

        //2부터 시작해서 그의 배수들을 0으로 만든다.
        //후에 0이면 넘어가고 아니면 그의 배수들을 다시 0으로 만든다.
        for(int i=2; i<=n; i++) {
            if(arr[i]==0) continue;

            for(int j= 2*i; j<=n; j += i) {
                arr[j] = 0;
            }
        }

        //배열에서 0이 아닌 것들의 개수를 세준다.
        for(int i=0; i<arr.length; i++) {
            if(arr[i]!=0) {
                answer++;
            }
        }
        return answer;
    }
}
