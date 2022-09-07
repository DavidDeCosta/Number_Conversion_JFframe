import javax.swing.JFrame;                                                 //for JFrame
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;                                                         // for Dimension
import java.awt.event.*;


public class MyFrame extends JFrame 
                    implements ChangeListener, ActionListener, DocumentListener
{
//=====================================DATA MEMBERS========================================================================

    Dimension screenSize;
    Toolkit toolkit;

    JPanel panel_1;
    JPanel panel_2;
    JPanel panel_3;
    JPanel panel_4;
    JPanel panel_5;

    JLabel label_1;
    JLabel label_2;

    JButton exitButton;

    JTextField textField_1;
    JTextField textField_2;

    JSpinner spinner;
    SpinnerModel spinnerModel;
    JLabel spinnerTitleLabel;
    JLabel spinnerValueLabel;
    

//====================================== CONSTRUCTOR=========================================================================
    MyFrame()
    {
        toolkit = Toolkit.getDefaultToolkit();                            // used to help get the users screen size
        screenSize = toolkit.getScreenSize();                             //get the users screen size
        setSize(screenSize.width/3, screenSize.height/3);           // makes JFrame 1/3 the users screensize
        setLocationRelativeTo(null);                             // window is placed in the center of screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            //when close frame the program stops
        setTitle("Project 1 Number Conversion");


        addPanels();
        addComponents();
        setVisible(true);                                       //had to make visable once everything was added
        
    }
    //===================================METHODS=============================================================================

    public void addPanels()
    {
        
/*      panel_1 = new JPanel();
        panel_1.setBackground(Color.GREEN);
        panel_1.setPreferredSize(new Dimension(50,50));
        
        add(panel_1,BorderLayout.NORTH);
*/
        panel_2 = new JPanel();
        panel_2.setBackground(Color.RED);
        panel_2.setPreferredSize(new Dimension(50,50));
        
        add(panel_2,BorderLayout.SOUTH);

        panel_3 = new JPanel();
        panel_3.setBackground(Color.YELLOW);
        panel_3.setPreferredSize(new Dimension(100,50));
        
        add(panel_3,BorderLayout.EAST);

/*      panel_4 = new JPanel();
        panel_4.setBackground(Color.BLUE);
        panel_4.setPreferredSize(new Dimension(50,50));
        
        add(panel_4,BorderLayout.WEST);
*/
        panel_5 = new JPanel();
        panel_5.setBackground(Color.PINK);
        panel_5.setPreferredSize(new Dimension(50,50));
        
        add(panel_5,BorderLayout.CENTER);
    }

    public void addComponents()
    {                                           

        spinnerModel = new SpinnerNumberModel(2,2,20,1);
        spinnerModel.addChangeListener(this);                                 // listens to see if you click the up or down arrow
        spinner = new JSpinner(spinnerModel);
        spinnerTitleLabel = new JLabel("The Spinner");
        spinnerTitleLabel.setFont(new Font("Times Roman", Font.PLAIN,18));
        spinnerValueLabel = new JLabel("2");


        panel_3.add(spinnerTitleLabel,BorderLayout.NORTH);
        panel_3.add(spinner,BorderLayout.CENTER);


        label_1 = new JLabel("Enter Number: ");
        textField_1 = new JTextField();

        textField_1.setPreferredSize(new Dimension(150,50));
        textField_1.setFont(new Font("Times Roman", Font.PLAIN,18));
        textField_1.setBackground(Color.WHITE);
        textField_1.setForeground(Color.RED);;

        textField_1.getDocument().addDocumentListener(this);

        
        panel_5.setLayout(new GridLayout(2,1));                //set so the input box is ontop of the output box
        panel_5.add(label_1);
        panel_5.add(textField_1);

        label_2 = new JLabel("Output: ");
        textField_2 = new JTextField();
        textField_2.setPreferredSize(new Dimension(150,50));        //sets the dimensions of output box
        textField_2.setFont(new Font("Times Roman", Font.PLAIN,18));
        textField_2.setBackground(Color.BLACK);                                  //background of output box is black
        textField_2.setForeground(Color.GREEN);                                  //output text will be green
        textField_2.setEditable(false);                                        //output field is not editable

        panel_5.add(label_2);                                             
        panel_5.add(textField_2);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);                   // listens for the button to be clicked and send it to actionperformed
        panel_2.add(exitButton);
    }


    /*
    In: Takes in an String and radix
    Out: Returns the String version of the integer thats been changed determined by the radix
     */
    String convertNumber(String originalNum, int rad){

        String convertedNum;
        int i;
        i =  Integer.parseInt(originalNum);
        convertedNum= Integer.toString(i,rad);


        return convertedNum;
    }

    public void stateChanged(ChangeEvent ce)
    {
        int n;

        n = (Integer) spinner.getModel().getValue();

        spinnerValueLabel.setText("" + n);

        myConversion();

    }


     public void actionPerformed(ActionEvent e)
    {
        this.dispose();                            //closes the Jframe

    }

    @Override
    public void insertUpdate(DocumentEvent e) {

        myConversion();

    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        

        if(textField_1.getText().trim().isEmpty())                        //if textfield1 is empty set texfield2 to empty
        {
            textField_2.setText("");
        }
        else
        {
            myConversion();
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        
    }

    void myConversion()
    {
        try{
        String convertedNum;
        String str1;
        int testingIfInt;
        str1 = textField_1.getText().trim();
        
        testingIfInt = Integer.parseInt(str1);
    
        int n;
        n = (Integer) spinner.getModel().getValue();
        convertedNum = convertNumber(str1, n);
        textField_2.setText(convertedNum);
        }
        catch(NumberFormatException e)
            {
            textField_2.setText("Error - not a numeral!");
//            System.out.println("Not a Numeral!");
            }
        }
}
