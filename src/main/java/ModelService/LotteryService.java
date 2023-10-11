package ModelService;

import Model.Data.LotteryParticipant;
import Model.Lottery;
import Model.Data.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class LotteryService implements LotteryInterface {
    private Lottery lottery;

    public LotteryService() {
        this.lottery = new Lottery();
    }

    public Lottery getLottery() {
        return lottery;
    }

    public void setLottery(Lottery lottery) {
        this.lottery = lottery;
    }

    @Override
    public void putToy(Toy toy) {
        List<Toy> toys = lottery.getToys();
        toys.add(toy);
        lottery.setToys(toys);
    }

    @Override
    public void getToy() {
        if(lottery.getToys().isEmpty()){
            System.out.println("Игрушек не осталось");
        } else if(lottery.getParticipants().isEmpty()){
            System.out.println("Участников не осталось");
        } else {
            List<Toy> toys = lottery.getToys();
            Toy toy = findToy(lottery.getToys());
            LotteryParticipant lotteryParticipant = getParticipant();
            lotteryParticipant.setToy(toy);
            lottery.setToys(removeToy(toys,toy));
            WriteToFile.writeUserData(lotteryParticipant);
        }
    }

    private Toy findToy(List<Toy> list) {
        int totalWeight = 0;
        Toy result = null;
        Random r = new Random();
        for (Toy toy : list) {
            totalWeight += toy.getCount() * toy.getDropChance();
        }
        int resultNumber = r.nextInt(0, totalWeight);
        for (Toy toy : list) {
            resultNumber -= toy.getDropChance() * toy.getCount();
            if (resultNumber <= 0) {
                return toy;
            }
        }
        return null;
    }

    private List<Toy> removeToy(List<Toy> list, Toy toy){
        List<Toy> resultList = list;
        for (Toy t : list) {
            if(t.equals(toy)){
                if (toy.getCount()>1){
                    toy.setCount(toy.getCount() - 1);
                    return list;
                } else {
                    resultList.remove(t);
                    return resultList;
                }
            }
        }
        return null;
    }

    public void putParticipant(LotteryParticipant lotteryParticipant) {
        PriorityQueue<LotteryParticipant> pq = new PriorityQueue<>(new LotteryParticipantComparator<>());
        pq.addAll(lottery.getParticipants());
        pq.add(lotteryParticipant);
        lottery.setParticipants(pq);
    }

    public LotteryParticipant getParticipant(){
        PriorityQueue<LotteryParticipant> pq = new PriorityQueue<>(new LotteryParticipantComparator<>());
        pq.addAll(lottery.getParticipants());
        LotteryParticipant lotteryParticipant = pq.poll();
        lottery.setParticipants(pq);
        return lotteryParticipant;
    }
}
