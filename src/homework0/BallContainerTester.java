package homework0;

public class BallContainerTester
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

        System.out.println("The volume of medium ball is: " +
                mediumBall1.getVolume());

        System.out.println("The volume of large ball ball is: " +
                largeBall1.getVolume());

        System.out.println("The volume of giant ball ball is: " +
                giantBall1.getVolume());

        BallContainer ballContainer = new BallContainer(30.4);
        System.out.println(ballContainer.getContainerSize());
        System.out.println(ballContainer.getVolume());
        System.out.println(ballContainer.size());

        System.out.println(ballContainer.add(smallBall1));
        System.out.println(ballContainer.add(largeBall1));
        System.out.println(ballContainer.add(smallBall1));
        System.out.println(ballContainer.add(mediumBall1));

        System.out.println(ballContainer.getContainerSize());
        System.out.println(ballContainer.getVolume());
        System.out.println(ballContainer.size());

        System.out.println(ballContainer.contains(smallBall1));
        System.out.println(ballContainer.contains(largeBall1));

        System.out.println(ballContainer.remove(mediumBall1));

        System.out.println(ballContainer.getContainerSize());
        System.out.println(ballContainer.getVolume());
        System.out.println(ballContainer.size());

        ballContainer.clear();
        System.out.println(ballContainer.contains(smallBall1));

        System.out.println(ballContainer.getContainerSize());
        System.out.println(ballContainer.getVolume());
        System.out.println(ballContainer.size());

        System.out.println("-----------------------------------");
        BallContainer ballContainer2 = new BallContainer(100);
        System.out.println(ballContainer2.add(smallBall1));
        System.out.println(ballContainer2.add(mediumBall1));
        System.out.println(ballContainer2.contains(smallBall1));

        System.out.println(ballContainer2.getContainerSize());
        System.out.println(ballContainer2.getVolume());
        System.out.println(ballContainer2.size());

        System.out.println(ballContainer2.remove(smallBall1));
        System.out.println(ballContainer2.contains(smallBall1));

        System.out.println(ballContainer2.getContainerSize());
        System.out.println(ballContainer2.getVolume());
        System.out.println(ballContainer2.size());

        System.out.println(ballContainer2.remove(smallBall1));

        System.out.println(ballContainer2.getContainerSize());
        System.out.println(ballContainer2.getVolume());
        System.out.println(ballContainer2.size());

        System.out.println(ballContainer2.remove(mediumBall1));

        System.out.println(ballContainer2.getContainerSize());
        System.out.println(ballContainer2.getVolume());
        System.out.println(ballContainer2.size());
    }
}
