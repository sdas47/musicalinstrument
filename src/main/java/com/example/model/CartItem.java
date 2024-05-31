package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table
@Builder
public class CartItem {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column(name="instrument_id")
    private Long instrumentId;

    @ManyToOne
    @JoinColumn(name="instrument_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Instrument instrument;


}
