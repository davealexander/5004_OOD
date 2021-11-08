/*
LeafNode is a generic class and child of AbstractTreeNode. 
This node allows for a single data element. 

You'll have to include the needed imports, fix the class declaration, and then populate the body with the needed methods.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class LeafNode<T> extends AbstractTreeNode<T>{

    public LeafNode(T data) {
        super(data);
    }

    @Override
    public TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T> child) {
        if (identifier.test(data)) {
            GroupNode<T> newNode = new GroupNode<T>(this.data);
            newNode.addChild(identifier,child);
            return newNode;
        }
        return this;
    }

    //Converts a tree to a list
    @Override
    public List<T> toList() {
        //creates a variable called result that creates an ArrayList with a generic
        List<T> result = new ArrayList<T>();
        //Adds the tree into an ArrayList
        result.add(this.data);
        //Returns the result as an ArrayList
        return result;
    }

    @Override
    public <R> TreeNode<R> map(Function<T, R> transform) {
        //returns the LeafNode as a new type
        return new LeafNode<R>(transform.apply(this.data));
    }

    @Override
    //creates a generic reduce function
    public T reduce(T initialValue, BiFunction<T, T, T> combiner) {
        //applies the combiner to the data in the leaf node.
        return combiner.apply(initialValue,this.data);
    }

    @Override
    public void print() {
    }

    public String toString(){
        return this.data.toString() + "\n";
    }
}
