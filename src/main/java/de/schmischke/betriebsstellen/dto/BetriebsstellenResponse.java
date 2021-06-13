package de.schmischke.betriebsstellen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BetriebsstellenResponse {
    private String name;
    private String kurzname;
    private String typ;
}
