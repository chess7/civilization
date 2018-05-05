package model;

public class Greece extends Civilization {
    private Hills hills = new Hills();

    public Greece() {
        super("Ancient Greece");
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
