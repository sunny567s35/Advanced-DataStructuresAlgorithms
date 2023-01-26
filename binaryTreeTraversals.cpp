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

//level order
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
//reverse levelorder
void reverseLevelOrder(node* root){
    stack<node*> s;
    queue<node*> q;
    q.push(root);
    while(!q.empty()){
        node* temp = q.front();
        s.push(temp);
        q.pop();
        if(temp->right){
            q.push(temp->right);
        }
        if(temp->left){
            q.push(temp->left);
        }

    }
    while(s.empty() == false){
        root = s.top();
        cout<<root->data<<" ";
        s.pop();
    }
}
void inorder(node* root){
    

    if(root == NULL){
        return ;
    }
    inorder(root->left);
    cout<<root->data<< " ";
    inorder(root->right);

}

//preorder traversal 
void preorder(node* root){
    if(root== NULL){
        return ;
    }
    cout<< root->data<<" ";
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
    cout<<root->data<<" ";

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
    cout<<endl;

    cout<<"This is preorder traversal : ";
    preorder(root);
    cout<<endl;
    cout<<"This is postorder traversal : ";
    postorder(root);
    cout<<endl;
    cout<<"This is Reverse Level Order traversal : ";
    reverseLevelOrder(root);
    cout<<endl;
    return 0;

}