package dto;

import jakarta.validation.constraints.*;
public record ProductoInput(
@NotBlank String nombre,
@NotBlank Double precio,
@NotBlank Integer stock)
{}