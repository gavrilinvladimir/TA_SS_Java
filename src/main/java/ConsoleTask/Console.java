package ConsoleTask;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Console {
    private static ArrayList<Cars> carList;
    public enum Menu {
        show, sort, add, remove, quit;
    }
    enum Sort {
        type1 ("By brand (asc)"), type2 ("By brand (desc)"),
        type3 ("By model (asc)"), type4 ("By model (desc)"),
        type5 ("By year (asc)"), type6 ("By year (desc)");

        private String type;

        Sort(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public static void main (String args[]) {
        carList = new ArrayList<Cars>();
        menu();
    }

    public static void menu (){
        Menu menus[] = Menu.values();
        System.out.println("Please, select an option: ");
        for(Menu menu: menus) {
            System.out.println(menu.ordinal() + ") - " + menu);
        }
        Scanner scan = new Scanner(System.in);
        int actionId = scan.nextInt();
        switch (actionId) {
            case  (0):
                showCar();
                menu();
            case (1):
                sortCar();
                menu();
            case (2):
                addCar();
                menu();
            case (3):
                removeCar();
                menu();
            case (4):
                quit();
        }
    }


    public static void showCar() {
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(
                    "Car ID" + i + ":" +
                            " Brand: " + carList.get(i).getBrand() +
                            " Model: " + carList.get(i).getModel() +
                            " Year: " + carList.get(i).getYear()
            );
        }
    }

    public static void sortCar() {
        System.out.println("How to sort cars? ");
        Sort sorts[] = Sort.values();
        for(Sort sort: sorts) {
            System.out.println(sort.ordinal() + ") - " + sort.getType());
        }
        Scanner scan = new Scanner(System.in);
        int sortType = scan.nextInt();
        ArrayList<Cars> sortedCars = new ArrayList<Cars>();
        switch (sortType) {
            case (0):
                sortedCars = carList.stream().sorted(Comparator.comparing(Cars::getBrand)).collect(Collectors.toCollection(ArrayList<Cars>::new));
                break;
            case (1):
                sortedCars = carList.stream().sorted(Comparator.comparing(Cars::getBrand).reversed()).collect(Collectors.toCollection(ArrayList<Cars>::new));
                break;
            case (2):
                sortedCars = carList.stream().sorted(Comparator.comparing(Cars::getModel)).collect(Collectors.toCollection(ArrayList<Cars>::new));
                break;
            case (3):
                sortedCars = carList.stream().sorted(Comparator.comparing(Cars::getModel).reversed()).collect(Collectors.toCollection(ArrayList<Cars>::new));
                break;
            case (4):
                sortedCars = carList.stream().sorted(Comparator.comparing(Cars::getYear)).collect(Collectors.toCollection(ArrayList<Cars>::new));
                break;
            case (5):
                sortedCars = carList.stream().sorted(Comparator.comparing(Cars::getYear).reversed()).collect(Collectors.toCollection(ArrayList<Cars>::new));
                break;
        }
        System.out.println("Sorted Cars: ");
        for (int i = 0; i < sortedCars.size(); i++) {
            System.out.println(
                    "Car ID" + i + ":" +
                            " Brand: " + sortedCars.get(i).getBrand() +
                            " Model: " + sortedCars.get(i).getModel() +
                            " Year: " + sortedCars.get(i).getYear()
            );
        }

    }

    public static void addCar() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Brand: ");
        String brand = scan.next();
        System.out.println("Enter Model: ");
        String model = scan.next();
        System.out.println("Enter Year: ");
        int year = scan.nextInt();
        Cars car=new Cars ();
        car.setBrand(brand);
        car.setModel(model);
        car.setYear(year);
        carList.add(car);
        System.out.println("Car was added");
    }

    public static void removeCar() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter car id for delete: ");
        int j = scan.nextInt();
        carList.remove(j);
    }

    public static void quit() {
        System.exit(0);
    }
}

