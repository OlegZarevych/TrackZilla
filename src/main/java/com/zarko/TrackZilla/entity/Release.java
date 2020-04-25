package com.zarko.TrackZilla.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data //@Data include @ToString, @EqualsAndHashCode,Getter, Setter, @RequiredArgsConstructor I'm use it for try different lombok options
@NoArgsConstructor
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String releaseDate;
    private String description;

}
