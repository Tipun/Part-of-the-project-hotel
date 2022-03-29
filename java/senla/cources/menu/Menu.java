package senla.cources.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String name;
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();

    public Menu(String name) {
        this.name = name;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public String getName() {
        return name;
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }
}
