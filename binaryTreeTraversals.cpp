#include<iostream>
#include<stack>
#include<queue>
using namespace std;

//class node 
class node{
    public:

        int data;
        node* left;
        node* right;

        node(int d){
            this-> data = d;
            this-> left = NULL;
            this-> right = NULL;

        }
};

//build tree
node* buildTree(node* root){
        cout<<"enter the data : "<<endl;
        int data;
        cin >>data;
        
        root = new node(data);
    if(data == -1){
        return NULL;
    }

    cout<<"enter the value for inserting in left node of : "<< data << endl;
    root->left = buildTree(root->left);
    cout<<"enter the value for inserting in right node of : "<< data << endl;
    root->right = buildTree(root->right);
    return root;

}

void levelOrder(node* root){
    queue<node*> q ;
    q.push(root);
    q.push(NULL);

    while ( !q.empty()){
        node* temp =  q.front();
        q.pop(); 
        if(temp==NULL){
            cout<<endl;
            if(!q.empty()){
                q.push(NULL);

            }
        }
        else{
            cout<< temp->data<<" ";
            if(temp->left){
                q.push(temp->left);
            }
            if(temp->right){
                q.push(temp->right);
            }
        }
    }
    

}
void inorder(node* root){
    

    if(root == NULL){
        return ;
    }
    inorder(root->left);
    cout<<root->data<< " "<<endl;
    inorder(root->right);

}

//preorder traversal 
void preorder(node* root){
    if(root== NULL){
        return ;
    }
    cout<< root->data<<" "<<endl;
    preorder(root->left);
    preorder(root->right);
}
//postorder traversal
void postorder(node* root){
    if(root == NULL){
        return ;
    }
    postorder(root->left);
    postorder(root->right);
    cout<<root->data<<" "<<endl;
    
}

//main
int main(){
    node* root = NULL;

    root = buildTree(root);
    //1 3 7 -1 -1 11 15 -1 -1 17 -1 -1 5 13 -1 -1 14 -1 -1  
    cout<<"This is Level order traversal : ";
    levelOrder(root);
    
    cout<<"This is Inorder traversal : ";
    inorder(root);
    return 0;

}