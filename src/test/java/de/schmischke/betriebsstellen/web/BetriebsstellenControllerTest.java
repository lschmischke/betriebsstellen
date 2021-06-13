package de.schmischke.betriebsstellen.web;


import de.schmischke.betriebsstellen.dto.BetriebsstellenResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BetriebsstellenController.class)
class BetriebsstellenControllerTest extends BaseControllerTest {

    private static final String PATH = "/betriebsstelle";

    @Test
    void shouldGetTasks() throws Exception {
        // given
        String name = "betriebsstelle-name";

        BetriebsstellenResponse betriebsstellenResponse = BetriebsstellenResponse.builder().name(name).build();
        when(betriebsstellenService.getBetriebsstellen()).thenReturn(Collections.singletonList(betriebsstellenResponse));

        // when
        ResultActions actualResult = this.mockMvc.perform(get(PATH));

        // then
        actualResult
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(name)));

    }

    @Test
    void shouldGetSingleTask() throws Exception {
        // given
        String apk = "bs";
        String name = "betriebsstelle-name";

        BetriebsstellenResponse betriebsstellenResponse = BetriebsstellenResponse.builder().name(name).build();
        when(betriebsstellenService.getBetriebsstelle(apk)).thenReturn(betriebsstellenResponse);

        // when
        ResultActions actualResult = this.mockMvc.perform(get(PATH+"/"+apk));

        // then
        actualResult
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is(name)));

    }

}