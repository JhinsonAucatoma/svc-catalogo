package repository;

import model.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public class ProductoRepository {
    public interface ProductoRepository extends JpaRepository<Producto, Long> {
Page<Producto> findByCategoriaIgnoreCase(String categoria, Pageable pageable);
}

}
