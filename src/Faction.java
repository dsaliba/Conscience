import java.util.ArrayList;

public class Faction {

    public String name;
    public ArrayList<Question> questions;
    public ArrayList<Question> used;
    public int score;

    public Faction(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
        this.used = new ArrayList<>();
        this.score = 5;
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

    public void changeScore(int s) {
        this.score += s;
        this.score = this.score < 0? 0:this.score > 10?10: this.score;
    }
}
