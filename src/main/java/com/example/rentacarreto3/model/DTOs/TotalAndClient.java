package com.example.rentacarreto3.model.DTOs;
import com.example.rentacarreto3.model.Client;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TotalAndClient {

    private Long total;
    private Client client;

    public TotalAndClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }
}
