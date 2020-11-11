package homework0;

import java.util.ArrayList;
import java.util.List;

/**
 * A container that can be used to contain Balls. A given Ball may only
 * appear in a BallContainer once. Each container has a size, and can only
 * contain balls up to the size of the container.
 */

//BallContainer for Part A
public class BallContainer2 {

    private static final int EMPTY = 0;

    private final double containerSize; //volume of container itself
    private int size;	//the number of Balls in the container
    private List<Ball>  ballList;
    /**
     * @requires containerSize > 0
     * @effects Creates a new BallContainer with the size of containerSize.
     */
    public BallContainer2(double containerSize) {
        this.containerSize = containerSize;
        this.size = EMPTY;
        ballList = new ArrayList<>(); //default size is 10
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
        if((ball == null) || (ballList.contains(ball)))
        {
            return false;
        }

        double volume = 0;
        for(Ball i : ballList)
        {
            volume += i.getVolume();
        }

        if(ball.getVolume() + volume <= containerSize)
        {
            ballList.add(ball);
            size += 1;
            return true;
        }
        return false;
    }


    /**
     * @modifies this
     * @effects Removes ball from the container.
     * @return true if ball was successfully removed from the container,
     * 		   i.e. ball is actually in the container; false otherwise.
     */
    public boolean remove(Ball ball) {
        // remove(Object o) returns true if the object exists in the list
        if(ball == null)
        {
            return false;
        }
        boolean removed = ballList.remove(ball);
        if(removed)
        {
            size -= 1;
        }
        return removed;
    }


    /**
     * @return the volume of the contents of the container, i.e. the
     * 		   total volume of all Balls in the container.
     */
    public double getVolume() {
        double volume = 0;
        for(Ball i : ballList)
        {
            volume += i.getVolume();
        }
        return volume;
    }

    /**
     * @return the size of the container.
     */
    public double getContainerSize() {
        return containerSize;
    }


    /**
     * @return the number of Balls in the container.
     */
    public int size() {
        return size;
    }


    /**
     * @modifies this
     * @effects Empties the container, i.e., removes all its contents.
     */
    public void clear() {
        ballList.clear();
        size = EMPTY;
    }


    /**
     * @return true if this container contains ball; false, otherwise.
     */
    public boolean contains(Ball ball) {
        return ballList.contains(ball);
    }

}
