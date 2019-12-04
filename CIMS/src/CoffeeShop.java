
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
    public void setProducts(List<CoffeeProduct> product){
        this.products = product;
    }
    public void collectProduct(int productID,int qty){
        CoffeeProduct p =  getProductByID(productID);
        p.setQty(p.getProductID()+qty);
    }
    public void shipProduct(int productID,int qty){
        CoffeeProduct p =  getProductByID(productID);
        p.setQty(p.getProductID()-qty);
    }
    public CoffeeShop clone(){
        CoffeeShop temp = new CoffeeShop(this.title);
        for(CoffeeProduct p : this.getAllProducts()){
            temp.addPorduct(p.clone());
        }
        return temp;
    }
}

class Memento {
    private CoffeeShop cs;
    private List<CoffeeProduct> p;
    public Memento(CoffeeShop cs) {
       this.p = cs.clone().getAllProducts();
    }
    public void restore() {
        cs.setProducts(p);
    }
}