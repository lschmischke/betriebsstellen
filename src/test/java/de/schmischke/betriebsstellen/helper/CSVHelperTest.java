package de.schmischke.betriebsstellen.helper;

import de.schmischke.betriebsstellen.domain.Betriebsstelle;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class CSVHelperTest {

    private final String CSV_path = "src/main/resources/DBNetz-Betriebsstellenverzeichnis-Stand2018-04.csv";

    @Test
    public void shouldLoadBetriebsstellenFromFile() throws IOException {
        List<Betriebsstelle> betriebsstellen = CSVHelper.csvToBetriebsstelle(CSV_path);
        assertFalse(betriebsstellen.isEmpty());
    }

}