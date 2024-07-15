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
public:
    TreeNode* createBinaryTree(vector<vector<int>>& descriptions) {
     unordered_set<int> childs;
        unordered_map<int, TreeNode*> nodes;

        for (auto& des : descriptions) {
            int p = des[0];
            int c = des[1];
            int type = des[2];
            TreeNode* parent = NULL;
            TreeNode* child = NULL;

            if (nodes.find(p) != nodes.end()) {
                parent = nodes[p];
            } else {
                parent = new TreeNode(p);
                nodes[p] = parent;
            }

            if (nodes.find(c) != nodes.end()) {
                child = nodes[c];
            } else {
                child = new TreeNode(c);
                nodes[c] = child;
            }

            if (type == 1) {
                parent->left = child;
            } else {
                parent->right = child;
            }
            childs.insert(c);
        }

        TreeNode* root = NULL;

        for (auto& pair : nodes) {
            if (childs.find(pair.first) == childs.end()) {
                root = pair.second;
            }
        }

        return root;
    }
};