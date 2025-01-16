class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        //for(int num:ages)
        // System.out.print(num+" ");
        //  System.out.println();
        int n = ages.length;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            double tar=ages[i] * 0.5 + 7;
            int idx1 = bs(ages, i, tar);
            int idx2 =(ages[i]>tar)?bs2(ages, i, ages[i]):i;
            ans += (i - idx2);
            ans += (i - idx1);
        // System.out.println(i+" " +ages[i]);
        // System.out.println((ages[i]*0.5+7)+"--"+idx1+"-->"+ages[idx1]);
        // System.out.println(ages[i]+"--"+idx2+"-->"+ages[idx2]);
        //  System.out.println("Ans"+ans);
        //   System.out.println("--------------------------");
        
        }
        return ans;
    }

    private int bs(int[] ages, int high, double target) {
        // System.out.println("IDX:"+high);
        int h = high - 1;
        int l = 0;
        int ans = high;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (ages[mid] > target) {
                // System.out.println(ans);
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // System.out.println("----------------------------");
        return ans;
    }
private int bs2(int[] ages, int high, double target) {
        // System.out.println("IDX:"+high);
        int h = high - 1;
        int l = 0;
        int ans = high;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (ages[mid] >= target) {
                // System.out.println(ans);
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // System.out.println("----------------------------");
        return ans;
    }
}

/**
 * Total Frined Request
 * Arrays.sortA
 * 
 */