
import java.util.*;

public class Caretaker {

    private Stack<Memento> undoList = new Stack<Memento>();
    private Stack<Memento> redoList = new Stack<Memento>();

    public void save(CoffeeProduct p, String a) {
        redoList.clear();
        Memento amemento = new Memento(p, a);
        undoList.push(amemento);
    }

    public void undo() {
        if (!undoList.isEmpty()) {
            System.out.println("undo completed.");
            Memento m = undoList.pop();
            Memento redomemento = new Memento(m.getProduct(),m.getAction());
            redoList.push(redomemento);
            m.restore();
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo() {
        if (!redoList.isEmpty()) {
            System.out.println("redo completed.");
            Memento m = redoList.pop();
            Memento undomemento = new Memento(m.getProduct(),m.getAction());
            undoList.push(undomemento);
            m.restore();
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    public String records() {
        String s = "";
        s += "Undo List: \n";
        if (!undoList.empty()) {
            for (int i = 0; i < undoList.size(); i++) {
                s += undoList.get(i).getAction() + "\n";
            }
        } else {
            s += "Empty";
        }
        s += "\nRedo List: \n";
        if (!redoList.empty()) {
            for (int i = 0; i < redoList.size(); i++) {
                s += redoList.get(i).getAction() + "\n";
            }
        } else {
            s += "Empty";
        }
        return s;
    }
}
