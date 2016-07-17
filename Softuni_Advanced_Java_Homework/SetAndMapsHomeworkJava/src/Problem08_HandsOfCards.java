import java.util.*;

public class Problem08_HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashSet<String>> data = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        String input = sc.nextLine();

        while (!input.equals("JOKER")){
            String[] params = input.split(":");
            String name = params[0];
            String cards = params[1].trim();
            String[] allCards = cards.split("[ ,]");
            if (!data.containsKey(name)){
                data.put(name, new LinkedHashSet<>());
            }
            for (String allCard : allCards) {
                if (allCard.equals("")){
                    continue;
                }
                data.get(name).add(allCard);
            }
            input= sc.nextLine();
        }

        for (Map.Entry<String, LinkedHashSet<String>> entry : data.entrySet()) {
            String name = entry.getKey();
            Set<String> allCard = data.get(entry.getKey());
            int cardValue = 0;
            if (!result.containsKey(name)){
                result.put(name, new Integer(0));
                for (String card : allCard) {
                    cardValue += CalcValue(card);
                }
                result.put(name, cardValue);
            } else {
                int oldValue = result.get(name);
                result.put(name, oldValue + cardValue);
            }
        }

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
    }

    private static int CalcValue(String value) {
        int cardValue = 0;
        switch (value.charAt(0)){
            case '1':
                cardValue = MultiplyValue(10, value.charAt(2));
                break;
            case '2':
                cardValue = MultiplyValue(2, value.charAt(1));
                break;
            case '3':
                cardValue = MultiplyValue(3, value.charAt(1));
                break;
            case '4':
                cardValue = MultiplyValue(4, value.charAt(1));
                break;
            case '5':
                cardValue = MultiplyValue(5, value.charAt(1));
                break;
            case '6':
                cardValue = MultiplyValue(6, value.charAt(1));
                break;
            case '7':
                cardValue = MultiplyValue(7, value.charAt(1));
                break;
            case '8':
                cardValue = MultiplyValue(8, value.charAt(1));
                break;
            case '9':
                cardValue = MultiplyValue(9, value.charAt(1));
                break;
            case 'J':
                cardValue = MultiplyValue(11, value.charAt(1));
                break;
            case 'Q':
                cardValue = MultiplyValue(12, value.charAt(1));
                break;
            case 'K':
                cardValue = MultiplyValue(13, value.charAt(1));
                break;
            case 'A':
                cardValue = MultiplyValue(14, value.charAt(1));
                break;

        }

        return cardValue;
    }

    private static int MultiplyValue(int i, char c) {
        int value = 0;
        switch (c){
            case 'S':
                value = i * 4;
                break;
            case 'H':
                value = i * 3;
                break;
            case 'D':
                value = i * 2;
                break;
            case 'C':
                value = i * 1;
                break;
        }
        return value;
    }
}
