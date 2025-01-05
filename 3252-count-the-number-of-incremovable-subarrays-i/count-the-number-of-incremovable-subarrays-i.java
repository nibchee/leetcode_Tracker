class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                boolean yes = true;
                for (int k = 0; k < i - 1; k++) {
                    if (nums[k] >= nums[k + 1]) {
                        yes = false;
                        break;
                    }
                }
                if (!yes || (i - 1 >= 0 && j + 1 < n && nums[i - 1] >= nums[j + 1]))
                    continue;
                for (int k = j + 1; k < n - 1; k++) {
                    if (nums[k] >= nums[k + 1]) {
                        yes = false;
                        break;
                    }
                }

                if (yes) {
                    // System.out.println(i+" "+j);
                    ans++;
                }
            }
        }
        return ans;
    }
}