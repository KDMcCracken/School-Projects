import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Kenan on 3/13/2018.
 */
public class Menu extends MouseAdapter {
    private int buttonWidth = 100;
    private int buttonHeight = 50;
    private Game game;
    private Handler handler;

    public Menu(Game game, Handler handler){
        this.game = game;
        this.handler = handler;
    }
    public void render(Graphics g){
        g.setColor(Color.ORANGE);
        g.setFont(new Font("arial", Font.BOLD,20));
        g.drawString("KENAN'S FIRST GAME", 200,50);

        g.setColor(Color.orange);
        g.drawString("Start", 275,185);
        g.drawRect(250,150,buttonWidth,buttonHeight);

        g.setColor(Color.orange);
        g.drawString("Help", 275,285);
        g.drawRect(250,250,buttonWidth,buttonHeight);

    }
    public void tick(){

    }
    public void mousePressed(MouseEvent e){
        // User selected "Start" button
        if(checkMouseBounds(e.getX(),e.getY(),250,150)){
            game.gameState = STATE.Game;
            handler.addObject(new Player(100,100,ID.Player));
        }
        //User selected "Help" button
        else if(checkMouseBounds(e.getX(),e.getY(),250,250)) {
            game.gameState = STATE.Help;

        }
    }
    private boolean checkMouseBounds(int mX, int mY, int x, int y){
        if(mX > x && mX < x+buttonWidth){
            if(mY > y && mY < y+buttonHeight){
                return true;
            }
        }
        return false;
    }
    public void mouseReleased(MouseEvent e){

    }
}
