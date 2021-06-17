
/**
 * Write a description of class CustomSet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CustomSet
{
    // instance variables - replace the example below with your own
    private String newSet;
    private StackAsList newStack;

    /**
     * Constructor for objects of class CustomSet
     */
    public CustomSet(String input)
    {
        // initialise instance variables
        String newSet = input;
        newStack = new StackAsList();
    }
    
    public void push(String input)
    {
        newStack.addFirstNode(input);
        System.out.println(newStack.peek());
    }
}
