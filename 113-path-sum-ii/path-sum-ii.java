/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans=new ArrayList<>();
        helper(root,targetSum,0,new ArrayList<Integer>());
        return ans;
    }

    public void helper(TreeNode root,int targetSum,int ssf,List<Integer> psf){
        if(root==null) return;

        int currSum=ssf+root.val;
        psf.add(root.val);

        if(root.left==null && root.right==null){
            if(currSum==targetSum){
                ans.add(new ArrayList<>(psf));
            }
        }
        helper(root.left,targetSum,currSum,psf);
        helper(root.right,targetSum,currSum,psf);

        psf.removeLast();
    }
}