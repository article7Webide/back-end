package article.WebIde.api.service;

import article.WebIde.api.dto.container.ContainerReqDto;
import article.WebIde.api.entity.Container;
import article.WebIde.api.entity.DirectoryFile;
import article.WebIde.api.repository.ContainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContainerService {

    private final ContainerRepository containerRepository;

    @Transactional
    public void register(Container container) {
        containerRepository.save(container);
    }

    @Transactional
    public List<Container> list(ContainerReqDto containerReqDto) throws RuntimeException {
        return containerRepository.findContainersByRegId(containerReqDto.getRegId());
    }

    @Transactional
    public void update(int containerId, ContainerReqDto dto) throws RuntimeException {
        Optional<Container> byId = containerRepository.findById(containerId);
        Container container = byId.get();
        container.updateContainer(dto.getContainerNm(), dto.getContainerMemo(), dto.getModId(), dto.getModDt());
    }

    @Transactional
    public void delete(int containerId) throws RuntimeException {
        containerRepository.deleteById(containerId);
    }

}
