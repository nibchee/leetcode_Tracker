/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    ArrayList<Integer> l;

    public TreeNode balanceBST(TreeNode root) {
        l = new ArrayList<>();
        inorder(root);
        int arr[] = new int[l.size()];
        int i = 0;
        for (Integer integer : l)
            arr[i++] = integer;
        return sortedArrayToBST(arr);
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            inorder(root.left);
        l.add(root.val);
        if (root.right != null)
            inorder(root.right);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int si, int ei) {
        if (si > ei)
            return null;
        int mi = (si + ei) / 2;
        TreeNode curr = new TreeNode(nums[mi]);
        curr.left = sortedArrayToBST(nums, si, mi - 1);
        curr.right = sortedArrayToBST(nums, mi + 1, ei);
        return curr;
    }
}