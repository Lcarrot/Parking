public class CarPlace {

    private Car currentCar;

    public CarPlace() {
        currentCar = null;
    }

    public boolean setCar(Car currentCar) {
        if (this.currentCar == null) {
            this.currentCar = currentCar;
        }
        return this.currentCar.equals(currentCar);
    }

    public Car getCar() {
        return currentCar;
    }

    public void ridPlace() {
        currentCar = null;
    }

    public boolean isEmpty() {
        return currentCar == null;
    }
}
