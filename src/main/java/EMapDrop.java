import org.ehcache.Cache;
import java.util.Scanner;

public class EMapDrop {
    public Cache<Long, Zoo> dropAnimalById(Cache<Long, Zoo> animals) {
        System.out.println("Podaj id zwierzęcia które chcesz usunąć: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();

        if (!animals.containsKey(Long.parseLong(id)))
            System.out.println("W zoo nie ma takiego zwierzęcia");
        else {
            for (Cache.Entry<Long, Zoo> e : animals) {
                if (e.getKey().toString().equals(id)) {
                    animals.remove(e.getKey());
                    System.out.println("Usunięto ze składu następujący element: "
                            + e.getKey() + " => " + e.getValue());
                }
            }
        }

        return animals;
    }
}
