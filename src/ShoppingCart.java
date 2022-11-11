import java.util.*;

public class ShoppingCart {

    private static final Map<Integer, Item> itemOrdered = new HashMap<Integer, Item>();

    ShoppingCart() {

    }

    public void addItemOrdered(Item item) {
        itemOrdered.put(item.getId(), item);
    }

    public void removeItemOrdered(int c) {
        itemOrdered.keySet().remove(c);
    }


    public static void showCart() {
        System.out.println("Ordered:");
        System.out.println("------------------------------------------");
        for (Map.Entry<Integer, Item> items : itemOrdered.entrySet()) {
            System.out.println("Id:" + items.getKey() + ", " + "Name:" + items.getValue().getName() + ", Quantity:" + items.getValue().getQuantity() + ", " + "Price:" + calculateNet(items.getValue()) + ", Order price:" + SumOfCalculation(items.getValue()) + ", Courier:" + caclulateCourierCost(items.getValue()));
        }
        if (itemOrdered.isEmpty()) {
            System.out.println("Nothing ordered");
        }
        System.out.println("------------------------------------------");
    }

    public void clearCart() {
        itemOrdered.clear();
        System.out.println("Cart has cleared!");
    }

    public void checkout(EShop eshop) {
        showCart();
        System.out.print("Would you like to confirm your order(Y/n):");

        Scanner keyboard = new Scanner(System.in);

        char option = keyboard.next().charAt(0);
        switch (option) {
            case 'Y', 'y' -> {
                for (Map.Entry<Integer, Item> items : itemOrdered.entrySet()) {
                    int b = (int) (0.1*calculateNet(items.getValue()));
                    eshop.tmpBuyer.awardBonus(b);
                }
                System.out.println("You have successfully confirmed your order!");
            }
            case 'n', 'N' -> System.exit(1);
            default -> System.out.println("Error occurred");
        }
    }

    public static double calculateNet(Item item) {
        double sum = 0.0;

        sum = item.getPrice() * item.getQuantity();

        return sum;

    }

    public static double SumOfCalculation(Item item){
        double sum = 0.0;
        sum = caclulateCourierCost(item) + item.getPrice() * item.getQuantity();
        return sum;
    }

    public static double caclulateCourierCost(Item item) {
        double courierCost = 0;

        if (Buyer.isGold) {
            courierCost = 0;
        } else if (Buyer.isSilver) {
            courierCost = 0.5 * item.getPrice() * 0.02;
        } else if (Buyer.isBronze) {
            courierCost = item.getPrice() * 0.02;
        }
        return courierCost;
    }

    public void getKeyChecked(int c) {
        if (itemOrdered.containsKey(c)) {
            removeItemOrdered(c);
            System.out.println("Order with id:"+c+" has been removed");
        } else {
            System.out.println("The id does not exist!");
        }
    }

    public void ChangeQuantity(int quantity, int c) {
            if (itemOrdered.containsKey(c)) {
                itemOrdered.get(c).setQuantity(quantity);
                System.out.println("The quantity has been changed to:"+quantity);
            } else {
                System.out.println("Item, by that id, does not exist!");
            }
    }

}

