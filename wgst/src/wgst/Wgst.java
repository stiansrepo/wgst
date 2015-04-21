package wgst;

import java.awt.GridLayout;
import javax.swing.*;
import java.io.*;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * @author DesktopStian
 */
public class Wgst extends JFrame{

    public Wgst(){
    
        ImageIcon bg = new ImageIcon(getClass().getResource("/bgWhite.png"));
        ImageIcon black = new ImageIcon(getClass().getResource("/black.png"));
    
        JFrame frame = new JFrame("Tile");
        JPanel panel = new JPanel(new GridLayout(10,10));
        JLabel[] map = new JLabel[100];
        
        for(int i=0;i<100;i++){             
             if(i%20==0){
                 map[i]=new JLabel(black);
             }
             else{
                 map[i]=new JLabel(bg);
             }
             panel.add(map[i]);
        }        
        frame.add(panel);
        frame.pack();
    }
        
        public static void main(String[] args) throws Exception {
            Wgst a = new Wgst();
            a.setVisible(true);
            a.pack();
    }
    
}
    