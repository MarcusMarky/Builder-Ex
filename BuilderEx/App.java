public class App {
    public static void main(String[] args) {
        Product product = new Product.ProductBuilder("Samsung XC13", 9500.00)
                .withDimensions(new PhysicalDimensions(2.5, "inch"), new PhysicalDimensions(0.1, "inch"), new PhysicalDimensions(4.5, "inch"))
                .withWeight(new PhysicalDimensions(10.0, "lbs"))
                .build();

        System.out.println(product);
    }
}