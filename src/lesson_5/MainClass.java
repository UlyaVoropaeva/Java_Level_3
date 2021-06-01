package lesson_5;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        Stage[] stages = {
                new Road(60),
                new Tunnel(80),
                new Road(40)
        };

        Race race = new Race(CARS_COUNT, stages);
        Car[] cars = new Car[CARS_COUNT];

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car( 20 + (int) (Math.random() * 10));
            cars[i].RaceCar(race);
        }
        for (int i = 0; i < CARS_COUNT; i++) {
            int index = i;
            new Thread(() -> {
                new Thread(cars[index]).start();
            }).start();
        }
    }
}