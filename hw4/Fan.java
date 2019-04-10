/*
I worked on the homework assigment alone, using only course materials.
*/

public class Fan {
    private int yearsAsFan;
    private int albumsBought;
    private int concertsAttended;
    private boolean buzzcard;
    private Musician favoriteMusician;

    Fan(int years, int albums, int concerts, boolean buzz, Musician favorite) {
        yearsAsFan = years;
        albumsBought = albums;
        concertsAttended = concerts;
        buzzcard = buzz;
        favoriteMusician = favorite;
    }

    public int getYearsAsFan() {
        return yearsAsFan;
    }

    public int getAlbumsBought() {
        return albumsBought;
    }

    public int getConcertsAttended() {
        return concertsAttended;
    }

    public boolean getBuzzcard() {
        return buzzcard;
    }

    public Musician getFavoriteMusician() {
        return favoriteMusician;
    }

    public boolean winGiveaway() {
        return true;
    }

    public String liveTweet(Concert concert) {
        String tweet = "";
        if (this.yearsAsFan > 5) {
            tweet += "Best band ever!";
        }

        if (concert.getTicketPrice() > 100) {
            if (tweet.length() > 0) {
                tweet += "\n";
            }
            tweet += "Totally worth my entire bank account!";
        }

        if (this.albumsBought > 0) {
            if (tweet.length() > 0) {
                tweet += "\n";
            }
            tweet += "Even better in person!";
        }

        String concerts = (this.concertsAttended == 0 ? "concert!" : "concerts!");
        concertsAttended += 1;

        if (this.albumsBought > 0) {
            tweet += "\n";
        }

        tweet += "I've been to " + (concertsAttended) + " " + concerts;
        return tweet;
    }

    public void lostBuzzcard() {
        if (this.yearsAsFan > 3) {
            this.buzzcard = false;
        }
    }

    public void announceFavoriteMusician() {
        String print = "My favorite musician is " + this.favoriteMusician.getName() + "!";
        System.out.println(print);
    }
}