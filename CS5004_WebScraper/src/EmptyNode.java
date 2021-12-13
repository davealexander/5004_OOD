
/*
David Centeno
CS5004 OOD
Final Project

Empty node class which is used for the building of a linked list. It implements IWeblist to promise mandatory
methods are handled.
 */

public class EmptyNode implements  IWebList{

    /**
     * count overrides its interface method and returns 0
     * @return returns 0
     */
    @Override
    public int count() {
        return 0;
    }

    //Returns null when the node is empty

    /**
     * getRow method overrides its interface method and returns null at a given index.
     * @param index expects an integer
     * @return null
     */
    @Override
    public String getRow(int index) {
        return null;
    }

    //Override of toString method will return no text back to the user to help further define the node has no data.

    /**
     * toString overrides interface method and returns back effectively nothing.
     * @return ""
     */
    @Override
    public String toString(){return "";}
}
