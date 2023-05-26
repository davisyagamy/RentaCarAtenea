package com.example.rentacarreto3.model.DTOs;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CompleteAndCancelled {

    private Long completed;
    private Long cancelled;
    public CompleteAndCancelled(Long completed, Long cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }
}
