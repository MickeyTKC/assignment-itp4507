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
    public CoffeeProduct clone(){
        CoffeeProduct temp = new CoffeeProduct(this.name,this.productID);
        temp.setQty(this.qty);
        return temp;
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
    @Override
    public CoffeeProduct clone(){
        CoffeeProduct temp = new Candy(this.getProductID(),this.getName(),this.getNoOfCandy(),this.getCaloriesPerCandy());
        temp.setQty(this.getQty());
        return temp;
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
    @Override
    public CoffeeProduct clone(){
        CoffeeProduct temp = new Powder(this.getProductID(),this.getName(),this.getWeight());
        temp.setQty(this.getQty());
        return temp;
    }
}
