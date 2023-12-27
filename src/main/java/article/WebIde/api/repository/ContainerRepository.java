package article.WebIde.api.repository;

import article.WebIde.api.entity.Container;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContainerRepository extends JpaRepository<Container, Integer>{
    List<Container> findContainersByRegId(String regId);
}
