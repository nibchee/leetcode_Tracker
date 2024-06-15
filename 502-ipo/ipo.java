class Solution {
  public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    int n = profits.length;
    int arr[][] = new int[n][2];
    for (int i = 0; i < n; i++) {
      arr[i][0] = capital[i];
      arr[i][1] = profits[i];
    }
    Arrays.sort(arr, (int[] a, int[] b) -> {
      return a[0] - b[0];
    });
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
      return b[1] - a[1];
    });

    int i = 0;
    while (k > 0) {
      while (i < n && w >= arr[i][0]) {
        maxHeap.add(arr[i]);
        i++;
      }

      if (maxHeap.size() == 0)
        break;
      int[] maxProfitTightlyBoundCap = maxHeap.remove();
      w += maxProfitTightlyBoundCap[1];
      k--;

    }
    return w;
  }
}