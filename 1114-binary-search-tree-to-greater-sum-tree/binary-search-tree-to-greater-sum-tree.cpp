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
  vector<TreeNode*> inorderNodes;
public:
    TreeNode* bstToGst(TreeNode* root) {
        inorder(root);
        int sum = 0;
        for(int i = inorderNodes.size() - 1; i >= 0; --i) {
            sum += inorderNodes[i]->val;
            TreeNode* current = inorderNodes[i];
            current->val = sum;
        }
        return root;
    }

    private:
    void inorder(TreeNode* root) {
        if(root == nullptr) return;
        inorder(root->left);
        inorderNodes.push_back(root);
        inorder(root->right);
    }
};