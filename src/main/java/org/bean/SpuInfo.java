package org.bean;

import java.io.Serializable;
import java.util.List;

public class SpuInfo implements Serializable {
    private Integer spuId;
    private long createTime;
    private List<SkuInfo> skuList;//sku信息集合

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public List<SkuInfo> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<SkuInfo> skuList) {
        this.skuList = skuList;
    }
}
