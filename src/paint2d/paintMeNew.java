package paint2d;     //Name of our Java Package

//Here all methods are imported.All of this method is needed to be imported when we want to work with every method
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/*Here is the main class of the program.Implementation of the program starts from there.
We can extends many components and implement many Listeners what we need to work with then we declare all the needed
variables  for this program. */
public class paintMeNew extends JPanel implements MouseListener, ActionListener, MouseMotionListener // receiving an event from mouse
{

    private static final long serialVersionUID = 1L;                                                                     // serialVersionUID
    public static int stroke = 0, eraser = 0, paintBrush = 0, pencil = 0, airBrush = 0, paintBucket = 0;
    public static int colorPicker = 0, clear = 0, rectangle = 0, oval = 0, line = 0, fillRectangle = 0, fillOval = 0, mediumLine = 0, largeLine = 0, exit = 0, set = 0, check = 0;
    public static int triangle = 2, fillTriangle = 2, halfFillCircle = 2, roundRectangle = 2, fillRoundRectangle = 2;
    private int xX1, yY1, xX2, yY2, choice = 0;             // choice
    private static final Color BACKGROUND_COLOR = Color.WHITE;  // set background of the canvas as white
    private ImageIcon img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15, img16, img17, img18, img19, img20;
    private ImageIcon shutDownIcon, openArrowIcon, musicOnIcon, musicOffIcon;
    private ImageIcon openPage, appIcon, openIcon, saveIcon, exitIcon, newIcon, aboutUsIcon, helpIcon, homeIcon, facebookIcon, gmailIcon, phoneIcon;
    private JLabel imageLabel;
    JButton button, musicOnButton, mucicOffButton, shutDownButton, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21;
    private Cursor cursor;
    private javax.swing.JLabel messageLabel;
    private JFileChooser openFileChooser, saveFileChooser;
    private BufferedImage originalBI;
    private BufferedImage newBI;
    private int[][] pixels;
    JFrame frame, frame2;
    JMenuItem open;

    private static AudioStream audios;
    private static InputStream music;
    private static int returnValue;

    //playing music work is done by the methods when we create the method call it from the main function and implements many condions to play and stop music
    public static void playMusic(String filepath) {

        try {
            music = new FileInputStream(new File(filepath));
            audios = new AudioStream(music);
            AudioPlayer.player.start(audios);

        } catch (Exception e) {

        }
    }

    /*Here is the main method of the program where constructor is called*/
    public static void main(String[] args) {

        new paintMeNew();

    }

    //Here is the constructor from where all frames,cursors,playMusic() method,buttons and menuButtons are created,implemented and added;
    paintMeNew() {

        playMusic("src\\music1.wav");

        frame2 = new JFrame("Paint(2D)");
        frame2.setSize(1217, 840);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame2.setLayout(null);
        frame2.setLocation(350, 100);

        openArrowIcon = new ImageIcon(getClass().getResource("openArrowIcon.png"));
        button = new JButton(openArrowIcon);
        button.setBounds(1050, 650, 120, 75);
        button.setBackground(Color.pink);
        button.addActionListener(this);

        musicOnIcon = new ImageIcon(getClass().getResource("musicOn.png"));
        musicOnButton = new JButton(musicOnIcon);
        musicOnButton.setBounds(20, 710, 50, 50);
        musicOnButton.setBackground(Color.pink);
        musicOnButton.addActionListener(this);

        musicOffIcon = new ImageIcon(getClass().getResource("musicOff.png"));
        mucicOffButton = new JButton(musicOffIcon);
        mucicOffButton.setBounds(20, 710, 50, 50);
        mucicOffButton.setBackground(Color.pink);
        mucicOffButton.addActionListener(this);

        shutDownIcon = new ImageIcon(getClass().getResource("shutDown.png"));
        shutDownButton = new JButton(shutDownIcon);
        shutDownButton.setBounds(85, 710, 50, 50);
        shutDownButton.setBackground(Color.pink);
        shutDownButton.addActionListener(this);

        openPage = new ImageIcon(getClass().getResource("openPage4N.jpeg"));
        imageLabel = new JLabel(openPage);
        imageLabel.setBounds(0, 0, openPage.getIconWidth(), openPage.getIconHeight());

        frame2.add(button);
        frame2.add(musicOnButton);
        frame2.add(mucicOffButton);
        frame2.add(shutDownButton);
        frame2.add(imageLabel);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame2.setVisible(true);
        button.setVisible(true);
        musicOnButton.setVisible(true);
        mucicOffButton.setVisible(false);

        frame = new JFrame("Paint(2D)");            // the title of program is set as My Drawing
        frame.setSize(1217, 840);    // the size of the frame is set to 1200w, 800h
        frame.setBackground(BACKGROUND_COLOR);  // this will set the background color
        frame.getContentPane().add(this);
        frame.setLocation(350, 100);

        cursor = new Cursor(Cursor.HAND_CURSOR);
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar); // this wll create a menu bar
        menuBar.setBackground(Color.pink);

