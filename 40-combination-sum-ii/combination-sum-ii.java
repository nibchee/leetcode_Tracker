class Solution {
  List<List<Integer>> ans;

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    ans = new ArrayList<>();
    List<Integer> l = new ArrayList<>();
    helper(0, candidates, target, l);
    return ans;

  }

  private void helper(int idx, int[] candidates, int target, List<Integer> l) {

    // base cases
    if (target == 0) {
     // if (!ans.contains(l))
        ans.add(new ArrayList<Integer>(l));
      return;
    }

    for (int i = idx; i < candidates.length; i++) {
      if (i > idx && candidates[i] == candidates[i - 1])
        continue;
      if (candidates[i] > target)
        break;

      l.add(candidates[i]);
      helper(i + 1, candidates, target - candidates[i], l);
      l.remove(l.size() - 1);
    }
  }
}