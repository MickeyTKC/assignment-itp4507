
import java.util.*;

public interface CoffeeCommand {
    public abstract String getKey();
    public abstract void execute(Scanner sc, CoffeeShop c);
}

class CommandAddProduct implements CoffeeCommand {
    private String key="a";
    public String getKey(){
        return this.key;
    }
    public void execute(Scanner sc, CoffeeShop c) {
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
            execute(sc, c);
        }
        catch(Exception e){
            
        }
    }
}

class CommandViewProduct implements CoffeeCommand {
    private String key="v";
    public String getKey(){
        return this.key;
    }
    public void execute(Scanner sc, CoffeeShop c) {
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
            execute(sc, c);
        }
    }
}

class CommandCollectProduct implements CoffeeCommand {
    private String key="c";
    public String getKey(){
        return this.key;
    }
    public void execute(Scanner sc, CoffeeShop c) {
        System.out.println("Enter Product ID:");
        String input = sc.next();
        List<CoffeeProduct> list = c.getAllProducts();
        try {
            CoffeeProduct p = c.getProductByID(Integer.valueOf(input));
            System.out.println("Quantity to deposit:");
            p.setQty(Integer.valueOf(sc.next()));
            return;
        } catch (NumberFormatException e) {
            System.out.println("It is a invalid value !");
        } catch (Exception e) {

        }
        System.out.println("Please input a valid Product ID");
        execute(sc, c);
    }
}

class CommandShipProduct implements CoffeeCommand {
    private String key="s";
    public String getKey(){
        return this.key;
    }
    public void execute(Scanner sc, CoffeeShop c) {
        System.out.println("Enter Product ID:");
        String input = sc.next();
        List<CoffeeProduct> list = c.getAllProducts();
        try {
            CoffeeProduct p = c.getProductByID(Integer.valueOf(input));
            System.out.println("Quantity to ship:");
            p.setQty(Integer.valueOf(sc.next()) * -1);
            return;
        } catch (NumberFormatException e) {
            System.out.println("It is a invalid value !");
        } catch (Exception e) {

        }
        System.out.println("Please input a valid Product ID");
        execute(sc, c);
    }
}