        JMenu file = new JMenu("File");
        menuBar.add(file);

        JMenu option = new JMenu("Option");
        menuBar.add(option);

        JMenu contactUs = new JMenu("Contact Us");
        menuBar.add(contactUs);

        JMenuItem newItem = new JMenuItem("  New");
        file.add(newItem);
        file.addSeparator();
        newItem.addActionListener(this);
        newIcon = new ImageIcon("src/paint2d/newIcon.png");
        newItem.setIcon(newIcon);

        open = new JMenuItem("  Open");
        file.add(open);
        file.addSeparator();
        open.addActionListener(this);
        openIcon = new ImageIcon("src/paint2d/openIcon.png");
        open.setIcon(openIcon);

        JMenuItem save = new JMenuItem("  Save");
        file.add(save);
        file.addSeparator();
        save.addActionListener(this);
        saveIcon = new ImageIcon("src/paint2d/saveIcon.png");
        save.setIcon(saveIcon);

        JMenuItem exit = new JMenuItem("  Exit");
        file.add(exit);
        exit.addActionListener(this);
        exitIcon = new ImageIcon("src/paint2d/exitIcon.png");
        exit.setIcon(exitIcon);

        JMenuItem home = new JMenuItem("  Home");
        option.add(home);
        option.addSeparator();
        home.addActionListener(this);// this event passed to every ActionListener object that registered using addActionListener
        homeIcon = new ImageIcon("src/paint2d/homeIcon.png");
        home.setIcon(homeIcon);

        JMenuItem help = new JMenuItem("  Info");
        option.add(help);
        option.addSeparator();
        help.addActionListener(this);// this event passed to every ActionListener object that registered using addActionListener
        helpIcon = new ImageIcon("src/paint2d/infoIcon.png");
        help.setIcon(helpIcon);

        JMenuItem about = new JMenuItem("  About Us");
        option.add(about);
        about.addActionListener(this);// this event passed to every ActionListener object that registered using addActionListener
        aboutUsIcon = new ImageIcon("src/paint2d/aboutUs.png");
        about.setIcon(aboutUsIcon);

        JMenuItem phone = new JMenuItem("  Phone");
        contactUs.add(phone);
        contactUs.addSeparator();
        phone.addActionListener(this);
        phoneIcon = new ImageIcon("src/paint2d/phoneIcon.png");
        phone.setIcon(phoneIcon);

        JMenuItem facebook = new JMenuItem("  Facebook");
        contactUs.add(facebook);
        contactUs.addSeparator();
        facebook.addActionListener(this);
        facebookIcon = new ImageIcon("src/paint2d/facebookIcon.png");
        facebook.setIcon(facebookIcon);

        JMenuItem gmail = new JMenuItem("  Gmail");
        contactUs.add(gmail);
        contactUs.addSeparator();
        gmail.addActionListener(this);
        gmailIcon = new ImageIcon("src/paint2d/gmailIcon.png");
        gmail.setIcon(gmailIcon);

        appIcon = new ImageIcon(getClass().getResource("appIcon.png"));
        frame.setIconImage(appIcon.getImage());
        frame2.setIconImage(appIcon.getImage());

        img1 = new ImageIcon(getClass().getResource("pencil2.png"));
        b1 = new JButton(img1);// this button is set as Clear Drawing  
        b1.setBackground(Color.orange);

        b1.addActionListener(this);// button 1 passed to every ActionListener object that registered using addActionListener
        b1.setCursor(cursor);

        img2 = new ImageIcon(getClass().getResource("paintBrush.png"));
        b2 = new JButton(img2);
        b2.setBackground(Color.orange);
        b2.addActionListener(this);
        b2.setCursor(cursor);

        img3 = new ImageIcon(getClass().getResource("airBrush.png"));
        b3 = new JButton(img3);
        b3.setBackground(Color.orange);
        b3.addActionListener(this);
        b3.setCursor(cursor);

        img4 = new ImageIcon(getClass().getResource("paintBucket.png"));
        b4 = new JButton(img4);
        b4.setBackground(Color.orange);
        b4.addActionListener(this);
        b4.setCursor(cursor);

        img5 = new ImageIcon(getClass().getResource("colorPicker.png"));
        b5 = new JButton(img5);
        b5.setBackground(Color.orange);
        b5.addActionListener(this);
        b5.setCursor(cursor);

        img6 = new ImageIcon(getClass().getResource("eraser.png"));
        b6 = new JButton(img6);
        b6.setBackground(Color.orange);
        b6.addActionListener(this);
        b6.setCursor(cursor);

