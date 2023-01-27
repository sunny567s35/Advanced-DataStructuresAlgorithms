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
 #include<stack>
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> list;
        stack<TreeNode*> s;
        
        
        while(!s.empty()|| root){
            while(root){
                s.push(root);
                root = root->left;
            }
            root = s.top();
            s.pop();
            list.push_back(root->val);
            root = root->right;
        }
        return list;
    }
};