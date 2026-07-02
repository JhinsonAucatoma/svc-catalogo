package model;
import jakarta.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Producto")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Producto {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

        @Column(nullable = false, length = 200)
private String nombre;

        @Column(nullable = false, length = 120)
private Double precio;

         @Column(nullable = false, unique = true, length = 17)
private Integer stock;

        public Producto(String nombre, Double precio, Integer stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        }

}
