package com.app.pojos;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @NotBlank
    @Column(nullable = false)
    private String projectDescription;

    @NotBlank
    @Column(nullable = false)
    private String projectName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Project_Status projectStatus;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    // Replace Donor with User and filter by UserRole.DONOR in the service layer
    @ManyToMany
    @JoinTable(
            name = "userProjects",
            joinColumns = @JoinColumn(referencedColumnName = "projectId"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id")
    )
    private Set<User> donors; // Replacing Donor with User entity

    // Replace Admin with User and filter by UserRole.ADMIN in the service layer
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    @JsonBackReference
    private User admin; // Replacing Admin with User entity

    @OneToMany(mappedBy = "project")
    @JsonManagedReference
    private List<Event> events;
}
