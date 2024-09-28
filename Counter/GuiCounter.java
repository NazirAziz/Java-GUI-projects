import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.*;

public class Counter extends JFrame{
    JPanel mainPanel;
    
    JTextField showCount;
    JButton add;
    JButton subtract;
    JButton reset;

    Counter(){
        super("Counter");
        setUpMailPanelComponents();
        setUpAction();
        setUpFrame();
    }
    
    private void setUpFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void setUpMailPanelComponents(){
        mainPanel = new JPanel();

        showCount = new JTextField(3);
        showCount.setEnabled(false);
        showCount.setFont(new Font("Arail", Font.BOLD, 20));

        add = new JButton(" + ");
        add.setFocusable(false);

        subtract = new JButton(" - ");
        subtract.setFocusable(false);

        reset = new JButton("reset");


        mainPanel.add(showCount);
        mainPanel.add(add);
        mainPanel.add(subtract);
        mainPanel.add(reset);
    }


    int num;
    private void setUpAction(){
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (num < 100)
                    num++;
                showCount.setText(num + "");
            }
        });
        subtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (num > 0)
                    num--;
                showCount.setText(num + "");
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = 0;
                showCount.setText(num + "");
            }
        });
    }
    
    
    
    public static void main(String[] args) {
        new Counter();
    }
}
