
public abstract class Ticket {
	int ticketNumber;
	
	public Ticket (int ticketNumber){
		this.ticketNumber= new ticketNumber;
		
	}
	
	public  abstract double getPrice(); //abstract method
	public abstract String toString(); //abstract method
	
}