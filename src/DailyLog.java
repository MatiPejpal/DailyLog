import javax.swing.*;
import java.awt.*;
import java.util.Date;

class DailyLog extends JFrame {
    // Class that handles GUI and shows entries to the log.

    DailyLog(){
        init(this);
    }

    static void init(JFrame f){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(new Dimension(400, 800));
        f.getContentPane().setBackground(Color.gray);
        f.setLocationRelativeTo(null);
        f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));
        f.setVisible(true);
    }

    public static void main(String[] args){ SwingUtilities.invokeLater(DailyLog::new); }

}

class Entry{
    // Class that contains date and activities

    Date date;
    String activities;

    Entry(Date date, String activities){
        this.date = date;
        this.activities = activities;
    }

}