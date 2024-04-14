/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int a=rand7();
        int b=rand7();
        int val=(a-1)*7+b;
        while(val>40){
            val=(rand7()-1)*7+rand7();
        }
      return val%10+1;

    }
}