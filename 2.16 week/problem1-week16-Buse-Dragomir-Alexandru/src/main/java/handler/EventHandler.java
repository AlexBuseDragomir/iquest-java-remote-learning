package handler;

import event.Event;

public interface EventHandler {

    void addEvent(Event event);

    void listAllEvents();

    void listEventsForNextWeekend();

    void listEventsForTimeZone(String date, String zoneIdString);

    void listEventsInInterval(String startTime, String endTime);
}
