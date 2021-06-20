import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.lang.Double;
import java.lang.Integer;
public class union 
{

    public void union (String set1, String set2)
	{
		// Arrays.sort(set1.toCharArray()); // Does not work... again... Thank you Java...
		String set3 = removeDups(set1 + set2);
		Scanner input = new Scanner(set3);
		String unionSet = "";

		// Should work, too, but Double and Integer cannot be found despite imported...
		while (input.hasNext())
		{
			if (input.hasNextInt())
			{
				unionSet = unionSet + Integer(input.nextInt()).toString() + " ";
			}
			else if (input.hasNextDouble())
			{
				unionSet = unionSet + Double(input.nextDouble()).toString() + " ";
			}
		}

		System.out.println(unionSet);
	}

	public void subtractSets (String set1, String set2)
	{

	}

	/**
   * Java method to remove duplicate characters from String This method uses a
   * HashSet collection to get rid of duplicate characters.
   *
   * @param word
   * @return String without duplicate characters
   */
	// Referenced from java67.com
  public static String removeDups(String word) {
    Set<Character> chars = new HashSet<>();
    StringBuilder output = new StringBuilder(word.length());

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (chars.add(ch)) {
        output.append(ch);
		output.append(' ');
      }
    }

    return output.toString();
  }

  public void setDifference() 
  {
	  Set<Integer> numbers = new HashSet<>();
    	numbers.add(1);
    	numbers.add(2);
    	numbers.add(3);
    	numbers.add(4);

	Set<Integer> primeNumbers = new HashSet<>();
    primeNumbers.add(2);
    primeNumbers.add(3);

    numbers.removeAll(primeNumbers);
    System.out.println("Numbers without prime numbers: " + numbers);
  }

	public static void main (String args[])
	{
		union u1 = new union();
		u1.union("3 1 3", "1 3 2");
		setDifference();
		return;
	}
}
