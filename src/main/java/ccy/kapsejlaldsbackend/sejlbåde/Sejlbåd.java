package ccy.kapsejlaldsbackend.sejlbåde;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sejlbåd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private BådType bådType;

    public Sejlbåd(String name, BådType bådType) {
        this.name = name;
        this.bådType = bådType;
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

    public BådType getBådType() {
        return bådType;
    }

    public void setBådType(BådType bådType) {
        this.bådType = bådType;
    }
}
