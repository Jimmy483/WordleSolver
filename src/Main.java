import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        new Main();

    }

    public Main(){
        gui();
    }

    public void gui(){
        JFrame jFrame=new JFrame();
        jFrame.setSize(400,400);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setTitle("Wordle Solver");
        jFrame.setVisible(true);

        JPanel jPanel=new JPanel();
        jPanel.setLayout(null);

        jFrame.add(jPanel);

        JTextField saveTextF=new JTextField();
        saveTextF.setBounds(100,30,150,50);
        //saveTextF.setLocation(100,30);
        saveTextF.setFont(new Font("Arial",Font.BOLD,40));
        jPanel.add(saveTextF);

        JTextField fetchTextF=new JTextField();
        fetchTextF.setBounds(100,180,150,50);
        //fetchTextF.setLocation(100,180);
        fetchTextF.setFont(new Font("Arial",Font.BOLD,40));
        jPanel.add(fetchTextF);

        JButton saveButton=new JButton();
        saveButton.setText("Save");
        saveButton.setBounds(120,100,120,30);
//        saveButton.setLocation(120,100);
        jPanel.add(saveButton);

        JButton fetchButton=new JButton();
        fetchButton.setText("Fetch");
        fetchButton.setBounds(40,250,80,30);
        //fetchButton.setLocation(40,250);
        jPanel.add(fetchButton);

        JButton previousButton=new JButton();
        previousButton.setText("Previous");
        previousButton.setBounds(130,250,90,30);
        //previousButton.setLocation(130,250);
        jPanel.add(previousButton);

        JButton nextButton=new JButton();
        nextButton.setText("Next");
        nextButton.setBounds(230,250,80,30);
        //nextButton.setLocation(230,250);
        jPanel.add(nextButton);
        jPanel.revalidate();
        jPanel.repaint();
    }

}
