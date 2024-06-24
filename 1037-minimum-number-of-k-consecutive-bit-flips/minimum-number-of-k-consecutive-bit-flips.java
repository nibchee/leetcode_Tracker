class Solution {
  public int minKBitFlips(int[] nums, int k) {
    int n = nums.length;
    // this helps in keep count for flips at current i
    int[] totalFlipCount = new int[n];
    totalFlipCount[0] = (nums[0] == 0) ? 1 : 0;
    // Iterating till n-k+1, for which need to find resultant Flips count
    for (int i = 1; i < n - k + 1; i++) {
      int resultantFlips = totalFlipCount[i - 1];
      // if current idx is greater than k then need to remove the i-k flip effect
      if (i - k >= 0) {
        resultantFlips -= totalFlipCount[i - k];
      }
      // Need to flip so increase resultant
      if ((nums[i] == 0 && resultantFlips % 2 == 0) || (nums[i] == 1 && resultantFlips % 2 == 1)) {
        totalFlipCount[i] = totalFlipCount[i - 1] + 1;
      } else {
        totalFlipCount[i] = totalFlipCount[i - 1];
      }
      System.out.print(totalFlipCount[i] + " ");
    }

    // Now from n-k+1 to n , have to check , is it all 1's possible
    for (int i = n - k + 1; i < n; i++) {
      int resultantFlips = totalFlipCount[i - 1];
      if (i - k >= 0) {
        resultantFlips -= totalFlipCount[i - k];
      }
      // here need flip but we can't so return -1
      if ((nums[i] == 0 && resultantFlips % 2 == 0) || (nums[i] == 1 && resultantFlips % 2 == 1))
        return -1;
      // here we not flipping just initilaise prev value
      totalFlipCount[i] = totalFlipCount[i - 1];
    }

    return totalFlipCount[n - 1];
  }
}