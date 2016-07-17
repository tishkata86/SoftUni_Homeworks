package Problem04_BeerCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BeerCounterProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!"End".equals(line = sc.readLine())){
            int[] params = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int boughtBeer = params[0];
            int drunkBeer = params[1];
            BeerCounter.BuyBeer(boughtBeer);
            BeerCounter.DrinkBeer(drunkBeer);
        }
        System.out.println(BeerCounter.beerInStock + " " + BeerCounter.beersDrankCount);
    }
}

class BeerCounter{
    static int beerInStock = 0;
    static int beersDrankCount = 0;

    public static void BuyBeer(int bottlesCount){
        beerInStock += bottlesCount;
    }

    public static void DrinkBeer(int bottlesCount){
        beerInStock -= bottlesCount;
        beersDrankCount += bottlesCount;
    }
}