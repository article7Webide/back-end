package article.WebIde.api.dto.com;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class comDto {
    private String regId;

    private LocalDateTime regDt;

    private String modId;

    private LocalDateTime modDt;
}
