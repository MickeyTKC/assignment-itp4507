
import java.util.*;

public class Assignment {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoffeeShop shop = new CoffeeShop("Coffee Inventory Management System");
        Caretaker record = new Caretaker();
        final CoffeeCommandFactory[] coffeeCommand = {
            new AddProductFactory("a", sc, shop, record),
            new CollectProductFactory("c", sc, shop, record),
            new ShipProductFactory("s", sc, shop, record),
            new ViewProductFactory("v", sc, shop),
            new UndoFactory("u", sc, record),
            new RedoFactory("r", sc, record),
            new URListFactory("sl", sc, record),
            new ExitFactory("x"),};
        record.save(shop, "Create Coffee Shop");
        while (true) {
            System.out.println(shop.getTitle());
            System.out.println("Please enter command: [a | v | c | s | u | r | sl | x]");
            System.out.println("a = add product, v = view products, c = collect product, s = ship product,\nu = undo, r = redo, sl = show list undo/redo, x = exit system");
            String input = sc.next();
            for (CoffeeCommandFactory cf : coffeeCommand) {
                if (cf.name().equals(input)) {
                    cf.create().execute();
                    break;
                }
            }
        }
    }
}
