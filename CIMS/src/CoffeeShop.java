
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

    public void addPorduct(CoffeeProduct p) {
        if(this.getProductByID(p.getProductID())!=null){
            System.out.println("Product "+p.getProductID()+" is exist already");
        }
        else{
            this.products.add(p);
        }
    }
    
    public CoffeeShop clone(){
        CoffeeShop temp = new CoffeeShop(this.title);
        for(CoffeeProduct p : this.getAllProducts()){
            temp.addPorduct(p.clone());
        }
        return temp;
    }
}