package ru.job4j.oop;

public final class Product {
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

//Через неделю нам потребовались продукты со скидкой. Мы делаем наследника.

// Вариант 1. Работает в случае применения наследования

/*
class LiquidationProduct extends Product {
    public LiquidationProduct(String name, int price) {
        super(name, price);
    }

        @Override
    public int discount() {
        return 90;
    }
*/

// Вариант 2. Когда наследование не работает. Применяем полиморфизм.

final class LiquidationProduct {
    private Product product;

    public LiquidationProduct(String name, int price) {
        product = new Product(name, price);
    }

    public Product getProduct() {
        return product;
    }

    public String lable() {
        return product.label();
    }

    public int discount() {
        return 90;
    }
}

/**
 * Добавляем логику в магазин.
 */
class Shop {
    public static void main(String[] args) {
        Product product = of("oil", 100);
        System.out.println(product.label());
    }

    public static Product of(String name, int price) {
        if ("oil".equals(name)) {
            return new LiquidationProduct(name, price).getProduct();
        }
        return new Product(name, price);
    }
}
