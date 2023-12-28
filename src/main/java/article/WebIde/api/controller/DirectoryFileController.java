package article.WebIde.api.controller;

import article.WebIde.api.dto.directoryFile.DirectoryFileReqDto;
import article.WebIde.api.dto.directoryFile.DirectoryFileRespDto;
import article.WebIde.api.entity.DirectoryFile;
import article.WebIde.api.repository.DirectoryFileRepository;
import article.WebIde.api.service.DirectoryFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/dir")
@RequiredArgsConstructor
@Slf4j
public class DirectoryFileController {

    private final DirectoryFileService directoryFileService;

    @GetMapping("/list")
    public ResponseEntity<Object> directoryFileList(@RequestBody DirectoryFileReqDto directoryReqDto) {
        List<DirectoryFile> result = new ArrayList<DirectoryFile>();

        try {
            result = directoryFileService.list(directoryReqDto);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update (@RequestBody DirectoryFileReqDto directoryReqDto) {
        try {
            directoryFileService.update(directoryReqDto.getDirId(), directoryReqDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 수정 되었습니다.");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete (@RequestBody DirectoryFileReqDto directoryReqDto) {
        try {
            directoryFileService.delete(directoryReqDto.getDirId());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제 되었습니다.");
    }
    @PostMapping("/insert")
    public ResponseEntity<Object> insert (@RequestBody DirectoryFile directoryReqDto) {
        try {
            directoryFileService.register(directoryReqDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 등록 되었습니다.");
    }
}
