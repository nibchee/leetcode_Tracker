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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> childs=new HashSet<>();
        HashMap<Integer,TreeNode> nodes=new HashMap<>();

        for(int[] des:descriptions){
          int p=des[0];
          int c=des[1];
          int type=des[2];
          TreeNode parent=null;
          TreeNode child=null;

          if(nodes.containsKey(p)){
             parent=nodes.get(p);
          }else{
             parent=new TreeNode(p);
             nodes.put(p,parent);
          }

          if(nodes.containsKey(c)){
              child=nodes.get(c);
             }else{
               child=new TreeNode(c);
               nodes.put(c,child);
             }

             if(type==1){
              parent.left=child;
             }else{
              parent.right=child;
             }
          childs.add(c);
    }
    TreeNode root=null;

    for(Integer key:nodes.keySet()){
      if(!childs.contains(key)){
           root=nodes.get(key);
      }
    }
    return root;
}
}