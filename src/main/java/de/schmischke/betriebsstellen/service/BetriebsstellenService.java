package de.schmischke.betriebsstellen.service;

import de.schmischke.betriebsstellen.dto.BetriebsstellenResponse;

import java.util.List;

public interface BetriebsstellenService {

    List<BetriebsstellenResponse> getBetriebsstellen();
    BetriebsstellenResponse getBetriebsstelle(String betriebsstellenId);
}
