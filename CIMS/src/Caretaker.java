
import java.util.*;

public class Caretaker {

    private Stack<Memento> undoList;
    private Stack<Memento> redoList;

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
        s+="Undo List: \n";
        if (!undoList.empty()) {
            for (int i = 1; i < undoList.size(); i++) {
                s+=undoList.get(i).getAction()+"\n";
            }
        }
        else{
            s+="Empty";
        }
        s+="\nRedo List: \n";
        if (!redoList.empty()) {
            for (int i = 0; i < redoList.size(); i++) {
                s+=redoList.get(i).getAction()+"\n";
            }
        }
        else{
            s+="Empty";
        }
        return s;
    }
}
