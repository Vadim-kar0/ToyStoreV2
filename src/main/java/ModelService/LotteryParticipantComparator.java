package ModelService;

import Model.Data.LotteryParticipant;

import java.util.Comparator;

public class LotteryParticipantComparator<T extends LotteryParticipant> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getPlaceInQueue() - o2.getPlaceInQueue();
    }
}
