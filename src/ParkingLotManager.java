import java.util.Random;
import java.util.Scanner;

public class ParkingLotManager {

    public static void main(String[] args) {
        int id = 0;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество мест на парковке");
        int parkingPlaces = scanner.nextInt(); //предпочитаю делать так, но можно и как ты
        Parking parking = new Parking(parkingPlaces);
        System.out.println("You can choose \n1 for make a turn \n2 to get info about parking " +
                "\n3 to clear parking from cars");
        // todo generate cars
        while (true) {
            Car[] cars = createCars(random.nextInt(parkingPlaces / 2), id);
            if (parking.getCountFreeParkingPlaces() == 0) {
                System.out.println("Parking doesn't have any spaces");
            }
            System.out.println("Введите команду");
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    for (Car car : cars) {
                        System.out.println("Cars is in the parking");
                        System.out.println("Осталось мест: " + parking.getCountFreeParkingPlaces());
                        parking.setCarOnParkingPlace(car);
                    }
                    break;
                case 2:
                    System.out.println("Вывести нужную информацию");
                    break;
                case 3:
                    parking.clearParking();
                    System.out.println("Парковка очищена");
                    break;
                default:
                    System.out.println("Неизвестная команда");
            }

            System.out.println("Now we have cars. There are: " + parking.getCountOccupiedPlaces());
            System.out.println("ваша машина может заехать на парковку");
            for (Car car : cars) {
                car.doTurn();
                if (car.getTurn() == 0) {
                    parking.placeFree(car);
                }
            }
            System.out.println(parking.getCountFreeParkingPlaces());
        }
    }

    public static Car[] createCars(int count, int id) {
        Random random = new Random();
        Car[] cars = new Car[count];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(random.nextInt(10), id++);
        }
        return cars;
    }
}

