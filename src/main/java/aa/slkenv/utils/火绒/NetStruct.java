package aa.slkenv.utils.火绒;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NetStruct implements Serializable {
    private String ver;
    private String tag;
    private List<DATA> data = new ArrayList<DATA>();

    public NetStruct(List<DATA> data) {
        this.ver = "5.0";
        this.tag = "appnetctrl";
        this.data = data;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<DATA> getData() {
        return data;
    }

    public void setData(List<DATA> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "NetStruct{" +
                "ver='" + ver + '\'' +
                ", tag='" + tag + '\'' +
                ", data=" + data +
                '}';
    }
}

class DATA implements Serializable {
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
