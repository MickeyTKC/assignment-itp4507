
import java.util.*;

public interface CoffeeCommand {
    public String name();
    public abstract void execute();
}

class CommandAddProduct implements CoffeeCommand {
    private String name;
    private Scanner sc;
    private CoffeeShop c;
    private Caretaker r;
    public CommandAddProduct(String commandName,Scanner sc,CoffeeShop c,Caretaker r){
        this.name = commandName;
        this.sc = sc;
        this.c = c;
        this.r=r;
    }
    public String name(){
        return this.name;
    }
    public void execute() {
        try{
            CoffeeProductFactory[] cpf = {new CandyFactory(), new PowderFactory()};
            System.out.println("Enter Coffee type (cc=Coffee Candy/cp=Coffee Powder):");
            String choice = sc.next();
            for (CoffeeProductFactory f : cpf) {
                if (f.name().equals(choice)) {
                    CoffeeProduct p = f.createProduct(sc);
                    c.addPorduct(p);
                    r.save(c, "Add: "+p.toString());
                    return;
                }
            }
            System.out.println("Please input a valid Coffee type");
            execute();
        }
        catch(Exception e){
            
        }
    }
}

class CommandViewProduct implements CoffeeCommand {
    private String name;
    private Scanner sc;
    private CoffeeShop c;
    public CommandViewProduct(String commandName,Scanner sc,CoffeeShop c){
        this.name = commandName;
        this.sc = sc;
        this.c = c;
    }
    public String name(){
        return this.name;
    }
    public void execute() {
        System.out.println("Enter product Id. (* to show all):");
        String input = sc.next();
        List<CoffeeProduct> list = c.getAllProducts();
        if (input.equals("*")) {
            for (CoffeeProduct p : list) {
                System.out.println(p);
            }
        } else {
            for (CoffeeProduct p : list) {
                if (p.getProductID() == Integer.valueOf(input)) {
                    System.out.println(p);
                    return;
                }
            }
            System.out.println("Please input a valid Product ID");
            execute();
        }
    }
}

class CommandCollectProduct implements CoffeeCommand {
    private String name;
    private Scanner sc;
    private CoffeeShop c;
    private Caretaker r;
    public CommandCollectProduct(String commandName,Scanner sc,CoffeeShop c,Caretaker r){
        this.name = commandName;
        this.sc = sc;
        this.c = c;
        this.r=r;
    }
    public String name(){
        return this.name;
    }
    public void execute() {
        System.out.println("Enter Product ID:");
        int id = sc.nextInt();
        List<CoffeeProduct> list = c.getAllProducts();
        try {
            CoffeeProduct p = c.getProductByID(id);
            System.out.println("Quantity to deposit:");
            int qty = sc.nextInt();
            p.setQty(p.getQty()+qty);
            r.save(c, "Received: "+qty+p.getName()+" ("+p.getProductID()+")");
            return;
        } catch (NumberFormatException e) {
            System.out.println("It is a invalid value !");
        } catch (Exception e) {

        }
        System.out.println("Please input a valid Product ID");
        execute();
    }
}

class CommandShipProduct implements CoffeeCommand {
    private String name;
    private Scanner sc;
    private CoffeeShop c;
    private Caretaker r;
    public CommandShipProduct(String commandName,Scanner sc,CoffeeShop c,Caretaker r){
        this.name = commandName;
        this.sc = sc;
        this.c = c;
        this.r=r;
    }
    public String name(){
        return this.name;
    }
    public void execute() {
        System.out.println("Enter Product ID:");
        String input = sc.next();
        List<CoffeeProduct> list = c.getAllProducts();
        try {
            CoffeeProduct p = c.getProductByID(Integer.valueOf(input));
            System.out.println("Quantity to ship:");
            int qty = sc.nextInt();
            p.setQty(p.getQty()-qty);
            r.save(c, "Shipped: "+qty+p.getName()+" ("+p.getProductID()+")");
            return;
        } catch (NumberFormatException e) {
            System.out.println("It is a invalid value !");
        } catch (Exception e) {

        }
        System.out.println("Please input a valid Product ID");
        execute();
    }
}

class CommandUndo implements CoffeeCommand{
    private String name;
    private Scanner sc;
    private Caretaker r;
    public CommandUndo(String commandName,Scanner sc,Caretaker r){
        this.name = commandName;
        this.sc = sc;
        this.r = r;
    }
    public String name(){
        return this.name;
    }
    public void execute(){
        if(r.undo()){
            System.out.println("Perform undo");
        }
        else{
            System.out.println("Nothing to undo.");
        }
    }
}

class CommandRedo implements CoffeeCommand{
    private String name;
    private Scanner sc;
    private Caretaker r;
    public CommandRedo(String commandName,Scanner sc,Caretaker r){
        this.name = commandName;
        this.sc = sc;
        this.r = r;
    }
    public String name(){
        return this.name;
    }
    public void execute(){
        if(r.redo()){
            System.out.println("Perform redo");
        }
        else{
            System.out.println("Nothing to redo.");
        }
    }
}

class CommandURList implements CoffeeCommand{
    private String name;
    private Scanner sc;
    private Caretaker r;
    public CommandURList(String commandName,Scanner sc,Caretaker r){
        this.name = commandName;
        this.sc = sc;
        this.r = r;
    }
    public String name(){
        return this.name;
    }
    public void execute(){
        System.out.println(r.records());
    }
}

class CommandExit implements CoffeeCommand{
    private String name;
    private Scanner sc;
    public CommandExit(String commandName,Scanner sc){
        this.name = commandName;
        this.sc = sc;
    }
    public String name(){
        return this.name;
    }
    public void execute(){
        System.out.println("Exit System ? (Y/N)");
        String input = sc.next();
        if(input.toUpperCase().equals("Y")){
            System.exit(1);
        }
    }
}
