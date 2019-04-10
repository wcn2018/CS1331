/*
I worked on the homework assigment alone, using only course materials.
*/

public class Concert {

    private double ticketPrice;
    private int capacity;
    private int ticketsSold;
    private String location;
    private String date;

    Concert(int capacity, String location, String date) {
        this(30.0, capacity, location, date);
    }

    Concert(double ticketPrice, int capacity, String location, String date) {
        this.ticketsSold = 0;
        this.ticketPrice = ticketPrice;
        this.capacity = capacity;
        this.location = location;
        this.date = date;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public boolean isSoldOut() {
        return (ticketsSold >= capacity);
    }

    public void sellTicket() {
        if (this.isSoldOut()) {
            return;
        } else {
            ticketsSold++;
        }
    }

    public String toString() {
        String a = "A concert on " + this.date + " at " + this.location;
        return a;
    }

    public void setTicketPrice(double price) {
        this.ticketPrice = price; //is it okay if they're both named ticketprice
    }

    public void setLocation(String loc) {
        this.location = loc;
    }

    // public void setCapacity

}