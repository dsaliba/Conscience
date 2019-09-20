

public class Game {
    Faction[] factions;
    static int
    parents = 0,
    friends = 1,
    teachers = 2,
    peers = 3,
    me = 4,
            siblings = 5;

    public int character;
    public int day;

    public Game(){
        factions = new Faction[6];
        factions[parents] = new Faction("Parents");
        factions[friends] = new Faction("Friends");
        factions[teachers] = new Faction("Teachers");
        factions[peers] = new Faction("Peers");
        factions[me] = new Faction("Me");
        factions[siblings] = new Faction("Siblings");
        Parser p = new Parser();
        p.parse(this);
        this.character = 500;
        this.day = 1;
    }


    public static void main(String[] args) {
        mainFrame.addElements();
        Game g = new Game();

    }
}
