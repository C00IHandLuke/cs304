# AirUBC
AirUBC is a flight reservation system for domestic flights in Canada. Through AirUBC, a potential passenger can make a number of transactions (uniquely defined by their transaction ID), or reserve/cancel tickets for scheduled dates. A transaction has various methods of payment, of which a ticket is then issued by an employee once the transaction goes through successfully. A ticket maintains information of the employee, the transaction that was made and the according flight schedule. The flight schedule is constantly updated with every route having a set destination and departure location across Canada. Airplanes have various models with a limited number of seats, which is also handled through the flight schedule. In a branch, which are located throughout provinces, are a number of employees who’s responsible for the handling of tickets to passengers. We also keep track of every employee and passenger’s information such as phone number, date of birth, etc. A transaction can be made between a passenger and an employee, of which a ticket is then issued with its corresponding flight schedule for a specific route the passenger may want to travel. 

This application offers two views for its clients:
- Employee View 
- User View 

### Requirements
AirUBC is built on a Java platform (IntelliJ IDEA) and MySQL. Download the driver and add to your project:
- mysql-connector-java-5.0.8

### Details
This application comes with the following tables:
- Airplane
- AirplaneFlight
- Branch
- Employee
- FlightSchedule
- Location
- Passenger
- Route
- RouteSchedule
- Ticket
- TicketTransaction
- Transaction




