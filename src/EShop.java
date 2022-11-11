import java.util.*;
import java.lang.*;

public class EShop {

    Menu m = new Menu();
    Buyer tmpBuyer = new Buyer();

    public void createOwner(String name, String mail, int pin) {
        Owner owner = new Owner();

        owner.setName(name);
        owner.setMail(mail);
        owner.setPin(pin);

        addOwner(owner);
    }

    public void addOwner(Owner owner) {
        ownerList.add(owner);
    }

    public List<Owner> getOwner() {
        return ownerList;
    }

    public void updateItemStock(Item item, int quantity) {
        if (quantity == item.getStock()) {
            System.out.println("Warning, both values are same");
        } else {
            item.setStock(quantity);
            System.out.println("Quantity for the item has changed!");
        }
    }

    public void addPenProduct(String name, double price, String description, int stock, String color, double tipSize, String type) {
        Pen pen = new Pen();

        pen.setName(name);
        pen.setPrice(price);
        pen.setDescription(description);
        pen.setStock(stock);
        pen.setColor(color);
        pen.setTipSize(tipSize);
        pen.setType(type);

        addPenItem(pen);

    }

    public void addPencilProduct(String name, double price, String description, int stock, double tipSize, String type) {
        Pencil pencil = new Pencil();

        pencil.setName(name);
        pencil.setPrice(price);
        pencil.setDescription(description);
        pencil.setStock(stock);
        pencil.setTipSize(tipSize);
        pencil.setType(type);

        addPencilItem(pencil);

    }

    public void addNotebookProduct(String name, double price, String description, int stock, int sections) {
        Notebook notebook = new Notebook();

        notebook.setName(name);
        notebook.setPrice(price);
        notebook.setDescription(description);
        notebook.setStock(stock);
        notebook.setSections(sections);

        addNotebookItem(notebook);
    }

    public void addPaperProduct(String name, double price, String description, int stock, int weight, int pages) {
        Paper paper = new Paper();

        paper.setName(name);
        paper.setPrice(price);
        paper.setDescription(description);
        paper.setStock(stock);
        paper.setWeight(weight);
        paper.setPages(pages);

        addPaperItem(paper);
    }


    public static class CategoriesName {
        private static final String PEN = "Pen";
        private static final String PENCIL = "Pencil";
        private static final String NOTEBOOK = "Notebook";
        private static final String PAPER = "Paper";

        public static String[] getCategories() {
            return new String[]{PEN + "\t\t\t\t" + Pen.getNoOfObjects(), PENCIL + "\t\t\t" + Pencil.getNoOfObjects(),
                    NOTEBOOK + "\t\t\t" + Notebook.getNoOfObjects(), PAPER + "\t\t\t\t" + Paper.getNoOfObjects()};
        }
    }

    private List<Buyer> buyerList = new ArrayList<Buyer>();
    private List<Owner> ownerList = new ArrayList<Owner>();
    private List<Pen> penList = new ArrayList<Pen>();
    private List<Pencil> pencilList = new ArrayList<Pencil>();
    private List<Paper> paperList = new ArrayList<Paper>();
    private List<Notebook> notebookList = new ArrayList<Notebook>();


    public EShop() {
        buyerList = new ArrayList<Buyer>();
    }

    public void showCategories() {
        System.out.println("Categories\t Amount of items");
        int i = 1;
        for (String cat : CategoriesName.getCategories()) {
            System.out.println(i + "." + cat);
            i++;
        }
    }

    public void showProductsInCategories(EShop eshop) {
        String option;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the name of a category to show its products:");
        option = keyboard.nextLine();

        switch (option) {
            case "Pen": {
                System.out.println("----------------");
                System.out.println("Pen Products:");
                System.out.println("Id  Name");
                for (Pen pen : getPenList()) {
                    System.out.println(getItemById(pen) + "\t" + pen.getName());

                }
                System.out.println("----------------");
                chooseProductForPen(eshop);
                break;
            }


            case "Pencil": {
                System.out.println("----------------");
                System.out.println("Pencil Products:");
                System.out.println("Id  Name");
                for (Pencil pencil : getPencilList()) {
                    System.out.println(getItemById(pencil) + "\t" + pencil.getName());
                }
                System.out.println("----------------");
                chooseProductForPencil(eshop);
                break;
            }
            case "Notebook": {
                System.out.println("----------------");
                System.out.println("Notebook Products:");
                System.out.println("Id  Name");
                for (Notebook notebook : getNotebookList()) {
                    System.out.println(getItemById(notebook) + "\t" + notebook.getName());

                }
                System.out.println("----------------");
                chooseProductForNotebook(eshop);
                break;
            }
            case "Paper": {
                System.out.println("----------------");
                System.out.println("Paper Products:");
                System.out.println("Id  Name");
                for (Paper paper : getPaperList()) {
                    System.out.println(getItemById(paper) + "\t" + paper.getName());
                }
                System.out.println("----------------");
                chooseProductForPaper(eshop);
                break;
            }
            default: {
                System.out.println("Error occurred!");
                break;
            }
        }


    }

