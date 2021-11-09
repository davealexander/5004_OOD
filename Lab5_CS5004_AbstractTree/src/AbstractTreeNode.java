/*
AbstractTreeNode takes it's orders from TreeNode and sets up the basic, very simple, structure of a tree node. 
You'll have to fix the class declaration and complete this file. 
*/

//Abstract clas that creates a node with data
public abstract class AbstractTreeNode<T> implements TreeNode<T>{
    //Promises to instantiate a generic type and assign to a data variable;
    protected T data;
    // Constructor for AbstractTreeNode
    public AbstractTreeNode(T data){
        this.data = data;
    }
}