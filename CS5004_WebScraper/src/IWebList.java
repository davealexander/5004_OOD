
/*
David Centeno
CS5004 OOD
Final Project

IWebList is an interface that is passed on to Empty Node, Node, and is used in WebListImpl to create a linkedlist.
 */
public interface IWebList {
    //Counts the amount of nodes in the linked list

    /**
     * Counts the amount of nodes in the linked list
     * @return the amount of nodes in the linked list
     */
    int count();

    //Implements a toString override

    /**
     * toString implements a toString override
     * @return string
     */
    String toString();

    /**
     * getRow that will grab the current node and provide that data in that current row of extracted information.
     * @param index expects integer
     * @return returns the data stored at the designated index.
     */
    String getRow(int index);
}