    public void showProduct(Item item) {
        System.out.println(item.getBasicInfo());
    }


    //Methods for Buyers
    public Buyer createBuyer(String name, String mail, int bonus) {

        Buyer buyer = new Buyer();

        buyer.setName(name);
        buyer.setMail(mail);
        buyer.setBonus(bonus);

        //add buyer in the list
        addBuyer(buyer);

        return buyer;

    }

    public void addBuyer(Buyer buyer) {
        buyerList.add(buyer);
    }

    public void removeBuyer(Buyer buyer) {
        buyerList.remove(buyer);
    }

    public List<Buyer> getBuyers() {
        return buyerList;
    }

    //Methods for pen Items
    public void addPenItem(Pen pen) {
        penList.add(pen);
    }

    public List<Pen> getPenList() {
        return penList;
    }

    public void chooseProductForPen(EShop eshop) {
        int id;
        Scanner keyboard = new Scanner(System.in);

        try {

            System.out.print("Insert the id to choose:");
            id = keyboard.nextInt();

            for (Pen pen : getPenList()) {
                if (id == pen.getId()) {
                    showProduct(pen);
                    itemToBuy(pen, eshop);
                }
            }
        }catch (InputMismatchException ex){
            System.out.println("Wrong character!");
        }
    }

    //Methods for pencil Items
    public void addPencilItem(Pencil pencil) {
        pencilList.add(pencil);
    }

    public List<Pencil> getPencilList() {
        return pencilList;
    }

    public void chooseProductForPencil(EShop eshop) {
        int id;
        Scanner keyboard = new Scanner(System.in);

        try {
            System.out.print("Insert the id:");
            id = keyboard.nextInt();

            for (Pencil pencil : getPencilList()) {
                if (id == pencil.getId()) {
                    showProduct(pencil);
                    itemToBuy(pencil, eshop);
                }
            }
        }catch (InputMismatchException ex){
            System.out.println("Wrong character!");
        }
    }
    //Methods for notebook Items
    public void addNotebookItem(Notebook notebook) {
        notebookList.add(notebook);
    }

    public List<Notebook> getNotebookList() {
        return notebookList;
    }

    public void chooseProductForNotebook(EShop eshop) {
        int id;
        Scanner keyboard = new Scanner(System.in);

        try {
            System.out.print("Insert the id:");
            id = keyboard.nextInt();


            for (Notebook notebook : getNotebookList()) {
                if (id == notebook.getId()) {
                    showProduct(notebook);
                    itemToBuy(notebook, eshop);
                }
            }
        }catch (InputMismatchException ex){
            System.out.println("Wrong character!");
        }
    }

    //Methods for paper Items
    public void addPaperItem(Paper paper) {
        paperList.add(paper);
    }

    public List<Paper> getPaperList() {
        return paperList;
    }

    public int getItemById(Item item) {
        return item.getId();
    }

    public void chooseProductForPaper(EShop eshop) {
        int id;
        Scanner keyboard = new Scanner(System.in);

        try {
            System.out.print("Insert the id:");
            id = keyboard.nextInt();


            for (Paper paper : getPaperList()) {
                if (id == paper.getId()) {
                    showProduct(paper);
                    itemToBuy(paper, eshop);
                }
            }
        }catch (InputMismatchException ex){
            System.out.println("Wrong character!");
        }
    }

    public void itemToBuy(Item item, EShop eshop) {
        char option;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Would you like to buy?(Y/n):");
        option = keyboard.next().charAt(0);

        switch (option) {
            case 'Y':
            case 'y': {
                System.out.print("Quantity:");
                int quantity = keyboard.nextInt();
                item.setQuantity(quantity);
                checkForStock(item, quantity);
                Buyer.placeOrder(item);
                System.out.println("You have purchased the current item!");
                //updating stock instantly
                item.setStock(item.getStock() - quantity);
                break;
            }
            case 'N':
            case 'n': {
                m.menuForUser(eshop);
                break;
            }
            default: {
                System.out.println("Error occurred!");
                break;
            }
        }

    }

