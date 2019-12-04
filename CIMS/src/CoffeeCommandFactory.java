import java.util.*;

public interface CoffeeCommandFactory {
    public String name();
    public CoffeeCommand create();
}

class AddProductFactory implements CoffeeCommandFactory{
    private String name;
    private Scanner sc;
    private CoffeeShop c;
    private Caretaker r;
    public AddProductFactory(String name, Scanner sc, CoffeeShop c, Caretaker r) {
        this.name = name;
        this.sc = sc;
        this.c = c;
        this.r = r;
    }
    public CoffeeCommand create(){
        return new CommandAddProduct(sc,c,r);
    }
    public String name(){
        return name;
    }
}

class ViewProductFactory implements CoffeeCommandFactory{
    private String name;
    private Scanner sc;
    private CoffeeShop c;
    public ViewProductFactory(String name, Scanner sc, CoffeeShop c) {
        this.name = name;
        this.sc = sc;
        this.c = c;
    }
    public CoffeeCommand create(){
        return new CommandViewProduct(sc,c);
    }
    public String name(){
        return name;
    }
}

class CollectProductFactory implements CoffeeCommandFactory{
    private String name;
    private Scanner sc;
    private CoffeeShop c;
    private Caretaker r;
    public CollectProductFactory(String name, Scanner sc, CoffeeShop c, Caretaker r) {
        this.name = name;
        this.sc = sc;
        this.c = c;
        this.r = r;
    }
    public CoffeeCommand create(){
        return new CommandCollectProduct(sc,c,r);
    }
    public String name(){
        return name;
    }
}

class ShipProductFactory implements CoffeeCommandFactory{
    private String name;
    private Scanner sc;
    private CoffeeShop c;
    private Caretaker r;
    public ShipProductFactory(String name, Scanner sc, CoffeeShop c, Caretaker r) {
        this.name = name;
        this.sc = sc;
        this.c = c;
        this.r = r;
    }
    public CoffeeCommand create(){
        return new CommandShipProduct(sc,c,r);
    }
    public String name(){
        return name;
    }
}

class UndoFactory implements CoffeeCommandFactory{
    private String name;
    private Scanner sc;
    private Caretaker r;
    public UndoFactory(String name, Scanner sc, Caretaker r) {
        this.name = name;
        this.sc = sc;
        this.r = r;
    }
    public CoffeeCommand create(){
        return new CommandUndo(sc,r);
    }
    public String name(){
        return name;
    }
}

class RedoFactory implements CoffeeCommandFactory{
    private String name;
    private Scanner sc;
    private Caretaker r;
    public RedoFactory(String name, Scanner sc, Caretaker r) {
        this.name = name;
        this.sc = sc;
        this.r = r;
    }
    public CoffeeCommand create(){
        return new CommandRedo(sc,r);
    }
    public String name(){
        return name;
    }
}
class URListFactory implements CoffeeCommandFactory{
    private String name;
    private Scanner sc;
    private Caretaker r;
    public URListFactory(String name, Scanner sc, Caretaker r) {
        this.name = name;
        this.sc = sc;
        this.r = r;
    }
    public CoffeeCommand create(){
        return new CommandURList(sc,r);
    }
    public String name(){
        return name;
    }
}

class ExitFactory implements CoffeeCommandFactory{
    private String name;
    private Scanner sc;
    public ExitFactory(String name,Scanner sc){
        this.name = name;
        this.sc = sc;
    }
    public CoffeeCommand create(){
        return new CommandExit(sc);
    }
    public String name(){
        return name;
    }
}
