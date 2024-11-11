class Solution {
    private boolean isPrime(int n){
       for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;  
    }
    public boolean primeSubOperation(int[] nums) {
        int maxEle=Integer.MIN_VALUE;
         for(int num: nums){
            maxEle=Math.max(maxEle,num);
         }

         int[] prevPrime=new int[maxEle+1];
         for(int i=2;i<=maxEle;i++){
            if(isPrime(i)){
                prevPrime[i]=i;
            }else{
                prevPrime[i]=prevPrime[i-1];
            }
         }
         int prime_range=nums[0];
        for(int i=0;i<nums.length;i++){
           if(i!=0)
            prime_range=nums[i]-nums[i-1];

            if(prime_range<=0)
            return false;

            int nearest_prime=prevPrime[prime_range-1];
            

            nums[i]=nums[i]-nearest_prime;
            
        }
        return true;
    }
}