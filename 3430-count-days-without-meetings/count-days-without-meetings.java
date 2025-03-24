class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });

        List<int[]> merge = new LinkedList<>();
        int[] curr = meetings[0];

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] <= curr[1]) {
                curr[1] = Math.max(meetings[i][1], curr[1]);
            } else {
                merge.add(curr);
                curr = meetings[i];
            }
        }

        merge.add(curr);

        int count = 0;
        int lastMeet = 0;
        for (int[] meet : merge) {
            count += meet[0] - lastMeet - 1;
            lastMeet = meet[1];
        }

        count += days - lastMeet;
        return count;
    }
}