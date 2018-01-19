import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class FirstGUI extends JFrame implements ActionListener {
   // Attributes are GUI components (buttons, text fields, etc.)
   // are declared here.
   private JPanel jpNorth = new JPanel();
   private JPanel jpSouth = new JPanel();   
   
   // JLabels 
   private JLabel jlN1 = new JLabel ("Number 1");
   private JLabel jlN2 = new JLabel ("Number 2");
   private JLabel jlRes = new JLabel ("Result");
   
   // JTextFields
   private JTextField jtfN1 = new JTextField(10);
   private JTextField jtfN2 = new JTextField(10);
   private JTextField jtfRes = new JTextField(10);
   
   // JButtons
   private JButton jbAdd = new JButton("Add");
   private JButton jbClear = new JButton("Clear");
   private JButton jbExit = new JButton("Exit");
   
   // Main just instantiates an instance of this GUI class
   public static void main(String[] args) {
      new FirstGUI();
   }
   
   // Constructor draws the GUI
   public FirstGUI() {
      // Set windows properties (title, size, location, close operation)
      this.setTitle("This is a great fucking title"); // Sets title in title bar
      this.setSize(600, 90); // sets the size of the window
      //this.setLocationRelativeTo(null); // sets location of the windows
      this.setLocation(30, 50); // sets location of window
      this.setResizable(false);
      
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Place components in the window
      JPanel jpNorth = new JPanel();
      JPanel jpSouth = new JPanel();
      this.add(jpNorth, BorderLayout.NORTH);
      this.add(jpSouth, BorderLayout.SOUTH);
      
      
      // place components
      jpNorth.add(jlN1);
      jpNorth.add(jtfN1);
      jpNorth.add(jlN2);
      jpNorth.add(jtfN2);
      jpNorth.add(jlRes);
      jpNorth.add(jtfRes);
      jpSouth.add(jbAdd);
      jpSouth.add(jbClear);
      jpSouth.add(jbExit);
      
      // Connect the buttons
      jbAdd.addActionListener(this);
      jbClear.addActionListener(this);
      jbExit.addActionListener(this);
      
      // init the fields
      doClear();
      
      jtfRes.setEditable(false);
      
      // Make the window visible
      this.setVisible(true);
   }
   
   // actionPerformed abstract provided 
   public void actionPerformed(ActionEvent ae) {
      switch (ae.getActionCommand()) {
         case "Add":
            //System.out.println("Add");
            doAdd();
            break;
         case "Clear":
            //System.out.println("Clear");
            doClear();
            break;
         case "Exit":
            //System.out.println("Exit");
            System.exit(0);
            break;
      }
   } // actionPerformed
   
   public void doAdd() {
      try {
         String sN1 = jtfN1.getText();
         int iN1 = Integer.parseInt(sN1);
         String sN2 = jtfN2.getText();
         int iN2 = Integer.parseInt(sN2);
         int res = iN1 + iN2;
         jtfRes.setText("" + res);
      }
      catch (NumberFormatException e) {
         JOptionPane.showMessageDialog(
            this, // parent window
            "Unrecognizable or non-present values in Number 1 and/or Number 2",
            "Format Error",
            JOptionPane.WARNING_MESSAGE
            
            );
      }
   }
   
   public void doClear() {
      jtfN1.setText("0");
      jtfN2.setText("0");
      jtfRes.setText("0");
   } 
}	
