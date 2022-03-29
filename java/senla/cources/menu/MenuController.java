package senla.cources.menu;

import java.util.Scanner;

public class MenuController {
    private Builder builder;
    private Navigator navigator;

    public MenuController() {
        this.builder = new Builder();
        this.navigator = new Navigator();
    }
    public void run(){
        navigator.setCurrentMenu(builder.getRootMenu());
        navigator.printMenu();
        Integer index;
        Scanner scanner = new Scanner(System.in);
        while (true){
            if(scanner.hasNextInt()){
                index = scanner.nextInt();
                if(index.equals(-1)){
                    System.out.println("Exit..");
                    return;
                }
                navigator.navigate(index);
                navigator.printMenu();
            }
        }




    }
}
