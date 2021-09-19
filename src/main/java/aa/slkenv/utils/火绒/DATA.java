package aa.slkenv.utils.火绒;

import java.io.Serializable;

public class DATA implements Serializable {
    private static final long serialVersionUID = -3083396627716273607L;
    String procname;
    Boolean block;
    public DATA(String procname) {
        this.block = true;
        this.procname = procname;
    }
    public String getProcname() {
        return procname;
    }
    public void setProcname(String procname) {
        this.procname = procname;
    }
    public Boolean getBlock() {
        return block;
    }
    public void setBlock(Boolean block) {
        this.block = block;
    }
}
