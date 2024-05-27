package pokemonGoCalc;

public class Pokemon {
    private boolean isLegendary;
    private boolean isShiny;
    private boolean isInDeck;

    public Pokemon(boolean isLegendary, boolean isShiny, boolean isInDeck) {
        this.isLegendary = isLegendary;
        this.isShiny = isShiny;
        this.isInDeck = isInDeck;
    }

    public boolean isLegendary() {
        return isLegendary;
    }

    public void setLegendary(boolean legendary) {
        isLegendary = legendary;
    }

    public boolean isShiny() {
        return isShiny;
    }

    public void setShiny(boolean shiny) {
        isShiny = shiny;
    }

    public boolean isInDeck() {
        return isInDeck;
    }

    public void setInDeck(boolean inDeck) {
        isInDeck = inDeck;
    }
}
