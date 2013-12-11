package com.muni.fi.pa165.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Auron
 */
@XmlRootElement
public class MonsterAreaPkDto {

    private Long monsterId;
    private Long areaId;

    public MonsterAreaPkDto() {
    }

    public MonsterAreaPkDto(Long monsterId, Long areaId) {
        this.monsterId = monsterId;
        this.areaId = areaId;
    }

    public Long getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(Long monsterId) {
        this.monsterId = monsterId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }
}
