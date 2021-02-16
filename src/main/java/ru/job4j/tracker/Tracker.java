package ru.job4j.tracker;

import java.util.Arrays;

/*
 * 5. Tracker - хранилище [#395287]
 * Поле private Item[] items = new Item[100] содержит возможное количество заявлений
 * Метод public Item add(Item item) добавляет заявку, переданную в аргументах в массив заявок items
 * Метод public Item[] findAll() возвращает копию массива items без null элементов (без пустых ячеек)
 * Метод public Item[] findByName(String key) проверяет в цикле все элементы массива items, сравнивая name
 * (используя метод getName класса Item) с аргументом метода String key
 * Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его.
 * Метод public Item findById(int id) проверяет в цикле все элементы массива items, сравнивая id с аргументом int id
 * и возвращает найденный Item. Если Item не найден - возвращает null.
 *
 * 6. Метод замены заявки. Tracker.replace [#395282] public boolean replace(int id, Item item)
 * Процесс замены отличается от процесса добавление, тем что у нас остается одинаковый ключ id.
 * В случае добавление новой заявки, мы генерируем всегда новый ключ. Поэтому
 * Первоначально нам нужно найти ячейку с id приходящем в параметре  - метод indexOf(int id)
 * метод заменяет заявки c id на заявку item, При замене старый id сохраняем.
 * Вернуть true, если замена произведена или false, если index по id не найден
 *
 * 7. Метод удаления заявки Tracker.delete [#395283] public boolean delete(int id)
 * По факту, мы не можем изменять размер массива, поэтому под удалением заявки здесь подразумевается запись в ячейку
 * нулевой ссылки - null. Теперь необходимо сжать массив - избавиться от нулевых элементов.
 * В Java есть метод, который позволяет скопировать блоки массива целиком. Перемещение в этом случае идет через
 * нативные методы операционной системы. Это значительно быстрее нежели копировать отдельные ячейки.
 * System.arraycopy(source, startPos, dist, distPos, length);
 * source - массив откуда нужно скопировать элементы начиная с позиции startPos и до позиции startPos + length.
 * length - сколько элементов взять начиная от startPos.
 * dist - массив, куда вставить скопированные элементы от source
 * distPos - начиная с какого элемента вставлять скопированные ячейки
 */

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        int size2 = 0;
        Item[] rsl = new Item[items.length];
        for (int i = 0; i < size; i++) {
            String name = items[i].getName();
            if (name.equals(key)) {
                rsl[size2] = items[i];
                size2++;
            }
        }
        return Arrays.copyOf(rsl, size2);
    }

    public Item findById(int id) {
        /* Данная часть программы из задачи 5 при реализации задачи 6 преобразована
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
         */
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = false;
        if (index != -1) {
            item.setId(items[index].getId());
            items[index] = item;
            rsl = true;
        }
        return rsl;
    }

    /* Применим метод System.arraycopy(Arrays1, start, Arrays2, distPos, length);
    Arrays1 - массив откуда копируем набор элементов в количестве length
    start - индекс элемента в Arrays1 наиная с которого копируем length элементов
    Arrays2 - массив куда копируем набор элементов из Arrays1
    distPos - индекс элемента в Arrays2 начиная с которого вставляем length элементов из массива Arrays1
    index - индекс обнуленного элемента, копируем все элементы, начиная со следующегго за ним.
    В ставляем их начиная с index
    Так же в конце нам нужно обнулить последнюю ячейку, так как она будет заполнена последним элементов,
    а мы элементы сдвинули
     */

    public boolean delete(int id) {
        boolean rsl = false;
        int index = indexOf(id);
        if(index != -1) {
            int start = index + 1;
            int distPos = index;
            int length = size - distPos;
            items[indexOf(id)] = null;
            System.arraycopy(items, start, items, distPos, length);
            items[size - 1] = null;
            size--;
            rsl = true;
        }
        return rsl;
    }
}