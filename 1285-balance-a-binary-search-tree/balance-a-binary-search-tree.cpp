/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
   std::vector<TreeNode*> l;
public:
    TreeNode* balanceBST(TreeNode* root) {
       inorder(root);
        return sortedArrayToBST(0, l.size() - 1);  
    }

    private:
    void inorder(TreeNode* root) {
        if (root == nullptr) return;
        inorder(root->left);
        l.push_back(root);
        inorder(root->right);
    }

    TreeNode* sortedArrayToBST(int si, int ei) {
        if (si > ei) return nullptr;
        int mi = (si + ei) / 2;
        TreeNode* curr = l[mi];
        curr->left = sortedArrayToBST(si, mi - 1);
        curr->right = sortedArrayToBST(mi + 1, ei);
        return curr;
    }
};