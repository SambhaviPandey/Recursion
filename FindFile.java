import java.io.File;
/**
 * class FindFile consists of a 
 * class that searches a directory
 * (and subdirectories) for a 
 * target file. 
 * 
 * @author (Sambhavi Pandey)
 * @version (Last modified May 11,2018)
 */
public class FindFile 
{
    //Declaring instance variables 
    //Tracks files found 
    private String [] files; 
    //Tracks maximum number of files 
    private int maximum;
    //Keeps count of the files 
    private int counter; 

    /**
     * FindFile constructor takes an argument of type 
     * int corresponding to the maximum number of 
     * files found. The purpose of this constructor 
     * is to initialize the instance variables. 
     * 
     * @param maxFiles 
     */
    public FindFile(int maxFiles) 
    {
        //Initializing instance variables 
        maximum = maxFiles;
        counter = 0; 
        files = new String[maxFiles];
    }

    /**
     * directorySearch takes two String arguments corresponding to 
     * the name of the target file and the name of the directory. 
     * This method throws a MaximumFileFoundException when the
     * maximum number of files is found. The purpose of this 
     * method is to utilize recursion to search for the 
     * target file. 
     * 
     * @param name 
     * @param dirName
     */
    public void directorySearch(String name, String dirName) 
                                throws MaximumFileFoundException
    {
        //String is type casted to file object
        File f = new File(dirName);
        //If the file is not in the directory 
        if (f.exists() == false) 
        {
            throw new IllegalArgumentException();
        }
        //Stores files in directory 
        File[] directoryFiles = new File(dirName).listFiles();

        //Goes through the directory files 
        for (File fl : directoryFiles) 
        {
            //If the target file is equal to the directory file
            if (fl.getName().equals(name)) 
            {
                //Determines absolute path of the file 
                files[counter] = f.getAbsolutePath();
                //Increases count 
                counter++;
            }
            //If the maximum number of files are found 
            else if (this.counter == this.maximum) 
            {
                throw new MaximumFileFoundException();
            }
            //The location of the file 
            else if (fl.isDirectory() == true) 
            {
                directorySearch(name,fl.getAbsolutePath());
            }
        }
    }
    
    /**
     * getFiles method returns the array of 
     * file locations.  
     */
    public String[] getFiles() 
    {
        return files;
    }
    
    /**
     *  getMaximum method returns an int value 
     *  corresponding to the maximum number of 
     *  files. 
     */
    public int getMaximum() 
    {
        return this.maximum;
    }
    
    /**
     * getCounter method returns a value 
     * of type int that corresponds to the number of 
     * matching files found. 
     */
    public int getCounter() 
    {
        return counter;
    }

    /**
     *  toString method returns a value of type 
     *  String corresponding to if the file was 
     *  found or not. 
     */
    public String toString() 
    {
        String check = " ";
        //If the number of matching files found is not 0
        if (getCounter() != 0) 
        {
            //Determines the files 
            for (int i = 0; i < getFiles().length; i++) 
            {
                check = "\n " + getFiles()[i];
            }
        }
        //otherwise, the file is not found 
        else 
        {
            check = "File not found";
        }  
        return check;
    }
}