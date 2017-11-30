import java.awt.Color;
import java.awt.Graphics;
 
public class Projectile
{
    int x;
    int y;
    int width;
    int height;
    Color red;
    boolean visible;
     
    public Projectile(int x, int y)
    {

        this.x = x;
        this.y = y;
		
         
        this.width = 10;
        this.height = 10;
         
        this.red = new Color(255,255,255);
        this.visible = false;
 
    }
     
 
    public void drawMe(Graphics g)
    {
        if( visible )
        {
            g.setColor(red);
            g.fillOval(x+20,y,width,height);
			g.fillOval(x+40,y,width,height);
			g.fillOval(x,y,width,height);
        }
         
    }
     
    public void move()
    {
        if( visible )
        {
            y--;
             
            if( y  < 0)
                visible = false;
        }
             
    }
     
    public void fire(int x, int y)
    {
        if( visible == false )
        {
            this.x = x;
            this.y = y;
            visible = true;
        }
         
    }
     
    public int getX()
    {
        return x;
    }
     
    public int getY()
    {
        return y;
    }
     
    public int getWidth()
    {
        return width;
    }
     
    public int getHeight()
    {
        return height;
    }
     
    public boolean getVisible()
    {
        return visible;
    }
 
}