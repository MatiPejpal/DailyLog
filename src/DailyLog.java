import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.util.Date;

class DailyLog extends JFrame {
    // Class that handles GUI and shows entries to the log.

    DailyLog(){
        init(this);
        add(new EntryWriter());
        pack();
    }

    static private void init(JFrame f){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.gray);
        f.setLocationRelativeTo(null);
        f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));
        f.setVisible(true);
    }

    public static void main(String[] args){ SwingUtilities.invokeLater(DailyLog::new); }

}

class EntryWriter extends JPanel{
    // Class that allow user to write and save entries.

    EntryWriter(){
        init(this);
        final JTextField dateField = createDateField();
        final JTextArea activityField = createActivityField();

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        add(dateField, c);

        c.gridx = 1;
        c.gridy = 0;
        add(addButton(), c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        add(activityField, c);
    }

    static private void init(JPanel p){
        p.setBackground(Color.gray);
        p.setLayout(new GridBagLayout());
    }

    static private JTextField createDateField(){
        JTextField t = new JTextField();
        t.setBackground(Color.gray);
        t.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(1,1,1,1), BorderFactory.createLineBorder(Color.black, 1)));
        t.setPreferredSize(new Dimension(360, 40));
        t.setMaximumSize(new Dimension(360, 40));
        t.setVisible(true);
        return t;
    }

    static private JTextArea createActivityField(){
        JTextArea t = new JTextArea();
        t.setBackground(Color.gray);
        t.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(1,1,1,1), BorderFactory.createLineBorder(Color.black, 1)));
        t.setPreferredSize(new Dimension(400, 100));
        t.setMinimumSize(new Dimension(360, 40));
        t.setVisible(true);
        return t;
    }

    static private JButton addButton(){
        JButton b = new JButton("+");
        b.setPreferredSize(new Dimension(40,40));
        b.setMaximumSize(new Dimension(40,40));
        b.setFocusPainted(false);
        b.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(1,1,1,1), BorderFactory.createSoftBevelBorder(0, Color.gray, Color.darkGray)));
        b.setBackground(Color.gray);
        b.setVisible(true);
        return b;
    }

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