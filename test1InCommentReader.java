public class Test1inCommentReader
{   
    public static void main(String[] args)
    {
        /*Comment 1*/ int a = 1;
        //Comment 2
        /* Comment 3 */ String test = "test";
        // /* Comment 4
        /* //Comment  5//*/

        /* comment
        6
        */

        //  comment 7//
        //comment8/*
        //comment9*/
        //comment 10 ////////*

        /*Comment 11 test 1
        comment 11 test 2
        comment 11 test 3
        */

        int x; /*comment 12*/

        int z; /* comment 13 test 1
        comment 13 test 2
        comment 13 test 3*/

        int y; // comment 14
    }
}