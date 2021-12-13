/*
David Centeno
CS5004 OOD
Final Project

WebListImpl class establishes a linked list with the use of EmptyNode, Node, and IWebList(interface).
 */
public class WebListImpl {

    private IWebList webList;

    /**
     * WebListImpl starts a linked list data structure starting with an EmptyNode
     */
    public WebListImpl(){
        webList = new EmptyNode();
    }

    /**
     * addData method that will add data to an existing webList object
     * @param data is a parameter that expects a string value to add to the
     */
    public void addData(String data) {webList = new Node(data, webList);}

    /**
     * getData is a method that will return the data stored an indexed position.
     * The info here is typically a row of information
     * @param index is a parameter that  expects an int value
     * @return will return the string value stored at the indexed position
     */
    public String getData(int index){
        return webList.getRow(index);
    }

    /**
     * count method will return the amount of nodes within the list
     * @return returns the amount of nodes within the linked list
     */
    public int count(){return webList.count();}

    /**
     * Override method for toString
     * @return returns the string value of the linked list
     */
    @Override
    public String toString(){return webList.toString();};

}
