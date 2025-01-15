class Solution {
    private int countBits(int n) {
        int c = 0;
        while (n != 0) {
            if ((n & 1) == 1)
                c++;
            n = n >> 1;
        }
        return c;
    }

    public int minimizeXor(int num1, int num2) {
        int b1 = countBits(num2);
        int bitArray[] = new int[30];

        int pos = 0;
        int c = 0;
        while (num1 != 0) {
            if ((num1 & 1) == 1) {
                bitArray[pos] = 1;
                c++;
            }
            num1 = num1 >> 1;
            pos++;
        }

        int ans = 0;
        int diff = b1 - c;
        if (diff >= 0) {
            for (int i = 0; i < 30; i++) {
                if (bitArray[i] == 1) {
                    ans += Math.pow(2, i);
                } else {
                    if (diff > 0) {
                        ans += Math.pow(2, i);
                        diff--;
                    }
                }
            }
        } else {
            for (int i = 29; i >= 0; i--) {
                if (b1 > 0 && bitArray[i] == 1) {
                    ans += Math.pow(2, i);
                    b1--;
                }
            }
        }
        return ans;
    }
}
