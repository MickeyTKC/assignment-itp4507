
import java.util.*;

public class Caretaker {

    private Stack<Memento> undoList;
    private Stack<Memento> redoList;

    public Caretaker() {
        undoList = new Stack<Memento>();
        redoList = new Stack<Memento>();
    }
    
    public void save(CoffeeShop sc,String action) {
        Memento amemento = new Memento(sc,action);
        if (!redoList.empty()) {
            if (!amemento.equals(redoList.get(redoList.size() - 1))) {
                redoList.clear();
            }
        }
        undoList.push(amemento);
    }

     public boolean undo() {
        if (undoList.size()>1) {
            Memento temp = undoList.pop();
            redoList.push(temp);
             Memento m  = undoList.get(undoList.size()-1);
            m.restore();
            System.out.println("Perform undo");
            return true;
        } else {
            System.out.println("Nothing to undo.");
            return false;
        }
    }

    public boolean redo() {
        if (!redoList.isEmpty()) {
            Memento m = redoList.pop();
            undoList.push(m);
            m.restore();
            System.out.println("Perform redo");
            return true;
        } else {
            System.out.println("Nothing to redo.");
            return false;
        }
    }
    
    public String records(){
        return "";
    }
}
