import java.awt.*;

public class MyFish {
    public Image myImg;
    public int x = 200;
    public int y = 200;
    public Integer lv = 0;
    public int count = 0;
    public boolean uplv = false;
    public int Turn = Common.TURNRIGHT;
    MyFish(){
        myImg = Common.myFishRight.getScaledInstance(Common.myFIshWidth[0], Common.myFishHeight[0], Image.SCALE_AREA_AVERAGING);
    }
    public Rectangle getrange() {
        return new Rectangle(x, y, Common.myFIshWidth[lv], Common.myFishHeight[lv]);
    }
    public void print(Graphics g) {
        g.drawImage(myImg.getScaledInstance(Common.myFIshWidth[lv], Common.myFishHeight[lv], Image.SCALE_AREA_AVERAGING),x,y, null);
    }
}