import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class InformationAboutDiscScheduling{
    public InformationAboutDiscScheduling(){
        JFrame jframe = new JFrame("Inoformation About Disc Scheduling");
        jframe.setVisible(true);
        jframe.setLayout(null);
        jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("background-green-cells-green-schedule-hd-wallpaper-preview.jpg"); // Replace with your image file path
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);
        panel.setBounds(0, 0, jframe.getWidth(), jframe.getHeight());
        jframe.add(panel);
        JLabel headingLabel = new JLabel("Disc Scheduling",SwingConstants.CENTER);
        headingLabel.setBounds(0,10,panel.getWidth(),40);
        headingLabel.setFont(new Font("Times New Roman", Font.BOLD,36));
        headingLabel.setForeground(new Color(0, 0, 100));
        panel.add(headingLabel);

        String definition = "Disk scheduling is the process of determining the order in which read and write requests to a disk are serviced by an operating system. It involves managing the movement of the disk's read/write head to access data efficiently. The primary goal of disk scheduling is to minimize the seek time, which is the time it takes for the read/write head to move to the location of the requested data on the disk.\nDisk scheduling algorithms aim to optimize the disk's performance by considering factors such as the location of data on the disk, the order of incoming requests, and the characteristics of the disk hardware. These algorithms help reduce access latency and improve overall system efficiency by ensuring that data requests are processed in an optimal manner.\nDisk scheduling algorithms can vary in complexity and efficiency, and different algorithms may be suitable for different types of workloads or disk access patterns. Common disk scheduling algorithms include First-Come, First-Served (FCFS), Shortest Seek Time First (SSTF), SCAN, C-SCAN, LOOK, and others.";
        String keyPoints = "1.Disk Scheduling: The process of determining the order in which read and write requests to a disk are serviced.\n\n2.Seek Time: The time it takes for the disk's read/write head to move to the location of the requested data on the disk. Minimizing seek time is a primary goal of disk scheduling.\n\n3.Rotational Latency: The time it takes for the desired sector of the disk to rotate under the read/write head after the head is positioned over the correct track. It's another component of access time in addition to seek time.\n\n4.Disk Scheduling Algorithm: A method or strategy used to determine the order in which disk requests are serviced. Common algorithms include FCFS (First-Come, First-Served), SSTF (Shortest Seek Time First), SCAN, C-SCAN, LOOK, and others.\n\n5.Access Time: The total time required to complete a read or write operation, which includes both seek time and rotational latency.";

        JLabel defLabel = new JLabel("Definition:");
        defLabel.setBounds(20,40,400,30);
        defLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
        defLabel.setForeground(new Color(230, 230, 250));
        panel.add(defLabel);

        JTextArea defArea = new JTextArea();
        defArea.setBounds(20,80,jframe.getWidth() - 50,180);
        defArea.setText(definition);
        defArea.setLineWrap(true);
        defArea.setWrapStyleWord(true);
        defArea.setEditable(false);
        defArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        defArea.setBackground(new Color(0, 0, 0, 0));
        defArea.setForeground(new Color(255, 215, 0));
        panel.add(defArea);

        JLabel keyLabel = new JLabel("Some key terms to remember:");
        keyLabel.setBounds(20,270,450,30);
        keyLabel.setFont(new Font("Times New Roman", Font.PLAIN,26));
        keyLabel.setForeground(new Color(230, 230, 250));
        panel.add(keyLabel);

        JTextArea keyArea = new JTextArea();
        keyArea.setBounds(20,310,jframe.getWidth() - 50,280);
        keyArea.setText(keyPoints);
        keyArea.setLineWrap(true);
        keyArea.setWrapStyleWord(true);
        keyArea.setEditable(false);
        keyArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        keyArea.setBackground(new Color(0,0,0,0));
        keyArea.setForeground(new Color(255, 215, 0));
        panel.add(keyArea);

        JButton nextButton = new JButton("Next");
        nextButton.setBounds(600,650,120,30);
        nextButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        nextButton.setForeground(new Color(255, 215, 0));
        nextButton.setBackground(new Color(0,0,100));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                SwingUtilities.invokeLater(new Runnable(){
                    @Override
                    public void run(){
                        new InputOutputGUI();
                    }
                });
                jframe.dispose();
            }
        });
        panel.add(nextButton);
        jframe.repaint();
    }
}
public class discScheduling {

