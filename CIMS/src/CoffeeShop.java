
import java.util.*;

public class CoffeeShop {

    private String title;
    private List<CoffeeProduct> products;

    public CoffeeShop(String title) {
        this.title = title;
        this.products = new Vector<CoffeeProduct>();
    }

    public CoffeeShop(String title, List<CoffeeProduct> products) {
        this.title = title;
        this.products = products;
    }

    public String getTitle() {
        return this.title;
    }
    public void addPorduct(CoffeeProduct p) {
        if(this.getProductByID(p.getProductID())!=null){
            System.out.println("Product "+p.getProductID()+" is exist already");
        }
        else{
            this.products.add(p);
        }
    }
    public List<CoffeeProduct> getAllProducts() {
        return this.products;
    }
    public CoffeeProduct getProductByID(int productID) {
        for (CoffeeProduct p : products) {
            if (p.getProductID() == productID) {
                return p;
            }
        }
        return null;
    }
}

class Memento {
    private CoffeeProduct p;
    private int qty;
    private String action;
    public Memento(CoffeeProduct p) {
       this.p = p;
       this.qty = p.getQty();
    }
    public Memento(CoffeeProduct p,String action) {
       this.p = p;
       this.qty = p.getQty();
       this.action = action;
    }
    public void restore() {
        p.setQty(this.qty);
    }
    public String getAction(){
        return this.action;
    }
    public CoffeeProduct getProduct(){
        return p;
    }
}