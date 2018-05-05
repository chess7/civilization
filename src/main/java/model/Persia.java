package model;

public class Persia extends Civilization {
    private Desert desert = new Desert();

    public Persia() {
        super("Persia");
    }

    @Override
    public String explore() {
        int gold = desert.findTreasure();
        getTreasury().earn(gold);
        return "You explore the desert and find " + gold + " gold!";
    }

    public Desert getDesert() {
        return desert;
    }

}
