import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Kenan on 3/12/2018.
 */
public class Game extends Canvas implements Runnable{
    private int windowWidth = 640;
    private int windowHeight = windowWidth /12 * 9;
    private Thread thread;
    private boolean running = false;

    /*
        Instantiate necessary objects for running the game
     */
    Handler handler;
    private Menu menu;

    public STATE gameState = STATE.Menu; //Sets original STATE as the menu

    public Game(){
        handler = new Handler();
        menu = new Menu(this,handler);
        new Window(windowWidth, windowHeight,"My first game", this);
        this.addMouseListener(menu);
    }

    public static void main(String args[]) {
        new Game();
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >=1)
            {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
        stop();
    }
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0, windowWidth, windowHeight);

        handler.render(g);

        if(gameState == STATE.Game){
        }
        else if(gameState == STATE.Menu){
            menu.render(g);
        }

        g.dispose();
        bs.show();
    }
    private void tick(){
        handler.tick();
        if(gameState == STATE.Game){}
        else if(gameState == STATE.Menu){
            menu.tick();
        }
    }


}
