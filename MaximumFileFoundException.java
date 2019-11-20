/**
 * This class is utilized when a 
 * MaximumFileFoundException is needed to be 
 * thrown, which is when the maximum number
 * of files are found. 
 *
 * @author (Sambhavi Pandey)
 * @version (Last modified May 11,2018)
 */
public class MaximumFileFoundException extends Exception
{
    /**
     * No-argument constructor that calls the 
     * super (which is the Exception class).
     */
    public MaximumFileFoundException()
    {
        super ("Maximum Number of Files Found");
    }
    
    /**
     * This constructor accepts a String argument 
     * that pertains to a message. This class also 
     * calls super (which is the Exception class).
     */
    public MaximumFileFoundException(String message)
    {
        super(message);
    }
}