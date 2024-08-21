import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

class Display{

    boolean startTime = false;

    JFrame mainFrame;
    JPanel upperPanel;
    JPanel buttonsPanel;

    Display(){
        mainFrame = new JFrame("Stop Watch");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(2,1));
        mainFrame.setResizable(false);

        
        

        setUpUpperPanel();
        setUpBottonPanel();
        setUpButtonAction();
        
        mainFrame.add(upperPanel);
        mainFrame.add(buttonsPanel);







        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
    // upper panel
    JPanel hourPanel;
    JPanel minutePanel;
    JPanel secondPanel;
    private void setUpUpperPanel(){
        upperPanel = new JPanel();
        upperPanel.setLayout(new FlowLayout());
        setUpHourPanel();
        setUpMinutePanel();
        setUpSecondPanel();
        upperPanel.setLayout(new FlowLayout());
        upperPanel.add(hourPanel);
        upperPanel.add(minutePanel);
        upperPanel.add(secondPanel);
    }
    // hourPanel
    JLabel hourLabel;
    JLabel hourMove;
    private void setUpHourPanel(){
        hourPanel = new JPanel();
        hourPanel.setLayout(new BoxLayout(hourPanel, BoxLayout.Y_AXIS));

        hourLabel = new JLabel("Hour");
        hourLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        hourLabel.setFont(new Font(hourLabel.getFont().getName(), Font.PLAIN, 20));
        hourMove = new JLabel("00");
        hourMove.setAlignmentX(Component.CENTER_ALIGNMENT);
        hourMove.setFont(new Font(hourMove.getFont().getName(), Font.PLAIN, 20));
        hourPanel.add(hourLabel);
        hourPanel.add(hourMove);

        hourPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
    // minute panel
    JLabel minuteLabel;
    JLabel minuteMove;
    private void setUpMinutePanel(){
        minutePanel = new JPanel();
        minutePanel.setLayout(new BoxLayout(minutePanel, BoxLayout.Y_AXIS));

        minuteLabel = new JLabel("Minute");
        minuteLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        minuteLabel.setFont(new Font(minuteLabel.getFont().getName(), Font.PLAIN, 20));
        minuteMove = new JLabel("00");
        minuteMove.setAlignmentX(Component.CENTER_ALIGNMENT);
        minuteMove.setFont(new Font(minuteMove.getFont().getName(), Font.PLAIN, 20));

        minutePanel.add(minuteLabel);
        minutePanel.add(minuteMove);

        minutePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
    // second panel
    JLabel secondLabel;
    JLabel secondMove;
    private void setUpSecondPanel(){
        secondPanel = new JPanel();
        secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.Y_AXIS));

        secondLabel = new JLabel("Second");
        secondLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        secondLabel.setFont(new Font(secondLabel.getFont().getName(), Font.PLAIN, 20));
        secondMove = new JLabel("00");
        secondMove.setAlignmentX(Component.CENTER_ALIGNMENT);
        secondMove.setFont(new Font(secondMove.getFont().getName(), Font.PLAIN, 20));

        secondPanel.add(secondLabel);
        secondPanel.add(secondMove);

        secondPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
    // lower panel -> buttons
    public JButton start;
    JButton reset;
    private void setUpBottonPanel(){
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        start = new JButton("Start");
        reset = new JButton("Reset");

        buttonsPanel.add(start);
        buttonsPanel.add(reset);
    }
    
    private void setUpButtonAction(){
        
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!startTime){
                    startTime = true;
                    // thread and shit
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (startTime){
                                s++;
                                checking();
                                updating();
                    
                                try{
                                    Thread.sleep(1000);
                                }catch(Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }
                    }).start();
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTime = false;
                restart();
            }
        });
    }
    private void restart(){
        h = 0;
        m = 0;
        s = 0;
        updating();
    }

    int h;
    int m;
    int s;
    private void checking(){
        if (s == 60){
            s = 0;
            m++;
        }
        if (m == 60){
            m = 0;
            h++;
        }
        if (h == 100)
            h = 0;
    }
    private void updating(){
        if (h < 10)
            hourMove.setText("0" + h);
        else
            hourMove.setText(h + "");

        if (m < 10)
            minuteMove.setText("0" + m);
        else
            minuteMove.setText(m + "");
        
        if (s < 10)
            secondMove.setText("0" + s);
        else
            secondMove.setText(s + "");
    }
}