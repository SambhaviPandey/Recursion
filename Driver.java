/**
 * The driver class is utilized to test the 
 * FindFile class. This test is done in 
 * order to determine that the class is working 
 * properly in searching for a target file. 
 *
 * @author (Sambhavi Pandey)
 * @version (Last modified May 11,2018)
 */
public class Driver 
{
    /**
     * main method tests the FindFile
     * class in order to ensure that it is
     * working properly. 
     * 
     * @param args
     */
    public static void main(String [] args) 
    {
        //The maximum number of files to find
        final int MAX_NUMBER_OF_FILES_TO_FIND = 10;
        
        //Specifying the target file to search for 
        String targetFile = "longwords.txt";
        //Specifying the path to search the file from
        String pathToSearch = "C:\\WCWC";
        //Creating an object of the FindFile class
        FindFile find = new FindFile(MAX_NUMBER_OF_FILES_TO_FIND);
        
        //Try-catch block to handle any exceptions that may occur
        try 
        {
            //Searching for the file 
            find.directorySearch(targetFile, pathToSearch);
        }
        //If the path passed in is not a valid directory
        catch (IllegalArgumentException e) 
        {
            System.out.println("Not a valid directory");
        }
        //If the maximum number of files are found 
        catch (MaximumFileFoundException e) 
        {
            System.out.println(find.toString());
        }
        //For any other exceptions that may result 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
}