package wgst;
/**
 * @author DesktopStian
 */
public class Tile {
    
    private int x;
    private int y;
    private boolean occupied;
    
    private enum TileType{
        WALL,
        FLOOR,
        DOOR
    }
    
        public Tile(int x,int y){
        this.x=x;
        this.y=y;
        occupied=false;
    }
}
