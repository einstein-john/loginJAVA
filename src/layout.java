import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class layout extends JFrame implements ActionListener {
    //declare variables

    //buttons
        JButton btnSubmit = new JButton("SUBMIT");
        JButton btnClear = new JButton("CLEAR");
        //labels
        JLabel usernameLabel = new JLabel("\n Enter your username: ");
        JLabel passwordLabel = new JLabel("\n Enter your password");
    //input fields
        JTextField usernameText = new JTextField(10);
        JPasswordField passwordText = new JPasswordField(12);
    //Panels
        JPanel inputPanel = new JPanel();
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
    //control
        private int control = 1;
    // layout
    public layout(String title) throws HeadlessException {
        setTitle(title);
        setLayout(new BorderLayout());
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //input panel
        inputPanel.add(usernameLabel);
        inputPanel.add(usernameText);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordText);
        //input panel.SIZE
        inputPanel.setPreferredSize(new Dimension(340,60));
        //north panel
        northPanel.add(inputPanel);
        //south panel
        southPanel.add(btnSubmit);
        southPanel.add(btnClear);
        //add panels
        add("North",northPanel);
        add(southPanel);
        //btn controls
        this.btnClear.addActionListener(this);
        this.btnSubmit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//clear text
        if (e.getSource() == btnClear){
            this.usernameText.setText("");
            this.passwordText.setText("");
            this.usernameText.requestFocus();
        }
//login
        if (e.getSource() == btnSubmit){
            String username = this.usernameText.getText();
            String password = this.passwordText.getText();

            //linking the two classes
            admin login = new admin("ADMIN PAGE");
            //force exit
            if (control > 3){
                JOptionPane.showMessageDialog(this, "SORRY, You attempted to login more " +
                        "than three times","ERROR",JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
    //login.user confirm
            if ((username.equals(login.getUsername())) && (password.equals(login.getPassword()))){
        login.welcomeLabel.setText("WELCOME!!");
        login.setVisible(true);
        setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect username and password!!",
                        "ERROR",JOptionPane.ERROR_MESSAGE);
                this.passwordText.setText("");
                control++;

            }
        }
    }
}
