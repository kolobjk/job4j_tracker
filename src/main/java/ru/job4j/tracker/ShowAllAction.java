package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction implements UserAction {

    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ====");
        List<Item> printItems = tracker.findAll();
        for (Item printItem : printItems) {
            out.println(printItem);
        }
        return true;
    }
}