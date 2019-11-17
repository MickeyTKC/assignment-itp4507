
import java.util.*;

public class CoffeMemento {
    
    private List<String> commands;
    private List<CoffeeShop> doRecords;
    private List<CoffeeShop> undoRecords;

    public CoffeMemento() {
        commands = new Vector<String>();
        doRecords = new Vector<CoffeeShop>();
        undoRecords = new Vector<CoffeeShop>();
    }

    public void action(CoffeeShop status) {
        doRecords.add(status);
    }

    public CoffeeShop undo() {
        CoffeeShop status = null;
        if (doRecords.size() > 0) {
            status = doRecords.get(doRecords.size() - 1);
            undoRecords.add(status);
        }
        return status;
    }
    
    public CoffeeShop redo(){ 
         CoffeeShop status = null;
         if (undoRecords.size() > 0) {
              status = undoRecords.get(doRecords.size() - 1);
              doRecords.add(status);
         }
         return status;
    }
}
