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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans=new LinkedList<>();
         if(root==null)
        return ans;
        LinkedList<TreeNode> q=new LinkedList<>();

        q.addLast(root);
        
        while(!q.isEmpty()){
           q.addLast(null);
            LinkedList<Integer> level=new LinkedList<>();
            while(q.peekFirst()!=null){
                TreeNode node=q.removeFirst();
                level.addLast(node.val);
                if(node.left!=null)
                q.addLast(node.left);

                if(node.right!=null)
                q.addLast(node.right);
            }
            //remove null
            q.removeFirst();
            ans.addLast(level);
        }
   return ans;
    }

}