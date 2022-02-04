import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import java.util.ArrayList;

class EntryWriter extends JPanel {
    // Class that allow user to write and save entries.

    EntryWriter(ArrayList<Entry> entries){
        init(this);
        final GhostTextField dateField = createDateField();
        final JTextArea activityField = createActivityField();

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        add(dateField, c);

        c.gridx = 1;
        c.gridy = 0;
        add(createAddButton(entries, dateField, activityField), c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        add(activityField, c);
    }

    static private void init(JPanel p){
        p.setBackground(Color.gray);
        p.setLayout(new GridBagLayout());
        p.setAlignmentX(SwingConstants.CENTER);
        p.setPreferredSize(new Dimension(400, 140));
        p.setMinimumSize(new Dimension(400, 140));
    }

    static private GhostTextField createDateField(){
        // creates text field for date
        GhostTextField t = new GhostTextField("YYYY-MM-DD");
        t.setBackground(Color.gray);
        t.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(1,1,1,1), BorderFactory.createLineBorder(Color.black, 1)));
        t.setPreferredSize(new Dimension(360, 40));
        t.setMaximumSize(new Dimension(360, 40));
        t.setHorizontalAlignment(SwingConstants.CENTER);
        t.setVisible(true);
        return t;
    }

    static private JTextArea createActivityField(){
        // creates text area for substance of entries (activities)
        JTextArea t = new JTextArea();
        t.setBackground(Color.gray);
        t.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(1,1,1,1), BorderFactory.createLineBorder(Color.black, 1)));
        t.setPreferredSize(new Dimension(400, 100));
        t.setMinimumSize(new Dimension(400, 100));
        t.setVisible(true);
        return t;
    }

    static private JButton createAddButton(ArrayList<Entry> entries, JTextField d, JTextArea af){
        // creates button that will save and add entry.
        JButton b = new JButton("+");
        b.setPreferredSize(new Dimension(40,40));
        b.setMaximumSize(new Dimension(40,40));
        b.setFocusPainted(false);
        b.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(1,1,1,1), BorderFactory.createSoftBevelBorder(0, Color.gray, Color.darkGray)));
        b.setBackground(Color.gray);
        b.addActionListener((a) -> {
            LocalDate date;
            try {
                date = LocalDate.parse(d.getText());
            }
            catch (Exception e) {
                return;
            }

            entries.add(new Entry(date, af.getText()));
        });
        b.setVisible(true);
        return b;
    }

    private static class GhostTextField extends JTextField{
        // class that modifies JTextField to add to it ghost text.
        GhostTextField(final String ghostText){
            super(ghostText);
            addFocusListener(new FocusListener() {

                @Override
                public void focusLost(FocusEvent e) {
                    if(getText().isEmpty()) {
                        setText(ghostText);
                    }
                }

                @Override
                public void focusGained(FocusEvent e) {
                    if(getText().equals(ghostText)) {
                        setText("");
                    }
                }
            });
        }
    }

}