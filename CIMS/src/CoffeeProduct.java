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
    public String details(){
        return "ID: " + getProductID() +"\nName: " + getName() + "\nQuantity: " + getQty();
    }
}

class CoffeeCandy extends CoffeeProduct {
    private int noOfCandy;
    private int caloriesPerCandy;

    public CoffeeCandy(int productID,String name, int noOfCandy, int caloriesPerCandy) {
        super(name, productID);
        this.noOfCandy = noOfCandy;
        this.caloriesPerCandy = caloriesPerCandy;
    }
    
    @Override
    public String toString(){
        return super.toString()+"\t"+this.noOfCandy+" candy per package ("+this.caloriesPerCandy+" calories each)";
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
        CoffeeProduct temp = new CoffeeCandy(this.getProductID(),this.getName(),this.getNoOfCandy(),this.getCaloriesPerCandy());
        temp.setQty(this.getQty());
        return temp;
    }
    public String details() {
        return super.details() + "\nNumber of candies per package: " + getNoOfCandy()+ "\nCalories Per candy: " + getCaloriesPerCandy();
    }
}

class CoffeePowder extends CoffeeProduct{
    private double weight;

    public CoffeePowder(int productID,String name,double weight) {
        super(name, productID);
        this.weight = weight;
    }

    @Override
    public String toString(){
        return super.toString()+"\t"+this.weight+"g";
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    @Override
    public CoffeeProduct clone(){
        CoffeeProduct temp = new CoffeePowder(this.getProductID(),this.getName(),this.getWeight());
        temp.setQty(this.getQty());
        return temp;
    }
    public String details() {
        return super.details() + "\nWeight: " + getWeight();
    }
}
