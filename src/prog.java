import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class prog {
    public static void main(String[] args) {
        okno nf = new okno();

    }
}
class okno extends JFrame {
    private JTextArea text;
    double p1;
    double p2;
    boolean[] dey = new boolean[4];
    private int oper = 0;

    private void btnClick(JButton btn){
        String str = btn.getText();
        if(str == "C"){
            text.setText("");
            p1 = 0;
            p2 = 0;
            for (int i = 0; i < 4; i++) {
                dey[i] = false;
            }
            System.out.println(p1 + " " + p2);
        }
        else if(str == "="){
          //  p2 = Integer.parseInt(text.getText());
            if(oper == 2){
                p1 = p1-p2;
                text.setText(text.getText() + " = " + p1);
                dey[1] = false;
            }
            if(oper == 1) {
                p1 = p1+p2;
                text.setText(text.getText() + " = " + p1);
                dey[0] = false;
            }
            if(oper == 3) {
                p1 = p1 * p2;
                text.setText(text.getText() + " = " + p1);
                dey[2] = false;
            }
            if(oper == 4) {
                p1 = p1 / p2;
                text.setText(text.getText() + " = " + p1);
                dey[3] = false;
            }
        }
        else if(str == "sqrt"){
            p1 = Double.parseDouble(text.getText());
            text.setText("" + Math.sqrt(p1));
        }
        else if(str == "^2"){
            p1 = Double.parseDouble(text.getText());
            text.setText("" + (p1*p1));
        }
        else if(str == "+"){
            dey[0] = true;
            text.setText(text.getText() + " + ");
        }
        else if(str == "-"){
            dey[1] = true;
            text.setText(text.getText() + " - ");
        }
        else if(str == "*"){
            dey[2] = true;
            text.setText(text.getText() + " * ");
        }
        else if(str == "/"){
            dey[3] = true;
            text.setText(text.getText() + " / ");
        }
        else {
            if(dey[0] == true){
                p2 = Double.parseDouble(str);
                text.setText(text.getText() + str);
                System.out.println("p2= " + p2);
                oper = 1;
            }if(dey[1] == true){
                p2 = Double.parseDouble(str);
                text.setText(text.getText() + str);
                System.out.println("p2= " + p2);
                oper = 2;
            }if(dey[2] == true){
                p2 = Double.parseDouble(str);
                text.setText(text.getText() + str);
                System.out.println("p2= " + p2);
                oper = 3;
            }if(dey[3] == true){
                p2 = Double.parseDouble(str);
                text.setText(text.getText() + str);
                System.out.println("p2= " + p2);
                oper = 4;
            }
            else if(dey[0] == false && dey[1] == false && dey[2] == false && dey[3] == false  ) {
                p1 = Double.parseDouble(str);
                System.out.println("p1 = " + p1);
                text.setText(text.getText() + str);
            }

        }
    }

    public okno() {
        Container cont = getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        Font btnFont = new Font("serif", 0, 20);
        Font textFont = new Font("arial", 2, 60);
        JButton[] btn = new JButton[18];
        cont.add(panel);
        setBounds(0, 0, 800, 595);
        for (int i = 0; i < 18; i++) {
            btn[i] = new JButton();
            btn[i].setSize(200, 100);
            btn[i].setFont(btnFont);
            btn[i].set

            btn[i].addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    btnClick((JButton) e.getSource());

                }
            });
            panel.add(btn[i]);
        }
        btn[0].setLocation(200, 360 );
        btn[1].setLocation(0, 60);
        btn[2].setLocation(200, 60);
        btn[3].setLocation(400, 60);
        btn[4].setLocation(0, 160);
        btn[5].setLocation(200, 160);
        btn[6].setLocation(400, 160);
        btn[7].setLocation(0, 260);
        btn[8].setLocation(200, 260);
        btn[9].setLocation(400, 260);
        btn[10].setLocation(600, 360);
        btn[11].setLocation(600, 260);
        btn[12].setLocation(600, 60);
        btn[13].setLocation(600, 160);
        btn[14].setLocation(400, 360);
        btn[15].setLocation(0, 360);
        btn[16].setLocation(0, 460);
        btn[17].setLocation(200, 460);

        for (int j = 0; j < 10; j++) {
            btn[j].setText("" + j);

        }
        btn[10].setText("+");
        btn[11].setText("-");
        btn[12].setText("/");
        btn[13].setText("*");
        btn[14].setText("=");
        btn[15].setText("C");
        btn[16].setText("^2");
        btn[17].setText("sqrt");
        text = new JTextArea();
        text.setFont(textFont);
        text.setBounds(000, 00, 800, 60);
        text.setForeground(Color.BLACK);
        text.setBackground(Color.white);
        panel.add(text);
        setTitle("калькулятор");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
