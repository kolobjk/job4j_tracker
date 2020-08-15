package ru.job4j.tracker;


public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
                /*            } else if (...) { */
                /*             Добавить остальные действия системы по меню. */
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] printItems = tracker.findAll();
                for (Item printItem : printItems) {
                    System.out.println(printItem);
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                int id = input.askInt("Enter id: ");
                String name = input.askStr("Enter new name: ");
                Item newItem = new Item(name);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Объект успешно заменен");
                } else {
                    System.out.println("Произошла ошибка при замене");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                int id = input.askInt("Enter id: ");
                if (tracker.delete(id)) {
                    System.out.println("Объект успешно удален");
                } else {
                    System.out.println("Произошла ошибка при удалении");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                int id = input.askInt("Enter id: ");
                Item findItem = tracker.findById(id);
                if (findItem != null) {
                    System.out.println(findItem);
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            }else if (select == 5) {
                    System.out.println("=== Find items by name ====");
                    String name = input.askStr("Enter name: ");
                    Item[] findItems = tracker.findByName(name);
                    if (findItems.length > 0) {
                        for (Item findItem : findItems) {
                            System.out.println(findItem);
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}