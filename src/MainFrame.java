import javax.swing.*;
import java.awt.*;
public class MainFrame extends JFrame{
    private JLabel lab1 = new JLabel("Hit:0");
    private JLabel lab2 = new JLabel();
    private JLabel lab3 = new JLabel();
    private JLabel lab4 = new JLabel();
    private JLabel lab5 = new JLabel();
    private JButton btnAuto =new JButton("Auto move");
    private JButton btnleft=new JButton("<-");
    private JButton btnfire =new JButton("fire");
    private JButton btnright =new JButton("->");
    private JButton btnexit =new JButton("exit");
    private JPanel jpan1=new JPanel(new GridLayout(1,1,1,1));
    private JPanel jpan2=new JPanel(new GridLayout(2,5,1,1));
            ImageIcon img=new ImageIcon("sun.jpg");
            ImageIcon imgbullet=new ImageIcon("sun.jpg");
            ImageIcon imgtriangle=new ImageIcon("sun.jpg");

            private Container cp;
    public  MainFrame(){
        init();
    }
    public void init(){
        cp =this.getContentPane();
        this.setBounds(150,200,600,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        cp.setLayout( new BorderLayout(5,5));
        cp.add(jpan1,BorderLayout.CENTER);
        cp.add(jpan2,BorderLayout.SOUTH);


        jpan2.add(lab1);
        jpan2.add(btnleft);
        jpan2.add(btnfire);
        jpan2.add(btnright);
        jpan2.add(lab2);
        jpan2.add(btnAuto);
        jpan2.add(lab3);
        jpan2.add(lab4);
        jpan2.add(lab5);
        jpan2.add(btnexit);



    }
}
