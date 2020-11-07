package homework0;

/**
 * A container that can be used to contain Balls. A given Ball may only
 * appear in a BallContainer once. Each container has a size, and can only contain balls up to the size of the container.
 */
public class BallContainer {

    /**
     * @effects Creates a new BallContainer with the size of containerSize.
     */
    public BallContainer(double containerSize) {
		//TODO: Add your code here
		
    }


    /**
     * @modifies this
     * @effects Adds ball to the container.
     * @return true if ball was successfully added to the container,
     * 		   i.e. ball is not already in the container and if adding ball does not cause 
	 *		   the total volume of the balls in the container to exceed the size of	the container;
	 * 		   false otherwise.
     */
    public boolean add(Ball ball) {
		// TODO: Add your code here
		
    }


    /**
     * @modifies this
     * @effects Removes ball from the container.
     * @return true if ball was successfully removed from the container,
     * 		   i.e. ball is actually in the container; false otherwise.
     */
    public boolean remove(Ball ball) {
		// TODO: Add your code here
		
    }


    /**
     * @return the volume of the contents of the container, i.e. the
     * 		   total volume of all Balls in the container.
     */
    public double getVolume() {
		// TODO: Add your code here
		
    }
	
	/**
     * @return the size of the container.
     */
    public double getContainerSize() {
		// TODO: Add your code here
		
    }


    /**
     * @return the number of Balls in the container.
     */
    public int size() {
		// TODO: Add your code here
		
    }


    /**
     * @modifies this
     * @effects Empties the container, i.e., removes all its contents.
     */
    public void clear() {
		// TODO: Add your code here
		
    }


    /**
     * @return true if this container contains ball; false, otherwise.
     */
    public boolean contains(Ball ball) {
		// TODO: Add your code here
	
    }

}
