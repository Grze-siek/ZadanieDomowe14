package wynikizawodow;

public class Competitor implements Comparable<Competitor> {
    private String firstName;
    private String lastName;
    private int score;

    public Competitor(String firstName, String lastName, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    @Override
    public int compareTo(Competitor o) {
        if(this.score == o.score) {
            return this.lastName.compareTo(o.lastName);
        }
        else if(this.lastName.equals(o.lastName)) {
            return this.firstName.compareTo(o.firstName);
        }
        else
            return -Integer.compare(this.score, o.score);
    }

    @Override
    public String toString() {
        return  firstName + ' ' + lastName + ';' + score ;
    }
}
