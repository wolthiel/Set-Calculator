import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * A graphical user interface for the calculator. No calculation is being
 * done here. This class is responsible just for putting up the display on 
 * screen. It then refers to the "CalcEngine" to do all the real work.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class UserInterface
    implements ActionListener
{
    private CalcEngine calc;
    private boolean showingAuthor;

    private JFrame frame;
    private JFrame hexFrame;
    private JFrame setFrame;
    public JTextField display;
    private JTextField displayInputOne;
    private JTextField displayInputTwo;
    private JTextField displayOutput;
    private JLabel status;
    private CustomSet customSet;
    private SetIntersectionIdentifier siid;
    public static boolean hex = false;
    public static boolean set = false;

    /**
     * Create a user interface.
     * @param engine The calculator engine.
     */
    public UserInterface(CalcEngine engine)
    {
        calc = engine;
        showingAuthor = true;
        makeFrame();
        frame.setVisible(true);
        makeSetFrame();
        setFrame.setVisible(false);
        makeHexFrame();
        hexFrame.setVisible(false);
    }

    /**
     * Set the visibility of the interface.
     * @param visible true if the interface is to be made visible, false otherwise.
     */
    public void setVisible(boolean visible)
    {
        frame.setVisible(visible);
    }

    /**
     * Make the frame for the user interface.
     */
        private void makeSetFrame()
    {
        setFrame = new JFrame(calc.getTitle());
        
        JPanel contentPane = (JPanel)setFrame.getContentPane();
        contentPane.setLayout(new BorderLayout(3, 1));
        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));
        
        JPanel displayPanel = new JPanel(new GridLayout(3, 1));
        displayInputOne = new JTextField();
        displayInputTwo = new JTextField();
        displayOutput = new JTextField();
        
        displayPanel.add(displayInputOne, BorderLayout.NORTH);
        displayPanel.add(displayInputTwo, BorderLayout.CENTER);
        displayPanel.add(displayOutput, BorderLayout.SOUTH);
        contentPane.add(displayPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 5));
            addButton(buttonPanel, "Push");
            addButton(buttonPanel, "Show number of Set elements");
            addButton(buttonPanel, "Set Addition");
            addButton(buttonPanel, "Set Subtraction");
            addButton(buttonPanel, "Set Intersection");
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        status = new JLabel(calc.getAuthor());
        contentPane.add(status, BorderLayout.SOUTH);

        setFrame.pack();
    }
    private void makeHexFrame()
    {
        hexFrame = new JFrame(calc.getTitle());
        
        JPanel contentPane = (JPanel)hexFrame.getContentPane();
        contentPane.setLayout(new BorderLayout(8, 8));
        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));

        display = new JTextField();
        contentPane.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 5));
            addButton(buttonPanel, "Del");
            addButton(buttonPanel, "HEX");
            addButton(buttonPanel, "=");
            addButton(buttonPanel, "SET");
            addButton(buttonPanel, "?");            
            
            addButton(buttonPanel, "*");            
            addButton(buttonPanel, "+");            
            addButton(buttonPanel, "-");
            buttonPanel.add(new JLabel(" "));
            addButton(buttonPanel, "0");
            
            addButton(buttonPanel, "1");
            addButton(buttonPanel, "2");
            addButton(buttonPanel, "3"); 
            addButton(buttonPanel, "4");
            addButton(buttonPanel, "5");
            
            addButton(buttonPanel, "6");
            addButton(buttonPanel, "7");
            addButton(buttonPanel, "8");
            addButton(buttonPanel, "9");
            addButton(buttonPanel, "A");
            
            addButton(buttonPanel, "B");
            addButton(buttonPanel, "C");
            addButton(buttonPanel, "D");
            addButton(buttonPanel, "E");
            addButton(buttonPanel, "F");
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        status = new JLabel(calc.getAuthor());
        contentPane.add(status, BorderLayout.SOUTH);

        hexFrame.pack();
    }
    private void makeFrame()
    {
        frame = new JFrame(calc.getTitle());
        
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout(8, 8));
        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));

        display = new JTextField();
        contentPane.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 3));
            addButton(buttonPanel, "Del");
            addButton(buttonPanel, "HEX");
            addButton(buttonPanel, "=");
            
            addButton(buttonPanel, "*");            
            addButton(buttonPanel, "+");
            addButton(buttonPanel, "-");
            
            addButton(buttonPanel, "?");
            addButton(buttonPanel, "SET");            
            addButton(buttonPanel, "0");
            
            addButton(buttonPanel, "1");
            addButton(buttonPanel, "2");
            addButton(buttonPanel, "3");
            
            addButton(buttonPanel, "4");
            addButton(buttonPanel, "5");
            addButton(buttonPanel, "6");
            
            addButton(buttonPanel, "7");            
            addButton(buttonPanel, "8");
            addButton(buttonPanel, "9");
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        status = new JLabel(calc.getAuthor());
        contentPane.add(status, BorderLayout.SOUTH);

        frame.pack();
    }


    /**
     * Add a button to the button panel.
     * @param panel The panel to receive the button.
     * @param buttonText The text for the button.
     */
    private void addButton(Container panel, String buttonText)
    {
        JButton button = new JButton(buttonText);
        button.addActionListener(this);
        panel.add(button);
    }

    /**
     * An interface action has been performed.
     * Find out what it was and handle it.
     * @param event The event that has occured.
     */
    public void actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();
        if ( hex == true ) {
                switch (command) {
                    case "A":
                        calc.numberPressed(10);
                        break;
                    case "B":
                        calc.numberPressed(11);
                        break;
                    case "C":
                        calc.numberPressed(12);
                        break;
                    case "D":
                        calc.numberPressed(13);
                        break;
                    case "E":
                        calc.numberPressed(14);
                        break;
                    case "F":
                        calc.numberPressed(15);
                        break;
                    default:
                        break;
                }
        }
        if(
                command.equals("0") ||
                command.equals("1") ||
                command.equals("2") ||
                command.equals("3") ||
                command.equals("4") ||
                command.equals("5") ||
                command.equals("6") ||
                command.equals("7") ||
                command.equals("8") ||
                command.equals("9")) {
                int number = Integer.parseInt(command);
                calc.numberPressed(number);
        }
        else if(command.equals("HEX")) {
            hex = !hex;
            if (hex)
            {
                frame.setVisible(false);
                hexFrame.setVisible(true);
                setFrame.setVisible(false);
            }
            else {
                frame.setVisible(true);
                hexFrame.setVisible(false);
                setFrame.setVisible(false);
            }
        }
        else if(command.equals("SET")) {
            set = !set;
            if (set)
            {
                frame.setVisible(false);
                hexFrame.setVisible(false);
                setFrame.setVisible(true);
            }
            else {
                frame.setVisible(true);
                hexFrame.setVisible(false);
                setFrame.setVisible(false);
            }
        }
        else if(command.equals("+")) {
            calc.plus();
        }
        else if(command.equals("*")) {
            calc.multiply();
        }
        else if(command.equals("-")) {
            calc.minus();
        }
        else if(command.equals("=")) {
            calc.equals();
        }
        else if(command.equals("Del")) {
            calc.clear();
        }
        else if(command.equals("?")) {
            showInfo();
        }
        else if(command.equals("Push")) {
            String newString = getDisplay(displayInputOne);
            customSet = new CustomSet();
            customSet.push(newString);
        }
        else if(command.equals("Set Addition")){
            String newString1 = getDisplay(displayInputOne);
            String newString2 = getDisplay(displayInputTwo);
            setArithmetic sa = new setArithmetic();
            String newString3 = sa.union(newString1, newString2);
            displayOutput.setText(newString3);
        }
        else if(command.equals("Set Subtraction")){
            String newString1 = getDisplay(displayInputOne);
            String newString2 = getDisplay(displayInputTwo);
            setArithmetic sa = new setArithmetic();
            String newString3 = sa.setDifference(newString1, newString2);
            displayOutput.setText(newString3);
        }
        else if(command.equals("Show number of Set elements")){
            String newString = getDisplay(displayInputOne);
            char ch[] = newString.toCharArray();
            int x = ch.length;
            displayOutput.setText("Number of elements in set: " + x);
        }
        else if(command.equals("Set Intersection")){
            String newString1 = getDisplay(displayInputOne);
            String newString2 = getDisplay(displayInputTwo);
            boolean s1E = false;
            if (newString1 == "")
            {
                s1E = true;
            }
            boolean s2E = false;
            if (newString2 == "")
            {
                s2E = true;
            }
            if (s1E && s2E)
            {
                displayOutput.setText("No input identified");
            }
            else if (s1E)
            {
                displayOutput.setText(newString2);
            }
            else if (s2E)
            {
                displayOutput.setText(newString1);
            }
            else {
                //displayOutput.setText("Test successful" );
                SetIntersectionIdentifier sid = new SetIntersectionIdentifier(newString1, newString2);
                String resultString = sid.calculate();
                displayOutput.setText(resultString);
            }
        }
        // else unknown command.

        redisplay();
    }

    /**
     * Update the interface display to show the current value of the 
     * calculator.
     */
    private void redisplay()
    {
        if ( hex ) {
            display.setText("" + calc.getDisplayValueInHex());
        }
        else {
            display.setText("" + calc.getDisplayValue());
        }
    }

    /**
     * Toggle the info display in the calculator's status area between the
     * author and version information.
     */
    private void showInfo()
    {
        if(showingAuthor)
            status.setText(calc.getVersion());
        else
            status.setText(calc.getAuthor());

        showingAuthor = !showingAuthor;
    }
    public String getDisplay(JTextField inputDisplay)
    {
        String newString = inputDisplay.getText();
        return newString;
    }
}
