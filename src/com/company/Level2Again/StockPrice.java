package com.company.Level2Again;
//191108 금요일
//주식가격
public class StockPrice {
    public int[] solution(int[] prices) {
        //마지막 요소는 하상 0초 지속임
        int[] answer = new int[prices.length];
        for(int i=0;i<answer.length;i++){
            for(int j=i+1;j<answer.length;j++){
                //prices[i]가 prices[j]보다 더 크다는 것은
                //가격이 떨어진 것이기 때문에 가격이 떨어질 때 까지 걸린 기간을 answer에 삽입
                if(prices[i]>prices[j]){
                    answer[i]=j-i;
                    break;
                }
                if (j==answer.length-1) answer[i] = j-i;
            }
        }
        return answer;
    }
}
