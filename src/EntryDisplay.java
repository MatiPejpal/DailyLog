import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

class EntryDisplay extends JPanel {
    // Class that displays entries.

    EntryDisplay(ArrayList<Entry> entries){
        init(this);
        add(new SingleEntryDisplay(new Entry(LocalDate.parse("2020-05-06"), "hello entry")));
    }

    static private void init(JPanel p){
        p.setBackground(Color.gray);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setAlignmentX(SwingConstants.CENTER);
        p.setPreferredSize(new Dimension(400, 620));
        p.setMinimumSize(new Dimension(400, 620));
        p.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(3,3,1,3), BorderFactory.createLineBorder(Color.black, 1)));
    }

    private static class SingleEntryDisplay extends JPanel{

        SingleEntryDisplay(Entry entry){
            init(this);
            add(dateLabel(entry.date));
            add(activityLabel(entry.activities));
        }

        static private void init(JPanel p){
            p.setBackground(Color.gray);
            p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
            p.setPreferredSize(new Dimension(410, 140));
            p.setMinimumSize(new Dimension(410, 140));
        }

        static JLabel dateLabel(LocalDate date){
            JLabel l = new JLabel(date.toString());
            l.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(1,1,1,1), BorderFactory.createLineBorder(Color.black, 1)));
            l.setPreferredSize(new Dimension(400, 40));
            l.setMaximumSize(new Dimension(400, 40));
            l.setHorizontalAlignment(SwingConstants.CENTER);
            return l;
        }

        static JLabel activityLabel(String text){
            JLabel l = new JLabel(text);
            l.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(1,1,1,1), BorderFactory.createLineBorder(Color.black, 1)));
            l.setPreferredSize(new Dimension(400, 100));
            l.setMaximumSize(new Dimension(400, 100));
            return l;
        }

    }

}
