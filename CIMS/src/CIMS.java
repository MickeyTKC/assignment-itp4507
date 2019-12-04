
import java.util.*;

public class CIMS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoffeeShop shop = new CoffeeShop("Coffee Shop");
        Caretaker record = new Caretaker();
        final CoffeeCommand[] coffeeCommand = {
            new CommandAddProduct("a", sc, shop,record),
            new CommandCollectProduct("c", sc, shop,record),
            new CommandShipProduct("s", sc, shop,record),
            new CommandViewProduct("v", sc, shop),
            new CommandUndo("u", sc, record),
            new CommandRedo("r", sc, record),
            new CommandURList("sl",sc,record),
            new CommandExit("x", sc),
        };
        record.save(shop,"Create Coffee Shop");
        while (true) {
            System.out.println("Please enter command: [a | v | c | s | u | r | sl | x]");
            String input = sc.next();
            for (CoffeeCommand cmd : coffeeCommand) {
                if (cmd.name().equals(input)) {
                    cmd.execute();
                    break;
                }
            }
        }
    }
}
