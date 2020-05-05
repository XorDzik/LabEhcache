import org.ehcache.Cache;
import java.util.Scanner;

public class EMapUpdate {
    public Cache<Long, Zoo> updateAnimal(Cache<Long, Zoo> animals) {
        System.out.println("Podaj id: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();

        if (!animals.containsKey(Long.parseLong(id)))
            System.out.println("W zoo nie ma takiego zwierzęcia");
        else {
            System.out.println("Podaj gatunek: ");
            String type = scanner.nextLine();

            System.out.println("Podaj rodzinę: ");
            String family = scanner.nextLine();

            for (Cache.Entry<Long, Zoo> e : animals) {
                if (e.getKey().toString().equals(id)) {
                    Zoo oldAnimal = new Zoo(e.getValue().getType(), e.getValue().getFamily());
                    Zoo newAnimal = new Zoo(type, family);
                    animals.replace(e.getKey(), newAnimal);
                    System.out.println("Zaktualizowano " + e.getKey() + "=> " + oldAnimal.toString() +
                            " na => " + newAnimal.toString());
                }
            }
        }
        return animals;
    }
}
