import java.awt.*;

/**
 * Created by Kenan on 3/13/2018.
 */
public class Player extends GameObject {

    public Player (int x, int y, ID id){
        super(x, y, id);
    }
    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(100,100,100,100);
    }
}
