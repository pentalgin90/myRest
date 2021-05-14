package ru.home.learn.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.home.learn.api.services.EventService;
import ru.home.learn.dto.Event;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
@Tag(name = "Controller events", description = "endpoints for manage events")
public class EventController {

    private final EventService service;

    @GetMapping
    @Operation(
            summary = "List events",
            description = "Returned list all events"
    )
    public ResponseEntity<List<Event>> getAll(){
        return new ResponseEntity<>(service.getAllEvents(), HttpStatus.OK);
    }

    @Operation(
            summary = "One event",
            description = "Returned event by id"
    )
    @GetMapping("{id}")
    public ResponseEntity<Event> getOne(@PathVariable @Parameter(description = "identification event") Long id){
        return new ResponseEntity<>(service.getEvent(id), HttpStatus.OK);
    }

    @PostMapping
    @Operation(
            summary = "Create event",
            description = "Allowed create new event"
    )
    public ResponseEntity<Event> create(@RequestBody Event event){
        event.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(service.createEvent(event), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    @Operation(
            summary = "Delete event",
            description = "Allowed delete event by id"
    )
    public void delete(@PathVariable @Parameter(description = "identification event") Long id){
        service.deleteEvent(id);
    }

    @PutMapping("{id}")
    @Operation(
            summary = "Update event",
            description = "Allowed update event by id"
    )
    public ResponseEntity<Event> update(@RequestBody Event event, @PathVariable @Parameter(description = "identification event") Long id){
        return new ResponseEntity<>(service.updateEvent(event, id), HttpStatus.OK);
    }

    @GetMapping("/search")
    @Operation(
            summary = "Search event",
            description = "Allowed search event by title"
    )
    public ResponseEntity<List<Event>> getByTitle(@RequestParam(name = "title", required = true) @Parameter(description = "title event") String title) {
        return new ResponseEntity<>(service.getAllEventsByTitle(title), HttpStatus.OK);
    }
}
