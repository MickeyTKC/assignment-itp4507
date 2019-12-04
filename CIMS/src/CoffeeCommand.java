
import java.util.*;

public interface CoffeeCommand {
    public abstract void execute();
}

class CommandAddProduct implements CoffeeCommand {
    private Scanner sc;
    private CoffeeShop c;
    private Caretaker r;
    public CommandAddProduct(Scanner sc,CoffeeShop c,Caretaker r){
        this.sc = sc;
        this.c = c;
        this.r=r;
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
                    r.save(c, "Add "+p.getProductID()+" "+p.getName());
                    System.out.println("New product record created.");
                    return;
                }
            }
            System.out.println("Please input a valid Coffee type");
        }
        catch(Exception e){
            
        }
    }
}

class CommandViewProduct implements CoffeeCommand {
    private Scanner sc;
    private CoffeeShop c;
    public CommandViewProduct(Scanner sc,CoffeeShop c){
        this.sc = sc;
        this.c = c;
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
        }
    }
}

class CommandCollectProduct implements CoffeeCommand {
    private Scanner sc;
    private CoffeeShop c;
    private Caretaker r;
    public CommandCollectProduct(Scanner sc,CoffeeShop c,Caretaker r){
        this.sc = sc;
        this.c = c;
        this.r=r;
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
            r.save(c, "Received "+qty+p.getName()+" ("+p.getProductID()+")");
            System.out.println("Received "+qty+" packs of "+p.getName()+". Current quantity is "+p.getQty()+".");
            return;
        } catch (NumberFormatException e) {
            System.out.println("It is a invalid value !");
        } catch (Exception e) {

        }
        System.out.println("Please input a valid Product ID");
    }
}

class CommandShipProduct implements CoffeeCommand {
    private Scanner sc;
    private CoffeeShop c;
    private Caretaker r;
    public CommandShipProduct(Scanner sc,CoffeeShop c,Caretaker r){
        this.sc = sc;
        this.c = c;
        this.r=r;
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
            r.save(c, "Shipped "+qty+p.getName()+" ("+p.getProductID()+")");
            System.out.println("Shipped "+qty+" packs of "+p.getName()+". Current quantity is "+p.getQty()+".");
            return;
        } catch (NumberFormatException e) {
            System.out.println("It is a invalid value !");
        } catch (Exception e) {

        }
        System.out.println("Please input a valid Product ID");
    }
}

class CommandUndo implements CoffeeCommand{
    private Scanner sc;
    private Caretaker r;
    public CommandUndo(Scanner sc,Caretaker r){
        this.sc = sc;
        this.r = r;
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
    private Scanner sc;
    private Caretaker r;
    public CommandRedo(Scanner sc,Caretaker r){
        this.sc = sc;
        this.r = r;
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
    private Scanner sc;
    private Caretaker r;
    public CommandURList(Scanner sc,Caretaker r){
        this.sc = sc;
        this.r = r;
    }
    public void execute(){
        System.out.println(r.records());
    }
}

class CommandExit implements CoffeeCommand{
    private Scanner sc;
    public CommandExit(Scanner sc){
        this.sc = sc;
    }
    public void execute(){
        System.out.println("Exit System ? (Y/N)");
        String input = sc.next();
        if(input.toUpperCase().equals("Y")){
            System.exit(1);
        }
    }
}
