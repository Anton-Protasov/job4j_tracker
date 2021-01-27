package ru.job4j.oop;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int price() {
        return price - discount();
    }

    public int discount() {
        return 0;
    }

    public String label() {
        return name + " " + price();
    }
}

/**
 * Выполнение
 *
class Shop {
    public static void main(String[] args) {
        Product product = of("Oil", 100);
        System.out.println(product.label());
    }

    public static Product of(String name, int price) {
        return new Product(name, price);
    }
}
 */

/**
 * Через неделю нам потребовались продукты со скидкой. Мы делаем наследника.
 */

class LiquidationProduct extends Product {
    public LiquidationProduct(String name, int price) {
        super(name, price);
    }

    @Override
    public int discount() {
        return 90;
    }
}

/**
 * Добавляем логику в магазин.
 */
class Shop {
    public static void main(String[] args) {
        Product product = of("Oil", 100);
        System.out.println(product.label());
    }

    public static Product of(String name, int price) {
        if ("Oil".equals(name)) {
            return new LiquidationProduct(name, price);
        }
        return new Product(name, price);
    }
}





