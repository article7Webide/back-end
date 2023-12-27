package article.WebIde.api.dto.container;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ContainerRespDto {
    private int containerId;

    private String containerNm;

    private String containerMemo;

    private String regId;

    private LocalDateTime regDt;

    private String modId;

    private LocalDateTime modDt;
}
