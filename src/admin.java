import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin extends JFrame implements ActionListener {
    //declare variables

        //labels
        JLabel welcomeLabel = new JLabel("WELCOME!");
       //logout btn
    JButton btnLogout = new JButton("LOGOUT");
    //Panels
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
    //PASSWORDS
    private final String username = "EINSTEIN";
    private final String password = "112233";
    // layout
    public admin(String title) throws HeadlessException {
        setTitle(title);
        setLayout(new BorderLayout());
        setSize(300,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       // setVisible(true);

        //north panel
        northPanel.add(welcomeLabel);
        //south panel
        southPanel.add(btnLogout);
        //add panels
        add("North",northPanel);
        add(southPanel);
        // btn control
        this.btnLogout.addActionListener(this);
    }
    //string public


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    //logout
        new layout("LOGIN");
        setVisible(false);
    }
}
