package hw6;
//понимать пазлереы оказалось сложнее ,чем виделось после Вашего примера
//несколько раз я давала правильный ответ, а при разборе выяснилось, что это только от того,
//что я плохо знаю как обычно java себя ведёт
// тут который оказался наиболее понятным.
//Метод killThemAll явяется примером undefined behavior.
// Сюда можно попробовать подать разные коллекции, и если попробовать это сделать, мы получим разные результаты

import java.util.*;

public class JavaPuzzler {

    static void killThemAll(Collection<String> expendables) {
        Iterator<String> heroes = expendables.iterator();
        heroes.forEachRemaining(e -> {
            if (heroes.hasNext()) {
                heroes.next();
                heroes.remove();
            }
        });
        System.out.println(expendables);
    }

    public static void main(String[] args) {
        killThemAll(new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8")));
        killThemAll(new LinkedList<String>(Arrays.asList("1","2","3","4","5","6","7","8")));
        killThemAll(new ArrayDeque<String>(Arrays.asList("1","2","3","4","5","6","7","8")));
        killThemAll(new TreeSet<String>(Arrays.asList("1","2","3","4","5","6","7","8")));
    }
}
//
