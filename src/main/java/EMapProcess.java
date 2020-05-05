import org.ehcache.Cache;

public class EMapProcess {
    public Cache<Long, Zoo> processData(Cache<Long, Zoo> animals) {

        for (Cache.Entry<Long, Zoo> e : animals) {
            if (e.getValue().getType().equals(e.getValue().getType().toLowerCase()) &&
                    e.getValue().getFamily().equals(e.getValue().getFamily().toLowerCase())) {
                String animalType = e.getValue().getType().toUpperCase();
                String animalFamily = e.getValue().getFamily().toUpperCase();

                Zoo animal = new Zoo(animalType, animalFamily);
                animals.replace(e.getKey(), animal);
                System.out.println(e.getKey() + " => " + animalType + " " + animalFamily);
            } else {
                String animalType = e.getValue().getType().toLowerCase();
                String animalFamily = e.getValue().getFamily().toLowerCase();

                Zoo animal = new Zoo(animalType, animalFamily);
                animals.replace(e.getKey(), animal);
                System.out.println(e.getKey() + " => " + animalType + " " + animalFamily);
            }
        }

        return animals;
    }

}
