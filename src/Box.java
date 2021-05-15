import java.util.ArrayList;
import java.util.Collections;

public class Box <T extends  Fruit >  {

    private ArrayList <T> box = new ArrayList<>();

    public Box() {

    }
//d.	Сделать метод getWeight(), который высчитывает вес коробки,
// зная вес одного фрукта и их количество:
// вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);

    public float getWeight (){

    float getWeight =0.0f;
        for (T o :box) {
            getWeight+= o.getWeight();
        }

        return getWeight;
    }
//g.	Не забываем про метод добавления фрукта в коробку.

    public void addFruit(T fruit, int val) {

        for (int i = 0; i < val; i++) {

            box.addAll(Collections.singleton(fruit));
        }
    }
//e.	Внутри класса Box сделать метод compare(),
// который позволяет сравнить текущую коробку с той,
// которую подадут в compare() в качестве параметра. true – если их массы равны,
// false в противоположном случае.
// Можно сравнивать коробки с яблоками и апельсинами;

    public  boolean compare (Box o){
        if(getWeight()==o.getWeight()) return  true;
        else return false;
    }

    //f.	Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
    // Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
    // Соответственно, в текущей коробке фруктов не остается,
    // а в другую перекидываются объекты, которые были в первой

    public void transfer(Box <T> o){
        o.box.addAll(box);
        box.clear();
    }
}
