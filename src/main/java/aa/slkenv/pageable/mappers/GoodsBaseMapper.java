package aa.slkenv.pageable.mappers;

import aa.slkenv.pageable.domain.GoodsBase;
import aa.slkenv.pageable.parameter.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsBaseMapper {

    @Select("select * from goods")
    List<GoodsBase> selectListPageable(@Param("page")Page page);

}
