public class CoffeeProduct {
    private String name;
    private int productID;
    private int qty;
    
    public CoffeeProduct(String name, int productID) {
        this.name = name;
        this.productID = productID;
    }

    public String toString() {
        return this.productID+"\t"+this.name+"\t"+this.qty;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getProductID() {
        return productID;
    }
    public void setProductID(int productID) {
        this.productID = productID;
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
}

class Candy extends CoffeeProduct {
    private int noOfCandy;
    private int caloriesPerCandy;

    public Candy(int productID,String name, int noOfCandy, int caloriesPerCandy) {
        super(name, productID);
        this.noOfCandy = noOfCandy;
        this.caloriesPerCandy = caloriesPerCandy;
    }
    
    public int getNoOfCandy() {
        return noOfCandy;
    }
    public void setNoOfCandy(int noOfCandy) {
        this.noOfCandy = noOfCandy;
    }
    public int getCaloriesPerCandy() {
        return caloriesPerCandy;
    }
    public void setCaloriesPerCandy(int caloriesPerCandy) {
        this.caloriesPerCandy = caloriesPerCandy;
    }
}

class Powder extends CoffeeProduct{
    private int weight;

    public Powder(int productID,String name,int weight) {
        super(name, productID);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}
