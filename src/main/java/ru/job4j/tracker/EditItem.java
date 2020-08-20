package ru.job4j.tracker;

public class EditItem implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter new name: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Объект успешно заменен");
        } else {
            System.out.println("Произошла ошибка при замене");
        }
        return true;
    }
}