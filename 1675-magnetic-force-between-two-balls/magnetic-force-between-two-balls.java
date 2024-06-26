class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int min = Integer.MAX_VALUE;
        int max = position[n - 1] - position[0];
        // min distance can be min between any 2 consecutive balls
        for (int i = 1; i < n; i++) {
            min = Math.min(min, position[i] - position[i - 1]);
        }

        int ans = 0;
        while (min <= max) {
            int mid = min + (max - min) / 2;

            if (is_possible(position, m, mid)) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return ans;
    }

    private boolean is_possible(int[] position, int m, int dist) {
        // place first ball
        int last_placed = position[0];
        int balls = 1;

        for (int i = 1; i < position.length; i++) {
            if (position[i] - last_placed >= dist) {
                last_placed = position[i];
                balls++;
            }

            if (balls == m)
                return true;
        }
        return false;
    }

}