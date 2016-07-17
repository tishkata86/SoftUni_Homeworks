package Problem08_PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<Trainer> trainers = new ArrayList<>();
        List<String> trainersNams = new ArrayList<>();
        String line;
        while (!"Tournament".equals(line = sc.readLine())) {
            String[] params = line.trim().split("\\s+");
            String playerName = params[0];
            String pokemonName = params[1];
            String element = params[2];
            int health = Integer.parseInt(params[3]);

            Pokemon currentPokemon = new Pokemon(pokemonName, element, health);

            if (!trainersNams.contains(playerName)) {
                trainersNams.add(playerName);
                trainers.add(new Trainer(playerName));

            }
            for (Trainer trainer : trainers) {
                if (trainer.name.equals(playerName)) {
                    trainer.listOfPokemons.add(currentPokemon);
                    break;
                }
            }
        }

        while (!"End".equals(line = sc.readLine())){
            String wantedElement = line;
            for (Trainer trainer : trainers) {
                boolean hasAtLeastOne = false;
                for (Pokemon pokemon : trainer.listOfPokemons) {
                    if (pokemon.element.equals(wantedElement)){
                        hasAtLeastOne = true;
                        break;
                    }
                }

                if (hasAtLeastOne){
                    trainer.numberOfBadges++;
                } else {
                    trainer.DecreaseHealth();
                    trainer.RemoveDead();
                }
            }
        }

        trainers.stream().sorted((tr1, tr2) -> Integer.valueOf(tr2.numberOfBadges).compareTo(Integer.valueOf(tr1.numberOfBadges)))
                .forEach(trainer -> {
                    System.out.println(trainer.toString());
                });
    }
}

class Trainer {
    String name;
    int numberOfBadges;
    List<Pokemon> listOfPokemons;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.listOfPokemons = new ArrayList<>();
    }

    public void DecreaseHealth(){
        for (int i = 0; i < listOfPokemons.size(); i++) {
            listOfPokemons.get(i).health -= 10;
        }
    }

    public void RemoveDead(){
        List<Pokemon> currentList = new ArrayList<>();
        for (int i = 0; i < listOfPokemons.size(); i++) {
            if (listOfPokemons.get(i).health > 0){
                currentList.add(listOfPokemons.get(i));
            }
        }

        listOfPokemons = currentList;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.listOfPokemons.size());
    }
}

class Pokemon {
    String name;
    String element;
    int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }
}
