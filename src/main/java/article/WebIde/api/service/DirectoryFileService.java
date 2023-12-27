package article.WebIde.api.service;

import article.WebIde.api.dto.directoryFile.DirectoryFileReqDto;
import article.WebIde.api.entity.Container;
import article.WebIde.api.entity.DirectoryFile;
import article.WebIde.api.repository.DirectoryFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DirectoryFileService {

    private final DirectoryFileRepository directoryFileRepository;

    @Transactional
    public void register(DirectoryFile directoryFile) {
        directoryFileRepository.save(directoryFile);
    }

    @Transactional
    public List<DirectoryFile> list(DirectoryFileReqDto directoryFileReqDto) throws RuntimeException {
        return directoryFileRepository.findDirectoryFilesByContainerIdAndParentDirNo
                (directoryFileReqDto.getContainerId(), directoryFileReqDto.getParentDirNo());
    }

    @Transactional
    public void update(int dirId, DirectoryFileReqDto dto) throws RuntimeException{
        Optional<DirectoryFile> byId = directoryFileRepository.findById(dirId);
        DirectoryFile directoryFile = byId.get();
        directoryFile.updateDirectoryFile(dto.getDirNm(), dto.getFileCntn(), dto.getModId(), dto.getModDt());

    }

    @Transactional
    public void delete(int dirId) throws RuntimeException {
        directoryFileRepository.deleteById(dirId);
    }

}
