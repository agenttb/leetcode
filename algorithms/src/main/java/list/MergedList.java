package list;

import java.util.List;
import java.util.PriorityQueue;

public class MergedList {

    public void mergeKList(List<Integer>[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(lists.length, Integer::compareTo);
    }
}
