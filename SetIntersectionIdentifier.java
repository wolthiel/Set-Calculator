import java.util.ArrayList;

/**
 * Write a description of class SetIntersectionIdentifier here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SetIntersectionIdentifier
{
    // instance variables - replace the example below with your own
    private String input1;
    private String input2;
    private char[] inc1;
    private char[] inc2;

    /**
     * Constructor for objects of class SetIntersectionIdentifier
     */
    public SetIntersectionIdentifier(String i, String j)
    {
        input1 = i;
        input2 = j;
        inc1 = input1.toCharArray();
        inc2 = input2.toCharArray();        
    }
    public String calculate()
    {
        String newString = "";
        ArrayList<Character> forbiddenCh = new ArrayList<Character>();
        for (int a = 0; a < inc1.length; a++)
        {
            for (int b = 0; b < inc2.length; b++)
            if (inc1[a] == inc2[b])
            {
                if(!contains(forbiddenCh, inc1[a]))
                {
                    newString = newString + inc1[a];
                    forbiddenCh.add(inc1[a]);
                }
            }
        }
        return newString;
    }
    private boolean contains(ArrayList<Character> array, char character) {
        for(int i = 0; i < array.size(); i++)
        {
            if (array.get(i) == character)
            {
                return true;
            }
        }
        return false;
    }
}
