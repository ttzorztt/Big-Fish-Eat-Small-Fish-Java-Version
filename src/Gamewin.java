import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.event.MouseInputAdapter;

public class Gamewin extends JFrame {
    private List<EnemyFish> fish;
    /**
     * 0 game not start 1 game start 2 pause 3 game over
     */
    private int state;
    private MyFish myfish;
    private int count = 0;

    public Gamewin() {
        fish = new ArrayList<>();
        myfish = new MyFish();
        state = 0;
        this.setSize(Common.frameWidth, Common.frameHight); // set width and hight of this Frame
        this.setLocationRelativeTo(null);
        this.setResizable(false); // make frame was not be fix
        this.setTitle("嘤嘤嘤"); // set title of this frame
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // chose close way
        this.setVisible(true); // this code need put in the lastest
    }
    /**
     * clean in all data in this game
     */
    public void Cleaning() {
        myfish.lv = 0;
        myfish.count = 0;
        fish.clear();
        AidChoiceTurn();
    }
    /**
     * Draw Iamge in state of gameover
     * @param test object of Graphics
     */
    public void DrawGameOver(Graphics test) {
        DrawGameingImge(test);
        test.setFont(Common.gameOverBigFont);
        test.setColor(Color.RED);
        test.drawString("Game OVER!!!", 100, 300);
        test.setFont(Common.gameOverLitterFont);
        test.setColor(Color.green);
        test.drawString("点击鼠标重新开始", 260, 350);
    }

    /**
     * Draw Image in state  
     * @param test
     */
    public void DrawGameStartImage(Graphics test) {
        test.drawImage(Common.bkImg, 0, 0, null);
        test.setColor(Color.white);
        test.setFont(Common.frameFont);
        test.drawString("开始", 400, 400);
    }

    public void DrawGamePause(Graphics test) {
        DrawGameingImge(test);
        test.setColor(Color.orange);
        test.setFont(Common.gamePauseFont);
        state = 2;
        test.drawString("点击鼠标继续", 280, 380);
    }

    public void DrawGameingImge(Graphics test) {
        test.drawImage(Common.startImg, 0, 0, null);
        for (int a = 0; a < fish.size(); ++a) {
            EnemyFish f = fish.get(a);
            test.drawImage(f.fish_img, f.x, f.y, null);
        }
        test.setColor(Color.green);
        test.setFont(Common.fishFont);
        test.drawString("LV: " + " " + myfish.lv, 60, 70);
        test.drawString("Count: " + " " + myfish.count, 180, 70);
        test.drawImage(myfish.myImg, myfish.x, myfish.y, null);
    }

