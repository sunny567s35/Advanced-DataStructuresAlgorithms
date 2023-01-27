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
#include<queue>
#include<stack>
using namespace std;
class Solution {
public:
    
    bool isMirror(TreeNode* node1, TreeNode* node2){
        if(node1==NULL&&node2==NULL)return true;
        if(node1==NULL||node2==NULL)return false;
        if(node1->val!=node2->val)return false;
        return isMirror(node1->left,node2->right) && isMirror(node1->right,node2->left);
    }
    bool isSymmetric(TreeNode* root) {
        return root==NULL|| isMirror(root->left,root->right);
        
        }
    
};