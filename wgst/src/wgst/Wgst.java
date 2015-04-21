package wgst;

import java.awt.GridLayout;
import javax.swing.*;

/**
 * @author DesktopStian
 */
public class Wgst {

    public static void main(String[] args) {
    
        JFrame frame = new JFrame("Tile");
        JPanel panel = new JPanel(new GridLayout(10,10));
        JLabel[] map = new JLabel[100];
        for(int i=0;i<100;i++){
             map[i]=new JLabel();
             panel.add(map[i]);
        }        
        frame.add(panel);
        frame.setVisible(true);
        
    }
    
}
    