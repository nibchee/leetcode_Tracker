class Solution {
  List<List<Integer>> ans;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    ans = new ArrayList<>();
    List<Integer> l = new ArrayList<>();
    helper(0, candidates, target,l);
    return ans;
  }

  private void helper(int idx, int[] candidates, int target, List<Integer> l) {

    // base cases
    if (target == 0) {
      ans.add(new ArrayList<Integer>(l));
      return;
    }

    if (idx == candidates.length) {
      return;
    }
    //Take multiple number of times
    l.add(candidates[idx]);
    if (target - candidates[idx] >= 0)
      helper(idx, candidates, target - candidates[idx], l);
    l.remove(l.size() - 1);

    // not take
    helper(idx + 1, candidates, target, l);

  }
}