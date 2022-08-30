import javax.swing.JFrame;                                                 //for JFrame
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;                                                         // for Dimension
import java.awt.event.*;

public class MyFrame extends JFrame 
                    implements ChangeListener, ActionListener
{
//=====================================DATA MEMBERS========================================================================
    JFrame frame;
    Dimension screenSize;
    Toolkit toolkit;
    SpinnerModel spinnerModel;

    JPanel panel_1;
    JPanel panel_2;
    JPanel panel_3;
    JPanel panel_4;
    JPanel panel_5;
    JPanel panel_6;
    JPanel panel_7;

    JLabel label_1;
    JLabel label_2;

    JButton button_1;
    JButton button_2;

    JTextField textField_1;
    JTextField textField_2;

    JSpinner spinner;
    SpinnerModel spinerModel;
    JLabel spinnerTitleLabel;
    JLabel spinnerValueLabel;
    

//====================================== CONSTRUCTOR=========================================================================
    MyFrame()
    {

        frame = new JFrame();

        toolkit = Toolkit.getDefaultToolkit();                            // used to help get the users screen size
        screenSize = toolkit.getScreenSize();                             //get the users screen size
        frame.setSize(screenSize.width/3, screenSize.height/3);           // makes JFrame 1/3 the users screensize
        frame.setLocationRelativeTo(null);                             // window is placed in the center of screen
        frame.setVisible(true);                                        // makes the window visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            //when close frame the program stops
        frame.setTitle("Project 1 Number Conversion");


        addPanels();
        addComponents();
        
        
    }
    //===================================METHODS=============================================================================

    void addPanels()
    {
        
        panel_1 = new JPanel();
        panel_1.setBackground(Color.GREEN);
        panel_1.setPreferredSize(new Dimension(50,50));
        
        frame.add(panel_1,BorderLayout.NORTH);

        panel_2 = new JPanel();
        panel_2.setBackground(Color.RED);
        panel_2.setPreferredSize(new Dimension(50,50));
        
        frame.add(panel_2,BorderLayout.SOUTH);

        panel_3 = new JPanel();
        panel_3.setBackground(Color.YELLOW);
        panel_3.setPreferredSize(new Dimension(100,50));
        
        frame.add(panel_3,BorderLayout.EAST);

        panel_4 = new JPanel();
        panel_4.setBackground(Color.BLUE);
        panel_4.setPreferredSize(new Dimension(50,50));
        
        frame.add(panel_4,BorderLayout.WEST);

        panel_5 = new JPanel();
        panel_5.setBackground(Color.PINK);
        panel_5.setPreferredSize(new Dimension(50,50));
        
        frame.add(panel_5,BorderLayout.CENTER);

    }

    void addComponents()
    {
//        panel_6 = new JPanel();
//        panel_3.setLayout(new BorderLayout()); //makes it so we can add components to 'N''S''E''W'inside panel_3                                            

        spinnerModel = new SpinnerNumberModel(2,2,20,1);
        spinnerModel.addChangeListener(this);
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

        textField_1.addActionListener(this);

        panel_5.add(label_1);
        panel_5.add(textField_1);

        label_2 = new JLabel("Output: ");
        textField_2 = new JTextField();
        textField_2.setPreferredSize(new Dimension(150,50));        //sets the dimensions of output box
        textField_2.setFont(new Font("Times Roman", Font.PLAIN,18));
        textField_2.setBackground(Color.BLACK);        //background of output box is black
        textField_2.setForeground(Color.GREEN);        //output text will be green
        textField_2.setEditable(false);             //output field is not editable

        panel_5.setLayout(new GridLayout(2,1));                //set so the input box is ontop of the output box
        panel_5.add(label_2);                                             
        panel_5.add(textField_2);
    }

    public void stateChanged(ChangeEvent ce)
    {
        int n;

        n = (Integer) spinner.getModel().getValue();

        spinnerValueLabel.setText("" + n);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== textField_1)
        {
            String text = textField_1.getText();
            textField_2.setText(text);
        }
    }

}
