import java.util.Comparator;

class PsComparator implements Comparator<String> {
    @Override
    public int compare(String score1, String score2) {
        int score_1 = Integer.parseInt(score1.split(" ")[1]);
        int score_2 = Integer.parseInt(score2.split(" ")[1]);
        return score_1 - score_2;
    }
}
