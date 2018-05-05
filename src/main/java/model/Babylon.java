package model;

public class Babylon extends Civilization {
    private Hills hills = new Hills();

    public Babylon() {
        super("Ancient Babylon");
    }

    @Override
    public String explore() {
        int resources = hills.mineCoal();
        produceResources(resources);
        return "You go mining and get " + resources + " resources!";
    }

    public Hills getHills() {
        return hills;
    }

}
