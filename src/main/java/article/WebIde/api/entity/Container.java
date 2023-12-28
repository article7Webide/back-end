package article.WebIde.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
// import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "CONTAINER_INF")
public class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int containerId;

    private String containerNm;

    @Column(length = 512)
    private String containerMemo;

    @Column(length = 20)
    private String regId;

    @CreatedDate
    private LocalDateTime regDt;

    @Column(length = 20)
    private String modId;

    @LastModifiedDate
    private LocalDateTime modDt;

    @Builder
    public void updateContainer (String containerName, String containerMemo, String modId, LocalDateTime modDt){
        this.containerNm = containerName;
        this.containerMemo = containerMemo;
        this.modId = modId;
        this.modDt = modDt;

    }
}
