/**
 * AirUBC.java
 *  Main program to run AirUBC Database App
 */

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
            /* insert airplane into flightschedule */
        fs.insertAirplaneIntoFS(1, "01/11/2015 17:15", "01/11/2015 21:15", 12, 1, 2);
        fs.insertAirplaneIntoFS(2, "01/12/2015 12:15", "01/12/2015 23:15", 65, 2, 3);
        fs.insertAirplaneIntoFS(3, "08/10/2015 03:25", "08/10/2015 09:15", 90, 6, 1);
            /* delete airplane from flightschedule */
        fs.deleteAirplaneFromFS(1,1,"01/11/2015 17:15","01/11/2015 21:15");
        fs.deleteAirplaneFromFS(3,6,"08/10/2015 03:25", "08/10/2015 09:15");

            /* insert route into flightschedule */
        //fs.insertRouteIntoFS();
       // fs.insertRouteIntoFS();
            /* delete route from flightschedule */
       // fs.deleteRouteFromFS();


    }
}
