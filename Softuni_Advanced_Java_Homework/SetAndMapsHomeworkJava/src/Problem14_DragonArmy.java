import java.util.*;

public class Problem14_DragonArmy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, TreeMap<String, LinkedHashMap<String, Integer>>> dragonData = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Double>> typeStats = new LinkedHashMap<>();
        int lines = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < lines; i++) {
            String[] input = sc.nextLine().split(" ");
            String type = input[0];
            String name = input[1];
            int damage = 45;
            int health = 250;
            int armor = 10;
            if (!input[2].equals("null")) {
                damage = Integer.parseInt(input[2]);
            }
            if (!input[3].equals("null")) {
                health = Integer.parseInt(input[3]);
            }
            if (!input[4].equals("null")) {
                armor = Integer.parseInt(input[4]);
            }

            if (!dragonData.containsKey(type)) {
                dragonData.put(type, new TreeMap<>());
            }
            if (!dragonData.get(type).containsKey(name)) {
                dragonData.get(type).put(name, new LinkedHashMap<>());
            }
            dragonData.get(type).get(name).put("damage", damage);
            dragonData.get(type).get(name).put("health", health);
            dragonData.get(type).get(name).put("armor", armor);

        }

        for (Map.Entry<String, TreeMap<String, LinkedHashMap<String, Integer>>> firstEntry : dragonData.entrySet()) {
            double totalDamage = 0.0;
            double totalHealth = 0.0;
            double totalArmor = 0.0;
            for (Map.Entry<String, LinkedHashMap<String, Integer>> secondEntry : firstEntry.getValue().entrySet()) {
                for (Map.Entry<String, Integer> thirdEntry : secondEntry.getValue().entrySet()) {
                    if (thirdEntry.getKey().equals("damage")) {
                        totalDamage += thirdEntry.getValue() * 1.0;
                    }
                    if (thirdEntry.getKey().equals("health")) {
                        totalHealth += thirdEntry.getValue() * 1.0;
                    }
                    if (thirdEntry.getKey().equals("armor")) {
                        totalArmor += thirdEntry.getValue() * 1.0;
                    }
                }
            }
            totalDamage = totalDamage / Double.valueOf(firstEntry.getValue().size());
            totalHealth = totalHealth / Double.valueOf(firstEntry.getValue().size());
            totalArmor = totalArmor / Double.valueOf(firstEntry.getValue().size());

            typeStats.put(firstEntry.getKey(), new LinkedHashMap<>());
            typeStats.get(firstEntry.getKey()).put("damage", totalDamage);
            typeStats.get(firstEntry.getKey()).put("health", totalHealth);
            typeStats.get(firstEntry.getKey()).put("armor", totalArmor);
        }

        dragonData.entrySet().stream().forEach(entry -> {
            System.out.print(entry.getKey() + "::(");
            System.out.printf("%.2f/%.2f/%.2f)\n",
                    typeStats.get(entry.getKey()).get("damage"),
                    typeStats.get(entry.getKey()).get("health"),
                    typeStats.get(entry.getKey()).get("armor"));
            entry.getValue().entrySet().stream().forEach(dragon -> {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", dragon.getKey(),
                        dragon.getValue().get("damage"),
                        dragon.getValue().get("health"),
                        dragon.getValue().get("armor"));
            });
            });
    }


}
