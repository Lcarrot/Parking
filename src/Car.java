public class Car {
    private int turn;
    private int id;

    public Car(int turn, int id) {
        this.turn = turn;
        this.id=id;
    }

    public int getTurn() {
        return turn;
    }

    public void doTurn() {
        this.turn--;
    }

    public int getId() {
        return id;
    }


    public int setId() {
        return  id++; //не очень понял, что это делает
    }

}
