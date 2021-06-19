package aa.slkenv.pageable.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsBase implements Serializable {

    private Long id;
    private Long status;
    private Long goodsNum;
    private java.sql.Timestamp createTime;
    private String goodsName;
    private String goodsDesc;
    private String price;
    private Long version;
}
