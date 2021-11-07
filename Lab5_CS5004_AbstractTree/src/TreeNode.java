/*
Basic tree node interface. I've left this body populated, but I've removed all comments. 
The only thing you'll have to do is add comments and imports. 
*/
 import java.util.function.*;
 import java.util.List;

 public interface TreeNode<T> {
	 //Add's a child node to a parent node
	TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T> child);

	// sends nodes to list?
	List<T> toList();

	//map function that will transform type
	<R> TreeNode<R> map(Function<T,R> transform);

	T reduce(T initialValue, BiFunction<T,T,T> combiner);

	public void print();
	}
 
 