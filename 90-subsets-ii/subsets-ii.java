class Solution {
  List<List<Integer>> ans;

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    ans = new ArrayList<>();
    helper(nums, 0, new ArrayList<Integer>());
    return ans;
  }

  private void helper(int[] nums, int idx, ArrayList<Integer> ds) {
    if (idx == nums.length) {
      if (!ans.contains(ds))
        ans.add(new ArrayList<>(ds));
      return;
    }
    // take
    ds.add(nums[idx]);
    helper(nums, idx + 1, ds);
    ds.remove(ds.size() - 1);

    // not Take
    helper(nums, idx + 1, ds);
  }
}