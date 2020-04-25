package com.zarko.TrackZilla.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String description;

    @ManyToOne
    @JoinColumn(name = "application_id")
    @Getter
    @Setter
    private Application application;

    @ManyToOne
    @JoinTable(name = "ticket_release", joinColumns = @JoinColumn(name = "ticket_fk"), inverseJoinColumns = @JoinColumn(name = "release_fk"))
    @Getter
    @Setter
    private Release release;

    @Getter
    @Setter
    private String status;

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