        img7 = new ImageIcon(getClass().getResource("clear.png"));
        b7 = new JButton(img7);
        b7.setBackground(Color.orange);
        b7.addActionListener(this);
        b7.setCursor(cursor);

        img8 = new ImageIcon(getClass().getResource("colors.png"));
        b8 = new JButton(img8);
        b8.setBackground(Color.orange);
        b8.addActionListener(this);
        b8.setCursor(cursor);

        img9 = new ImageIcon(getClass().getResource("oval.png"));
        b9 = new JButton(img9);
        b9.setBackground(Color.orange);
        b9.addActionListener(this);
        b9.setCursor(cursor);

        img10 = new ImageIcon(getClass().getResource("rectangle.png"));
        b10 = new JButton(img10);
        b10.setBackground(Color.orange);
        b10.addActionListener(this);
        b10.setCursor(cursor);

        // img11 = new ImageIcon(getClass().getResource("line.png"));
        img11 = new ImageIcon(getClass().getResource("roundRectangle.png"));

        b11 = new JButton(img11);
        b11.setBackground(Color.orange);
        b11.addActionListener(this);
        b11.setCursor(cursor);

        img12 = new ImageIcon(getClass().getResource("triangle.png"));
        b12 = new JButton(img12);
        b12.setBackground(Color.orange);
        b12.addActionListener(this);
        b12.setCursor(cursor);

        img13 = new ImageIcon(getClass().getResource("line.png"));
        b13 = new JButton(img13);
        b13.setBackground(Color.orange);
        b13.addActionListener(this);
        b13.setCursor(cursor);

        img14 = new ImageIcon(getClass().getResource("mediumLine.png"));
        b14 = new JButton(img14);
        b14.setBackground(Color.orange);
        b14.addActionListener(this);
        b14.setCursor(cursor);

        img15 = new ImageIcon(getClass().getResource("largeLine.png"));
        b15 = new JButton(img15);
        b15.setBackground(Color.orange);
        b15.addActionListener(this);
        b15.setCursor(cursor);

        //b16forexit
        img16 = new ImageIcon(getClass().getResource("fillCircle.png"));
        b17 = new JButton(img16);
        b17.setBackground(Color.orange);
        b17.addActionListener(this);
        b17.setCursor(cursor);

        img17 = new ImageIcon(getClass().getResource("HalfFillCircle.png"));
        b18 = new JButton(img17);
        b18.setBackground(Color.orange);
        b18.addActionListener(this);
        b18.setCursor(cursor);

        img18 = new ImageIcon(getClass().getResource("fillRectangle.png"));
        b19 = new JButton(img18);
        b19.setBackground(Color.orange);
        b19.addActionListener(this);
        b19.setCursor(cursor);

        img19 = new ImageIcon(getClass().getResource("fillRoundRectangle.png"));
        b20 = new JButton(img19);
        b20.setBackground(Color.orange);
        b20.addActionListener(this);
        b20.setCursor(cursor);

        img20 = new ImageIcon(getClass().getResource("fillTriangle.png"));
        b21 = new JButton(img20);
        b21.setBackground(Color.orange);
        b21.addActionListener(this);
        b21.setCursor(cursor);

        /*Here we add all the buttons what we created*/
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(b5);
        this.add(b6);
        this.add(b7);
        this.add(b8);
        this.add(b9);
        this.add(b10);
        this.add(b11);
        this.add(b12);
        this.add(b13);
        this.add(b14);
        this.add(b15);
        this.add(b17);
        this.add(b18);
        this.add(b19);
        this.add(b20);
        this.add(b21);


        /*receiving an event from the mouse by addMouseListner() method then it will be work for buttons.For setDefaultCloseOperation() method, 
        Program will be ended when  exit button is pressed */
        addMouseListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /*This method is created for intializing all state to zero .It is used when needed to keep all state zero in the program by 
    intializing all the drawing methods value to zero.*/
    public void allStateZero() {
        fillTriangle = 0;
        fillRoundRectangle = 0;
        fillRectangle = 0;
        halfFillCircle = 0;
        fillOval = 0;
        largeLine = 0;
        eraser = 0;
        colorPicker = 0;
        airBrush = 0;
        pencil = 0;
        paintBrush = 0;
        paintBucket = 0;
        rectangle = 0;
        oval = 0;
        line = 0;
        mediumLine = 0;
        triangle = 0;
        roundRectangle = 0;

    }

    /*Here is paintComponent() method in which we can create graphics component in which we can draw many things what we want
    and we can set a width and length for our paint which  draws only the portion what we drag from the mouse 
    and we can set a size of our drawing board */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (grid == null) {
            int w = this.getWidth();                        // width
            int h = this.getHeight();                       // height
            grid = (BufferedImage) (this.createImage(w, h));
            gc = grid.createGraphics();
            gc.setColor(Color.BLACK);

        }

