import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Shop {
    private static int counter = 0;
    private String name;
    private String address;
    private ArrayList<Product> products = new ArrayList<>();
    private HashMap<User,Product> purchaseHistory = new HashMap<>();
    private ArrayList<User> users = new ArrayList<>();

    public Shop(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public HashMap<User, Product> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void addProduct (Product x) throws StockLimitReachedException {
        if (x.getProductQuantity() > 15){
            throw new StockLimitReachedException("You cannot add more than 15 items. You tried to add " + x.getProductQuantity() + ".");
        }
        if (products.contains(x)) {
            for (Product p: products) {
                if (x.getProductId() == p.getProductId()) {
                    int myQuantity = p.getProductQuantity();
                    int myXQuantity = x.getProductQuantity();
                    if (myQuantity + myXQuantity <= 15) {
                        p.setProductQuantity(myQuantity + myXQuantity);
                    } else {
                        throw new StockLimitReachedException("You cannot add more than 15 items. You tried to add " + myXQuantity + " items to " + myQuantity + " items(" + (myQuantity + myQuantity) + ")");
                    }
                }
            }
        } else {
            products.add(x);
        }
    }

    public void sellProduct (Product x, User y) {
        for (Product p: products) {
            if (x.getProductId() == p.getProductId()) {
                p.setProductQuantity(p.getProductQuantity()-1);
                purchaseHistory.put(y,p);
            }
        }
    }

    public void showLimitedProduct () {
        System.out.println("Name \t\t\t\tQuantity");
        System.out.println("--------------");

        for (Product p: products) {
            if (p.getProductQuantity() < 5) {
                System.out.printf("%-20s %d %n", p.getProductName() , p.getProductQuantity());
            }
        }
        System.out.println("--------------");
    }

    public void showUsers(){
        for (int i = 0; i < users.size(); i++){
            System.out.println(users.get(i).getFirstName());
        }

    }

    //Menu method
    public void showMenu () {
        System.out.println("+---------------------------------------------+");
        System.out.println("|                                             |");
        System.out.println("|                  Welcome                    |");
        System.out.println("|                  to the                     |");
        System.out.println("|                   Shop                      |");
        System.out.println("|                                             |");
        System.out.println("+---------------------------------------------+");



        Scanner sc = new Scanner(System.in);
        System.out.println("Make a Selection:");
        System.out.println("1) Display all products.");
        System.out.println("2) Display all products of category T-Shirt.");
        System.out.println("3) Display all products where stock < 5.");
        System.out.println("4) Display all products out of stock");
        System.out.println("5) Display all users in a \"nicely\" formatted way");
        System.out.println("0) Exit");
        System.out.println();
        System.out.println("Enter your choice: ");

        int menuScan = sc.nextInt();

        switch(menuScan){
            case 1:
                System.out.println(products);
                break;
            case 2:
                for (Product p : products) {
                    if (p.getProductCategory() == Category.T_SHIRT) {
                        System.out.println(p);
                    }
                }
                break;
            case 3:
                this.showLimitedProduct();
                break;
            case 4:
                for (Product p : products) {
                    if (p.getProductQuantity() == 0) {
                        System.out.println(p);
                    }
                }
                break;
            case 5:
                this.showUsers();
                break;
            case 0:
                break;
        }
    }
    
    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", products=" + products +
                '}';
    }
}
