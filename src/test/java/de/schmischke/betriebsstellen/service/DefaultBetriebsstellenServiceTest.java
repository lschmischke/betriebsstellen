package de.schmischke.betriebsstellen.service;

import de.schmischke.betriebsstellen.domain.Betriebsstelle;
import de.schmischke.betriebsstellen.dto.BetriebsstellenResponse;
import de.schmischke.betriebsstellen.repository.BetriebsstellenRepository;
import ma.glasnost.orika.MapperFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultBetriebsstellenServiceTest {

    @Mock
    private BetriebsstellenRepository betriebsstellenRepository;

    @Mock
    private MapperFacade mapperFacade;

    @InjectMocks
    private DefaultBetriebsstellenService objectUnderTest;

    @Test
    void shouldGetBetriebsstellen() {
        // given
        Betriebsstelle betriebsstelle = mock(Betriebsstelle.class);
        BetriebsstellenResponse betriebsstellenResponse = mock(BetriebsstellenResponse.class);
        when(betriebsstellenRepository.findAll()).thenReturn(List.of(betriebsstelle));
        when(mapperFacade.map(betriebsstelle, BetriebsstellenResponse.class)).thenReturn(betriebsstellenResponse);

        // when
        List<BetriebsstellenResponse> actualBetriebstellen = objectUnderTest.getBetriebsstellen();

        // then
        assertThat(actualBetriebstellen).contains(betriebsstellenResponse);
    }

    @Test
    void shouldGetSingleBetriebsstelle() {
        // given
        Betriebsstelle betriebsstelle = mock(Betriebsstelle.class);
        BetriebsstellenResponse betriebsstellenResponse = mock(BetriebsstellenResponse.class);
        String id = betriebsstelle.getAbk();
        when(betriebsstellenRepository.findById(id)).thenReturn(Optional.of(betriebsstelle));
        when(mapperFacade.map(betriebsstelle, BetriebsstellenResponse.class)).thenReturn(betriebsstellenResponse);

        // when
        BetriebsstellenResponse actualBetriebstelle = objectUnderTest.getBetriebsstelle(betriebsstelle.getAbk());

        // then
        assertThat(actualBetriebstelle).isEqualTo(betriebsstellenResponse);
    }

}