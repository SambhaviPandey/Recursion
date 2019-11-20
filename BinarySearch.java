/**
 * class BinarySearch is a subclass of 
 * class SearchAlgorithm. This class 
 * conducts a recursive search and an 
 * iterative search in order to search
 * through a target file for the words 
 * to find. 
 * 
 * @author (Sambhavi Pandey)
 * @version (Last modified May 11,2018)
 */
public class BinarySearch extends SearchAlgorithm
{
    /**
     * recSearch method takes an argument of the type
     * String array and an argument of type String, along 
     * with two int arguments corresponding to the 
     * starting and ending Index.This method returns an int value 
     * corresponding to the target word's index. 
     * The purpose of this method is to conduct a recursive 
     * search through the words array. 
     * 
     * @param words
     * @param wordToFind 
     * @param startIndex
     * @param endIndex
     */
    public int recSearch(String[] words, String wordToFind, 
                         int startIndex, int endIndex)
    {
        //Determines the count of comparisons
        incrementCount();
        if(endIndex <= startIndex)
        {
            //If the starting index word is equal to the word to
            //find then the startIndex is returned, otherwise -1 is returned 
            return words[startIndex].equals(wordToFind) ? startIndex : -1;
        }
        //To determine the middle index
        int mid = (endIndex-startIndex)/2 + startIndex;
        //Determines the count of comparisons
        incrementCount();
        //The target word matches the word at middle index
        if(words[mid].equals(wordToFind))
        {
            return mid;
        }
        //Determines the count of comparisons
        incrementCount();
        //If the target word is before the word at the middle index
        if(wordToFind.compareTo(words[mid]) < 0)
        {
            //Does not search the second half of array
            return recSearch(words, wordToFind, startIndex, mid-1); 
        }
        //If the target word is after the word at the middle index
        else 
        {
            //Does not search the first half of array
            return recSearch(words, wordToFind, mid+1, endIndex); 
        }		
    }
    
    /**
     * recSearch method takes an argument of the type 
     * String array and an argument of type String. 
     * This method returns an int value corresponding 
     * to the target word's index (if it is found). 
     * The purpose of the method is to call the method to 
     * recursively search for the target word. 
     * 
     * @param words 
     * @param wordToFind 
     */
    @Override
    public int recSearch(String[] words, String wordToFind) 
                         throws ItemNotFoundException 
    {
        resetCount();
        //Calls the method 
        int index = recSearch(words, wordToFind, 0, words.length-1);
        //To determine accurate count of comparisons
        incrementCount();
        //Determines if the method returns -1
        if(index == -1)
        {
            //If it returns -1 
            throw new ItemNotFoundException();
        }
        //Otherwise it returns the target words index 
        return index;
    }
    
    /** 
     * search method takes a String array argument and 
     * an argument of type String. This method returns an 
     * int value corresponding to the index of the target. 
     * The purpose of this method is to conduct an iterative
     * search though the array for the target word. This 
     * method throws an ItemNotFoundException if the 
     * target word is not found.
     * 
     * @param word
     * @param wordToFind
     */
    @Override
    public int search(String[] word, String wordToFind) 
                      throws ItemNotFoundException 
    {
        resetCount();
        //Declaring variables 
        int lowIndex = 0;
        int highIndex = word.length -1;
        int midIndex;
        //While lowIndex is less than or equal to HighIndex
        while(lowIndex <= highIndex)
        {
            //Determines the accurate count of comparisons
            incrementCount();
            //Determines the middle index 
            midIndex = (highIndex-lowIndex)/2 + lowIndex;
            //Determines the accurate count of comparisons 
            incrementCount();
            //If the word is the same as the wordToFind
            if(word[midIndex].equals(wordToFind))
            {
                return midIndex;
            }
            //Determines the count of comparisons
            incrementCount();
            //If the target word is before word at the middle index
            if(wordToFind.compareTo(word[midIndex]) < 0)
            {
                //Does not search the second half of the it
                highIndex = midIndex-1; 
            }
            //The target word is after the middle index
            else 
            {
                //Does not search the first half of it 
                lowIndex = midIndex+1; 
            }
        }
        //If the target word is not found
        throw new ItemNotFoundException();
    }
}