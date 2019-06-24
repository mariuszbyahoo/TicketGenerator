# TicketGenerator
Simulation of parking ticket machine's system (Spring &amp; IText7)

This app has a possibility to simulate a real parking, where a specific parking lot is attached to a ticket.

# Options:
* Enter the parking; when entering, uses an PUT method, with a requested chosen already specific parking lot, it may be chosen for example by 
a GUI, or be chosen automatically by an algorithm (feature which may be added in the future), as a response there comes a Response Body, 
and the code is generating a ticket in a newly created PDF in the "docs/" folder. "TicketGenerator/getTicket?columnNumber=X&slotNumber=Y" mapping <br /> 

* Generate a JSON formatted data output with a current information about the parking, GET method, "/parkingInfo" mapping. <br />

* Generate a PDF file with a current information about the parking, GET method, "TicketGenerator/parkingPdf" mapping. <br />

* Exit the parking, PUT method, requests parameters; columnNumber and slotNumber, sets the earlier occupied slot as a free one and updates
the parking's informations. "TicketGenerator/exit?columnNumber=X&slotNumber=Y" mapping. Generates a newly created PDF file in the "/docs" folder.