    public void DrawGameEnemFishMove(Graphics test) {
        for (int a = 0; a < fish.size(); ++a) {
            EnemyFish f = fish.get(a);
            f.x += f.trun * f.speed;
            if (myfish.getrange().intersects(f.getrange())) {
                if (f.lv > myfish.lv) {
                    state = 3;
                    return;
                } else {
                    myfish.count += f.lv + 1;
                    int ll = myfish.count / Common.FishUpgrade;
                    if(ll > myfish.lv && ll <= 4){
                        myfish.uplv = true;
                    myfish.lv = ll;
                }
                    fish.remove(a);
                }
            }
        }
        DrawGameingImge(test);
    }
    /**
     * create the new fish in the frame
     * 
     * @param turn if trun right ? 1 : -1
     */
    public void AddFish() {
        if (state == 2 || state == 3)
            return;
        Random random = new Random();
        int turn = random.nextInt(2);
        int hight = random.nextInt(Common.frameHight);
        int choise = random.nextInt(5);
        switch (turn) {
            case 0:
                fish.add(new EnemyFish(Common.fishImg[choise * 2], choise, 2, Common.frameWidth + 2, hight,
                        Common.fishWidth[choise], Common.fishHight[choise], -1));
                break;
            case 1:
                fish.add(new EnemyFish(Common.fishImg[choise * 2 + 1], choise, 2, -2, hight, Common.fishWidth[choise],
                        Common.fishHight[choise], 1));
                break;
        }
    }
    public void RemoveFish() {
        for (int a = 0; a < fish.size(); ++a) {
            if (fish.get(a).x > Common.frameWidth || fish.get(a).x < -100)
                fish.remove(a);
            else
                break;
        }
    }
    public void AidChoiceTurn(){
        Image m = myfish.myImg.getScaledInstance(Common.myFIshWidth[myfish.lv],
        Common.myFishHeight[myfish.lv], Image.SCALE_AREA_AVERAGING);
        myfish.myImg = m;
    }
    public void ChoiceTurn(int Turn) {
        if(Turn == myfish.Turn){
            return;
        }
        switch (Turn) {
            case Common.TURNUP: // W
                myfish.myImg = Common.myFishUp.getScaledInstance(Common.myFIshWidth[myfish.lv],
                        Common.myFishHeight[myfish.lv], Image.SCALE_AREA_AVERAGING);
                myfish.Turn = Turn;
                break;
            case Common.TURNDOWN: // S
                myfish.myImg = Common.myFishDown.getScaledInstance(Common.myFIshWidth[myfish.lv],
                        Common.myFishHeight[myfish.lv], Image.SCALE_AREA_AVERAGING);
                myfish.Turn = Turn;
                break;
            case Common.TURNRIGHT: // D
                myfish.myImg = Common.myFishRight.getScaledInstance(Common.myFIshWidth[myfish.lv],
                        Common.myFishHeight[myfish.lv], Image.SCALE_AREA_AVERAGING);
                myfish.Turn = Turn;
                break;
            case Common.TURNLEFT: // A
                myfish.myImg = Common.myFishLeft.getScaledInstance(Common.myFIshWidth[myfish.lv],
                        Common.myFishHeight[myfish.lv], Image.SCALE_AREA_AVERAGING);
                myfish.Turn = Turn;
                break;
            default:
                break;
        }
    }
    public void lunch() {
        this.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == 1 && state == 0) {
                    state = 1;
                } else if (e.getButton() == 1 && state == 1) {
                    state = 2;
                } else if (e.getButton() == 1 && state == 2) {
                    state = 1;
                } else if (e.getButton() == 1 && state == 3) {
                    Cleaning();
                    repaint();
                    state = 1;
                }
                repaint();
            }
        });
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (state == 2 || state == 3)
                    return;
                ChoiceTurn(e.getKeyCode());
                switch (e.getKeyCode()) {
                    case Common.TURNUP: // W
                        if (myfish.x > 0)
                            myfish.y -= Common.myFishSpeed;
                        break;
                    case Common.TURNDOWN: // S
                        if (myfish.x < Common.frameWidth)
                            myfish.y += Common.myFishSpeed;
                        break;
                    case Common.TURNRIGHT: // D
                        if (myfish.y < Common.frameHight)
                            myfish.x -= Common.myFishSpeed;
                        break;
                    case Common.TURNLEFT: // A
                        if (myfish.y > 0)
                            myfish.x += Common.myFishSpeed;
                        break;
                    default:
                        break;
                }
            }
        });
        while (true) {
            if (count == 0) {
                AddFish();
            }
            repaint(); // will usually use way that named paint
            try {
                Thread.sleep(10);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            count = (count + 1) % Common.createSpeed;
            RemoveFish();
        }
    }
    public void paint(Graphics g) {

        // ChoiceTurn();
        Image p = createImage(Common.frameWidth, Common.frameHight);
        Graphics test = p.getGraphics();
        switch (state) {
            case 0:
                DrawGameStartImage(test);
                break;
            case 1:
                if(myfish.uplv){
                    AidChoiceTurn();
                    myfish.uplv = false;
                }
                DrawGameEnemFishMove(test);
                break;
            case 2:
                DrawGamePause(test);
                break;
            case 3:
                DrawGameOver(test);
                break;
            case 4:
                break;
        }
        g.drawImage(p, 0, 0, null);
    }
}