package article.WebIde.api.dto.container;

import article.WebIde.api.dto.com.comDto;
import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContainerReqDto extends comDto {
    private int containerId;

    private String containerNm;

    private String containerMemo;

    private String regId;

    private LocalDateTime regDt;


}
