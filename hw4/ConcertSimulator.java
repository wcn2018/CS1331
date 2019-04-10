/*
I worked on the homework assigment alone, using only course materials.
*/

public class ConcertSimulator{
    public static void main(String[] args) {
        Musician mus1 = new Musician("Christopher W. Klaus", "violin", 30);
        Musician mus2 = new Musician("UGA", "students", 234);
        Fan geraldClough = new Fan(14, 8, 0, true, mus1);

        System.out.println("Test mus methods: " + mus1.getYearsPlaying() + " " + mus1.getSkillLevel());

        mus1.rehearse();
        mus1.perform();
        
        System.out.println("Test mus methods: " + mus1.getYearsPlaying() + " " + mus1.getSkillLevel());
        System.out.println(mus1);
        System.out.println(mus2);

        System.out.println(" ");
        System.out.println("Testing Fan");
        System.out.println(geraldClough.getYearsAsFan());
        System.out.println(geraldClough.getAlbumsBought());
        System.out.println(geraldClough.getConcertsAttended());
        System.out.println(geraldClough.getBuzzcard());
        System.out.println(geraldClough.getFavoriteMusician());
        System.out.println(geraldClough.winGiveaway());
        geraldClough.lostBuzzcard();
        System.out.println(geraldClough.getBuzzcard());
        geraldClough.announceFavoriteMusician();

        Concert concert1 = new Concert(500.0, 60, "Mercedes-Benz Stadium", "02/03/2019");
        concert1.setLocation("CULC");
        concert1.setTicketPrice(20);

        for (int i = 0; i < 60; i++){
            concert1.sellTicket();
        }

        if (concert1.isSoldOut()){
            System.out.println("Sorry! " + concert1.toString() + " is fully booked!");
        }

        System.out.print(geraldClough.liveTweet(concert1));
    }
}