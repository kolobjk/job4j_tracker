package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void whenSortItem() {
        ArrayList<Item> items = new ArrayList<>();
        Item item1 = new Item(1, "Petr2");
        items.add(item1);
        Item item2 = new Item(2, "Petr1");
        items.add(item2);
        items.sort(new SortByNameItemsAsc());
        assertThat(items.get(0).getName(), is(item2.getName()));
        assertThat(items.get(1).getName(), is(item1.getName()));
    }
    @Test
    public void whenSortItemDesc() {
        ArrayList<Item> items = new ArrayList<>();
        Item item1 = new Item(1, "Petr1");
        items.add(item1);
        Item item2 = new Item(2, "Petr2");
        items.add(item2);
        items.sort(new SortByNameItemsDesc());
        assertThat(items.get(0).getName(), is(item2.getName()));
        assertThat(items.get(1).getName(), is(item1.getName()));
    }
}