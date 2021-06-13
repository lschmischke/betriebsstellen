package de.schmischke.betriebsstellen.web;

import de.schmischke.betriebsstellen.dto.BetriebsstellenResponse;
import de.schmischke.betriebsstellen.service.BetriebsstellenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/betriebsstelle")
@RequiredArgsConstructor
public class BetriebsstellenController {

    private final BetriebsstellenService betriebsstellenService;

    @GetMapping
    public List<BetriebsstellenResponse> getAllBetriebsstellen() {
        return betriebsstellenService.getBetriebsstellen();
    }

    @GetMapping("/{betriebsstellenId}")
    public BetriebsstellenResponse getBetriebstelle(@PathVariable String betriebsstellenId) {
        return betriebsstellenService.getBetriebsstelle(betriebsstellenId);
    }
}
