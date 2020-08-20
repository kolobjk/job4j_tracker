package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] printItems = tracker.findAll();
        for (Item printItem : printItems) {
            System.out.println(printItem);
        }
        return true;
    }
}