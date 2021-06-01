package lesson_5;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    Semaphore smp = new Semaphore(4);

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car( int speed) {

        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    public void RaceCar (Race race){
        this.race = race;
    }

    @Override
    public void run() {

        try {
            System.out.println(this.getName() + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.getName() + " готов");

            race.getStart().await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            race.getStart().await();
            smp.acquire();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }

            race.getFinish().await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            race.getFinish().await();
            race.setWinner(this);

        } catch (InterruptedException  | BrokenBarrierException e) {

            e.printStackTrace();
        }finally {
            smp.release();
        }
    }
}