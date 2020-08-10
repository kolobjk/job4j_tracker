package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker firstTracker = new Tracker();
        firstTracker.add(new Item(1, "First item"));
        Item firstItem = firstTracker.findById(1);
        System.out.println("Find item with name " + firstItem.getName() + " and id " + firstItem.getId());
    }
}
