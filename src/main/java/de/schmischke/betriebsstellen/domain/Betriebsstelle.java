package de.schmischke.betriebsstellen.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="betriebsstelle")
@Getter
@Setter
public class Betriebsstelle  {

    @Id
    @Column(name = "abk", nullable = false, updatable = false)
    private String abk;

    @CsvBindByName(column = "Abk")
    private String abkOriginal;

    @CsvBindByName(column = "Name")
    private String name;

    @CsvBindByName(column = "Kurzname")
    private String kurzname;

    @CsvBindByName(column = "Typ")
    private String typ;

    @CsvBindByName(column = "Betr-Zust")
    private String betrZust;

    @CsvBindByName(column = "Primary location code")
    private String primaryLocation;

    @CsvBindByName(column = "UIC")
    private Integer uic;

    @CsvBindByName(column = "RB")
    private Integer rb;

    @CsvBindByName(column = "gültig von")
    private String validFrom;

    @CsvBindByName(column = "gültig bis")
    private String validTo;

    @CsvBindByName(column = "Netz-key")
    private String netzKey;

    @CsvBindByName(column = "Fpl-rel")
    private String fplRel;

    @CsvBindByName(column = "Fpl-Gr")
    private String fplGr;


}
