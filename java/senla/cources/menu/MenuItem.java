package senla.cources.menu;

import senla.cources.menu.actions.IAction;

public class MenuItem {
    private String title;
    private IAction action;
    private Menu nextMenu;

    public MenuItem(String title, IAction action, Menu nextMenu) {
        this.title = title;
        this.action = action;
        this.nextMenu = nextMenu;
    }

    public void doAction(){
        action.execute();
    }

    public String getTitle() {
        return title;
    }

    public Menu getNextMenu() {
        return nextMenu;
    }
}
