package article.WebIde.api.controller;

import article.WebIde.api.dto.container.ContainerReqDto;
import article.WebIde.api.dto.directoryFile.DirectoryFileReqDto;
import article.WebIde.api.entity.Container;
import article.WebIde.api.entity.DirectoryFile;
import article.WebIde.api.service.ContainerService;
import article.WebIde.api.service.DirectoryFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/container")
@RequiredArgsConstructor
@CrossOrigin(origins="*", allowedHeaders = "*")
@Slf4j
public class ContainerController {
    private final ContainerService containerService;

    @GetMapping("/list")
    public ResponseEntity<Object> containerList(@RequestBody ContainerReqDto containerReqDto) {
        List<Container> result = new ArrayList<Container>();

        try {
            result = containerService.list(containerReqDto);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update (@RequestBody ContainerReqDto containerReqDto) {
        try {
            containerService.update(containerReqDto.getContainerId(), containerReqDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 수정 되었습니다.");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete (@RequestBody ContainerReqDto containerReqDto) {
        try {
            containerService.delete(containerReqDto.getContainerId());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제 되었습니다.");
    }

    @PutMapping("/insert")
    public ResponseEntity<Object> insert (@RequestBody Container containerReqDto) {
        try {
            containerService.register(containerReqDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 등록 되었습니다.");
    }
}


