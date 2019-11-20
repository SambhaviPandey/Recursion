/**
 * class LinearSearch is a subclass of 
 * class SearchAlgorithm. This class 
 * conducts a iterative search and 
 * attempts to implement a recursive search 
 * in order to search through a target file. 
 * 
 * @author (Sambhavi Pandey)
 * @version (Last modified May 11,2018)
 */
public class LinearSearch extends SearchAlgorithm
{
    /**
     * The search method takes a String array 
     * argument and an argument of type String.
     * This method also returns an int value that 
     * corresponds to the target word's index. 
     * The purpose of this method is to conduct
     * an iterative search comparing the
     * current String array of words with the target
     * String at each step. This is done through a 
     * for loop and an if statement. Additionally, 
     * this method throws an ItemNotFoundException 
     * if the specified target is not found. 
     * 
     * @param words
     * @param wordToFind
     */
    @Override
    public int search(String[] words, String wordToFind) 
                      throws ItemNotFoundException 
    {
        //loops through the words 
        for(int i = 0; i < words.length; i++)
        {
            //to determine accurate count of the comparisons
            incrementCount();
            //to determine if the word is the target word
            if(words[i].equals(wordToFind))
            {
                //returns the target word's index 
                return i;
            }
        }
        //if the target word is not found 
        throw new ItemNotFoundException();
    }

    /**
     * recSearch method takes an argument of the type 
     * String array and and argument of type String,
     * along with an argument of type int that corresponds
     * to the beginning word index of the search. 
     * This method returns an int value corresponding 
     * to the target word's index (if it is found). 
     * The purpose of the method is to attempt to recursively 
     * search for the target word. However, this attempt 
     * results in a stack overflow. 
     * 
     * @param words 
     * @param wordToFind 
     * @param beginningIndex
     */
    public int recSearch(String[] words, String wordToFind, 
                         int beginningWord)
    {
        //to determine accurate count of the comparisons
        incrementCount();
        //if statement to determine if they are equivalent
        if(beginningWord == words.length-1)
        {
            //if the beginning word is equal to the word to find,
            //then the beginning word is returned. 
            //Otherwise, -1 is returned.
            return words[beginningWord].equals(wordToFind) ? 
                   beginningWord : -1;
        }
        //determines the accurate count of the comparisons
        incrementCount();
        //if statement to determine if the word in the array 
        //is equal to the word to find
        if(words[beginningWord].equals(wordToFind))
        {
            return beginningWord;
        }
        return recSearch(words, wordToFind, beginningWord+1);
    }
    
    /**
     * recSearch method takes an argument of the type
     * String array and an argument of type String. 
     * This method returns an int value corresponding 
     * to the target word's index. The purpose of this 
     * method is to attempt the recursive 
     * search (by calling the method) and to
     * determine if there is an ItemNotFoundException
     * (if the method returns -1).
     * 
     * @param words
     * @param wordToFind 
     */
    @Override
    public int recSearch(String[] words, String wordToFind) 
                         throws ItemNotFoundException
    {
        //calls the recSearch method 
        int index = recSearch(words, wordToFind, 0);
        //to determine the accurate count of the comparisons
        incrementCount();
        //Determines if the method returns -1
        if(index == -1)
        {
            //If it returns -1
            throw new ItemNotFoundException();
        }
        //Otherwise it returns the word's target index 
        return index;
    }
}