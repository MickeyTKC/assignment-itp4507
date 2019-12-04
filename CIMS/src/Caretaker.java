
import java.util.*;

public class Caretaker {

    public Stack<Memento> undoList;
    public Stack<Memento> redoList;

    public Caretaker() {
        undoList = new Stack<Memento>();
        redoList = new Stack<Memento>();
    }

    public void save(CoffeeShop cs, String action) {
        Memento amemento = new Memento(cs, action);
        if (!redoList.empty()) {
            if (!amemento.equals(redoList.get(redoList.size() - 1))) {
                redoList.clear();
            }
        }
        undoList.push(amemento);
    }

    public boolean undo() {
        if (undoList.size() > 1) {
            Memento temp = undoList.pop();
            redoList.push(temp);
            Memento m = undoList.get(undoList.size() - 1);
            m.restore();
            return true;
        } else {
            return false;
        }
    }

    public boolean redo() {
        if (!redoList.isEmpty()) {
            Memento m = redoList.pop();
            undoList.push(m);
            m.restore();
            return true;
        } else {
            return false;
        }
    }

    public String records() {
        String s = "";
        if (!undoList.empty()) {
            s+="Undo List:\n";
            for (int i = 1; i < undoList.size(); i++) {
                s+=undoList.get(i).getAction()+"\n";
            }
        }
        if (!redoList.empty()) {
            s+="Redo List:\n";
            for (int i = 0; i < redoList.size(); i++) {
                s+=redoList.get(i).getAction()+"\n";
            }
        }
        return s;
    }
}
