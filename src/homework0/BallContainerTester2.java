package homework0;

/**
 * A test class that can be used to test BallContainer2. The value printed by
 * each print statement should match the value printed in the following line.
 */

public class BallContainerTester2
{
    public static void main(String[] args)
    {
        Ball smallBall1 = new Ball(10);
        Ball mediumBall1 = new Ball(20.3);
        mediumBall1.setVolume(20.1);
        Ball largeBall1 = new Ball(50.75);
        Ball giantBall1 = new Ball(75);

        System.out.println("The volume of small ball is: " +
                smallBall1.getVolume());
        System.out.println("The volume of small ball should be: 10");

        System.out.println("The volume of medium ball is: " +
                mediumBall1.getVolume());
        System.out.println("The volume of medium ball should be: 20.1");

        System.out.println("The volume of large ball is: " +
                largeBall1.getVolume());
        System.out.println("The volume of large ball should be: 50.75");

        System.out.println("The volume of giant ball is: " +
                giantBall1.getVolume());
        System.out.println("The volume of giant ball should be: 75");

        BallContainer2 ballContainer2 = new BallContainer2(30.4);

        System.out.println(ballContainer2.getContainerSize());
        System.out.println("Should be: 30.4");

        System.out.println(ballContainer2.getVolume());
        System.out.println("Should be: 0");

        System.out.println(ballContainer2.size());
        System.out.println("Should be: 0");

        System.out.println(ballContainer2.add(smallBall1));
        System.out.println("Should be: true");

        System.out.println(ballContainer2.add(largeBall1));
        System.out.println("Should be: false");

        System.out.println(ballContainer2.add(smallBall1));
        System.out.println("Should be: false");

        System.out.println(ballContainer2.add(mediumBall1));
        System.out.println("Should be: true");

        System.out.println(ballContainer2.getContainerSize());
        System.out.println("Should be: 30.4");

        System.out.println(ballContainer2.getVolume());
        System.out.println("Should be: 30.1");

        System.out.println(ballContainer2.size());
        System.out.println("Should be: 2");

        System.out.println(ballContainer2.contains(smallBall1));
        System.out.println("Should be: true");

        System.out.println(ballContainer2.contains(largeBall1));
        System.out.println("Should be: false");

        System.out.println(ballContainer2.remove(mediumBall1));
        System.out.println("Should be: true");

        System.out.println(ballContainer2.getContainerSize());
        System.out.println("Should be: 30.4");

        System.out.println(ballContainer2.getVolume());
        System.out.println("Should be: 10");

        System.out.println(ballContainer2.size());
        System.out.println("Should be: 1");

        ballContainer2.clear();
        System.out.println(ballContainer2.contains(smallBall1));
        System.out.println("Should be: false");

        System.out.println(ballContainer2.getContainerSize());
        System.out.println("Should be: 30.4");

        System.out.println(ballContainer2.getVolume());
        System.out.println("Should be: 0");

        System.out.println(ballContainer2.size());
        System.out.println("Should be: 0");
    }
}
