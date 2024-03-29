
import java.util.*;

public interface CoffeeCommand {

    public abstract void execute();
}

class CommandAddProduct implements CoffeeCommand {

    private Scanner sc;
    private CoffeeShop c;
    private Caretaker r;

    public CommandAddProduct(Scanner sc, CoffeeShop c, Caretaker r) {
        this.sc = sc;
        this.c = c;
        this.r = r;
    }

    public void execute() {
        try {
            CoffeeProductFactory[] cpf = {new CandyFactory(), new PowderFactory()};
            System.out.println("\nEnter Coffee type (cc=Coffee Candy/cp=Coffee Powder): ");
            String choice = sc.nextLine();
            for (CoffeeProductFactory f : cpf) {
                if (f.name().equals(choice)) {
                    CoffeeProduct p = f.createProduct(sc);
                    r.save(p, "Add " + p.getProductID() + " " + p.getName());
                    c.addPorduct(p);
                    System.out.println("New product record created.");
                    return;
                }
            }
            System.out.println("Please input a valid Coffee type");
        } catch (Exception e) {

        }
    }
}

class CommandViewProduct implements CoffeeCommand {

    private Scanner sc;
    private CoffeeShop c;

    public CommandViewProduct(Scanner sc, CoffeeShop c) {
        this.sc = sc;
        this.c = c;
    }

    public void execute() {
        System.out.println("Enter product id (* to show all):");
        String input = sc.nextLine();
        List<CoffeeProduct> list = c.getAllProducts();
        if (input.equals("*")) {
            if (list.isEmpty()) {
                System.out.println("It is empty.");
            } else {
                System.out.println("\nCoffee Product information\nID			Name				Quantity		Other Info");
                for (CoffeeProduct p : list) {
                    System.out.println(p);
                }
            }
        } else {
            for (CoffeeProduct p : list) {
                if (p.getProductID() == Integer.valueOf(input)) {
                    System.out.println("Product information\n" + p.details());
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

    public CommandCollectProduct(Scanner sc, CoffeeShop c, Caretaker r) {
        this.sc = sc;
        this.c = c;
        this.r = r;
    }

    public void execute() {
        System.out.println("Enter product id:");
        int id = sc.nextInt();
        List<CoffeeProduct> list = c.getAllProducts();
        try {
            CoffeeProduct p = c.getProductByID(id);
            System.out.println("Quantity to receive:");
            int qty = sc.nextInt();
             r.save(p, "Received " + qty + " " + p.getName() + " (" + p.getProductID() + ")");
            p.setQty(p.getQty() + qty);
            System.out.println("Received " + qty + " packs of " + p.getName() + ". Current quantity is " + p.getQty() + ".");
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

    public CommandShipProduct(Scanner sc, CoffeeShop c, Caretaker r) {
        this.sc = sc;
        this.c = c;
        this.r = r;
    }

    public void execute() {
        System.out.println("Enter product id:");
        String input = sc.nextLine();
        List<CoffeeProduct> list = c.getAllProducts();
        try {
            CoffeeProduct p = c.getProductByID(Integer.valueOf(input));
            System.out.println("Quantity to ship:");
            int qty = sc.nextInt();
            if (qty <= p.getQty()) {
                r.save(p, "Shipped "+qty+" "+p.getName()+" ("+p.getProductID()+")");
                p.setQty(p.getQty() - qty);
                System.out.println("Shipped " + qty + " packs of " + p.getName() + ". Current quantity is " + p.getQty() + ".");
            } else {
                System.out.println("Invalid quantity (current balance is less than required quantity). Try again!!!");
            }
            return;
        } catch (NumberFormatException e) {
            System.out.println("It is a invalid value !");
        } catch (Exception e) {

        }
        System.out.println("Please input a valid Product ID");
    }
}

class CommandUndo implements CoffeeCommand {

    private Scanner sc;
    private Caretaker r;

    public CommandUndo(Scanner sc, Caretaker r) {
        this.sc = sc;
        this.r = r;
    }

    public void execute() {
        r.undo();
    }
}

class CommandRedo implements CoffeeCommand {

    private Scanner sc;
    private Caretaker r;

    public CommandRedo(Scanner sc, Caretaker r) {
        this.sc = sc;
        this.r = r;
    }

    public void execute() {
        r.redo();
    }
}

class CommandURList implements CoffeeCommand {

    private Scanner sc;
    private Caretaker r;

    public CommandURList(Scanner sc, Caretaker r) {
        this.sc = sc;
        this.r = r;
    }

    public void execute() {
        System.out.println(r.records());
    }
}

class CommandExit implements CoffeeCommand {

    public void execute() {
        System.out.println("Thanks for using Coffee Inventory Management System!!");
        System.exit(1);
    }
}
