import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem12_LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Long> junks = new TreeMap<>();
        TreeMap<String, Long> legendary = new TreeMap<>();
        legendary.put("fragments", new Long(0));
        legendary.put("shards", new Long(0));
        legendary.put("motes", new Long(0));

        String legendaryWin = "";
        String input = sc.nextLine().toLowerCase();
        boolean isNextTurn = true;

        while (isNextTurn) {
            String[] commands = input.split("[\\s]+");
            for (int i = 0; i < commands.length; i += 2) {
                long     quantities = Integer.parseInt(commands[i]);
                String material = commands[i + 1];
                if (material.equals("shards")) {
                    long oldValue = legendary.get("shards");
                    legendary.put("shards", oldValue + quantities);
                    if (legendary.get("shards") > 249) {
                        isNextTurn = false;
                        legendaryWin = "Shadowmourne obtained!";
                        long shardsValue = legendary.get("shards");
                        legendary.put("shards", shardsValue - 250);
                        break;
                    }
                } else if (material.equals("fragments")) {
                    long oldValue = legendary.get("fragments");
                    legendary.put("fragments", oldValue + quantities);
                    if (legendary.get("fragments") > 249) {
                        isNextTurn = false;
                        legendaryWin = "Valanyr obtained!";
                        long shardsValue = legendary.get("fragments");
                        legendary.put("fragments", shardsValue - 250);
                        break;
                    }
                } else if (material.equals("motes")) {
                    long oldValue = legendary.get("motes");
                    legendary.put("motes", oldValue + quantities);
                    if (legendary.get("motes") > 249) {
                        isNextTurn = false;
                        legendaryWin = "Dragonwrath obtained!";
                        long shardsValue = legendary.get("motes");
                        legendary.put("motes", shardsValue - 250);
                        break;
                    }
                } else {
                    if (!junks.containsKey(material)) {
                        junks.put(material, quantities);
                    } else {
                        long oldValue = junks.get(material);
                        junks.put(material, oldValue + quantities);
                    }
                }
            }
            if (isNextTurn) {
                input = sc.nextLine().toLowerCase();
            }
        }

        System.out.println(legendaryWin);
        legendary.entrySet().stream().sorted((v1, v2) -> v2.getValue().compareTo(v1.getValue())).forEach(value -> {
            System.out.println(value.getKey() + ": " + value.getValue());
        });
        for (Map.Entry<String, Long> entry : junks.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
