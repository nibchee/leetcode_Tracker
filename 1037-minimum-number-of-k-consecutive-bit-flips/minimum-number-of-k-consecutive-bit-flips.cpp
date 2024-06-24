class Solution {
public:
    int minKBitFlips(std::vector<int>& nums, int k) {
        int n = nums.size();
        std::vector<int> totalFlipCount(n, 0);
        totalFlipCount[0] = (nums[0] == 0) ? 1 : 0;

        for (int i = 1; i < n - k + 1; i++) {
            int resultantFlips = totalFlipCount[i - 1];
            if (i - k >= 0) {
                resultantFlips -= totalFlipCount[i - k];
            }
            if ((nums[i] == 0 && resultantFlips % 2 == 0) || (nums[i] == 1 && resultantFlips % 2 == 1)) {
                totalFlipCount[i] = totalFlipCount[i - 1] + 1;
            } else {
                totalFlipCount[i] = totalFlipCount[i - 1];
            }
        }

        for (int i = n - k + 1; i < n; i++) {
            int resultantFlips = totalFlipCount[i - 1];
            if (i - k >= 0) {
                resultantFlips -= totalFlipCount[i - k];
            }
            if ((nums[i] == 0 && resultantFlips % 2 == 0) || (nums[i] == 1 && resultantFlips % 2 == 1)) {
                return -1;
            }
            totalFlipCount[i] = totalFlipCount[i - 1];
        }

        return totalFlipCount[n - 1];
    }
};
