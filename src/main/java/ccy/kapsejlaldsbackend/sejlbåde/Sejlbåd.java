package ccy.kapsejlaldsbackend.sejlbåde;

import ccy.kapsejlaldsbackend.kapsejladser.Kapsejlads;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class Sejlbåd {

    public Sejlbåd() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int points;

    @Enumerated(EnumType.STRING)
    private BådType bådType;

//    @ManyToOne
//    @JoinColumn(name = "kapsejlads_id")
//    private Kapsejlads kapsejlads;

    public Sejlbåd(String name, BådType bådType) {
        this.name = name;
        this.bådType = bådType;
    }

    public Sejlbåd(String name, BådType bådType, int point) {
        this.name = name;
        this.bådType = bådType;
        this.points = point;
    }

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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public BådType getBådType() {
        return bådType;
    }

    public void setBådType(BådType bådType) {
        this.bådType = bådType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sejlbåd sejlbåd = (Sejlbåd) o;
        return id == sejlbåd.id && points == sejlbåd.points && Objects.equals(name, sejlbåd.name) && bådType == sejlbåd.bådType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, points, bådType);
    }
}
