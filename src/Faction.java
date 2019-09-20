import java.util.ArrayList;

public class Faction {

    public String name;
    public ArrayList<Question> questions;
    public ArrayList<Question> used;
    public int score;
    public int ind;

    public Faction(String name, int ind) {
        this.name = name;
        this.questions = new ArrayList<>();
        this.used = new ArrayList<>();
        this.score = 5;
        this.ind = ind;
    }

    public Question getQuestion(){
        int i = (int) (Math.random() * this.questions.size());
        Question q = this.questions.get(i);
        this.questions.remove(i);
        this.used.add(q);
        if (this.questions.size() < 1){
            for (Question e : used) {
                this.questions.add(e);
            }
            this.used = new ArrayList<>();
        }
        return q;
    }

    public int getIncome(){
        if (this.score < 3) {
            return -5 * (3-this.score);
        }else if (this.score > 10){
            return 5 * (this.score -10);
        }
        return 0;
    }

    public void changeScore(int s) {
        this.score += s;
        this.score = this.score < 0? 0:this.score > 20?20: this.score;
    }

    public Question getDeathQuestion() {
        String o1 = "";
        String o2 = "";
        String q = "";
        int [] o1N = new int[] {0, 0, 0, 0, 0, 0};
        int [] o2N = new int[] {0, 0, 0, 0, 0, 0};
        o1N[this.ind] = 3;
        switch(this.name){
            case "Parents":
                o1 = "";
                o2 = "";
                q = "";
                break;
            case "Friends":
                o1 = "";
                o2 = "";
                q = "";
                break;
            case "Teachers":
                o1 = "";
                o2 = "";
                q = "";
                break;
            case "Peers":
                o1 = "";
                o2 = "";
                q = "";
                break;
            case "Me":
                o1 = "";
                o2 = "";
                q = "";
                break;
            case "Sibilings":
                o1 = "";
                o2 = "";
                q = "";
                break;
        }
        return new Question(this.name, q, o1, o2, o1N, o2N, 50, 0);
    }

}
