package homework0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; //maybe unnecessary - check main - throws
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CommentReader
{
    private enum commentStartType
    {NONE, SINGLE_LINE, MULTI_LINE}

    private static final String LINE_COMMENT = "//";
    private static final String MULTI_LINE_COMMENT_START = "/*";
    private static final String MULTI_LINE_COMMENT_END = "*/";
    private static final int NOT_EXISTS = -1;
    private static final int LENGTH_OF_COMMENT_DELIMITER = 2;

    public static void main(String[] args) throws IOException //check this
    // throws
    {
        if (args.length != 1)    //checks number of input args
        {
            System.out.println("Wrong number of parameters!");  //add this later
            // with exception maybe
        }
        else
        {
            Path path = Paths.get(args[0]);
            if (Files.notExists(path))   //check if filename exists
            {
                System.out.println("Doesn't exist!");
                return;
            }
            System.out.println("Exists!");

            BufferedReader in = new BufferedReader(new FileReader(args[0]));

            String currentLine;
            int indexOfLineComment, indexOfMultiLineCommentStart,
                    indexOfMultiLineCommentEnd;

            while ((currentLine = in.readLine()) != null)
            {
                /*  Checks type of line: single line comment, multi-line comment
                    beginning, or neither.
                */

                if (lineType(currentLine) == commentStartType.SINGLE_LINE)
                {
                    indexOfLineComment = currentLine.indexOf(LINE_COMMENT);
                    System.out.println(currentLine.substring(
                            indexOfLineComment + LENGTH_OF_COMMENT_DELIMITER));
                    continue;
                }

                if (lineType(currentLine) == commentStartType.MULTI_LINE)
                {
                    indexOfMultiLineCommentStart =
                            currentLine.indexOf(MULTI_LINE_COMMENT_START);
                    indexOfMultiLineCommentEnd =
                            currentLine.indexOf(MULTI_LINE_COMMENT_END);

                    //check if multi-line comment begins and ends on same line
                    if ((indexOfMultiLineCommentEnd > NOT_EXISTS) &&
                            (indexOfMultiLineCommentStart <
                                    indexOfMultiLineCommentEnd))
                    {
                        System.out.println(currentLine.substring(
                                indexOfMultiLineCommentStart +
                                        LENGTH_OF_COMMENT_DELIMITER,
                                indexOfMultiLineCommentEnd));
                    }

                    else
                    {
                        System.out.println(currentLine.substring(
                                indexOfMultiLineCommentStart +
                                        LENGTH_OF_COMMENT_DELIMITER));

                        while (((currentLine = in.readLine()) != null) &&
                                (!currentLine.contains(MULTI_LINE_COMMENT_END)))
                        {
                            System.out.println(currentLine);
                        }
                        System.out.println(currentLine.substring(0,
                                currentLine.indexOf(MULTI_LINE_COMMENT_END)));
                    }
                }
            }
        }
    }

    //checks a line to see if it begins with a // or /*
    //Returns NONE, SINGLE_LINE, MULTI_LINE.
    private static commentStartType lineType(String line)
    {
        int indexOfLineComment = line.indexOf(LINE_COMMENT);
        int indexOfMultiLineCommentStart =
                line.indexOf(MULTI_LINE_COMMENT_START);
        if (indexOfLineComment == NOT_EXISTS) //not a single line comment
        {
            if (indexOfMultiLineCommentStart == NOT_EXISTS) //not a comment at all
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
            if (indexOfMultiLineCommentStart == NOT_EXISTS)
            {
                return commentStartType.SINGLE_LINE;
            }
            else    //line can be either single-line or multi-line comment,
            //depending on what comes first: "//" or "/*"
            {
                return (indexOfLineComment < indexOfMultiLineCommentStart) ?
                        commentStartType.SINGLE_LINE :
                        commentStartType.MULTI_LINE;
            }
        }
    }
}