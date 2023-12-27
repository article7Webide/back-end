package article.WebIde.api.repository;

import article.WebIde.api.entity.DirectoryFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DirectoryFileRepository extends JpaRepository<DirectoryFile, Integer> {
    List<DirectoryFile> findDirectoryFilesByContainerIdAndParentDirNo(int containerId, int parentDirNo);

}
