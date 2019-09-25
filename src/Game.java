

public class Game {
    Faction[] factions;
    public static int
    parents = 0,
    friends = 1,
    teachers = 2,
    peers = 3,
    me = 4,
            siblings = 5;

    boolean[] enabledFactions;
    public int lastFaction;

    public int character;
    public int day;

    public mainFrame mF;

    public Question activeQuestion;

    public Game(){
        factions = new Faction[6];
        factions[parents] = new Faction("Parents", 0);
        factions[friends] = new Faction("Friends", 1);
        factions[teachers] = new Faction("Teachers", 2);
        factions[peers] = new Faction("Peers", 3);
        factions[me] = new Faction("Me",4);
        factions[siblings] = new Faction("Siblings", 5);
        Parser p = new Parser();
        p.parse(this);
        this.character = 500;
        this.day = 1;
        enabledFactions = new boolean[6];
        lastFaction = 0;
        for (int i = 0; i < 6; i++){
            enabledFactions[i] = true;
        }
    }

    public void step(){
        this.day ++;
        for (Faction f : factions){
            this.character += f.getIncome();
        }
        this.character -= 10;



        for (Faction f : factions) {
            if (f.score < 1){
                this.activeQuestion = f.getDeathQuestion();
                System.out.println(this.activeQuestion.question);
                mF.askQuestion();
                break;
            }
        }
        this.update();
    }

    public void update(){
        mF.update();

    }


    public static void main(String[] args) {

        Game g = new Game();
        mainFrame f = new mainFrame(g);
        g.mF = f;
        f.addElements();
    }
}
