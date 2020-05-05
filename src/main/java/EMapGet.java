import org.ehcache.Cache;
import java.util.Scanner;

public class EMapGet {
    public void getAllAnimals(Cache<Long, Zoo> animals) {
        if (!animals.toString().isEmpty()) {
            System.out.println("Wszystkie zwierzeta: ");
            for (Cache.Entry<Long, Zoo> e : animals)
                System.out.println(e.getKey() + " => " + e.getValue());
        } else
            System.out.println("W zoo nie ma żadnych zwierząt");
    }

    public void getAnimalById(Cache<Long, Zoo> animals) {
        System.out.println("Podaj id: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();

        if (!animals.containsKey(Long.parseLong(id)))
            System.out.println("W zoo nie ma takiego zwierzęcia");
        else {
            for (Cache.Entry<Long, Zoo> e : animals) {
                if (e.getKey().toString().equals(id))
                    System.out.println(e.getKey() + " => " + e.getValue());
            }
        }
    }

    public void getByType(Cache<Long, Zoo> animals) {
        System.out.println("Podaj gatunek zwierzęcia");
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();

        for (Cache.Entry<Long, Zoo> e : animals) {
            if (e.getValue().getType().equals(type))
                System.out.println(e.getKey() + " => " + e.getValue());
        }
    }
}
