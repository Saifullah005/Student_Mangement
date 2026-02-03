import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class GUI implements ActionListener {
    String name;
    int Id;
    double marks;

    JFrame frame;
    JPanel p1;
    JPanel p2;
    JPanel p3;
    JButton add;
    JButton display;
    JLabel na;
    JLabel d;
    JLabel ma;
    JTextField n;
    JTextField id;
    JTextField m;
    JTextArea a;
    JScrollPane pane;
    public GUI() {

        frame = new JFrame("Student records");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600 , 600);
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();

        add = new JButton("Add");
        display = new JButton("Student Info");
        na = new JLabel("Name");
        d = new JLabel("ID");
        ma = new JLabel("Marks");
        
        n = new JTextField();
        id = new JTextField();
        m = new JTextField();
        
        a = new JTextArea();
        pane = new JScrollPane(a);
        p1.setLayout(new GridLayout(3, 2));
        p1.add(na);
        p1.add(n);
        p1.add(d);
        p1.add(id);
        p1.add(ma);
        p1.add(m);

        p2.add(add);
        p2.add(display);

        a.setEditable(false);
        
    frame.setLayout(new BorderLayout());

    frame.add(p1, BorderLayout.NORTH);   
    frame.add(pane, BorderLayout.CENTER);
    frame.add(p2, BorderLayout.SOUTH);   

        add.addActionListener(this);
        display.addActionListener(this);

        frame.setVisible(true);
    }
    
    Manager record = new Manager();
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == add){
            
            if(id.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(frame, "id field is empty");
                return;
            }
            
            try
            {this.Id = Integer.parseInt(id.getText());}
            catch(Exception ex){
                JOptionPane.showMessageDialog(frame, "Id is not in format (int)");
                return;
            }

            
            if(m.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Marks field is empty");
                return;
            }

            try
            {this.marks = Double.parseDouble(m.getText());}
            catch(Exception ex){
                JOptionPane.showMessageDialog(frame,"Enter the marks in correct format (Double)");
                return;
            }
            
            
            if(n.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Name field is empty");
                return;
            }

            this.name = n.getText();
          
            record.addStudent(new Student(Id, marks, name));
        }
        else if(e.getSource() == display){
            String s = record.display();
            a.setText(s);
        }

        id.setText("");
        n.setText("");
        m.setText("");
    }
}