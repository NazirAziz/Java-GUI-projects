import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;


class Time extends Frame{
    Label textField;
    int hour;
    int min;
    int sec;
    LocalDateTime time;
    Time(){
        super("Time and Date");
        
        // clost the window by the x
        super.setSize(200, 90);
        textField = new Label("Time");
        
        time = LocalDateTime.now();
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        super.setLayout(new FlowLayout());
        super.add(textField);
        
        super.setVisible(true);
        update();        
    }
    
    public void update(){
        while (true){
            time = LocalDateTime.now();
            hour = time.getHour() % 12;
            min = time.getMinute();
            sec = time.getSecond();
            textField.setText("" + hour + ":" + min + ":" + sec);
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
            sec++;

        }
    }


    public static void main(String[] args) {
        new Time();

    }
}
