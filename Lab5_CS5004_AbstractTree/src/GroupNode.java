/*
GroupNode is a generic class and child of AbstractTreeNode. 
This node basically take the place of a supervisor. 
It allows for a single data element along with an array list of other elements.

You'll have to include the needed imports, fix the class declaration, and then populate the body with the needed methods.
*/

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
    public Object reduce(Object initialValue, BiFunction combiner) {
        return null;
    }

    @Override
    public void print() {

    }

    @Override
    public TreeNode map(Function transform) {
        return null;
    }

}