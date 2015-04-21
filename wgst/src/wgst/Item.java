package wgst;

/**
 * @author DesktopStian
 */
public class Item {
    
    private int x;
    private int y;
    
    private Description d;
    
    public Item (Description d){
        this.d=d;
    }
    
    public Item (int x, int y, Description d){
        this.x=x;
        this.y=y;
        this.d=d;
    }
    
    

}
    