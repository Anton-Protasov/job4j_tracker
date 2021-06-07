package ru.job4j.pogo;

/**
 * 3. Массивы и модели. [#395279]
 */

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 100);
        Book book2 = new Book("Book 2", 200);
        Book book3 = new Book("Book 3", 300);
        Book book4 = new Book("Book 4", 400);
        Book[] library = new Book[4];
        library[0] = book1;
        library[1] = book2;
        library[2] = book3;
        library[3] = book4;
        for (int i = 0; i < library.length; i++) {
            Book bookcase = library[i];
            System.out.println("Название книги: " + bookcase.getName()
                    + " страниц: " + bookcase.getPages());
        }
        System.out.println();
        System.out.println("Переставляем местами 1 и 3 книги");
        Book reserve;
        reserve = library[0];
        library[0] = library[2];
        library[2] = reserve;
        for (int i = 0; i < library.length; i++) {
            Book bookcase = library[i];
            System.out.println("Название книги: " + bookcase.getName() + " страниц: "
                    + bookcase.getPages());
        }
        System.out.println();
        System.out.println("Ищем книгу");
        for (int i = 0; i < library.length; i++) {
            Book bookcase = library[i];
            if ("Clean code".equals(bookcase.getName())) {
                System.out.println("Книга найдена: " + bookcase.getName() + " страниц: "
                        + bookcase.getPages());
            }
        }
    }
}
