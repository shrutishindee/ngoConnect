package com.app.pojos;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @Column(nullable = false)
    @NotBlank(message = "Event Location required")
    private String eventLocation;

    @Column(nullable = false)
    @NotBlank(message = "Event Name required")
    private String eventName;

    @Column(nullable = false)
    private String eventDescription;

    @Column(nullable = false)
    @NotNull(message = "Event Date required")
    private LocalDate eventDate;

    @Column(nullable = false)
    @NotNull
    private int volunteersNeeded;

    // Replace Volunteer with User and filter by UserRole.VOLUNTEER in the service layer
    @ManyToMany
    @JoinTable(name = "userEvent",
        joinColumns = @JoinColumn(referencedColumnName = "eventId"),
        inverseJoinColumns = @JoinColumn(referencedColumnName = "id")
    )
    private Set<User> volunteers;  // This stays as is

    @OneToMany(mappedBy = "event")
    @JsonManagedReference
    private List<Beneficiary> beneficiaries;

    @ManyToOne
    @JoinColumn(name = "projectId", nullable = false)
    @JsonBackReference
    private Project project;
}
