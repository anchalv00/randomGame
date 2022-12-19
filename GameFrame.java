import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;






public class GameFrame extends JFrame {
    
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JTextField textField = new JTextField(40);
    JButton button = new JButton("Enter");


    GameFrame() {

        this.add(new GamePanel());
        this.setTitle("Modified Wordle");
        this.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        //add text box to console
        panel.add(textField);
        panel.add(button);
        //sets the size of text box
        textField.setColumns(5);

        
        button.addActionListener(new ActionListener() {
            //method for when enter is pressed
            public void actionPerformed(ActionEvent e){
                String input = textField.getText();
                label.setText(input);
            }
        });

        //adds button to console
        
        //button.add(label);
        panel.add(label);
        add(panel);

    }
}