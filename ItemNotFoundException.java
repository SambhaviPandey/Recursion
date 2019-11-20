/**
 * This class is utilized when an 
 * ItemNotFoundException is needed to be 
 * thrown, which is when the target item 
 * is not found through a search. 
 *
 * @author (Sambhavi Pandey)
 * @version (Last modified May 11,2018)
 */
public class ItemNotFoundException extends Exception
{
    /**
     * No-argument constructor that calls  
     * super (which is the Exception class).
     */
    public ItemNotFoundException()
    {
        super ("Item not found");
    }
    
    /**
     * This constructor accepts a String argument 
     * that pertains to a message. This class also 
     * calls super (which is the Exception class).
     */
    public ItemNotFoundException(String message)
    {
        super(message);
    }
}