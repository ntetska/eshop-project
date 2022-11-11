import java.util.concurrent.atomic.AtomicInteger;

public class Item {
    private String name;
    private double price;
    private String description;
    private int stock;
    private final int id;
    private static final AtomicInteger count = new AtomicInteger(0);

    private  int quantity;

    public  void setQuantity(int q){
        quantity = q;
    }

    public  int getQuantity(){
        return quantity;
    }

    private static int noOfObjects = 0;

    public Item(){
        this.id = count.incrementAndGet();
        noOfObjects++;
    }

    public void setName(String n){
        this.name = n;
    }

    public String getName()
    {
        return this.name;
    }

    public void setPrice(double p){
        this.price = p;
    }

    public double getPrice(){
        return price;
    }

    public void setDescription(String d) {
        this.description = d;
    }

    public String getDescription(){
        return description;
    }

    public void setStock(int s){
        this.stock = s;
    }

    public int getStock() {
        return stock;
    }

    public int getId(){
        return this.id;
    }

    public String getBasicInfo(){
        return "Name:"+getName()+"\nPrice:"+getPrice()+"Euro"+""+"\nDescription:"+getDescription()+"\nStock:"+getStock()+"\nId:"+getId();
    }

    public String getDetails(){
        return null;
    }

    public String toString() {
        return getBasicInfo()+"\n"+getDetails();
    }

}
