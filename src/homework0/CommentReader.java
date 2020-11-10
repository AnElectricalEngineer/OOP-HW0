package homework0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; //maybe unnecessary - check main - throws
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CommentReader
{
    private enum commentStartType{ NONE, SINGLE_LINE, MULTI_LINE}
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

            String currentLine;
            int indexOfLineComment, indexOfMultiLineCommentStart,
                    indexOfMultiLineCommentEnd;

            while ((currentLine = in.readLine()) != null)
            {
                if(lineType(currentLine) == commentStartType.SINGLE_LINE)
                {
                    indexOfLineComment = currentLine.indexOf(lineComment);
                    System.out.println(currentLine.substring(
                            indexOfLineComment + lengthOfCommentDelimiter));
                    continue;
                }
                if(lineType(currentLine) == commentStartType.MULTI_LINE)
                {
                    indexOfMultiLineCommentStart =
                            currentLine.indexOf(multiLineCommentStart);
                    indexOfMultiLineCommentEnd =
                            currentLine.indexOf(multiLineCommentEnd);

                    if((indexOfMultiLineCommentEnd > notExists) &&
                            (indexOfMultiLineCommentStart <
                                    indexOfMultiLineCommentEnd))
                    {
                        System.out.println(currentLine.substring(
                                indexOfMultiLineCommentStart +
                                        lengthOfCommentDelimiter,
                                indexOfMultiLineCommentEnd));
                    }
                    else
                    {
                        System.out.println(currentLine.substring(
                                indexOfMultiLineCommentStart +
                                        lengthOfCommentDelimiter));

                        while(((currentLine = in.readLine()) != null) &&
                                (!currentLine.contains(multiLineCommentEnd)))
                        {
                            System.out.println(currentLine);
                        }
                        System.out.println(currentLine.substring(0,
                                currentLine.indexOf(multiLineCommentEnd)));
                    }
                }
            }
        }
    }

    //checks a line to see if it begins with a // or /*
    //Returns NONE, SINGLE_LINE, MULTI_LINE.
    private static commentStartType lineType(String line)
    {
        int indexOfLineComment = line.indexOf(lineComment);
        int indexOfMultiLineCommentStart =
                line.indexOf(multiLineCommentStart);
        if(indexOfLineComment == notExists) //not a single line comment
        {
            if(indexOfMultiLineCommentStart == notExists) //not a comment at all
            {
                return commentStartType.NONE;
            }
            else    //beginning of multi-line comment
            {
                return commentStartType.MULTI_LINE;
            }
        }
        else    //line contains "//"
        {
            //not a multi-line comment
            if(indexOfMultiLineCommentStart == notExists)
            {
                return commentStartType.SINGLE_LINE;
            }
            else//line can be either single-line or multi-line comment,
            //depending on what comes first: "//" or "/*"
            {
                return (indexOfLineComment < indexOfMultiLineCommentStart) ?
                        commentStartType.SINGLE_LINE :
                        commentStartType.MULTI_LINE;
            }
        }
    }
}