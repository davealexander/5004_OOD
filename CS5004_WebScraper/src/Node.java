/*
David Centeno
CS5004 OOD
Final Project

Node is a class that establishes a node data structure to eventually create a linked list
It implements IWeblist to make sure mandatory methods are incorporated in the next Node object.
 */

public class Node implements IWebList {
    //Sets the data part of a linked list
    String data;
    //Sets the nextNode to expect the interface of IWebList
    IWebList nextNode;

    //constructor for adding a node

    /**
     * Constructor for adding a node for a linked list
     * @param d expects a string type to set data
     * @param next expects the interface of IWebList as the nextNode.
     */
    public Node(String d, IWebList next){
        data = d;
        this.nextNode = next;
    }

    /**
     * count is a recursive method that counts the nodes in the linked list.
     * @return returns the amount of nodes in a linked list
     */
    @Override
    public int count() {
        return 1 + nextNode.count();
    }

    /**
     * getRow is a recursive method that gets the row added to the linked list.
     * @param index expects integer value
     * @return returns the data at the specified index
     */
    @Override
    public String getRow(int index) {
        if(index == 0){
            return data;
        }
        else{
            return nextNode.getRow(index - 1 );
        }
    }

    /**
     * toString method that instead of returning the memory space the data that is stored in that memory is returned
     * as a string
     * @return returns a string.
     */
    @Override
    public String toString(){
        return data + nextNode.toString();
    }
}
