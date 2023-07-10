import java.util.Arrays;

public class Product {
    
    private String name;
    private Double price;
    private Attribute[] attribute;

    private Product() {}

    public static class ProductBuilder {

        private String name;
        private Double price;
//HW:
        private PhysicalDimensions width;
        private PhysicalDimensions height;
        private PhysicalDimensions length;
        private PhysicalDimensions weight;

        public ProductBuilder(String name, Double price) {
            this.name = name;
            this.price = price;
        }

        public ProductBuilder withDimensions(PhysicalDimensions width, PhysicalDimensions height, PhysicalDimensions length) {
            this.width = width;
            this.height = height;
            this.length = length;
            return this;
        }
        
        public ProductBuilder withWeight(PhysicalDimensions weight) {
            this.weight = weight;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
        
            
            if (width != null) {
                addAtribute(product, new Attribute("width", width));
            }
            if (height != null) {
                addAtribute(product, new Attribute("height", height));
            }
            if (length != null) {
                addAtribute(product, new Attribute("length", length));
            }
            if (weight != null) {
                addAtribute(product, new Attribute("weight", weight));
            }

            return product;
        } 
        private void addAtribute(Product product, Attribute attribute){
            if (product.getAttribute() == null) {
                product.setAttribute(new Attribute[1]);
            } else {
                product.setAttribute(
                    Arrays.copyOf(product.getAttribute(), product.getAttribute().length + 1));
            }
            product.getAttribute()[product.getAttribute().length - 1] = attribute;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Attribute[] getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute[] attribute) {
        this.attribute = attribute;
    }

    @Override
    public String toString() {
    return "Product name: " + name + ", price: " + price + ", attribute: " + Arrays.toString(attribute);
    }
}
//HW:
class PhysicalDimensions {
    private Double value;
    private String unit;

    public PhysicalDimensions(Double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    
    }
    @Override
    public String toString() {
        return value + " " + unit;
    }
}