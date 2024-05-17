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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans=new LinkedList<>();
        if(root==null)
        return ans;
        boolean LTR=true;

        LinkedList<TreeNode> q=new LinkedList<>();
        q.addLast(root);
        while(!q.isEmpty()){
            int size=q.size();
            LinkedList<Integer> subList=new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.removeFirst();
                int val=node.val;
                if(LTR){
                 subList.addLast(val);
                }else{
                 subList.addFirst(val);
                }
                if(node.left!=null)
                q.addLast(node.left);

                if(node.right!=null)
                q.addLast(node.right);
            }
           ans.addLast(subList);
            LTR=!LTR;
        }
    return ans;
    }
}