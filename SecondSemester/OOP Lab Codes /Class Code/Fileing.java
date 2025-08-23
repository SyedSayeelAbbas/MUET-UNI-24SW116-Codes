package SirNaveenTask;
import java.io.FileReader;

class CustomException extends Exception
{
    public CustomException(String message)
    {
        super(message);
    }
}

public class Fileing {
//        static void readFile(String filename) throws Exception{
//        FileReader fr =new FileReader(filename);
//        //if we not handle here handle where we call this function
//    }
static void readFile(String filename) throws CustomException{
    if(filename.equals("hello"))
    {
        System.out.println("Error");
    }
    else{
        throw new CustomException("NO Error Found");
    }
}

    public static void main(String[] args) {
        try
        {
            readFile("hello");
        } catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
