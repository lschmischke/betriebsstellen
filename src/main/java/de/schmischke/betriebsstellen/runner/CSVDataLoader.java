package de.schmischke.betriebsstellen.runner;

import de.schmischke.betriebsstellen.helper.CSVHelper;
import de.schmischke.betriebsstellen.repository.BetriebsstellenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CSVDataLoader implements ApplicationRunner {

    private final BetriebsstellenRepository betriebsstellenRepository;
    public final String CSV_path = "src/main/resources/DBNetz-Betriebsstellenverzeichnis-Stand2018-04.csv";

    @Override
    public void run(ApplicationArguments args) throws Exception {
        betriebsstellenRepository.saveAll(CSVHelper.csvToBetriebsstelle(CSV_path));
    }
}
