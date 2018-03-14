import java.awt.*;

/**
 * Created by Kenan on 3/13/2018.
 */
public abstract class GameObject {
    protected int x,y;
    protected ID id;
    protected int velX,velY;

    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }
    public abstract void tick();
    public abstract void render(Graphics g);
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setVelX(int xSpeed){
        this.velX = xSpeed;
    }
    public void setVelY(int ySpeed){
        this.velY = ySpeed;
    }
    public int getVelX(){
        return this.velX;
    }
    public int getVelY(){
        return this.velY;
    }
    public void setID(ID id){
        this.id = id;
    }
    public ID getID(ID id){
        return this.id;
    }

}
