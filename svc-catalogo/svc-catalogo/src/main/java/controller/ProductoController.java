package controller;

 import com.uteq.bibliotech.dto.ProductoInput;
import com.uteq.bibliotech.model.Libro;
import com.uteq.bibliotech.repository.LibroRepository;
 import dto.ProductoInput;
 import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
 import model.Producto;
 import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 import repository.ProductoRepository;

 import java.net.URI;

@RestController
@RequestMapping("/api/v1/productos")
 @RequiredArgsConstructor
public class ProductoController {

    private final ProductoRepository productos;

        @GetMapping
         public PaginaResponse<Producto> listar(
@RequestParam(defaultValue = "0") int page,
 @RequestParam(defaultValue = "20") int size,
@RequestParam(required = false) String categoria) {
         Page<Libro> pagina = (categoria == null)
        ? libros.findAll(PageRequest.of(page, size))
        : libros.findByCategoriaIgnoreCase(categoria, PageRequest.of(page,
                size));
        return new PaginaResponse<>(pagina.getContent(), pagina.getNumber(),
                pagina.getTotalPages(), pagina.getTotalElements());
        }

         @GetMapping("/{ProducoId}")
 public Producto obtener(@PathVariable Long ProducoId) {
         return productos.findById(libroId).orElseThrow(()->
                 new RecursoNoEncontradoException("El producto con id" + producto + " no
                existe"));
                 }

        @PostMapping
public ResponseEntity<Producto> crear(@Valid @RequestBody dto.ProductoInput in) {
        Producto guardado = Producto.save(new Producto(in.titulo(), in.autor(),
                58 in.isbn(), in.categoria(), in.ejemplaresDisponibles()));
        return ResponseEntity
        .created(URI.create("/api/v1/libros/" + guardado.getId())) // 201
                + Location
        .body(guardado);
        }

        @DeleteMapping("/{libroId}")
public ResponseEntity<Void> eliminar(@PathVariable Long libroId) {
            if (!libros.existsById(libroId)) {
             throw new RecursoNoEncontradoException("El libro con id " + libroId + "
                    no existe");
                    68 }
         productos.deleteById(libroId);
        return ResponseEntity.noContent().build(); // 204
        }
}
