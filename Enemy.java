import java.awt.Color;
import java.awt.Graphics;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class Enemy
{
    int x;
    int y;
     
    int width;
    int height;
     
     
    Color green;
    Color black;
     
    boolean visible;
	
	int score;
     
    public Enemy(int x, int y)
    {
         
        this.x = x;
        this.y = y;
         
        this.width = 50;
        this.height = 50;
         
 
        this.green = new Color(255,255,255);
        this.black = new Color(255,0,0);
         
        this.visible = true;
         
    }
     
    public void move()
    {
        if( visible ){

            x++;
             
            if( x > 800)
				x=0;
        }
             
    }
 
    public void drawMe(Graphics g)
    {
        if( visible )
        {
            g.setColor(green);
            g.fillRect(x,y,width,height);
         	g.setColor(black);
			g.fillOval(x+10,y+5,width-20,height-20);
            g.setColor(black);
            g.drawRect(x,y,width,height);
        }
     
    }
    public void playSound1() {
 
        try {
            URL url = this.getClass().getClassLoader().getResource("sound/0550.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
    public void checkCollision(Projectile p)
    {
        if( visible == true && p.getVisible() == true )
        {
            int pX = p.getX();
            int pY = p.getY();
            int pWidth = p.getWidth();
            int pHeight = p.getHeight();
             
            if( pX + pWidth >= x && pX <= x + width 
                && pY + pHeight >= y && pY <= y + height )
            {
				this.playSound1();
                visible=false;
            }
			
        }
         
         
    }
	
	public boolean getVisible()
	{
		return visible;
		
	}
 
 
 
}