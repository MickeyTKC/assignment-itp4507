
import java.util.*;

public interface CoffeeCommand {
    public String name();
    public abstract void execute();
}

class CommandAddProduct implements CoffeeCommand {
    private String name;
    private Scanner sc;
    private CoffeeShop c;
    public CommandAddProduct(String commandName,Scanner sc,CoffeeShop c){
        this.name = commandName;
        this.sc = sc;
        this.c = c;
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
                if (f.getFactoryKey().equals(choice)) {
                c.addPorduct(f.createProduct(sc));
                return;
                }
            }
            System.out.println("Please input a valid values");
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
    public CommandCollectProduct(String commandName,Scanner sc,CoffeeShop c){
        this.name = commandName;
        this.sc = sc;
        this.c = c;
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
            System.out.println("Quantity to deposit:");
            p.setQty(p.getQty()+Integer.valueOf(sc.next()));
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
    public CommandShipProduct(String commandName,Scanner sc,CoffeeShop c){
        this.name = commandName;
        this.sc = sc;
        this.c = c;
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
            p.setQty(p.getQty()-Integer.valueOf(sc.next()));
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
    private CoffeeShop c;
    public CommandUndo(String commandName,Scanner sc,CoffeeShop c){
        this.name = commandName;
        this.sc = sc;
        this.c = c;
    }
    public String name(){
        return this.name;
    }
    public void execute(){
        
    }
}

class CommandRedo implements CoffeeCommand{
    private String name;
    private Scanner sc;
    private CoffeeShop c;
    public CommandRedo(String commandName,Scanner sc,CoffeeShop c){
        this.name = commandName;
        this.sc = sc;
        this.c = c;
    }
    public String name(){
        return this.name;
    }
    public void execute(){
        
    }
}

class CommandURList implements CoffeeCommand{
    private String name;
    private Scanner sc;
    private CoffeeShop c;
    public CommandURList(String commandName,Scanner sc,CoffeeShop c){
        this.name = commandName;
        this.sc = sc;
        this.c = c;
    }
    public String name(){
        return this.name;
    }
    public void execute(){
        
    }
}

class CommandExit implements CoffeeCommand{
    private String name;
    private Scanner sc;
    private CoffeeShop c;
    public CommandExit(String commandName,Scanner sc,CoffeeShop c){
        this.name = commandName;
        this.sc = sc;
        this.c = c;
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
