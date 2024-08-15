class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5)
                count5++;
            else if (bills[i] == 10) {
                if (count5 == 0)
                    return false;
                count5--;
                count10++;
            }
            else if (bills[i] == 20) {
                if(count10>0 && count5>0){
                    count10--;
                    count5--;
                }else if(count5>=3){
                    count5=count5-3;
                }else{
                    return false;
                }

                           }
      // System.out.println(i+1+" "+bills[i]+" count5:"+count5+" count10:"+count10);
        }
        return true;
    }
}