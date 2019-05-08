package pl.budzisz.mariusz.ticketgenerator.parking;

public enum SlotStatus {
	FREE("Wolne"),
	OCCUPIED("Zajęte");
	
	String desc;
	
	SlotStatus(String desc) {
		this.desc = desc;
	}

}
