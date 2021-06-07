package ru.job4j.pogo;

/**
 * 3.2. Удаление моделей из массива. [#395285]
 * алгоритм перемещения заполненных ячеек в начало массива
 * метод leftShift должен сместить ячейки на одну позицию влево.
 * Метод leftShift принимает индекс ячейки, с которого нужно начинать смещение
 */

public class ShopDrop {
    /*
    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            System.out.println(product.getName());
        }
        System.out.println();
        // обнуление элемента массива с индексом 1;
        products[1] = null;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
    }
*/
    public static Product[] leftShift(Product[] products, int index) {
            for (int i = index; i < products.length - 1; i++) {
                products[i] = products[i + 1];
            }
            products[products.length - 1] = null;
        return products;
    }
}
