package com.company.Level2Again;
//191112 화요일
//전화번호 목록
public class PhoneNumberList {
    public boolean solution(String[] phone_book) {

        for (int i=0;i<phone_book.length;i++){
            for (int j=i+1;j<phone_book.length;j++){
                if (phone_book[i].startsWith(phone_book[j])) return false;
                if (phone_book[j].startsWith(phone_book[i])) return false;
            }
        }
        return true;

    }
}
