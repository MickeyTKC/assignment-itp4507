
import java.util.Scanner;

public interface CoffeeProductFactory {
    public String name();
    public CoffeeProduct createProduct(Scanner sc);
}

class CandyFactory implements CoffeeProductFactory {
    private final String name = "cc";
    public CoffeeProduct createProduct(Scanner sc) {
        String[] values;
        System.out.println("Enter product id, name, number of candy and calories per candy: ");
        try {
            values = sc.nextLine().split(", ");
            if (values.length == 4) {
                return new CoffeeCandy(
                        Integer.valueOf(values[0]),
                        values[1],
                        Integer.valueOf(values[2]),
                        Integer.valueOf(values[3])
                );
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Please input a valid values !");
        } finally {

        }
        return null;
    }
    public String name() {
        return this.name;
    }
}

class PowderFactory implements CoffeeProductFactory {
    private final String name = "cp";
    public CoffeeProduct createProduct(Scanner sc) {
        String[] values;
        System.out.println("Enter product id, name and weight(g): ");
        try {
            values = sc.nextLine().split(", ");
            if (values.length == 3) {
                return new CoffeePowder(
                        Integer.valueOf(values[0]),
                        values[1],
                        Integer.valueOf(values[2])
                );
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Please input a valid values !");
        } finally {

        }
        return null;
    }
    public String name() {
        return this.name;
    }
}
