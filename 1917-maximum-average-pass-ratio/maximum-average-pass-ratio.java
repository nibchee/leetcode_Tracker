import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // PriorityQueue to store classes based on their pass ratio improvement
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> 
            Double.compare((double)(b[0] + 1) / (b[1] + 1) - (double)(b[0]) / b[1], 
                           (double)(a[0] + 1) / (a[1] + 1) - (double)(a[0]) / a[1]));

        // Add all classes to the heap
        for (int[] currentClass : classes) {
            heap.add(currentClass);
        }

        // Allocate extra students to improve the pass ratio
        while (extraStudents > 0) {
            int[] highPassRatioClass = heap.remove();
            highPassRatioClass[0] += 1;
            highPassRatioClass[1] += 1;
            heap.add(highPassRatioClass);
            extraStudents--;
        }

        // Calculate the total average pass ratio
        double ans = 0;
        while (!heap.isEmpty()) {
            int[] currentClass = heap.remove();
            ans += (double) currentClass[0] / currentClass[1];
        }
        
        return ans / classes.length;
    }
}
