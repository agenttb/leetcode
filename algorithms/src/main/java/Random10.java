import java.util.Random;

public class Random10 {
    private Random random = new Random(7);

    private int rand7() {
        return random.nextInt();
    }

    public int rand10()  {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }
}