    public void checkForStock(Item item, int quantity) {
        Scanner keyboard = new Scanner(System.in);
        if (quantity > item.getStock()) {
            do {
                System.out.println("Your quantity is over than our stock!,please try again!");
                System.out.print("Quantity:");
                quantity = keyboard.nextInt();
                item.setQuantity(quantity);
            } while (quantity > item.getStock());
        }
    }

    public void checkStatus(EShop eshop) {
        int i = 1;

        for (Buyer buyer : getBuyers()) {
            System.out.println(i + "." + "Full name:" + buyer.getName() + " | Bonus:" + buyer.getBonus());
            buyer.BuyerCategory();
            System.out.println("------------------------------");
            i++;
        }
        chooseClient(eshop);
    }

    //owner Methods for products

    public void chooseClient(EShop eshop) {
        String option;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Insert the name of buyer:");
        option = keyboard.nextLine();
        for (Buyer buyer : buyerList) {
            if (option.equals(buyer.getName())) {
                ShoppingCart.showCart();
                char choice;
                System.out.print("Would you like to delete the temporary buyer?(Y/n):");
                choice = keyboard.next().charAt(0);
                if (choice == 'y' || choice == 'Y') {
                    removeBuyer(buyer);
                    System.out.println("Buyer has been removed successfully!");
                    m.menuForOwner(eshop);
                } else if (choice == 'n' || choice == 'N') {
                    m.menuForOwner(eshop);
                }
            }
        }
    }

    public void showProductsInCategoriesForOwner(EShop eshop) {
        String option;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the name of a category to show its products:");
        option = keyboard.nextLine();

        switch (option) {
            case "Pen": {
                System.out.println("Pen Products:");
                System.out.println("Id  Name");
                for (Pen pen : getPenList()) {
                    System.out.println(getItemById(pen) + "\t" + pen.getName());
                }
                chooseProductForPenOwner(eshop);
                break;
            }

            case "Pencil": {
                System.out.println("Pencil Products:");
                System.out.println("Id  Name");
                for (Pencil pencil : getPencilList()) {
                    System.out.println(getItemById(pencil) + "\t" + pencil.getName());
                }
                chooseProductForPencilOwner(eshop);
                break;
            }
            case "Notebook": {

                System.out.println("Notebook Products:");
                System.out.println("Id  Name");
                for (Notebook notebook : getNotebookList()) {
                    System.out.println(getItemById(notebook) + "\t" + notebook.getName());
                }
                chooseProductForNotebookOwner(eshop);
                break;

            }
            case "Paper": {
                System.out.println("Paper Products:");
                System.out.println("Id  Name");
                for (Paper paper : getPaperList()) {
                    System.out.println(getItemById(paper) + "\t" + paper.getName());
                }
                chooseProductForPaperOwner(eshop);
                break;
            }
            default: {
                System.out.println("Error occurred!");
                break;
            }
        }

    }

    public void chooseProductForPenOwner(EShop eshop) {
        int id;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Insert the id to choose:");
        id = keyboard.nextInt();

        for (Pen pen : getPenList()) {
            if (id == pen.getId()) {
                System.out.print("Give new quantity:");
                int quantity = keyboard.nextInt();
                updateItemStock(pen, quantity);
                break;
            }
        }
        m.menuForOwner(eshop);

    }

    public void chooseProductForPencilOwner(EShop eshop) {
        int id;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Insert the id:");
        id = keyboard.nextInt();

        for (Pencil pencil : getPencilList()) {
            if (id == pencil.getId()) {
                System.out.print("Give new quantity:");
                int quantity = keyboard.nextInt();
                updateItemStock(pencil, quantity);
            }
        }
        m.menuForOwner(eshop);

    }

    public void chooseProductForNotebookOwner(EShop eshop) {
        int id;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Insert the id:");
        id = keyboard.nextInt();

        for (Notebook notebook : getNotebookList()) {
            if (id == notebook.getId()) {
                System.out.print("Give new quantity:");
                int quantity = keyboard.nextInt();
                updateItemStock(notebook, quantity);
            }
        }
        m.menuForOwner(eshop);
    }

    public void chooseProductForPaperOwner(EShop eshop) {
        int id;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Insert the id:");
        id = keyboard.nextInt();

        for (Paper paper : getPaperList()) {
            if (id == paper.getId()) {
                System.out.print("Give new quantity:");
                int quantity = keyboard.nextInt();
                updateItemStock(paper, quantity);
            }
        }
        m.menuForOwner(eshop);
    }
}
