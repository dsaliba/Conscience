public class Question {

    public String faction;
    public String question;
    public String first;
    public String second;

    public int[] firstR;
    public int[] secondR;

    public int cost1;
    public int cost2;

    public Question(String faction, String question, String first, String second, int[] firstR, int[] secondR) {
        this.faction = faction;
        this.question = question;
        this.first = first;
        this.second = second;
        this.firstR = firstR;
        this.secondR = secondR;
        this.cost1 = 0;
        this.cost2 = 0;
    }

    public Question(String faction, String question, String first, String second, int[] firstR, int[] secondR, int cost1, int cost2) {
        this.faction = faction;
        this.question = question;
        this.first = first;
        this.second = second;
        this.firstR = firstR;
        this.secondR = secondR;
        this.cost1 = cost1;
        this.cost2 = cost2;
    }

    public boolean avialable(int a, Game g){
        if (a == 0){
            return this.cost1 >= g.character;
        }else {
            return this.cost2 >= g.character;
        }
    }

    public void answer(int a, Game g) {
        int[] mods = a==0?firstR:secondR;
        if (a == 0){
            g.character -= cost1;
        }else {
            g.character -= cost2;
        }
        for (int i = 0; i < mods.length; i++){
            g.factions[i].changeScore(mods[i]);
        }
    }


}
