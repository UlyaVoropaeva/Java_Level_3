
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {


        String armas[] = {"0.1", "12", "три", "java", "Level", "3"};
        Integer armas2[] = {0,1,2,3,4,5,6,7,8,9};

        swapping(armas, 2, 5);
        System.out.println("Содержимое списочного массива:" +  convertedArrayList(armas2));

        Box <Orange> orangeBox = new Box<>();
        Box <Orange> orangeBox2 = new Box<>();
        Box <Apple> appleBox = new Box<>();
        Box <Apple> appleBox2 = new Box<>();
        Orange orange = new Orange();
        Apple apple = new Apple();
        orangeBox.addFruit(orange, 10);
        orangeBox2.addFruit(orange, 7);
        orangeBox2.addFruit(orange, 8);
        appleBox.addFruit(apple, 15);
        appleBox2.addFruit(apple, 5);

        System.out.println("Вес коробки 1 с апельсинами = " +orangeBox.getWeight());
        System.out.println("Вес коробки 2 с апельсинами = " +orangeBox2.getWeight());
        System.out.println("Вес коробки 1 с яблоками = " +appleBox.getWeight());
        System.out.println("Вес коробки 2 с яблоками = " +appleBox2.getWeight());

        String result =  (appleBox.compare(appleBox2) == true) ? "Коробки равны по массе" :"Массы коробок не равны" ;
        System.out.println(result);
        String result2 =  (appleBox.compare(orangeBox) == true) ? "Коробки равны по массе" :"Массы коробок не равны" ;
        System.out.println(result2);

        appleBox.transfer(appleBox2);
        System.out.println("Вес коробки 1 с яблоками = " +appleBox.getWeight());
        System.out.println("Вес коробки 2 с яблоками = " +appleBox2.getWeight());

        orangeBox2.transfer(orangeBox);
        System.out.println("Вес коробки 1 с апельсинами = " +orangeBox.getWeight());
        System.out.println("Вес коробки 2 с апельсинами = " +orangeBox2.getWeight());

    }

//  1.	Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);

    public static <T> void swapping(T[] array, int k, int l) {

        try {
            T el1 = array[k];
            array[k] = array[l];
            array[l] = el1;
            System.out.println("Массив в котором преставлен " + k + " и " + l + " эементы:");

            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + ", ");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Неверно заданы индексы k, l");
        }
    }

    // 2.	Написать метод, который преобразует массив в ArrayList;

    public static <T> ArrayList<T>  convertedArrayList(T[] array) {

        ArrayList <T> result = new ArrayList<>();
        result.addAll(Arrays.asList(array));

        return result;
    }

}
