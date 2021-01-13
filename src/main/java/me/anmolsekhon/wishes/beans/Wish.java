package me.anmolsekhon.wishes.beans;

import java.io.Serializable;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Wish implements Serializable {
    private Long id;
    private String wish;
}
