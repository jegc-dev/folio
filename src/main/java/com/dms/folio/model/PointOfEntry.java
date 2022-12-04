package com.dms.folio.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "PointOfEntry")
@Table(name = "tbl_point_of_entry")
public class PointOfEntry implements Serializable {

    @Id
    @SequenceGenerator(name = "point_of_entry_seq", sequenceName = "point_of_entry_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_of_entry_seq")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "entry_code", updatable = false)
    private String entryCode;

    @Enumerated(EnumType.STRING)
    private EntryType entryType;

    private String subject;

    private String remarks;

    private LocalDateTime dateOfEntry;

    private String documentId;
}
