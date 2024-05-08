class Solution {
    public String[] findRelativeRanks(int[] score) {
        int max = score[0];
        for (int m : score)
            max = Math.max(max, m);

        int arr[] = new int[max + 1];
        Arrays.fill(arr, -1);
        for (int i = 0; i < score.length; i++) {
            arr[score[i]] = i;
        }
        String ans[] = new String[score.length];
        Integer count = 1;

        for (int i = arr.length-1; i>=0; i--) {
            if (arr[i] == -1)
                continue;

            switch (count) {
                case 1:
                    ans[arr[i]] = "Gold Medal";
                    break;
                case 2:
                    ans[arr[i]] = "Silver Medal";
                    break;
                case 3:
                    ans[arr[i]] = "Bronze Medal";
                    break;
                default:
                    ans[arr[i]] = count.toString();
                    break;
            }
            count++;
        }
        return ans;
    }
}