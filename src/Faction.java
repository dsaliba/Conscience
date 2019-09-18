import java.util.ArrayList;

public class Faction {

    public String name;
    public ArrayList<Question> questions;
    public int score;

    public Faction(String name) {
        this.name = name;
        questions = new ArrayList<>();
        this.score = 5;
    }

    public void changeScore(int s) {
        this.score += s;
        this.score = this.score < 0? 0:this.score > 10?10: this.score;
    }
}
