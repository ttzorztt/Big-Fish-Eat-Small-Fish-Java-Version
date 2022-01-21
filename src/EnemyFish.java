import java.awt.*;
import java.awt.Graphics;
public class EnemyFish {
    public int trun = 0;
    public int lv = -2; // lv of fish
    public int speed = 0; //fish go left ? speed = 1 : speed = -1;
    public int x = 0;
    public int y = 0;
    Image fish_img;
    /**
     * initialize fish
     * @param img class Image
     * @param llv Grade
     * @param speed move speed
     * @param x First show x coordinate
     * @param y First show y coordinate
     * @param img_width fish width
     * @param img_height fish height
     * @param t trun left is -1,and trun right is 1
     */
    public EnemyFish(Image img,int llv,int speed,int x,int y,int img_width,int img_height,int t){
        this.trun = t;
        fish_img = img.getScaledInstance(img_width, img_height, Image.SCALE_AREA_AVERAGING);
        this.lv = llv;
        this.speed = speed;
        this.x = x;
        this.y = y;
    }
    /**
     * print this fish in the frame
     * @param g Graphics class
     */
    public void PlainSelf(Graphics g){
        g.drawImage(fish_img, x,y, null);
    }
    /**
     * get the matrix of this picture
     * @return the class Rectangle
     */
    public Rectangle getrange(){
        return new Rectangle(x,y,Common.fishWidth[lv] - 15,Common.fishHight[lv] - 15);
    }
}