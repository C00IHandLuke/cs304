/**
 * AirUBC.java
 *  Main program to run AirUBC Database App
 */
import java.sql.*;
import java.sql.Date;
import java.sql.Timestamp;

public class AirUBC {
    //private ResultSet resultSet = null;
    public static void main(String[] argv) throws Exception {
        MySQLConnection db = new MySQLConnection(); // create new database connection
        db.connectToDatabse();
        db.readDatabase();


        // Route
        Route route = new Route();
            /* insert routes */
        route.insertRoute(3, "YVR", "YEG");
        route.insertRoute(4, "YVR", "YEG");
        route.insertRoute(5, "YVR", "YEG");
        route.insertRoute(6, "YVR", "YEG");
        db.readDatabase();
            /* delete routes */
        route.deleteRoute(4);
        route.deleteRoute(5);
        db.readDatabase();



        // Airplane
        Airplane airplane = new Airplane();
            /* insert airplanes */
        airplane.insertAirplane(1, "Boeing-777", 55);
        airplane.insertAirplane(2, "Boeing-787", 60);
        airplane.insertAirplane(3, "Boeing-779", 75);
        db.readDatabase();
            /* delete airplanes */
        airplane.deleteAirplane(2);


        // Flight Schedules
        FlightSchedule fs = new FlightSchedule();
        java.sql.Timestamp depTime;
        java.sql.Timestamp avlTime;


        //int nSeats;

            /* insert airplane into flightschedule */
            // Timestamp format: YYYY-MM-DD HH:MM:SS
        depTime = java.sql.Timestamp.valueOf("2015-11-01 08:30:30");
        avlTime = java.sql.Timestamp.valueOf("2015-11-01 12:30:00");
        fs.insertAirplaneIntoFlightSchedule(1, depTime, avlTime, 12, 1, 2);

        depTime = java.sql.Timestamp.valueOf("2015-12-01 12:15:00");
        avlTime = java.sql.Timestamp.valueOf("2015-12-01 23:15:00");
        fs.insertAirplaneIntoFlightSchedule(2, depTime, avlTime, 65, 2, 3);

        depTime = java.sql.Timestamp.valueOf("2015-10-08 03:25:00");
        avlTime = java.sql.Timestamp.valueOf("2015-10-08 09:15:30");
        fs.insertAirplaneIntoFlightSchedule(3, depTime, avlTime, 90, 6, 1);

            /* delete airplane from flightschedule */
        fs.deleteAirplaneFromFlightSchedule(3, 6, depTime, avlTime);

            /* insert route into flightschedule */
        depTime = java.sql.Timestamp.valueOf("2015-10-08 03:25:00");
        avlTime = java.sql.Timestamp.valueOf("2015-10-08 09:15:30");
        fs.insertRouteIntoFlightSchedule(3, depTime, avlTime, 100, 3, 6);

        depTime = java.sql.Timestamp.valueOf("2015-04-08 10:00:00");
        avlTime = java.sql.Timestamp.valueOf("2015-04-10 15:15:30");
        fs.insertRouteIntoFlightSchedule(4, depTime, avlTime, 70, 1, 2);
            /* delete route from flightschedule */
        fs.deleteRouteFromFlightSchedule(4, 2, depTime, avlTime);


        // AirplaneFlight
        AirplaneFlight af = new AirplaneFlight();
            /* insert airplane-flight */
        af.insertAirplaneFlight(1, 2);
        af.insertAirplaneFlight(3, 4);

            /* delete airplane-flight */
        af.deleteAirplaneFlight(1,2);


        // RouteSchedule
        RouteSchedule rs = new RouteSchedule();
            /* insert route-schedule */
        rs.insertRouteSchedule(3,1);
        rs.insertRouteSchedule(5,2);
            /* delete route-schedule */
        rs.deleteRouteSchedule(5,2);


        /*Add Employees*/
        Employee employee = new Employee();
            /* insert Employees */
        //employee.addEmployee("e2s4", "fred" ,"1230 street","normal","250595959","4e5y7");
        //employee.addEmployee("z41y", "tom", "3456 street", "manager", "23434556", "5e29");



        //java.sql.S empID;
        //depTime = java.sql.Timestamp.valueOf("2015-04-08 10:00:00");
        //String empId = "'z41y'";
        //String newName = "'Andy'";
        //String newAddress = "'1904 things'";
        //employee.removeEmployee(empId);

        //employee.updateEmployeeName(empId, newName);
        //employee.updateEmployeeAddress(empId, newAddress);
        //db.readDatabase();
            /* delete routes */
        /*route.deleteRoute(4);
        route.deleteRoute(5);
        db.readDatabase();
        */

        int planeID = 1234;
        String planeType = "'boeing'";
        int nSeats = 300;
        int seatsAvail = 200;
        int fsID = 200;
        int branchId = 150;
        int routeID = 245;
        String phone = "2505898980";
        String employeeId = "123";
        String name = "Allen";
        String address = "1230 street";
        String role = "manager";
        java.sql.Timestamp departTime;
        java.sql.Timestamp arriveTime;
        departTime = java.sql.Timestamp.valueOf("2015-04-08 10:00:00");
        arriveTime = java.sql.Timestamp.valueOf("2015-04-10 15:15:30");


        AirplaneFlight AirplaneFlight = new AirplaneFlight();
        AirplaneFlight.insertAirplaneFlight(planeID, fsID);

        Airplane airplane1 = new Airplane();
        airplane1.insertAirplane(planeID, planeType, nSeats);


        AirplaneFlight.insertAirplaneFlight(planeID, fsID);

        Branch Branch = new Branch();
        Branch.addBranch(branchId, phone);


        Employee Employee = new Employee();
        Employee.addEmployee(employeeId, name, address, role, phone, branchId);


        FlightSchedule FlightSchedule = new FlightSchedule();
        FlightSchedule.insertAirplaneIntoFlightSchedule(fsID, departTime, arriveTime, seatsAvail, planeID, routeID);


        String province = "BC";
        String city = "vancouver";
        String postalCode = "3s4r5";
        Location Location = new Location();
        Location.insertLocation(province, city, postalCode, branchId);


        int passengerId = 45;
        String name1 = "adam";
        String address1 = "5049 place";
        String phone1 = "3450993459834";
        java.sql.Timestamp DoB;
        DoB = java.sql.Timestamp.valueOf("2015-04-08 10:00:00");
        Passenger Passenger = new Passenger();
        Passenger.addPassenger(passengerId, name1, address1, phone, DoB);


        String destination = "New York";
        String departure = "Vancouver";


        Route Route = new Route();
        Route.insertRoute(routeID, destination, departure);

        RouteSchedule RouteSchedule = new RouteSchedule();
        RouteSchedule.insertRouteSchedule(routeID, fsID);


        int ticketNo = 45;
        int price = 400;
        String bkgDate = "May 10";
        String cnlDate = "Feb 20";

        Ticket Ticket = new Ticket();
        Ticket.insertTicket(ticketNo, price, bkgDate, cnlDate, employeeId , fsID, passengerId);


        int cancelFee = 200;
        int flightScheduleID = 19;
        int transactionId = 222;
        String paymentMethod = "VISA";
        ticketFlight ticketFlight = new ticketFlight();
        ticketFlight.insertTicketFlight(cancelFee, flightScheduleID);

        ticketTransaction ticketTransaction = new ticketTransaction();
        ticketTransaction.addTicketTrans(transactionId, ticketNo);

        Transaction Transaction = new Transaction();
        Transaction.insertTransaction(transactionId, paymentMethod, employeeId, passengerId);

    }
}
