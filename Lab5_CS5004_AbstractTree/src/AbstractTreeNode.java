/*
AbstractTreeNode takes it's orders from TreeNode and sets up the basic, very simple, structure of a tree node. 
You'll have to fix the class declaration and complete this file. 
*/


public abstract class AbstractTreeNode<T> implements TreeNode<T>{
    protected T data;
    public AbstractTreeNode(T data){
        this.data = data;
    }
}