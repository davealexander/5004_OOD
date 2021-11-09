/*
GroupNode is a generic class and child of AbstractTreeNode. 
This node basically take the place of a supervisor. 
It allows for a single data element along with an array list of other elements.

You'll have to include the needed imports, fix the class declaration, and then populate the body with the needed methods.
*/

import com.sun.source.tree.Tree;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class GroupNode<T> extends AbstractTreeNode<T>{
    //Initializes memory space for children
    protected List<TreeNode<T>> children;

    //Constructor
    public GroupNode(T data){
        super(data);
        this.children = new ArrayList<TreeNode<T>>();
    }

    //adds a child node depending if the predicate is met
    @Override
    public TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T> child) {
        if(identifier.test(this.data)){
                this.children.add(child);
                return this;
        }
        for(int i = 0; i<this.children.size(); i++){
            this.children.set(i, this.children.get(i).addChild(identifier,child));
        }
        return this;
    }

    @Override
    public List toList() {
        //Instantiates result as a new ArrayList
        List<T> result = new ArrayList<T>();
        //adds the tree to the ArrayList
        result.add(this.data);
        //adds nodes to the arraylist
        for(TreeNode<T> child : children){
            result.addAll(child.toList());
        }
        //returns the tree as an arraylist
        return result;
    }

    @Override
    public T reduce(T initialValue, BiFunction<T, T, T> combiner)  {
        //result is a generic variable that will equate to the data of the group node
        T result = this.data;
        //reduces the values that are in result
        for(TreeNode<T> child : children){
            result = child.reduce(result,combiner);
        }
        //returns the intialvalue and result.
        return combiner.apply(initialValue,result);
    }

    @Override
    public void print() {

    }

    @Override
    public <R> TreeNode<R> map(Function<T, R> transform) {
        //Creates a new variable that is of a Generic GroupNode and transforms it to the transform parameter.
        GroupNode<R> newNode = new GroupNode<R>(transform.apply(this.data));
        //For loop that iterates through the tree node and its children and copies them to a new type.
        for(TreeNode<T> child : children){
            newNode.children.add(child.map(transform));
        }
        //Returns the new group node.
        return newNode;

    }
    public String toString(){
        return children.toString();
    }

}