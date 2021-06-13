package de.schmischke.betriebsstellen.service;

import de.schmischke.betriebsstellen.domain.Betriebsstelle;
import de.schmischke.betriebsstellen.dto.BetriebsstellenResponse;
import de.schmischke.betriebsstellen.exception.BetriebsstelleNotFoundException;
import de.schmischke.betriebsstellen.repository.BetriebsstellenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class DefaultBetriebsstellenService implements BetriebsstellenService {

    private final MapperFacade mapperFacade;
    private final BetriebsstellenRepository betriebsstellenRepository;

    @Override
    @Transactional(readOnly = true)
    public List<BetriebsstellenResponse> getBetriebsstellen() {
        List<Betriebsstelle> betriebsstellen = IterableUtils.toList(betriebsstellenRepository.findAll());
        return betriebsstellen.stream().map(this::betriebsstelleToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public BetriebsstellenResponse getBetriebsstelle(String betriebsstellenId) {
        Betriebsstelle betriebsstelle = getBetriebsstelleOrThrowException(betriebsstellenId);
        return betriebsstelleToResponse(betriebsstelle);
    }

    private BetriebsstellenResponse betriebsstelleToResponse (Betriebsstelle betriebsstelle) {
//        return BetriebsstellenResponse.builder()
//                .Name(betriebsstelle.getName())
//                .Kurzname(betriebsstelle.getKurzname())
//                .Typ(betriebsstelle.getTyp())
//                .abk(betriebsstelle.getAbk())
//                .build();
        return mapperFacade.map(betriebsstelle, BetriebsstellenResponse.class);
    }

    private Betriebsstelle getBetriebsstelleOrThrowException(String betriebsstellenId) {
        return betriebsstellenRepository.findById(betriebsstellenId).orElseThrow(BetriebsstelleNotFoundException::new);
    }
}
