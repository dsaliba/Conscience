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
        for (Question q : questions){
            System.out.println(q.question);
        }
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
        int cost1 = 50;
        int [] o1N = new int[] {0, 0, 0, 0, 0, 0};
        int [] o2N = new int[] {0, 0, 0, 0, 0, 0};
        o1N[this.ind] = 3;
        switch(this.name){
            case "Parents":
                o1 = "Sit down and talk with them [" + cost1 + "]";
                o2 = "Go to boot camp";
                q = "You're parents are very concerned with your recent behavior...";
                break;
            case "Friends":
                o1 = "Take time to meet with them [" + cost1 + "]";
                o2 = "Ignore them and risk your friendship";
                q = "Your friends are mad at you and want to talk to you about your group's future";
                break;
            case "Teachers":
                o1 = "Talk to them after school [" + cost1 + "]";
                o2 = "Too relatable so you decide to not meet them";
                q = "Your grades are all F's, besides computer science and theology where you get all A's, so your teachers want to talk with you and your parents";
                break;
            case "Peers":
                o1 = "Start contributing to the projects [" + cost1 + "]";
                o2 = "Yeet them across the room and don't care if they snitch, because snitches get stitches";
                q = "Your Peers see that you are not contributing enough work so they are threatening to tell the teachers unless you start participating more.";
                break;
            case "Me":
                o1 = "Take a breather to give some time to yourself over the weekend [" + cost1 + "]";
                o2 = "Ignore your stress, it can wait";
                q = "You start to feel bad about your choices and get super stressed";
                break;
            case "Sibilings":
                o1 = "Talk to them about how you can be a better sibling [" + cost1 + "]";
                o2 = "Lock them in the closet and let them starve while your parents are gone";
                q = "Your siblings are mad at you because you haven't been  respectful towards them";
                break;
        }

        return new Question(this.name, q, o1, o2, o1N, o2N, cost1, 0);
    }

}
