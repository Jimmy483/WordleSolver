import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Main implements ActionListener {
    public static void main(String[] args) {
        new Main();

    }

    JFrame jf;
    JButton saveButton;
    JTextField saveTextF;
    JButton fetchButton;
    JButton previousButton;
    JButton nextButton;
    JTextField fetchTextF;
    JTextField jFirst;
    JTextField jSecond;
    JTextField jThird;
    JTextField jFourth;
    JTextField jFifth;
    ArrayList<String> wordsArray;
    char[] letters=new char[5];
    int index=0;
    public Main(){
        gui();
    }

    public void gui(){
        wordsArray=new ArrayList<>();

        JFrame jFrame=new JFrame();
        jFrame.setSize(400,500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setTitle("Wordle Solver");
        jFrame.setVisible(true);

        JPanel jPanel=new JPanel();
        jPanel.setLayout(null);

        jFrame.add(jPanel);

        saveTextF=new JTextField();
        saveTextF.setBounds(100,30,150,50);
        //saveTextF.setLocation(100,30);
        saveTextF.setFont(new Font("Arial",Font.BOLD,40));
        jPanel.add(saveTextF);

        fetchTextF=new JTextField();
        fetchTextF.setBounds(100,280,150,50);
        fetchTextF.setEnabled(false);
        //fetchTextF.setLocation(100,180);
        fetchTextF.setFont(new Font("Arial",Font.BOLD,40));
        jPanel.add(fetchTextF);

        saveButton=new JButton();
        saveButton.setText("Save");
        saveButton.setBounds(120,100,120,30);
//        saveButton.setLocation(120,100);
        jPanel.add(saveButton);

        fetchButton=new JButton();
        fetchButton.setText("Search");
        fetchButton.setBounds(40,350,80,30);
        //fetchButton.setLocation(40,250);
        jPanel.add(fetchButton);

        previousButton=new JButton();
        previousButton.setText("Previous");
        previousButton.setBounds(130,350,90,30);
        previousButton.setEnabled(false);
        //previousButton.setLocation(130,250);
        jPanel.add(previousButton);

        nextButton=new JButton();
        nextButton.setText("Next");
        nextButton.setBounds(230,350,80,30);
        //nextButton.setLocation(230,250);
        nextButton.setEnabled(false);
        jPanel.add(nextButton);

        JLabel jLabel=new JLabel("Enter the letters you know of the");
        jLabel.setBounds(55,140,400,24);
        jLabel.setFont(new Font("Arial",Font.ITALIC,20));
        jPanel.add(jLabel);
        JLabel jLabel1=new JLabel("word that you are trying to find");
        jLabel1.setBounds(55,170,400,24);
        jLabel1.setFont(new Font("Arial",Font.ITALIC,20));
        jPanel.add(jLabel1);

        jFirst=new JTextField();
        jFirst.setBounds(55,220,50,50);
        jFirst.setFont(new Font("Arial",Font.PLAIN,40));
        jPanel.add(jFirst);

        jSecond=new JTextField();
        jSecond.setBounds(105,220,50,50);
        jSecond.setFont(new Font("Arial",Font.PLAIN,40));
        jPanel.add(jSecond);

        jThird=new JTextField();
        jThird.setFont(new Font("Arial",Font.PLAIN,40));
        jThird.setBounds(155,220,50,50);
        jPanel.add(jThird);

        jFourth=new JTextField();
        jFourth.setFont(new Font("Arial",Font.PLAIN,40));
        jFourth.setBounds(205,220,50,50);
        jPanel.add(jFourth);

        jFifth=new JTextField();
        jFifth.setBounds(255,220,50,50);
        jFifth.setFont(new Font("Arial",Font.PLAIN,40));
        jPanel.add(jFifth);

        jPanel.revalidate();
        jPanel.repaint();



        saveButton.addActionListener(this);
        fetchButton.addActionListener(this);
        nextButton.addActionListener(this);
        previousButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==saveButton){
            saveBtn();
        }
        if(e.getSource()==fetchButton){
            fetchBtn();
        }
        if(e.getSource()==nextButton){
            nextBtn();
        }
        if(e.getSource()==previousButton){
            previousBtn();
        }
    }

    public void nextBtn(){
        //if(index<wordsArray.size()){
        fetchTextF.setText(wordsArray.get(index+1));
        index++;
        previousButton.setEnabled(true);
        if(index+1>=wordsArray.size()){
            nextButton.setEnabled(false);
        }


    }

    public void saveBtn(){
        String word=saveTextF.getText().toLowerCase().replace(" ","");
        if(word.length()>5||word.length()<5){
            JOptionPane.showMessageDialog(jf,"The length of the word should be exactly 5");
            return;
        }
        //String word=saveTextF.getText().toLowerCase().replace(" ","");
        try {
            BufferedWriter bW=new BufferedWriter(new FileWriter("words.txt",true));
            bW.write(word+"\n");
            bW.close();
            //bR.close();
            jf=new JFrame();
            JOptionPane.showMessageDialog(jf,"Word Added");
            saveTextF.setText("");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void previousBtn(){
        fetchTextF.setText(wordsArray.get(index-1));
        index--;
        if(index==0){
            previousButton.setEnabled(false);
        }
        nextButton.setEnabled(true);
    }

    public void fetchBtn(){
        if(wordsArray.size()!=0){
            wordsArray.clear();
            fetchTextF.setText("");
            previousButton.setEnabled(false);
            nextButton.setEnabled(false);
            index=0;
        }



        if(!jFirst.getText().replace(" ","").equals("")){
            char f=jFirst.getText().replace(" ","").substring(0,1).charAt(0);
            jFirst.setText(String.valueOf(f));
            letters[0]=f;
        }
        if(!jSecond.getText().replace(" ","").equals("")){
            char s=jSecond.getText().replace(" ","").substring(0,1).charAt(0);
            jSecond.setText(String.valueOf(s));
            letters[1]=s;
        }
        if(!jThird.getText().replace(" ","").equals("")){
            char t=jThird.getText().replace(" ","").substring(0,1).charAt(0);
            jThird.setText(String.valueOf(t));
            letters[2]=t;
        }
        if(!jFourth.getText().replace(" ","").equals("")){
            char f=jFourth.getText().replace(" ","").substring(0,1).charAt(0);
            jFourth.setText(String.valueOf(f));
            letters[3]=f;
        }
        if(!jFifth.getText().replace(" ","").equals("")){
            char f=jFifth.getText().replace(" ","").substring(0,1).charAt(0);
            jFifth.setText(String.valueOf(f));
            letters[4]=f;
        }


        char l='g';
        System.out.println(letters[1]);
        if(l==letters[0]){
            System.out.println("treeeee");
        }
        try {
            BufferedReader bR=new BufferedReader(new FileReader("words.txt"));
            String line="";
            boolean addOr=true;
            while((line= bR.readLine())!=null){
                for(int i=0;i<5;i++){
                    if(letters[i]!='\0'){
                        if(line.toLowerCase().charAt(i)!=letters[i]){
                            addOr=false;
                        }
                    }

                }
                if(addOr==true){
                    wordsArray.add(line);
                }
                addOr=true;

            }
            bR.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        System.out.println(wordsArray);
        if(wordsArray.size()!=0){
            fetchTextF.setText(wordsArray.get(0));
            //nextButton.setEnabled(true);
        }
        if(wordsArray.size()>0){
            nextButton.setEnabled(true);
        }else {
            JOptionPane.showMessageDialog(jf,"Oops no result found");
        }



    }
}