        g2.drawImage(grid, 0, 168, null);

    }

    /*Here draw method is called in which we can make if else conditions of our choices so that we can can 
    implement it in our rest of the function.When one state is activated another states are remained off */
    BufferedImage grid;
    Graphics2D gc;

    public void draw() {

        if (choice == 1) {

            pencil = 2;
            paintBrush = 0;
            airBrush = 0;
            paintBucket = 0;
            eraser = 0;
            rectangle = 0;
            oval = 0;
            fillRectangle = 0;
            fillOval = 0;
            line = 0;
            mediumLine = 0;
            largeLine = 0;
            triangle = 0;
            roundRectangle = 0;
            halfFillCircle = 0;
            fillRoundRectangle = 0;
            fillTriangle = 0;

            repaint();

        } else if (choice == 2) {

            paintBrush = 2;
            pencil = 0;
            airBrush = 0;
            paintBucket = 0;
            eraser = 0;
            rectangle = 0;
            oval = 0;
            fillRectangle = 0;
            fillOval = 0;
            line = 0;
            colorPicker = 0;
            mediumLine = 0;
            largeLine = 0;
            triangle = 0;
            roundRectangle = 0;
            halfFillCircle = 0;
            fillRoundRectangle = 0;
            fillTriangle = 0;
            repaint();

        } else if (choice == 3) {
            airBrush = 2;
            pencil = 0;
            paintBrush = 0;
            paintBucket = 0;
            eraser = 0;
            rectangle = 0;
            oval = 0;
            fillRectangle = 0;
            fillOval = 0;
            line = 0;
            colorPicker = 0;
            mediumLine = 0;
            largeLine = 0;
            triangle = 0;
            roundRectangle = 0;
            halfFillCircle = 0;
            fillRoundRectangle = 0;
            fillTriangle = 0;
            repaint();
        } else if (choice == 4) {
            paintBucket = 2;
            airBrush = 0;
            pencil = 0;
            paintBrush = 0;
            eraser = 0;
            rectangle = 0;
            oval = 0;
            fillRectangle = 0;
            fillOval = 0;
            line = 0;
            colorPicker = 0;
            mediumLine = 0;
            largeLine = 0;
            clear = 0;
            triangle = 0;
            roundRectangle = 0;
            halfFillCircle = 0;
            fillRoundRectangle = 0;
            fillTriangle = 0;
            repaint();
        } else if (choice == 5) {
            colorPicker = 2;
            airBrush = 0;
            pencil = 0;
            paintBrush = 0;
            paintBucket = 0;
            eraser = 0;
            rectangle = 0;
            oval = 0;
            fillRectangle = 0;
            fillOval = 0;
            line = 0;
            mediumLine = 0;
            largeLine = 0;
            triangle = 0;
            roundRectangle = 0;
            halfFillCircle = 0;
            fillRoundRectangle = 0;
            fillTriangle = 0;
            repaint();
        } else if (choice == 6) {
            eraser = 2;
            colorPicker = 0;
            airBrush = 0;
            pencil = 0;
            paintBrush = 0;
            paintBucket = 0;
            rectangle = 0;
            oval = 0;
            fillRectangle = 0;
            fillOval = 0;
            line = 0;
            mediumLine = 0;
            largeLine = 0;
            triangle = 0;
            roundRectangle = 0;
            halfFillCircle = 0;
            fillRoundRectangle = 0;
            fillTriangle = 0;
            repaint();

        } else if (choice == 9) {

            oval = 2;
            rectangle = 0;
            eraser = 0;
            colorPicker = 0;
            airBrush = 0;
            pencil = 0;
            paintBrush = 0;
            paintBucket = 0;
            fillRectangle = 0;
            fillOval = 0;
            line = 0;
            mediumLine = 0;
            largeLine = 0;
            triangle = 0;
            roundRectangle = 0;
            halfFillCircle = 0;
            fillRoundRectangle = 0;
            fillTriangle = 0;
            repaint();

        } else if (choice == 10) {
            oval = 0;
            rectangle = 2;
            eraser = 0;
            colorPicker = 0;
            airBrush = 0;
            pencil = 0;
            paintBrush = 0;
            paintBucket = 0;
            fillRectangle = 0;
            fillOval = 0;
            line = 0;
            mediumLine = 0;
            largeLine = 0;
            triangle = 0;
            roundRectangle = 0;
            halfFillCircle = 0;
            fillRoundRectangle = 0;
            fillTriangle = 0;
            repaint();

        } else if (choice == 11) {

            roundRectangle = 2;
            triangle = 0;
            line = 0;
            oval = 0;
            rectangle = 0;
            eraser = 0;
            colorPicker = 0;
            airBrush = 0;
            pencil = 0;
            paintBrush = 0;
            paintBucket = 0;
            mediumLine = 0;
            largeLine = 0;
            fillRectangle = 0;
            fillOval = 0;
            halfFillCircle = 0;
            fillRoundRectangle = 0;
            fillTriangle = 0;

            repaint();

        } else if (choice == 12) {

            triangle = 2;
            fillRectangle = 0;
            eraser = 0;
            colorPicker = 0;
            airBrush = 0;
            pencil = 0;
            paintBrush = 0;
            paintBucket = 0;
            rectangle = 0;
            oval = 0;
            fillOval = 0;
            line = 0;
            mediumLine = 0;
            largeLine = 0;
            roundRectangle = 0;
            halfFillCircle = 0;
            fillRoundRectangle = 0;
            fillTriangle = 0;
            repaint();

        } else if (choice == 13) {

            line = 2;
            fillOval = 0;
            fillRectangle = 0;
            eraser = 0;
            colorPicker = 0;
            airBrush = 0;
            pencil = 0;
            paintBrush = 0;
            paintBucket = 0;
            rectangle = 0;
            oval = 0;
            mediumLine = 0;
            largeLine = 0;
            triangle = 0;
            roundRectangle = 0;
            halfFillCircle = 0;
            fillRoundRectangle = 0;
            fillTriangle = 0;

            repaint();

        } else if (choice == 14) {

            mediumLine = 2;
            fillOval = 0;
            fillRectangle = 0;
            eraser = 0;
            colorPicker = 0;
            airBrush = 0;
            pencil = 0;
            paintBrush = 0;
            paintBucket = 0;
            rectangle = 0;
            oval = 0;
            line = 0;
            largeLine = 0;
            roundRectangle = 0;
            halfFillCircle = 0;
            fillRoundRectangle = 0;
            fillTriangle = 0;
            repaint();

        } else if (choice == 15) {

            largeLine = 2;
            fillOval = 0;
            fillRectangle = 0;
            eraser = 0;
            colorPicker = 0;
            airBrush = 0;
            pencil = 0;
            paintBrush = 0;
            paintBucket = 0;
            rectangle = 0;
            oval = 0;
            line = 0;
            mediumLine = 0;
            triangle = 0;
            roundRectangle = 0;
            halfFillCircle = 0;
            fillRoundRectangle = 0;
            fillTriangle = 0;
            repaint();

        } else if (choice == 16) {

            fillOval = 2;
            largeLine = 0;
            fillRectangle = 0;
            eraser = 0;
            colorPicker = 0;
            airBrush = 0;
            pencil = 0;
            paintBrush = 0;
            paintBucket = 0;
            rectangle = 0;
            oval = 0;
            line = 0;
            mediumLine = 0;
            triangle = 0;
            roundRectangle = 0;
            halfFillCircle = 0;
            fillRoundRectangle = 0;
            fillTriangle = 0;
            repaint();

        } else if (choice == 17) {

            halfFillCircle = 2;
            fillOval = 0;
            largeLine = 0;
            fillRectangle = 0;
            eraser = 0;
            colorPicker = 0;
            airBrush = 0;
            pencil = 0;
            paintBrush = 0;
            paintBucket = 0;
            rectangle = 0;
            oval = 0;
            line = 0;
            mediumLine = 0;
            triangle = 0;
            roundRectangle = 0;
            fillRoundRectangle = 0;
            fillTriangle = 0;
            repaint();

        } else if (choice == 18) {

            fillRectangle = 2;
            halfFillCircle = 0;
            fillOval = 0;
            largeLine = 0;

            eraser = 0;
            colorPicker = 0;
            airBrush = 0;
            pencil = 0;
            paintBrush = 0;
            paintBucket = 0;
            rectangle = 0;
            oval = 0;
            line = 0;
            mediumLine = 0;
            triangle = 0;
            roundRectangle = 0;
            fillRoundRectangle = 0;
            fillTriangle = 0;
            repaint();

        } else if (choice == 19) {

            fillRoundRectangle = 2;
            fillRectangle = 0;
            halfFillCircle = 0;
            fillOval = 0;
            largeLine = 0;
            eraser = 0;
            colorPicker = 0;
            airBrush = 0;
            pencil = 0;
            paintBrush = 0;
            paintBucket = 0;
            rectangle = 0;
            oval = 0;
            line = 0;
            mediumLine = 0;
            triangle = 0;
            roundRectangle = 0;
            fillTriangle = 0;
            repaint();

        } else if (choice == 20) {

            fillTriangle = 2;
            fillRoundRectangle = 0;
            fillRectangle = 0;
            halfFillCircle = 0;
            fillOval = 0;
            largeLine = 0;
            eraser = 0;
            colorPicker = 0;
            airBrush = 0;
            pencil = 0;
            paintBrush = 0;
            paintBucket = 0;
            rectangle = 0;
            oval = 0;
            line = 0;
            mediumLine = 0;
            triangle = 0;
            roundRectangle = 0;
            repaint();

        }

    }

    public void openFile() {
        returnValue = openFileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                originalBI = ImageIO.read(openFileChooser.getSelectedFile());
                // messageLabel.setText("Image File Successfully Load");
                System.out.println("Image File Successfully Load");

            } catch (IOException ie) {
                // messageLabel.setText("File To Load image file");
                System.out.println("File To Load image file");
            }
        } else {
            //   messageLabel.setText("no File Choosen");
            System.out.println("No File CHoosen");

        }

    }

    public void imageToArray() {

        // int width = 1200;
        //int height = 800;
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // try{
            // int width=originalBI.getWidth();
            // int height = originalBI.getHeight();
            int width = 1200;
            int height = 800;

            newBI = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            pixels = new int[width][height];

            //for (int i = 0; i < width; i++) {
            //   for (int j = 0; j < height; j++) {
            //     pixels[i][j] = originalBI.getRGB(i, j);
            // }
            // }
            // }catch(Exception ee)
            // {
            //   System.out.println("cAUGHT EXCEPTION");
            // }
        }

    }
    // public void makeFilteredImage()
    // {

    //}
    /*This method is created for save the image file what we draw on the drawingBoard by usind 
    saveFileChooser and writing of the images and we can select the format of the images*/
    public void saveImage() {

        saveFileChooser = new JFileChooser();
        saveFileChooser.setCurrentDirectory(new File("e:\\2.1"));
        saveFileChooser.setFileFilter(new FileNameExtensionFilter("PNG images", "png"));
        returnValue = saveFileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {

                ImageIO.write(newBI, "png", saveFileChooser.getSelectedFile());
                //messageLabel.setText("Image File Successfully Load");
                System.out.println("Image File Successfully Saved");

            } catch (Exception ie) {
                // messageLabel.setText("File To Load image file");
                System.out.println("File To Save image file");

            }
        } else {
            // messageLabel.setText("no File Choosen");
            System.out.println("No File Saved");

        }
    }

    /*Here all the action are to be performed.In this action event we implement many if else conditions so that
    all the buttons,menu buttons can works with specific conditions of choices what we given to to*/
    public void actionPerformed(ActionEvent e) {

        super.removeMouseMotionListener(this);

        if (e.getSource() == b1) {
            choice = 1;
            draw();
            super.addMouseMotionListener(this);
        } else if (e.getSource() == b2) {
            choice = 2;
            draw();
            super.addMouseMotionListener(this);
        } else if (e.getSource() == b3) {
            choice = 3;
            draw();
            super.addMouseMotionListener(this);
        } else if (e.getSource() == b4) {
            choice = 4;
            draw();
            super.addMouseMotionListener(this);
        } else if (e.getSource() == b5) {
            choice = 5;
            draw();
            super.addMouseMotionListener(this);
        } else if (e.getSource() == b6) {
            choice = 6;
            draw();
            super.addMouseMotionListener(this);
        } else if (e.getSource() == b7) {

            gc.clearRect(0, 0, 1200, 800);
            allStateZero();

            draw();
            repaint();

        } else if (e.getSource() == b8) {

            Color bgColor = JColorChooser.showDialog(this, "Choose Background Color", getBackground());
            if (bgColor != null) {
                gc.setColor(bgColor);

            }

        } else if (e.getSource() == b9) {
            choice = 9;
            draw();
            super.addMouseMotionListener(this);
        } else if (e.getSource() == b10) {
            choice = 10;
            draw();
            super.addMouseMotionListener(this);
        } else if (e.getSource() == b11) {
            choice = 11;
            draw();
            super.addMouseMotionListener(this);
        } else if (e.getSource() == b12) {
            choice = 12;
            draw();
            super.addMouseMotionListener(this);
        } else if (e.getSource() == b13) {
            choice = 13;
            draw();
            super.addMouseMotionListener(this);
        } else if (e.getSource() == b14) {
            choice = 14;
            draw();
            super.addMouseMotionListener(this);
        } else if (e.getSource() == b15) {
            choice = 15;
            draw();
            super.addMouseMotionListener(this);
        } else if (e.getSource() == b16) {

            System.exit(0);

        } else if (e.getSource() == b17) {

            choice = 16;
            draw();

        } else if (e.getSource() == b18) {

            choice = 17;
            draw();

        } else if (e.getSource() == b19) {

            choice = 18;
            draw();

        } else if (e.getSource() == b20) {

            choice = 19;
            draw();

        } else if (e.getSource() == b21) {

            choice = 20;
            draw();

        } else if (e.getSource() == button) {

            frame.setVisible(true);

            frame2.setVisible(false);
            super.addMouseMotionListener(this);
            AudioPlayer.player.stop(audios);

            allStateZero();

        } else if (e.getSource() == musicOnButton) {

            super.addMouseMotionListener(this);
            AudioPlayer.player.stop(audios);
            musicOnButton.setVisible(false);
            mucicOffButton.setVisible(true);

        } else if (e.getSource() == mucicOffButton) {

            super.addMouseMotionListener(this);
            AudioPlayer.player.start(audios);
            mucicOffButton.setVisible(false);
            musicOnButton.setVisible(true);

        } else if (e.getSource() == shutDownButton) {

            int choice = JOptionPane.showConfirmDialog(null, "Do You Want To Quit This Program?", "Quit", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }

        } else if (e.getActionCommand().equals("  Home")) // action when user choose About button         
        {
            int choice = JOptionPane.showConfirmDialog(null, "Do You Want To Go Home?", "Home", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                frame2.setVisible(true);
                frame.setVisible(false);
                 gc.clearRect(0, 0, 1200, 800);
                playMusic("src\\music1.wav");
                AudioPlayer.player.start(audios);

            }

        } else if (e.getActionCommand().equals("  About Us")) // action when user choose About button         
        {

            // JFrame about = new JFrame("  About Us");
            //about.setSize(800, 638);
            // JButton picture = new JButton(new ImageIcon("about.jpg"));
            // about.add(picture);
            // about.setVisible(true);
            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "E:\\Paint2D\\src\\paint2d\\aboutUs.jpg");
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(null, ee);
                System.out.println("Exception");
            }

        } else if (e.getActionCommand().equals("  Info")) // action when user choose About button         
        {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "E:\\Paint2D\\src\\paint2d\\readMe.docx");
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(null, ee);
                System.out.println("Exception");
            }

        } else if (e.getActionCommand().equals("  Phone")) // action when user choose About button         
        {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "E:\\Paint2D\\src\\paint2d\\phoneImage.jpg");
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(null, ee);
                System.out.println("Exception");
            }

        } else if (e.getActionCommand().equals("  Facebook")) // action when user choose About button         
        {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "https://www.facebook.com/jishan.chowdhory?ref=bookmarks");
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(null, ee);
                System.out.println("Exception");
            }

        } else if (e.getActionCommand().equals("  Gmail")) // action when user choose About button         
        {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "https://mail.google.com/mail/u/1/#inbox?compose=CllgCKCJDkSDxrPRBmbgVmsdfJxtbShsjvKcjQDNvdhMvcgVljXmsFTdDgKBdSFFschXxsBxvzg");
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(null, ee);
                System.out.println("Exception");
            }

        } else if (e.getActionCommand().equals("  Exit")) // action when user choose About button         
        {
            int choice = JOptionPane.showConfirmDialog(null, "Do You Want To Quit This Program?", "Quit", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }

        } else if (e.getActionCommand().equals("  Open")) // action when user choose About button         
        {
            
            openFileChooser = new JFileChooser();
            openFileChooser.setCurrentDirectory(new File("e:\\2.1"));
            openFileChooser.setFileFilter(new FileNameExtensionFilter("PNG images", "png"));
            openFile();

            gc.drawImage(originalBI, null, 0, 0);

            draw();
            repaint();

        } else if (e.getActionCommand().equals("  Save")) // action when user choose About button         
        {

            imageToArray();
            saveImage();
            gc.drawImage(originalBI, null, 10, 10);

        } else if (e.getActionCommand().equals("  New")) // action when user choose About button         
        {

            int choice = JOptionPane.showConfirmDialog(null, "Do You Want To Save Changes To Untitled ?", "Save", JOptionPane.OK_CANCEL_OPTION);
            if (choice == JOptionPane.OK_OPTION) {

                imageToArray();
                saveImage();

                gc.clearRect(0, 0, 1200, 800);
                allStateZero();

                frame.setVisible(false);
                frame2.setVisible(false);
                frame.setVisible(true);

            } else if (choice == JOptionPane.CANCEL_OPTION) {

                gc.clearRect(0, 0, 1200, 800);
                allStateZero();

                frame.setVisible(false);
                frame2.setVisible(false);
                frame.setVisible(true);

            }

        }

    }

    public void mouseExited(MouseEvent e) // action when mouse is exited
    {
    }

    public void mouseEntered(MouseEvent e) // action when mouse is entered
    {
    }

    public void mouseClicked(MouseEvent e) // action when mouse is clicked
    {

    }

    // action when mouse is pressed and our specific works are dont by this
    //Here we declare two axis and they are working when we commnad them from mouse
    public void mousePressed(MouseEvent e) {

        xX1 = e.getX();
        yY1 = e.getY();

        if (airBrush == 2) {

            Color ce2 = gc.getColor();
            gc.fillOval(e.getX(), e.getY() - 168, 12, 12);
            gc.setColor(ce2);
            repaint();

        } else if (paintBucket == 2) {

            Color ce3 = gc.getColor();
            gc.fillRect(0, 0, 1200, 800);
            gc.setColor(ce3);
            repaint();

        } else if (pencil == 2) {

            Color ce1 = gc.getColor();
            gc.fillRect(e.getX(), e.getY() - 168, 2, 2);
            gc.setColor(ce1);
            repaint();

        }

    }

    //Here action is performed when mouse is released.It does many works of shape tools of our drawing when we drag the mouse and release it.
    //It works with our if else conditions when we released the mouse here we declare w and h 
    public void mouseReleased(MouseEvent e) {

        xX2 = e.getX();
        yY2 = e.getY();
        draw();

        int w = xX2 - xX1;
        if (w < 0) {
            w = w * (-1);
        }

        int h = yY2 - yY1;
        if (h < 0) {
            h = h * (-1);
        }

        if (colorPicker == 2) {

            Color ce4 = gc.getColor();
            gc.setColor(Color.white);
            gc.fillOval(e.getX(), e.getY() - 168, 50, 50);
            gc.setColor(ce4);

            repaint();
        } else if (oval == 2) {
            Color ce5 = gc.getColor();
            gc.drawOval(xX1, yY1 - 168, w, h);
            gc.setColor(ce5);

            repaint();
        } else if (rectangle == 2) {

            Color ce5 = gc.getColor();
            gc.drawRect(xX1, yY1 - 168, w, h);
            gc.setColor(ce5);

            repaint();
        } else if (roundRectangle == 2) {

            Color ce6 = gc.getColor();
            gc.drawRoundRect(xX1, yY1 - 168, w, h, 35, 35);
            gc.setColor(ce6);

            repaint();

        } else if (triangle == 2) {
            Color ce17 = gc.getColor();
            gc.setColor(ce17);

            int x[] = {xX1, xX1 + w, xX2 + w};
            int y[] = {yY1 - 168 + w, yY1 - 168, yY1 - 168 + w};
            gc.drawPolygon(x, y, 3);

            repaint();

        } else if (line == 2) {

            Color ce8 = gc.getColor();
            gc.setStroke(new BasicStroke(0));
            gc.drawLine(xX1, yY1 - 168, xX2, yY2 - 168);
            gc.setStroke(new BasicStroke(0));
            gc.setColor(ce8);

            repaint();

        } else if (mediumLine == 2) {

            Color ce9 = gc.getColor();
            gc.setStroke(new BasicStroke(3));
            gc.drawLine(xX1, yY1 - 168, xX2, yY2 - 168);
            gc.setStroke(new BasicStroke(3));
            gc.setColor(ce9);

            repaint();

        } else if (largeLine == 2) {

            Color ce10 = gc.getColor();
            gc.setStroke(new BasicStroke(8));
            gc.drawLine(xX1, yY1 - 168, xX2, yY2 - 168);
            gc.setStroke(new BasicStroke(8));
            gc.setColor(ce10);

            repaint();

        } else if (fillOval == 2) {

            Color ce11 = gc.getColor();
            gc.fillOval(xX1, yY1 - 168, w, h);
            gc.setColor(ce11);

        } else if (halfFillCircle == 2) {

            Color ce12 = gc.getColor();
            gc.fillArc(xX1, yY1 - 168, w, h, 0, 180);
            gc.setColor(ce12);

            repaint();

        } else if (fillRectangle == 2) {

            Color ce13 = gc.getColor();
            gc.fillRect(xX1, yY1 - 168, w, h);
            gc.setColor(ce13);

            repaint();

        } else if (fillRoundRectangle == 2) {

            Color ce14 = gc.getColor();
            gc.fillRoundRect(xX1, yY1 - 168, w, h, 35, 35);
            gc.setColor(ce14);

            repaint();

        } else if (fillTriangle == 2) {

            Color ce15 = gc.getColor();
            int x[] = {xX1, xX1 + w, xX2 + w};
            int y[] = {yY1 - 168 + w, yY1 - 168, yY1 - 168 + w};
            gc.fillPolygon(x, y, 3);
            gc.setColor(ce15);

            repaint();

        }
    }

    public void mouseDragged(MouseEvent e) {
        if (eraser == 2) {

            Color c = gc.getColor();
            gc.setColor(Color.white);
            gc.fillRect(e.getX(), e.getY() - 168, 15, 15);
            gc.setColor(c);

            repaint();
        } else if (paintBrush == 2) {

            Color ce = gc.getColor();
            gc.fillRect(e.getX(), e.getY() - 168, 14, 14);
            gc.setColor(ce);

            repaint();
        } else if (pencil == 2) {

            Color ce1 = gc.getColor();
            gc.fillRect(e.getX(), e.getY() - 168, 2, 2);
            gc.setColor(ce1);

            repaint();
        }

    }
    //Action is perfomed when mouse is moved 

    public void mouseMoved(MouseEvent e) {

    }

}
