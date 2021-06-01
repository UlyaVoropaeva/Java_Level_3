package lesson_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicReference;


public class Race {
    private CyclicBarrier cb;
    private ArrayList<Stage> stages;
    private ArrayList <Car> cars;
    private AtomicReference<Car> winner;
    private int CARS_COUNT;

    private CyclicBarrier br;

    public ArrayList<Stage> getStages() { return stages; }

    public Race(int CARS_COUNT, Stage [] stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        this.winner = new AtomicReference<>();
        this.CARS_COUNT = CARS_COUNT;
        this.cb = new CyclicBarrier(CARS_COUNT);

    }

    public CyclicBarrier getStart() {
        this.br = new CyclicBarrier(CARS_COUNT);
        return cb;
    }

    public CyclicBarrier getFinish() {
        this.br = new CyclicBarrier(CARS_COUNT);
        return cb;
    }
    public boolean setWinner(Car winner) {
        boolean result = this.winner.compareAndSet(null, winner);
        if (result) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> " + winner.getName() + " победил!!!");
        }
        return result;
    }
}
