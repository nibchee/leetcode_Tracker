class Solution {
  public int[] findXSum(int[] nums, int k, int x) {
  HashMap<Integer, Integer> map = new HashMap<>();
    int n = nums.length;
    PriorityQueue<Integer> pq = new PriorityQueue<>(x,
        (a, b) -> {
          if (map.get(b) == map.get(a))
            return b - a;
          return map.get(b) - map.get(a);
        });

    for (int i = 0; i < k; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }

    for (int i = 0; i < k; i++) {
      if (!pq.contains(nums[i]))
        pq.add(nums[i]);
    }

    int j = k - 1, i = 0;
    int ans[] = new int[n - k + 1];

    while (j < nums.length) {
      int sum = 0;
      for (int y = 0; y < x && !pq.isEmpty(); y++) {
        int e = pq.remove();
        // System.out.println("ele " + e + " " + map.get(e));
        sum +=  e *  map.get(e);
      }
      while (!pq.isEmpty()) {
        pq.remove();
      }
      // System.out.println("Sum " + sum);
      map.put(nums[i], map.get(nums[i]) - 1);
      if (map.get(nums[i]) == 0)
        map.remove(nums[i]);
      ans[i] = sum;
      i++;
      j++;
      if (j < n) {
        map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
      }
      for (int z = i; z <= j && z < n; z++) {
        if (!pq.contains(nums[z]))
          pq.add(nums[z]);
      }
    }

    return ans;
  }
}