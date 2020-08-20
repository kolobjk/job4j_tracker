package ru.job4j.tracker;

public class FindByNameAction implements UserAction {

    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        Item[] findItems = tracker.findByName(name);
        if (findItems.length > 0) {
            for (Item findItem : findItems) {
                out.println(findItem);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}