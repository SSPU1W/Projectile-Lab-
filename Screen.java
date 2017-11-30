import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;
public class Screen extends JPanel implements KeyListener
{
	
 
    Projectile projectile;
    Player player;
    Enemy []enemyArray;
	int score;
	int timer = 60; 
	int go = 0;

	
	Color black = new Color(0,0,0);
	Color white = new Color(255,255,255); 
 
     
    public Screen()
    {
         
        player = new Player(350,500);
        projectile = new Projectile(50,300);
		enemyArray = new Enemy[4];
		int areaX = 100;
		enemyArray[0] =  new Enemy(200,200);
		enemyArray[1] =  new Enemy(300,200);
		enemyArray[2] =  new Enemy(400,200);
		enemyArray[3] =  new Enemy(500,200);
         
        addKeyListener(this);
        setFocusable(true);
    }
	
	
    public void playSound() {
 
        try {
            URL url = this.getClass().getClassLoader().getResource("sound/cannon.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

 
    public Dimension getPreferredSize() 
    {

        return new Dimension(800,600);
    }
     

    public void keyPressed(KeyEvent e)
    {
		if( e.getKeyCode() == 32) 
		{
			projectile.fire( player.getX(), player.getY());
			this.playSound();
		}
         
        if( e.getKeyCode() == 39 ) 
        {
            player.moveUp();
        }
         
        if( e.getKeyCode() == 37 ) 
        {
            player.moveDown();
        }
         
        repaint();
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
 
    public void animate()
    {
         
        while(true)
        {

            try {
                Thread.sleep(5);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
			if(timer > 0)
			{
				projectile.move();
			}

			

			for(int e = 0; e<enemyArray.length;e++)
			{
				enemyArray[e].checkCollision(projectile);
			}
			for(int i = 0; i<enemyArray.length;i++)
			{
				enemyArray[i].move();
			}
			
     

            repaint();
        }
 
    }
	
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
     

        player.drawMe(g);
         
        projectile.drawMe(g);
 

		for(Enemy each: enemyArray)
		{
			each.drawMe(g);
		}
		
		Font h = new Font("Helvetica", Font.PLAIN, 28);
		g.setFont(h);
		g.setColor(white);
		g.drawString("Score = " + score, 20, 100);
		g.drawString("Timer = " + timer, 20, 200); 
		if( score == 4)
		{
			g.drawString("You Win!", 20, 300); 
		}
		else if (score < 4 && timer == 0)
		{
			g.drawString("You Lose!", 20, 300);
		}
		repaint();
		score = 0;
		if(timer > 0){
			if(go < 400 ){
				go++;
			} else{
				timer--;
				go = 0;
			}
		}
		for(Enemy each : enemyArray)
		{
			if(!each.getVisible())
			{

					score ++;
			}
		}

		
		
    } 
     

     
     
 
}