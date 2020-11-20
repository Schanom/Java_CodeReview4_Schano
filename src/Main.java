import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product( "t-Shirt", "red",
                20, Category.T_SHIRT, 16);

        Product product2 = new Product( "TROUSER", "blue",
                30, Category.TROUSER, 6);

        Product product3 = new Product( "SHIRT", "green",
                40, Category.SHIRT,9);

        Product product4 = new Product( "JACKET", "orange",
                50, Category.JACKET,6);

        Product product5 = new Product( "ACCESSOIRE", "gold",
                60, Category.ACCESSOIRE,2);

        Product product6 = new Product( "Shirt", "yellow",
                33, Category.T_SHIRT,4);

        Product product7 = new Product( "Shirt", "white",
                73, Category.T_SHIRT,0);

        HashMap<Integer, Product> myProducts = new HashMap<>();
        myProducts.put(product2.getProductId(),product2);
        myProducts.put(product3.getProductId(),product3);
        myProducts.put(product4.getProductId(),product4);
        myProducts.put(product5.getProductId(),product5);
        myProducts.put(product6.getProductId(),product6);
        myProducts.put(product7.getProductId(),product7);

        System.out.println("Shop before adding products:");
        Shop shop = new Shop ("The Shop", "At the Address");
        System.out.println(shop);
        System.out.println();

        System.out.println("Shop after adding products:");
        try {
            shop.addProduct(product2);
            shop.addProduct(product3);
            shop.addProduct(product4);
            shop.addProduct(product5);
            shop.addProduct(product6);
            shop.addProduct(product7);

        } catch (StockLimitReachedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(shop);
        System.out.println();

        User user1 = new User(1,"Aaron","Aaronson", "aaroon@yahoo.com", "klosterneuburg",
                3400, 123456);

        User user2 = new User(2,"Gerald","von Riva", "monsterhunter@gmail.com", "Riva",
                3245, 654321);

        User user3 = new User(3,"Jack","Sparrow", "bestpirate@gmx.at", "carribean",
                000, 987456);

        User user4 = new User(4,"Fin","the human", "adventure@time.com", "land of Ooo",
                987, 168348);

        HashMap<Integer, User> users = new HashMap<>();
        users.put(user1.getId(),user1);
        users.put(user2.getId(),user2);
        users.put(user3.getId(),user3);
        users.put(user4.getId(),user4);

        System.out.println("Users:");
        for (Integer i : users.keySet()) {
            System.out.println(users.get(i));
        }
        System.out.println();

        System.out.println("Shop before purchase:");
        System.out.println(shop);
        System.out.println();

        System.out.println("Shop history before purchase:");
        System.out.println(shop.getPurchaseHistory());
        System.out.println();

        System.out.println("Shop after purchase:");
        shop.sellProduct(product3,user2);
        System.out.println(shop);
        System.out.println();

        System.out.println("Shop history after purchase:");
        System.out.println(shop.getPurchaseHistory());
        System.out.println();

        System.out.println("Low Stock items:");
        shop.showLimitedProduct();
        System.out.println();

        System.out.println("Max 15 items test:");
        try {
            shop.addProduct(product1);
        } catch (StockLimitReachedException e) {
            System.out.println(e.getMessage());
        }
        try {
            shop.addProduct(product3);
        } catch (StockLimitReachedException e) {
            System.out.println(e.getMessage());
        }

        shop.showMenu();
    }

}
