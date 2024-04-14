/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
     /* Here as we need to generate 10 numbers with equal probabilty 
          so can't use only rand7() once but have to use twice
          so Create a Table with 7*7 size , 
          & Map values from 1-40 , 
          Formula for nth ele= (R-1)*7 + C
          so val=(Rand7()-1)*7+Rand7()
          if its val > 40 then again generate
        */
    
class Solution extends SolBase {
    public int rand10() {
        int val=(rand7()-1)*7+rand7();
        while(val>40){
            val=(rand7()-1)*7+rand7();
        }
        return val%10+1; //as have to gen 1-10
    }
}