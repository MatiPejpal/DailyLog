import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

class DailyLog extends JFrame {
    // Class that handles GUI and shows entries to the log.

    DailyLog(){
        init(this);
        final ArrayList<Entry> entries = new ArrayList<>();
        add(new EntryWriter(entries));
        pack();
    }

    static private void init(JFrame f){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.gray);
        f.setLocationRelativeTo(null);
        f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));
        f.setPreferredSize(new Dimension(420, 800));
        f.setMinimumSize(new Dimension(420, 800));
        f.setVisible(true);
    }

    public static void main(String[] args){ SwingUtilities.invokeLater(DailyLog::new); }

}

class Entry{
    // Class that contains date and activities.

    LocalDate date;
    String activities;

    Entry(LocalDate date, String activities){
        this.date = date;
        this.activities = activities;
    }

}