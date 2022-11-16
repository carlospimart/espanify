package com.example.castellar.carlos.picon.espanify;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.border.Border;



public class Main {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        frameDoms window_happy=new frameDoms();
        window_happy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        window_happy.setTitle("Espanify");

    }
}
class frameDoms extends JFrame{


    public frameDoms() throws IOException {

        setBounds(400,100, 400,400);


        add(new Lamina_Doms());

        setVisible(true);


    }


}

class Lamina_Doms extends JPanel  implements ActionListener {
    /*** Method to set a background image ***/


    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        // Draws the img to the BackgroundPanel.
       g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

    public Lamina_Doms() throws IOException {



        setLayout(new BorderLayout());

        JPanel Lamina_Boton=new JPanel();



        Idioma1=new JButton("ENGLISH", new ImageIcon(((new ImageIcon(
                "src/main/resources/UK_flag.jpg")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
        //Idioma1.setBounds(10, 10, 30, 25);
        //Idioma1.setBorder (new RoundedBorder (10));
        //Icon i=  new ImageIcon("src/main/resources/UK_flag.jpg").getImage().getScaledInstance();

        //Idioma1.setIcon(i);



        //Idioma1.setPreferredSize(new Dimension(150, 50));

        Idioma2=new JButton("ESPAÑOL");

        Idioma3=new JButton("FRANÇAIS");

        boton1=new JButton("Next Question");


        //make the button transparent
        Idioma3.setOpaque(false);
        //remove content area
        Idioma3.setContentAreaFilled(false);
        //remove the border
        Idioma3.setBorderPainted(false);

        JPanel lamina_idiomas=new JPanel();


        lamina_idiomas.add(Idioma1);

        lamina_idiomas.add(Idioma2);

        lamina_idiomas.add(Idioma3);

        add(lamina_idiomas, BorderLayout.NORTH);

        Lamina_Boton.add(boton1);



        boton1.addActionListener(this);

        ActionListener OperateEnglish=new Operator1();

        ActionListener OperateSpanish=new Operator2();

        ActionListener OperateFrancais=new Operator3();



        Idioma1.addActionListener(OperateEnglish);

        Idioma2.addActionListener(OperateSpanish);

        Idioma3.addActionListener(OperateFrancais);



            add(Lamina_Boton, BorderLayout.CENTER);


        etiqueta1=new JLabel("...");

        Lamina_Boton.add(etiqueta1);


        JPanel  Lamina_Etiqueta=new JPanel();

        add(Lamina_Etiqueta, BorderLayout.SOUTH);



        language="ENGLISH";


        img = ImageIO.read(new File("src/main/resources/UK_flag.jpg"));

    }


    class Operator1 implements ActionListener{


        public void actionPerformed(ActionEvent c) {

            boton1.setText("Next Question");

            language=Idioma1.getText();



        }
    }

    class Operator2 extends JPanel implements ActionListener{


        public void actionPerformed(ActionEvent c) {

            boton1.setText("Haz una pregunta");

            language=Idioma2.getText();



        }
    }

    class Operator3 implements ActionListener{


        public void actionPerformed(ActionEvent c) {

            boton1.setText("Pose une question");

            language=Idioma3.getText();


        }
    }

    public void actionPerformed(ActionEvent e){

        String[] preguntas = new String[9];

        preguntas[0]= "Si un dia ocurriera que por accidente te apuntaras un dedo, y descubrieras que en el interior de tus dedos solo hay dispositivos electronicos, �Cual seria tu reaccion? ";
        preguntas[1]= "Si tuvieras la ocasion de hablar con jesucristo, y el te concediera tres preguntas, �cuales serian?";
        preguntas[2]= "� ?";
        preguntas[3]= "�?";
        preguntas[4]= "�agora?";
        preguntas[5]= "�La riqueza, la atraccion sexual total o el aplauso del publico?";
        preguntas[6]= "En una pelea entre Alien y Terminator, �Quien ganar�a?";
        preguntas[7]= "En una pelea entre Alien y Terminator, �Quien ganar�a?";
        preguntas[8]= "En una pelea entre Alien y Terminator, �Quien ganar�a?";


        String[] questions = new String[9];

        questions[0]="IS IT BETTER TO GIVE MONEY TO THE GOVERMENT OR TO CHARITY?";
        questions[1]="IN WHAT WAYS ARE YOU PRONE TO ADDICTION?";
        questions[2]="WOULD YOU LIKE TO LIVE MORE IN YOUR BODY OR MORE IN YOUR HEAD?";
        questions[3]="WHEN YOU LOOK IN THE MIRROR, WHAT'S THE FIRST THING YOU CHECK?";
        questions[4]="IF YOU HAD TO WRITE A BOOK, WHAT WOULD IT BE ABOUT?";
        questions[5]="HOW COULD OLDER PEOPLE BE VALUED MORE?";
        questions[6]="WHO OR WHAT MIGHT HAVE STOPPED YOU FROM REALISING YOUR FULL POTENTIAL?";
        questions[7]="ARE YOU COMPETITIVE?";
        questions[8]="WHICH OF YOUR EX-PARTNERS HURT YOU THE MOST?";


        String[] DesQuestions = new String[9];

        DesQuestions[0]="Est-ce que vous avez d�j� visit� la France?";
        DesQuestions[1]="Si vous aviez tout l'argent du monde mais deviez tout de m�me travailler, quel job choisiriez-vous ?";
        DesQuestions[2]="Quel est votre plus grand regret dans la vie � ce jour?";
        DesQuestions[3]="Que diraient vos proches � propos de vous lors de votre enterrement?";
        DesQuestions[4]="v";
        DesQuestions[5]="b";
        DesQuestions[6]="c";
        DesQuestions[7]="c";
        DesQuestions[8]="g";

        int a = (int)(Math.random()*9);


        if(language.equals("ENGLISH")){


            etiqueta1.setText(questions[a]);



        }else if(language.equals("ESPAÑOL")){


            etiqueta1.setText(preguntas[a]);



        }else if(language.equals("FRANÇAIS")){

            etiqueta1.setText(DesQuestions[a]);
        }

    }

    private static class RoundedBorder implements Border {

        private int radius;


        RoundedBorder(int radius) {
            this.radius = radius;
        }


        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }


        public boolean isBorderOpaque() {
            return true;
        }


        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }
    Image img;
    JLabel etiqueta1;

    JButton Idioma1;

    JButton Idioma2;

    JButton Idioma3;

    String language;

    JButton boton1;



}