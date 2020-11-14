public class Parking {


    private CarPlace[] parkingCarPlaces;
    private int parkingPlacesCount;
    private int freeParkingPlaces;

    public Parking(int parkingPlacesCount) {
        this.parkingPlacesCount = parkingPlacesCount;
        this.parkingCarPlaces = new CarPlace[parkingPlacesCount];
        clearParking();
    }

    public int getParkingPlacesCount() {
        return parkingPlacesCount;
    }

    public void placeTaked(Car car ,int slotNumber){
        if (parkingCarPlaces[slotNumber].setCar(car)) {
            freeParkingPlaces--;
        }
        else {
            //// TODO: 11/14/2020 Сообщить о невозможности поместить машину на это место
        }
    }
    public void placeFree(Car car){
        for (CarPlace parkingCarPlace : parkingCarPlaces) {
            if (!parkingCarPlace.isEmpty() && parkingCarPlace.getCar().getId() ==car.getId()) {
                parkingCarPlace.ridPlace();
                freeParkingPlaces++;
                break;
            }
        }
    }

    public int getCountFreeParkingPlaces() {
        return freeParkingPlaces;
    }

    public int getCountOccupiedPlaces() {
        return parkingPlacesCount - freeParkingPlaces;
    }

    //// TODO: 11/14/2020 в двух следующих методах нужно сделать проверку на возможность выхода за пределы массива
    public boolean checkPreviousPlaceIsEmpty(int slotNumber) {
        return parkingCarPlaces[slotNumber+1].isEmpty();
    }

    public boolean checkNextPlaceIsEmpty(int slotNumber) {
        return parkingCarPlaces[slotNumber-1].isEmpty();
    }

    public void setCarOnParkingPlace(Car car) {
        for (CarPlace parkingCarPlace : parkingCarPlaces) {
            if (parkingCarPlace.isEmpty()) {
                freeParkingPlaces--;
                parkingCarPlace.setCar(car);
                break;
            }
        }
    }

    public void clearParking() {
        for (int i = 0; i < parkingPlacesCount; i++) {
            parkingCarPlaces[i] = new CarPlace();
        }
        freeParkingPlaces = parkingPlacesCount;
    }
}
