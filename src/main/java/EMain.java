import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import java.util.Scanner;

public class EMain {
    public static void main(String [] args) {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("preConfigured",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, Zoo.class,
                                ResourcePoolsBuilder.heap(100))
                                .build())
                .build(true);

        Cache<Long, Zoo> animals = cacheManager.createCache("zoo",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, Zoo.class,
                        ResourcePoolsBuilder.heap(100)).build());

        EMapPut eMapPut = new EMapPut();
        EMapGet eMapGet = new EMapGet();
        EMapDrop eMapDrop = new EMapDrop();
        EMapProcess eMapProcess = new EMapProcess();
        EMapUpdate eMapUpdate = new EMapUpdate();

        System.out.println("Aplikacja ma za zadanie pokazać działanie składu Ehcache");
        System.out.println("Temat: zoo");

        for (;;) {
            System.out.println("1 -> Dodaj dane");
            System.out.println("2 -> Aktualizuj dane");
            System.out.println("3 -> Kasuj dane");
            System.out.println("4 -> Pobierz wszystkie dane");
            System.out.println("5 -> Pobierz dane po id");
            System.out.println("6 -> Pobierz wszystkie zwierzęta danego gatunku");
            System.out.println("7 -> Przetwórz dane");
            System.out.println("8 -> Zakończ program");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            if (choice.equals("1"))
                animals = eMapPut.putData(animals);

            if (choice.equals("2"))
                animals = eMapUpdate.updateAnimal(animals);

            if (choice.equals("3"))
                animals = eMapDrop.dropAnimalById(animals);

            if (choice.equals("4"))
                eMapGet.getAllAnimals(animals);

            if (choice.equals("5"))
                eMapGet.getAnimalById(animals);

            if (choice.equals("6"))
                eMapGet.getByType(animals);

            if (choice.equals("7"))
                animals = eMapProcess.processData(animals);

            if (choice.equals("8"))
                break;
        }

        cacheManager.close();
    }
}
