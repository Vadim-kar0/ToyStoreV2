package Model;

import Model.Data.LotteryParticipant;
import Model.Data.Toy;
import ModelService.LotteryParticipantComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Lottery {

    private List<Toy> toys;
    private PriorityQueue<LotteryParticipant> participants;

    public PriorityQueue<LotteryParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(PriorityQueue<LotteryParticipant> participants) {
        this.participants = participants;
    }

    public Lottery() {
        this.toys = new ArrayList<>();
        this.participants = new PriorityQueue<>(new LotteryParticipantComparator<>());
    }

    public List<Toy> getToys() {
        return toys;
    }

    public void setToys(List<Toy> toys) {
        this.toys = toys;
    }

    @Override
    public String toString() {
        return "Model.Store{" +
                "toys=" + toys +
                '}';
    }
}
