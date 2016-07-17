package Problem09_PizzaTime;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PizzaTime {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        Class<?> pizzaClass = Pizza.class;
        Method[] methods = pizzaClass.getDeclaredMethods();
        List<Method> checkedMethods = Arrays.stream(methods)
                .filter(m -> m.getReturnType().getName().contains("Map"))
                .collect(Collectors.toList());

        if (checkedMethods.size() < 1) {
            throw new ClassFormatException();
        }

        String input = sc.readLine();
        Pizza catalogue = new Pizza();
        catalogue.fillData(input);
        System.out.println(catalogue);

    }
}

class Pizza {
    private HashMap<Integer, List<String>> data = new HashMap<>();

    public HashMap<Integer, List<String>> fillData(String params) {
        Pattern pattern = Pattern.compile("(\\s|^)(\\d+)(\\w+)");
        Matcher matcher = pattern.matcher(params);
        while (matcher.find()) {
            int group = Integer.parseInt(matcher.group(2));
            String pizza = matcher.group(3);

            if (!this.data.containsKey(group)) {
                this.data.put(group, new ArrayList<>());
            }
            this.data.get(group).add(pizza);
        }

        return this.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, List<String>> entry : data.entrySet()) {
            sb.append(entry.getKey() + " - ");
            boolean isFirst = true;
            for (String pizza : entry.getValue()) {
                if (isFirst) {
                    sb.append(pizza);
                    isFirst = false;
                } else {
                    sb.append(", " + pizza);
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}