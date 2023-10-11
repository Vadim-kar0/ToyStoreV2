package Model.Data;

public class LotteryParticipant {
    private String name;
    private final int placeInQueue;
    private Toy toy;

    public int getPlaceInQueue() {
        return placeInQueue;
    }

    public LotteryParticipant(String name, int placeInQueue) {
        this.name = name;
        this.placeInQueue = placeInQueue;
    }

    public LotteryParticipant(String name) {
        this.name = name;
        placeInQueue = Integer.MAX_VALUE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Toy getToy() {
        return toy;
    }

    public void setToy(Toy toy) {
        this.toy = toy;
    }

}
