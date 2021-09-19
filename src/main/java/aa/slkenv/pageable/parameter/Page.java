package aa.slkenv.pageable.parameter;

/**
 * @author lla, 2021/2/9  21:42
 * <p>
 * 方案一：id数据连续，提供页码、每页条数
 * 方案二：id不连续，当前id,每页条数
 */
public class Page {

    // 当前id
    private Integer currentId;
    // 页码
    private Integer pageNum;
    // 每页数量
    private Integer size;


    /**
     * id不连续
     * select goods.* from goods
     * <p>
     * inner join (select id from goods limit 1995000,50) as ids_derived
     * on goods.id = ids_derived.id;
     * <p>
     * Continuous self increasing
     */
    public static Page PageBuilderNotContinuous(Integer currentId, Integer size) {
        Page page = new Page();
        page.setCurrentId(currentId);
        page.setSize((size == null) ? 2 : size);
        return page;
    }

    /**
     * id连续
     * select goods.* from goods
     * <p>
     * inner join (select id from goods where id > 1995000 limit 50) ids_derived
     * on goods.id = ids_derived.id;
     */
    public static Page PageBuilderContinuousAndIncreasingId(Integer pageNum, Integer size) {
        Page page = new Page();
        page.setPageNum(pageNum);
        page.setSize((size == null) ? 2 : size);
        return page;
    }


    public Integer getCurrentId() {
        return currentId;
    }

    public void setCurrentId(Integer currentId) {
        this.currentId = currentId;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
