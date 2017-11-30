import java.awt.Color;
import java.awt.Graphics;
 
public class Player
{
    int x;
    int y;
     
    int width;
    int height;
     
    Color blue;
	Color white; 
     
    public Player(int x, int y)
    {
         
        this.x = x;
        this.y = y;
         
        this.width = 50;
        this.height = 50;
         
        this.blue = new Color(0,0,255);
		this.white = new Color(255,255,255); 
         
    }
     
 
    public void drawMe(Graphics g)
    {
        g.setColor(blue);
        g.fillRect(x,y,width,height);
		g.setColor(white);
        g.fillOval(x+10,y+5,width-20,height-20);
		g.setColor(white);
        g.drawRect(x,y,width,height);
		g.setColor(white);
        g.drawRect(x,y,width,height);
		g.setColor(white);
        g.drawRect(x,y,width,height);
    }
     
    public void moveDown()
    {
        x -= 5;
    }
     
    public void moveUp()
    {
        x += 5;
    }
     
    public int getX()
    {
        return x;
    }
     
    public int getY()
    {
        return y;
    }
     
 
}