 import java.util.List;
 import java.util.ArrayList;
 import board.*;

  public class GameTree {
  GameTree level;
  GameBoard gb;
  List<GameTree> children = new ArrayList<GameTree>();

   public GameTree(GameBoard gb) {
            this.gb = gb;
      }

   public void addChild(GameTree child) {
            children.add(child);
      }

   public GameBoard getGameBoard() { return gb; }

   public boolean hasChildren() {
            return children.size() > 0;
      }

   public GameTree getFirstChild() {
            return children.get(0);
      }

   public void removeFirstChild() {
            children.remove(0);
      }

   public int numChildren() {
            return children.size();
      }
}
