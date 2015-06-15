/**
 * AirUBC.java
 *  Main program to run AirUBC Database App
 */

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
        int nSeats;

            /* insert airplane into flightschedule */
            // Timestamp format: YYYY-MM-DD HH:MM:SS
        depTime = java.sql.Timestamp.valueOf("2015-11-01 08:30:30");
        avlTime = java.sql.Timestamp.valueOf("2015-11-01 12:30:00");
        fs.insertAirplaneIntoFS(1, depTime, avlTime, 12, 1, 2);

        depTime = java.sql.Timestamp.valueOf("2015-12-01 12:15:00");
        avlTime = java.sql.Timestamp.valueOf("2015-12-01 23:15:00");
        fs.insertAirplaneIntoFS(2, depTime, avlTime, 65, 2, 3);

        depTime = java.sql.Timestamp.valueOf("2015-10-08 03:25:00");
        avlTime = java.sql.Timestamp.valueOf("2015-10-08 09:15:30");
        fs.insertAirplaneIntoFS(3, depTime, avlTime, 90, 6, 1);

            /* delete airplane from flightschedule */
        fs.deleteAirplaneFromFS(3, 6, depTime, avlTime);

            /* insert route into flightschedule */
        depTime = java.sql.Timestamp.valueOf("2015-10-08 03:25:00");
        avlTime = java.sql.Timestamp.valueOf("2015-10-08 09:15:30");
        fs.insertRouteIntoFS(3, depTime, avlTime, 100, 3, 6);

        depTime = java.sql.Timestamp.valueOf("2015-04-08 10:00:00");
        avlTime = java.sql.Timestamp.valueOf("2015-04-10 15:15:30");
        fs.insertRouteIntoFS(4, depTime, avlTime, 70, 1, 2);
            /* delete route from flightschedule */
        fs.deleteRouteFromFS(4, 2, depTime, avlTime);


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

    }
}
