package lesson3;

public class Product implements Comparable<Product>{
    String name;
    String producingСountry;
    Double weight;
    Double price;
    Integer variety;

    public Product() {
    }

    public Product(String name, Double price, Integer variety) {
        this.name = name;
        this.price = price;
        this.variety = variety;
    }

    public Product(String name, String producingСountry, Double weight, Double price, Integer variety) {
        this.name = name;
        this.producingСountry = producingСountry;
        this.weight = weight;
        this.price = price;
        this.variety = variety;
    }

    public String getName() {
        return name;
    }

    public String getProducingСountry() {
        return producingСountry;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getVariety() {
        return variety;
    }

    @Override
    public String toString() {
        if (producingСountry == null) {
            return "Наименование товара: " + name + ", цена: " + price + " руб., сорт: " + variety + ".";
        } else {
            return "Наименование товара: " + name + ", страна-производитель: " + producingСountry + ", вес товара: " + weight + " кг., цена: "
                + price + " руб., сорт: " + variety + ".";
        }
    }

    @Override
    public int compareTo(Product o) {
        return this.price.compareTo(o.price);
    }
}
