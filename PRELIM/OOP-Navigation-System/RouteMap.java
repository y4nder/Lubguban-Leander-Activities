import java.util.Scanner;
public class RouteMap {
    private Route start;
    private Map map;
    static Scanner scan = new Scanner(System.in);

    public RouteMap(){
        this.map = new Map();
        this.start = map.getStartingPosition();
    }

    public void startTravel(double speed){
        String traveledPath = "";
        if(start == null) return;
        traveledPath = findRoutes( start, "", 0.0, speed );
        System.out.println("\n\n------TRAVEL SUMMARY------\n" + traveledPath);
    }

    public String findRoutes(Route route, String path, double totalDistance, double speed){
        path = "    " + route.getPlaceName();
        totalDistance += route.getDistance();
        
        System.out.print(path.trim());

        if(noRoutesAhead(route)){
            path += ("\n\nFrom: " + start.getPlaceName());
            path += ("\nDestination: " + route.getPlaceName());
            path += String.format("\n\n- Distance: (%.1f km)", totalDistance);
            path += String.format("\n- Speed: %.1f km/h", speed);
            path += "\n- ETA: " + calculateTime(totalDistance, speed);
            return path;
        }

        if(crossRoadsAhead(route)){
            System.out.println("\n\n2 routes found at " + route.getPlaceName());
            int chosenPath = getInput("Choose preferred route\n[1]" + route.getLeftRoute().getPlaceName() + "\n[2]" + route.getRightRoute().getPlaceName() );
            if(chosenPath == 1){
                return path += "\n" + findRoutes(route.getLeftRoute(), path, totalDistance, speed);
            }
            else{
                return path += "\n" + findRoutes(route.getRightRoute(), path, totalDistance, speed);
            }
        }

        System.out.print(" ---> ");

        if( leftRouteIsAvailable(route) ){
            return path += "\n" + findRoutes(route.getLeftRoute(), path, totalDistance, speed);
        }
        if( rightRouteIsAvailable(route) ){
            return path += "\n" + findRoutes(route.getRightRoute(), path, totalDistance, speed);
        }

        return path;
    }

    private String calculateTime(double distance, double speed){
        String estimatedTime = "";
        double timeInHours = distance / speed;
        int seconds = (int)(timeInHours * 100);
        int hours = seconds/100;
        int minutes = seconds%100;

        if(minutes >= 60){
            hours++;
            minutes = minutes - 60;
        }

        estimatedTime = hours + " hr " + (minutes + 1) + "min";
        return estimatedTime;
    }

    //helper methods
    private int getInput(String instructions){
        int choice;
        System.out.println(instructions);
        choice = scan.nextInt();
        return choice;
    }

    private boolean crossRoadsAhead(Route route){
        return (route.getLeftRoute() != null && route.getRightRoute() != null);
    }

    private boolean noRoutesAhead(Route route){
        return (route.getLeftRoute() == null && route.getRightRoute() == null);
    }

    private boolean leftRouteIsAvailable(Route route){
        return route.getLeftRoute() != null;
    }

    private boolean rightRouteIsAvailable(Route route){
        return route.getRightRoute() != null;
    }
    //code by yander
}
