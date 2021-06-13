package de.schmischke.betriebsstellen.helper;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import de.schmischke.betriebsstellen.domain.Betriebsstelle;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CSVHelper {
    public static List<Betriebsstelle> csvToBetriebsstelle(String fileName) throws IOException {
        Path csvPath = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(csvPath, StandardCharsets.UTF_8)) {
            HeaderColumnNameMappingStrategy<Betriebsstelle> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(Betriebsstelle.class);

            CsvToBean<Betriebsstelle> csvToBean = new CsvToBeanBuilder<Betriebsstelle>(br)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(';')
                    .build();

            List<Betriebsstelle> betriebsstellen = csvToBean.parse();
            betriebsstellen.forEach(s -> {
                s.setAbk(s.getAbkOriginal().toLowerCase());
            });
            return betriebsstellen;
        }
    }
}
