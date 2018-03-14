import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Kenan on 3/13/2018.
 */
public class Handler {
    LinkedList<GameObject> objects= new LinkedList<>();
    public void tick(){
        for(GameObject object : objects){
            object.tick();
        }
    }

    public void render(Graphics g){
        for(GameObject object : objects){
            object.render(g);
        }
    }

    public void addObject(GameObject object){
        this.objects.add(object);
    }

    public void removeObject(GameObject object){
        this.objects.remove(object);
    }
}
