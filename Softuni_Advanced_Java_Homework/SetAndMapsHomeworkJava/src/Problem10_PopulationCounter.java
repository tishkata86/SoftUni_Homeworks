import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem10_PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> data = new LinkedHashMap<>();
        LinkedHashMap<String, Long> countryPopulation = new LinkedHashMap<>();
        String input = sc.nextLine();

        while (!input.equals("report")) {
            String[] params = input.split("\\|");
            String county = params[1];
            String city = params[0];
            Long population = Long.parseLong(params[2]);

            if (!data.containsKey(county)) {
                data.put(county, new LinkedHashMap<>());
            }
            if (!data.get(county).containsKey(city)) {
                data.get(county).put(city, new Long(0));
            }
            long oldValue = data.get(county).get(city);
            data.get(county).put(city, oldValue + population);

            input = sc.nextLine();
        }

        for (String country : data.keySet()) {
            long totalSum = 0;
            for (Long cityPopulation : data.get(country).values()) {
                totalSum += cityPopulation;
            }
            countryPopulation.put(country, totalSum);
        }

        countryPopulation.entrySet().stream().sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue())).forEach(country ->
        {
            System.out.println(country.getKey() + " (total population: " + country.getValue() + ")");

            data.get(country.getKey()).entrySet().stream().sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue())).forEach(city ->
            {
                System.out.println("=>" + city.getKey() + ": " + city.getValue());
            });
        });
    }
}
