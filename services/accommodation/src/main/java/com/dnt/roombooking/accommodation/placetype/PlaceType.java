package com.dnt.roombooking.accommodation.placetype;

import com.dnt.roombooking.accommodation.place.Place;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class PlaceType {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "place", cascade = CascadeType.REMOVE)
    private List<Place> places;
}
