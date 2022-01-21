import java.awt.*;

public class Common {
    public static final int frameWidth = 900;
    public static final int frameHight = 600;
    public static final Font frameFont = new Font("楷书", Font.BOLD, 60);
    public static final Font fishFont = new Font("楷书", Font.PLAIN, 30);
    public static final Font gameOverBigFont = new Font("楷书",Font.BOLD,100);
    public static final Font gameOverLitterFont = new Font("楷书",Font.BOLD,40);
    public static final Font gamePauseFont = new Font("楷书",Font.BOLD,50);
    public static final Image bkImg = Toolkit.getDefaultToolkit().createImage("img/1.jpeg");
    public static final Image startImg = Toolkit.getDefaultToolkit()
            .createImage("img/2.jpeg");
    public static final Image fishImg[] = {
            Toolkit.getDefaultToolkit().createImage("img/1.png"),
            Toolkit.getDefaultToolkit().createImage("img/2.png"),
            Toolkit.getDefaultToolkit().createImage("img/3.png"),
            Toolkit.getDefaultToolkit().createImage("img/4.png"),
            Toolkit.getDefaultToolkit().createImage("img/5.png"),
            Toolkit.getDefaultToolkit().createImage("img/6.png"),
            Toolkit.getDefaultToolkit().createImage("img/7.png"),
            Toolkit.getDefaultToolkit().createImage("img/8.png"),
            Toolkit.getDefaultToolkit().createImage("img/9.png"),
            Toolkit.getDefaultToolkit().createImage("img/10.png") };
    public static final Image myFishLeft = Toolkit.getDefaultToolkit()
            .createImage("img/11.png");
    public static final Image myFishRight = Toolkit.getDefaultToolkit()
            .createImage("img/14.png");
    public static final Image myFishUp = Toolkit.getDefaultToolkit()
            .createImage("img/12.png");
    public static final Image myFishDown = Toolkit.getDefaultToolkit()
            .createImage("img/13.png");
    public static final int myFIshWidth[] = { 30, 40, 60, 80, 120 };
    public static final int myFishHeight[] = { 30, 40, 60, 80, 120 };
    public static final int speed[] = { 2, 4, 6, 10 };
    public static final int fishWidth[] = { 20, 30, 40, 50, 60 };
    public static final int fishHight[] = { 20, 30, 40, 50, 60 };
    public static final int createSpeed = 20;
    public static final int myFishSpeed = 11;
    public static final int TURNLEFT = 68;
    public static final int TURNRIGHT = 65;
    public static final int TURNUP = 87;
    public static final int TURNDOWN = 83;
    public static final int EASY = 48;
    public static final int MEDIUM = 49;
    public static final int HARD = 48;
    public static final int FishUpgrade = 1;
}