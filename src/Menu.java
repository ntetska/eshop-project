import java.util.*;

public class Menu {
    ShoppingCart cart = new ShoppingCart();

    public void menuForUser(EShop eshop) {

        System.out.println("------Menu------");
        System.out.println("1.Browse Store");
        System.out.println("2.View Cart");
        System.out.println("3.Checkout");
        System.out.println("4.Logout");
        System.out.println("5.Exit");
        System.out.println("----------------");

        int choice = 0;

        Scanner keyboard = new Scanner(System.in);


        do {
            try {

                System.out.print("Enter your choice(1,2,...):");

                choice = keyboard.nextInt();

                switch (choice) {
                    case 1 -> {
                        eshop.showCategories();
                        eshop.showProductsInCategories(eshop);
                        buyAgain(eshop);
                    }
                    case 2 -> {
                        ShoppingCart.showCart();
                        optionForCart(eshop);
                        menuForUser(eshop);
                    }
                    case 3 -> {
                        cart.checkout(eshop);
                        cart.clearCart();
                        menuForUser(eshop);
                    }
                    case 4 -> {
                        System.out.print("Would you like to sign out(y/n):");
                        char option;

                        option = keyboard.next().charAt(0);

                        if (option == 'y' || option == 'Y') {
                            logout(eshop);
                        } else if (option == 'n' || option == 'N') {
                            menuForUser(eshop);
                        }
                    }
                    case 5 -> {
                        System.out.println("Exit...");
                        System.exit(0);
                    }
                    default -> System.out.println("Error occurred!\n");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Wrong character in input box!");
            }
            keyboard.nextLine();
        } while (choice < 1 || choice > 4);
    }

    public void menuForOwner(EShop eshop) {
        System.out.println("------Menu------");
        System.out.println("1.Browse Store");
        System.out.println("2.Check Status");
        System.out.println("3.Logout");
        System.out.println("4.Exit");
        System.out.println("----------------");

        int choice = 0;

        Scanner keyboard = new Scanner(System.in);

        do {
            try {


                System.out.print("Enter your choice(1,2,...):");

                choice = keyboard.nextInt();

                switch (choice) {
                    case 1 -> {
                        eshop.showCategories();
                        eshop.showProductsInCategoriesForOwner(eshop);
                    }
                    case 2 -> {
                        eshop.checkStatus(eshop);
                        menuForOwner(eshop);
                    }

                    case 3 -> {
                        System.out.print("Would you like to sign out(y/n):");
                        char option;

                        option = keyboard.next().charAt(0);

                        if (option == 'y' || option == 'Y') {
                            logout(eshop);

                        } else if (option == 'n' || option == 'N') {
                            menuForOwner(eshop);
                        }
                    }
                    case 4 -> {
                        System.out.println("Exit...");
                        System.exit(0);
                    }
                    default -> System.out.println("Error occurred!");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Wrong character in input box!");
                ex.printStackTrace();
            }
            keyboard.nextLine();
        } while (choice < 1 || choice > 4);
    }

    public void identification(EShop eshop) {

        try {
            eshop.tmpBuyer = null;
            Scanner keyboard = new Scanner(System.in);
            String mail;

            //identify the user
            System.out.print("Email:");
            mail = keyboard.nextLine();

            if (mail.equals(eshop.getOwner().get(0).getMail())) {
                askForPin(eshop.getOwner().get(0));
                menuForOwner(eshop);
            } else {

                for (Buyer b : eshop.getBuyers()) {
                    if ((mail.equals(b.getMail()))) {
                        eshop.tmpBuyer = b;
                        break;
                    }
                }

                if (eshop.tmpBuyer != null) {
                    System.out.println("Welcome to our shop!");
                    System.out.println("You have logged in as user");
                    eshop.tmpBuyer.BuyerCategory();
                    menuForUser(eshop);
                } else {
                    System.out.print("E-mail does not exist, would you like to registered?(Y/n):");
                    char option = keyboard.next().charAt(0);
                    switch (option) {
                        case 'Y', 'y' -> Register(eshop.getBuyers(), eshop);
                        case 'n', 'N' -> System.exit(0);
                        default -> System.out.println("Error occurred");
                    }
                }
            }
        } catch (NullPointerException nullEx) {
            nullEx.printStackTrace();
            nullEx.getMessage();
        }
    }


    public void logout(EShop eshop) {
        Scanner sc = new Scanner(System.in);

        System.out.println("You have logged out!");

        System.out.print("Log in with another account?(Y/n):");
        char choice = sc.next().charAt(0);

        if (choice == 'Y' || choice == 'y') {
            cart.clearCart();
            eshop.tmpBuyer = null;
            identification(eshop);
        } else if (choice == 'n' || choice == 'N') {
            System.out.println("Exit...");
            System.exit(0);
        }
    }

    public void askForPin(Owner owner) {
        Scanner keyboard = new Scanner(System.in);
        int pin;

        do {
            System.out.print("Pin:");
            pin = keyboard.nextInt();

            if (pin == owner.getPin()) {
                System.out.println("You have logged in as owner");
            }
        }while(pin != owner.getPin());
    }

    public void Register(List<Buyer> listBuyer, EShop eshop) {
        String name;
        String mail;

        Buyer userExists = null;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("----Please sign-up----");
        try {

            System.out.print("Username:");
            name = keyboard.nextLine();
            System.out.print("Email:");
            mail = keyboard.nextLine();

            for (Buyer b : listBuyer) {
                if ((name.equals(b.getName()) || (mail.equals(b.getMail())))) {
                    userExists = b;
                }
            }

            if (userExists != null) {
                System.out.println("Username or e-mail already exists!");
            } else {
                eshop.tmpBuyer = eshop.createBuyer(name, mail, 0);

                System.out.println("You have successfully registered!");
                menuForUser(eshop);
            }

        } catch (NullPointerException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }

    }

    public void buyAgain(EShop eshop) {
        char choice;

        Scanner keyboard = new Scanner(System.in);

        do {
            System.out.print("Would you like to buy more(Y/n):");
            choice = keyboard.next().charAt(0);

            if (choice == 'N' || choice == 'n') {
                menuForUser(eshop);
                break;
            }

            eshop.showCategories();
            eshop.showProductsInCategories(eshop);

        } while (choice == 'y' || choice == 'Y');

    }

    public void optionForCart(EShop eshop) {
        int getChoiceById;
        int option = 0;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("----------------");
        System.out.println("1.Delete your wish order");
        System.out.println("2.Change quantity");
        System.out.println("3.Delete the whole cart");
        System.out.println("4.Check Out");
        System.out.println("5.Back to menu");
        System.out.println("----------------");

        do {
            try {
                System.out.print("Insert your option(1,2,...):");
                option = keyboard.nextInt();

                switch (option) {
                    case 1 -> {
                        System.out.print("Enter the id:");
                        getChoiceById = keyboard.nextInt();
                        cart.getKeyChecked(getChoiceById);
                        menuForUser(eshop);
                    }
                    case 2 -> {
                        System.out.print("Enter the id of product:");
                        getChoiceById = keyboard.nextInt();

                        System.out.print("Enter new Quantity:");
                        int quantity = keyboard.nextInt();
                        cart.ChangeQuantity(quantity, getChoiceById);
                        menuForUser(eshop);
                    }
                    case 3 -> {
                        cart.clearCart();
                        menuForUser(eshop);
                    }

                    case 4 -> {
                        cart.checkout(eshop);
                        cart.clearCart();
                        menuForUser(eshop);
                    }

                    case 5 -> menuForUser(eshop);

                    default -> System.out.println("Error occurred!");
                }
                ShoppingCart.showCart();
            }catch (InputMismatchException ex){
                System.out.println("Wrong character in input box!");
            }
        }while (option < 1 || option > 5);
    }
}

