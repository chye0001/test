package ccy.kapsejlaldsbackend.kapsejladser;

import ccy.kapsejlaldsbackend.sejlbåde.BådType;
import ccy.kapsejlaldsbackend.sejlbåde.Sejlbåd;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Kapsejlads {

    public Kapsejlads() {}

    public Kapsejlads(String name, LocalDateTime startDate, BådType raceType) {
        this.name = name;
        this.startDate = startDate;
        this.raceType = raceType;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    private LocalDateTime startDate;

    @Enumerated(EnumType.STRING)
    private BådType raceType;

    @ManyToMany
    @JoinTable(
            name = "kapsejlads_sejlbåde",
            joinColumns = @JoinColumn(name = "kapsejlads_id"),
            inverseJoinColumns = @JoinColumn(name = "sejlbåde_id")
    )
    private List<Sejlbåd> sejlbåde;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public BådType getRaceType() {
        return raceType;
    }

    public void setRaceType(BådType raceType) {
        this.raceType = raceType;
    }

    public List<Sejlbåd> getSejlbåde() {
        return sejlbåde;
    }

    public void setSejlbåde(List<Sejlbåd> sejlbåde) {
        this.sejlbåde = sejlbåde;
    }
}
