import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.util.ArrayList;

public class EntryDisplay extends JPanel {

    EntryDisplay(ArrayList<Entry> entries){
        init(this);
    }

    static private void init(JPanel p){
        p.setBackground(Color.gray);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setPreferredSize(new Dimension(400, 620));
        p.setMinimumSize(new Dimension(420, 660));
        p.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(1,1,1,1), BorderFactory.createLineBorder(Color.black, 1)));
    }


    private static class SingleEntryDisplay extends JPanel{

        SingleEntryDisplay(Entry entry){
            init(this);
        }

        static private void init(JPanel p){
            p.setBackground(Color.gray);
            p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
            p.setPreferredSize(new Dimension(400, 620));
            p.setMinimumSize(new Dimension(420, 660));
            p.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(1,1,1,1), BorderFactory.createLineBorder(Color.black, 1)));
        }
    }

}
