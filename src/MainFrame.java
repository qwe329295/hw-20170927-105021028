import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame{
    private JLabel lab1 = new JLabel("Hit:0");
    private JLabel labgun = new JLabel();
    private JLabel labbullet = new JLabel();
    private JLabel labtarget = new JLabel();
    private JButton btnAuto =new JButton("Auto move");
    private JButton btnleft=new JButton("往左飄移");
    private JButton btnfire =new JButton("fire");
    private JButton btnright =new JButton("往右飄移");
    private JButton btnexit =new JButton("exit");
    private Timer t1fire;
    private Timer t2;
    private int labX=250,labY=350;
    private int bulletX,bulletY,count=0;
    private Random rdm = new Random();
            ImageIcon img=new ImageIcon("sun.jpg");
            ImageIcon imgbullet=new ImageIcon("bullet.jpg");
            ImageIcon imggun=new ImageIcon("gun.jpg");
    private boolean flag=(true);

            private Container cp;
    public  MainFrame(){
        init();
    }
    public void init(){
        cp =this.getContentPane();
        this.setBounds(150,200,700,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        cp.setLayout( null);
        cp.add(labgun);
        labgun.setIcon(imggun);
        labgun.setBounds(labX,labY,100,66);

        cp.add(labbullet);
        labbullet.setIcon(imgbullet);
        labbullet.setBounds(1000,100,100,100);
        labbullet.setVisible(false);
        cp.add(labtarget);
        labtarget.setIcon(img);
        labtarget.setBounds(rdm.nextInt(600)+1,50,100,50);


        cp.add(lab1);
        lab1.setBounds(10,450,80,50);
        cp.add(btnAuto);
        btnAuto.setBounds(10,500,100,50);
        cp.add(btnleft);
        btnleft.setBounds(220,500,100,50);
        cp.add(btnfire);
        btnfire.setBounds(340,500,100,50);
        btnfire.setBackground(new Color(255, 52, 3));
        btnfire.setForeground(Color.WHITE);
        cp.add(btnright);
        btnright.setBounds(460,500,100,50);
        cp.add(btnexit);
        btnexit.setBounds(580,500,100,50);


        btnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        btnleft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               labX-=10;
               labgun.setLocation(labX,350);
               t2.stop();
            }
        });
        btnfire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labbullet.setVisible(true);
                bulletX=labgun.getX();
                bulletY=labgun.getY();
                t1fire.start();
            }
        });


        btnright.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               labX+=10;
               labgun.setLocation(labX,350);
               t2.stop();
            }
        });
        btnAuto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               t2.start();
            }
        });


        t1fire =new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bulletY-=10;
                labbullet.setLocation(bulletX,bulletY);
                if(bulletX<labtarget.getX()+labtarget.getWidth()&&bulletX>labtarget.getX()&&bulletY==50){
                    count++;
                    lab1.setText("Hit:"+count);
                    labtarget.setLocation(rdm.nextInt(600)+1,50);
                }
                if(bulletY <= 0){
                    labbullet.setVisible(false);
                    labbullet.setLocation(bulletX,bulletY);
                    labY=labgun.getY();
                    t1fire.stop();
                }
            }

        });
        t2 =new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flag){
                    labX+=10;
                    labgun.setLocation(labX,350);
                    if(labX>MainFrame.this.getWidth()-120){
                        flag=false;
                    }
                }else if(!flag){
                    labX-=10;
                    labgun.setLocation(labX,350);
                    if(labX<0){
                        flag=true;
                    }
                }
            }
        });
    }
}
