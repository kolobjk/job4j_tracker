package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        CreateItem createItem = new CreateItem();
        createItem.execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenCreateItem() {
        String[] answers = {"One", "Two"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        CreateItem createItem = new CreateItem();
        createItem.execute(input, tracker);
        createItem.execute(input, tracker);
        Item[] created = tracker.findAll();
        Item expectedOne = new Item("One");
        Item expectedTwo = new Item("Two");
        Item[] expected = new Item[] {expectedOne, expectedTwo};
        assertThat(created[0].getName(), is(expected[0].getName()));
        assertThat(created[1].getName(), is(expected[1].getName()));
    }
}