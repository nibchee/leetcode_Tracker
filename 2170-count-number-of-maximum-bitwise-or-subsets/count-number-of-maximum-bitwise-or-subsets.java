class Solution {
  int maxBitValue = 0;
  int ans = 0;

  public int countMaxOrSubsets(int[] nums) {

    for (int i = 0; i < nums.length; i++) {
      maxBitValue = maxBitValue | nums[i];
    }
    System.out.println(maxBitValue);
    allSubsets(0, 0, nums);
    return ans;
  }

  private void allSubsets(int or, int i, int[] nums) {
  //  System.out.println(i+" "+or);
   
     if (i == nums.length ){
      if(or==maxBitValue)
       ans++;
       return;
     }

    allSubsets(or|nums[i], i+1 , nums);
  
    allSubsets(or, i+1 , nums);
    

    
   }
  }
