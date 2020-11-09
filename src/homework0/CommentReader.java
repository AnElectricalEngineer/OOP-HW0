package homework0;

import java.io.*; //make more concrete later
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.stringTokenizer;

public class CommentReader
{
    private static final String lineComment = "//";
    private static final String multiLineCommentStart = "/*";
    private static final String multiLineCommentEnd = "*/";
    private static final int notExists = -1;
    private static final int lengthOfCommentDelimiter = 2;

    public static void main(String[] args) throws IOException //check this
    // throws
    {
        if (args.length != 1)    //if wrong number of parameters
        {
            System.out.println("Wrong number of parameters!");  //add this later
            // with exception maybe
        }
        else
        {
            Path path = Paths.get(args[0]);
            if (Files.notExists(path))   //if filename doesn't exist
            {
                System.out.println("Doesn't exist!");
            }
            System.out.println("Exists!");  //filename exists

            BufferedReader in = new BufferedReader(new FileReader(args[0]));

            //check if null is right for EOF
            String currentLine;
            int indexOfLineComment, indexOfMultiLineCommentStart,
                    indexOfMultiLineCommentEnd;

            while ((currentLine = in.readLine()) != null)
            {
                indexOfLineComment = currentLine.indexOf(lineComment);
                indexOfMultiLineCommentStart =
                        currentLine.indexOf(multiLineCommentStart);

                //If there is a line comment and no multi-line comment beginning
                if (((indexOfLineComment > notExists) &&
                        (indexOfMultiLineCommentStart == notExists)))
                {
                    System.out.println(currentLine.substring(
                            indexOfLineComment + lengthOfCommentDelimiter));
                }

                //If there is a multi-line comment beginning and no line comment
                else if ((indexOfMultiLineCommentStart > notExists) &&
                        (indexOfLineComment == notExists))
                {
                    indexOfMultiLineCommentEnd =
                            currentLine.indexOf(multiLineCommentEnd);

                    //If multi-line comment ends on same line that it begins
                    if(indexOfMultiLineCommentEnd > notExists)
                    {
                        System.out.println(currentLine.substring(
                                indexOfMultiLineCommentStart
                                        + lengthOfCommentDelimiter,
                                indexOfMultiLineCommentEnd));
                    }
                    else
                    {
                        //Print first line of multi-line comment
                        System.out.println(currentLine.substring(
                                indexOfMultiLineCommentStart
                                        + lengthOfCommentDelimiter));

                        while ((currentLine = in.readLine()) != null)
                        {
                            indexOfMultiLineCommentEnd =
                                    currentLine.indexOf(multiLineCommentEnd);

                            //print last line of multi-line comment
                            if (indexOfMultiLineCommentEnd > -1)
                            {
                                System.out.println(currentLine.substring(0,
                                        indexOfMultiLineCommentEnd));
                            }

                            //Print full comment lines
                            else
                            {
                                System.out.println(currentLine);
                            }
                        }
                    }
                }
                //System.out.println(currentLine); //remove
            }
        }
    }
}