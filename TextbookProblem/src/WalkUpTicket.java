
public class WalkUpTicket extends Ticket{
	
	int ticketNumber;
	int ticketPrice;
	
	
	public WalkupTicket (int ticketNumber){
		super(ticketNumber);
		ticketPrice = 50; 
		//ticket price
	}
	
	public double getPrice() { //price of ticket
		return ticketPrice;
	}
	
	public String toString() { //override String method
		String walkUp = "Number: " + ticketNumber + ", Price : " + getPrice();
		return walkUp;
	}
	
}


