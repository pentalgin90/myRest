package ru.home.learn.api;

import ru.home.learn.dto.Event;

import java.util.List;

public interface EventService {
    Event createEvent(Event event);
    Event updateEvent(Event event, Long id);
    Event getEvent(Long id);
    void deleteEvent(Long id);
    List<Event> getAllEvents();
    List<Event> getAllEventsByTitle(String title);
}
