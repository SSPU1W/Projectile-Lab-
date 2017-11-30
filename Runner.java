import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
 
 
public class Runner 
{
   
    public static void main(String[] args) 
    {
 
 
        JFrame frame = new JFrame("Projectile Lab");
 
		frame.setSize(new Dimension (800,600));
 

        Screen sc = new Screen();
		
		
		try {
         	JLabel imageContainer = new JLabel();
         	ImageIcon ii = new ImageIcon(ImageIO.read(new File("game.jpg")));
       	 
        	Image img = ii.getImage();
        	Image newimg = img.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
        	ImageIcon newIcon = new ImageIcon(newimg);

        	imageContainer.setIcon(newIcon);
        	imageContainer.setLayout(new BorderLayout());
        	sc.setOpaque(false);    	 
        	imageContainer.add(sc);   
        	frame.setContentPane(imageContainer);
    	} catch (Exception e) {
        	e.printStackTrace();
    	}
         
        frame.add(sc);
        frame.pack();
        frame.setVisible(true);
		sc.animate();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         
 
    }
}