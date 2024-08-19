import java.awt.*;
import java.awt.event.*;

class AreYouSure extends Frame{

    Button yes;
    Button no;
    Label text;

    AreYouSure(){
        super("Conformation Window");
        super.setSize(360, 90);

        text = new Label("Are you sure?");
        yes = new Button();
        yes.setLabel("YES");
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        no = new Button("NO");
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        super.setLayout(new FlowLayout());
        super.add(text);
        super.add(yes);
        super.add(no);

        super.setVisible(true);
    }

}

public class GuiCounter extends Frame{
    Button incrementButton;
    Button decrementButton;
    Button reset;
    Button exit;
    Label label;
    TextField textField;
    int count = 0;

    GuiCounter(){
        super("Counter App");

        super.setSize(360, 90);

        incrementButton = new Button("   +   ");
        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(++count + "");
            }
        });
        decrementButton = new Button("   -   ");
        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count > 0)
                    textField.setText(--count + "");
            }
        });

        reset = new Button("reset");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count = 0;
                textField.setText(count + "");
            }
        });
        
        exit = new Button("exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AreYouSure();
            }
        });

        label = new Label("Number of product: ");

        textField = new TextField();
        textField.setText(count + "");
        super.setLayout(new FlowLayout());
        add(label);
        add(incrementButton);
        add(textField);
        add(decrementButton);
        super.add(reset);
        super.add(exit);

        super.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new GuiCounter();
    }
}
