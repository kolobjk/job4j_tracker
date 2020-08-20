package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] findItems = tracker.findByName(name);
        if (findItems.length > 0) {
            for (Item findItem : findItems) {
                System.out.println(findItem);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}