import org.ehcache.Cache;
import java.util.Random;
import java.util.Scanner;

public class EMapPut {
    final private static Random r = new Random(System.currentTimeMillis());

    public Cache<Long, Zoo> putData(Cache<Long, Zoo> animals) {
        System.out.println("Podaj gatunek zwierzęcia: ");
        Scanner scanner = new Scanner(System.in);
        String animalType = scanner.nextLine();

        System.out.println("Podaj rodzinę zwierzęcia: ");
        String animalFamily = scanner.nextLine();

        Long key1 = (long) Math.abs(r.nextInt());
        Zoo animal = new Zoo(animalType, animalFamily);
        System.out.println("Dodano " + key1 + " => " + animal);
        animals.put(key1, animal);

        return animals;
    }
}
