package application;

import event.Event;
import event.SimpleEvent;
import handler.EventHandler;
import handler.SimpleEventHandler;
import utility.TimeUtility;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.logging.Logger;

public class SimpleEventApplication implements EventApplication {

    private TimeUtility timeUtility = new TimeUtility();
    private EventHandler eventHandler = new SimpleEventHandler();

    private static final Logger LOGGER =
            Logger.getLogger(SimpleEventApplication.class.getName());

    @Override
    public void run() {

        boolean runningFlag = true;
        Scanner input = new Scanner(System.in);
        System.out.println("       EVENT MANAGEMENT APPLICATION\n");

        while (runningFlag) {
            System.out.println("Please choose one option from below: ");
            System.out.println("1. Add a new event");
            System.out.println("2. List all events registered");
            System.out.println("3. List events taking place next weekend");
            System.out.println("4. List events taking place on a specified day for given time zone");
            System.out.println("5. List events taking place in a given date time interval");
            System.out.println("6. Exit the application\n");

            int selection = input.nextInt();
            input.nextLine();

            switch (selection) {
                case 1: {
                    System.out.println("Adding a new event ");
                    System.out.println("Please insert the summary: ");
                    String summary = input.nextLine();

                    System.out.println("Please insert the start date time under " +
                            "format yyyy-MM-dd HH:mm:ss:");
                    String startDate = input.nextLine();

                    System.out.println("Please insert the end date time under " +
                            "format yyyy-MM-dd HH:mm:ss :");
                    String endDate = input.nextLine();

                    System.out.println("Please insert the location:");
                    String location = input.nextLine();

                    LocalDateTime startDateTime =
                            this.timeUtility.convertStringToLocalDateTime(startDate);
                    LocalDateTime endDateTime =
                            this.timeUtility.convertStringToLocalDateTime(endDate);

                    if (startDateTime.isAfter(endDateTime)) {
                        LOGGER.warning("Start date is after end date!");
                        System.out.println();
                        break;
                    } else {
                        Event event = new SimpleEvent(summary, startDateTime, endDateTime, location);
                        this.eventHandler.addEvent(event);
                        System.out.println("\n");
                        break;
                    }
                }
                case 2: {
                    System.out.println("List of all events:");
                    this.eventHandler.listAllEvents();
                    System.out.println();
                    break;
                }
                case 3: {
                    System.out.println("List all events taking place next weekend:");
                    this.eventHandler.listEventsForNextWeekend();
                    System.out.println();
                    break;
                }
                case 4: {
                    System.out.println("List events taking place on a " +
                            "specified day for given time zone:");

                    System.out.println("Insert the date for which to search " +
                            "with format yyyy-MM-dd :");
                    String date = input.nextLine();

                    System.out.println("Insert your time zone (example: America/Chicago)");
                    String zoneIdString = input.nextLine();

                    this.eventHandler.listEventsForTimeZone(date, zoneIdString);
                    System.out.println();
                    break;
                }
                case 5: {
                    System.out.println("List events taking place in a given date time interval:");

                    System.out.println("Insert start time under format yyyy-MM-dd HH:mm:ss :");
                    String startTime = input.nextLine();

                    System.out.println("Insert end time under format yyyy-MM-dd HH:mm:ss :");
                    String endTime = input.nextLine();

                    this.eventHandler.listEventsInInterval(startTime, endTime);

                    System.out.println();
                    break;
                }
                case 6: {
                    System.out.println("EXITING...");
                    runningFlag = false;
                    System.out.println();
                    break;
                }
                default: {
                    System.out.println("Please insert a number from 1 to 6");
                    System.out.println();
                    break;
                }
            }
        }
    }
}
