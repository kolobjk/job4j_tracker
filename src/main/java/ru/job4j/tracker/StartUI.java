package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                /*            } else if (...) { */
                /*             Добавить остальные действия системы по меню. */
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] printItems = tracker.findAll();
                for (Item printItem : printItems) {
                    System.out.println(printItem.toString());
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.print("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                Item newItem = new Item(name);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Объект успешно заменен");
                } else {
                    System.out.println("Произошла ошибка при замене");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.print("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Объект успешно удален");
                } else {
                    System.out.println("Произошла ошибка при удалении");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.print("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                Item findItem = tracker.findById(id);
                if (findItem != null) {
                    System.out.println(findItem.toString());
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            }else if (select == 5) {
                    System.out.println("=== Find items by name ====");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    Item[] findItems = tracker.findByName(name);
                    if (findItems != null && findItems.length > 0) {
                        for (Item findItem : findItems) {
                            System.out.println(findItem.toString());
                        }
                    } else {
                        System.out.println("Заявки с таким именем не найдены");
                    }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("1 - Show all items");
        System.out.println("2 - Edit item");
        System.out.println("3 - Delete item");
        System.out.println("4 - Find item by Id");
        System.out.println("5 - Find items by name");
        System.out.println("6 - Exit");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}