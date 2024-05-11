class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = wage.length;

        double totalCost = Double.MAX_VALUE;
        double currentTotalQuality = 0;

        double[][] wagePerQuality = new double[n][2];

        for (int i = 0; i < n; i++) {
            wagePerQuality[i] = new double[] { (double)wage[i] / quality[i], quality[i] };
        }

        Arrays.sort(wagePerQuality, (double[] a, double[] b) -> Double.compare(a[0], b[0]));

        // MAX heap , to maintain least Quality k workers
        PriorityQueue<Double> highestQuality = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            highestQuality.add(wagePerQuality[i][1]);
            currentTotalQuality += wagePerQuality[i][1];

            /// if more than k workers
            if (highestQuality.size() > k) {
                currentTotalQuality -= highestQuality.poll();
            }
            // if ==K
            if (highestQuality.size() == k) {
                totalCost = Math.min(totalCost, currentTotalQuality * wagePerQuality[i][0]);
            }
        }

        return totalCost;
    }
}