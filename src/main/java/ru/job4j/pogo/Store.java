package ru.job4j.pogo;

/**
 * 3. Массивы и модели. [#395279]
* 3.1. Массив с пустыми ячейками [#395281]
 * метод indexOfNull возвращает индекс первой пустой ячейки.
 */

public class Store {
    public static void main(String[] args) {
        Product milk = new Product("Milk", 10);
        Product bread = new Product("Bread", 4);
        Product egg = new Product("Egg", 19);
        Product[] prods = new Product[5];
        prods[0] = milk;
        prods[1] = bread;
        prods[2] = egg;
    }

    public static int indexOfNull(Product[] products) {
        int index = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                index = i;
                break;
            }
        }
        return index;
    }
}


        /*
        for (int index = 0; index < prods.length; index++) {
            Product pr = prods[index];
            System.out.println(pr.getName() + " - " + pr.getCount());
        }
        System.out.println("Replace milk to oil.");
        Product oil = new Product("Oil", 11);
        prods[0] = oil;
        for (int index = 0; index < prods.length; index++) {
            Product pr = prods[index];
            System.out.println(pr.getName() + " - " + pr.getCount());
        }
        System.out.println("Shown only product.count > 10");
        for (int index = 0; index < prods.length; index++) {
            Product pr = prods[index];
            if (pr.getCount() > 10) {
                System.out.println(pr.getName() + " - " + pr.getCount());
            }
        }
    }
}
*/