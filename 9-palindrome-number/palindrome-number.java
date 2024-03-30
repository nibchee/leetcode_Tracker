class Solution {
    public boolean isPalindrome(int x) {
        //If  a number is negative number
        //if the number end with 0 except the number 0
        if(x<0 || (x!=0 && x%10==0)){
            return false;
        }

        int reverse=0;
        int num=x;
        while(num>reverse){
            int lastDigit=num%10;
            reverse=reverse*10+lastDigit;
           num=num/10;
        }
        //num==reverse/10 is for Odd digits & else for even digits
        return num==reverse/10 || num==reverse;
        
    }
}
//TC:O(logN)