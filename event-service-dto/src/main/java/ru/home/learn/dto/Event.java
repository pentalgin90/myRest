package ru.home.learn.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@Schema(description = "Entity event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(example = "1")
    private Long id;
    @Schema(example = "error")
    private String title;
    @Schema(example = "service")
    private String place;
    @Schema(example = "ru")
    private String speaker;
    @Schema(example = "exception")
    private String eventType;
    @Schema(example = "2021-05-10T17:52:11.532")
    private LocalDateTime dateTime;
}
