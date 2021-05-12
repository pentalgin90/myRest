package ru.home.learn.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.home.learn.api.EventService;
import ru.home.learn.dto.Event;
import ru.home.learn.dto.repositories.EventRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepo repo;

    @Override
    public Event createEvent(Event event) {
        return repo.save(event);
    }

    @Override
    public Event updateEvent(Event event, Long id) {
        Event eventFromDB = this.getEvent(id);
        BeanUtils.copyProperties(eventFromDB, event);
        return repo.save(eventFromDB);
    }

    @Override
    public Event getEvent(Long id) {
        return repo.getOne(id);
    }

    @Override
    public void deleteEvent(Long id) {
        Event event = this.getEvent(id);
        repo.delete(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return repo.findAll();
    }

    @Override
    public List<Event> getAllEventsByTitle(String title) {
        return repo.getAllByTitle(title);
    }
}