    public static void main(String args[]){
        InformationAboutDiscScheduling info = new InformationAboutDiscScheduling();
    }

}
class InputOutputGUI{
    private int headPosition;
    private int noOfDiscRequest;
    private int positionArray[];
    public InputOutputGUI(){
        JFrame jframe = new JFrame("Input Output Screen");
        jframe.setLayout(null);
        jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("4f3f1b2dc3e53f255ca2343f1485f0e8.jpg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);
        panel.setBounds(0, 0, jframe.getWidth(), jframe.getHeight());
        jframe.add(panel);

        JLabel headingLabel = new JLabel("FCFS Disc Scheduling",SwingConstants.CENTER);
        headingLabel.setBounds(0,20,panel.getWidth(),40);
        headingLabel.setForeground(new Color(0,0,0));
        headingLabel.setFont(new Font("Times New Roman", Font.BOLD,36));
        panel.add(headingLabel);

        JLabel jlabel = new JLabel("Enter the number of  position of head: ");
        jlabel.setBounds(20,80,460,30);
        jlabel.setForeground(new Color(0,0,0));
        jlabel.setFont(new Font("Time New Roman", Font.PLAIN, 26));
        panel.add(jlabel);

        JTextField inhead = new JTextField();
        inhead.setBounds(500,80,250,30);
        inhead.setFont(new Font("Times New Roman", Font.PLAIN,26));
        inhead.setForeground(Color.BLACK);
        panel.add(inhead);

        JLabel jlabel2 = new JLabel("Enter the number of disc requests: ");
        jlabel2.setBounds(20,140,460,30);
        jlabel2.setForeground(new Color(0,0,0));
        jlabel2.setFont(new Font("Time New Roman", Font.PLAIN, 26));
        panel.add(jlabel2);

        JTextField numdisc = new JTextField();
        numdisc.setBounds(500,140,250,30);
        numdisc.setFont(new Font("Times New Roman", Font.PLAIN,26));
        numdisc.setForeground(Color.BLACK);
        panel.add(numdisc);

        JLabel jlabel3 = new JLabel("Enter the disc request positions: ");
        jlabel3.setBounds(20,200,460,30);
        jlabel3.setForeground(new Color(0,0,0));
        jlabel3.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        panel.add(jlabel3);

        JTextField posDisc = new JTextField();
        posDisc.setBounds(500,200,250,30);
        posDisc.setFont(new Font("Times New Roman", Font.PLAIN,26));
        posDisc.setForeground(Color.BLACK);
        panel.add(posDisc);

        JLabel jLabel = new JLabel("Output:",SwingConstants.LEFT);
        jLabel.setBounds(20,300,panel.getWidth(),35);
        jLabel.setFont(new Font("Times New Roman", Font.BOLD,30));
        jLabel.setForeground(Color.BLACK);
        panel.add(jLabel);

        JTextArea jTextArea = new JTextArea();
        jTextArea.setBounds(20,350,600,150);
        jTextArea.setFont(new Font("Times New Roman", Font.PLAIN,20));
        jTextArea.setEditable(false);
//        jTextArea.setOpaque(false);
        jTextArea.setForeground(Color.BLACK);
        panel.add(jTextArea);

        JButton submitButton = new JButton("Calculate");
        submitButton.setBounds(550,250,130,30);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Times New Roman", Font.PLAIN,20));
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                headPosition = Integer.parseInt(inhead.getText());
                noOfDiscRequest = Integer.parseInt(numdisc.getText());
                positionArray = new int[noOfDiscRequest];
                String postions = posDisc.getText();
                String [] posString = postions.split(",");
                for(int i = 0 ; i < noOfDiscRequest; i++){
                    positionArray[i] = Integer.parseInt(posString[i]);
                }
                Solution gui = new Solution(headPosition,noOfDiscRequest,positionArray);
                gui.calculateMovement();
                String str ="Total Seek Count: " +gui.getTotalMovement() +"\nSeek Sequence: \n"+ gui.seekSequence;
                jTextArea.setText(str);
            }
        });
        JButton jButton = new JButton("Home");
        jButton.setBounds(550,650,130,30);
        jButton.setFont(new Font("Times New Roman", Font.PLAIN,20));
        jButton.setForeground(Color.WHITE);
        jButton.setBackground(Color.BLACK);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OS os = new OS();
                jframe.dispose();
            }
        });
        panel.add(jButton);
    }
}

class Solution{
    int totalMovement = 0;
    int headPosition;
    int noOfDiscRequest;
    int [] positionArray;
    String seekSequence = "";
    public Solution(int headPosition,int noOfDiscRequest, int positionArray[]){
        this.headPosition = headPosition;
        this.noOfDiscRequest = noOfDiscRequest;
        this.positionArray = positionArray.clone();
    }
    public int getTotalMovement() {
        return totalMovement;
    }

    public String getSeekSequence() {
        return seekSequence;
    }

    public void calculateMovement(){
        for(int i=0;i<positionArray.length ;i++){
            totalMovement+=Math.abs(positionArray[i]-headPosition);
            headPosition=positionArray[i];
        }
        for(int pos: positionArray){
            seekSequence += String.valueOf(pos);
            seekSequence += "   ";
        }
    }
}
