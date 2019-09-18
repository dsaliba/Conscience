public class Question {

    public String faction;
    public String question;
    public String first;
    public String second;

    public int[] firstR;
    public int[] secondR;

    public Question(String faction, String question, String first, String second, int[] firstR, int[] secondR) {
        this.faction = faction;
        this.question = question;
        this.first = first;
        this.second = second;
        this.firstR = firstR;
        this.secondR = secondR;
    }

    public void answer(int a, Game g) {
        int[] mods = a==0?firstR:secondR;
        for (int i = 0; i < mods.length; i++){
            g.factions[i].changeScore(mods[i]);
        }
    }


}
