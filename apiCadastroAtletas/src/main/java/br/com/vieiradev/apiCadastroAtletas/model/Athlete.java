package br.com.vieiradev.apiCadastroAtletas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "atletas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Athlete {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private String sizeShirt;

}
