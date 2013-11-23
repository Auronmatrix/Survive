/* ------------------------------------------------
 * MonsterArea.java
 * 
 * ------------------------------------------------
 */
package com.muni.fi.pa165.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Entity MonsterArea represents a connection between {@link Monster} and {@link Area}. This is many-to-many
 * relationship.
 *
 * @author Michal Vinkler
 */
@Entity
public class MonsterArea implements Serializable {

    private static final long serialVersionUID = 10000L;
//     /**
//     * Id of this connection.
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
    /**
     * Type of a monster on this area.
     */
    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @PrimaryKeyJoinColumn(name = "MONSTERID", referencedColumnName = "id")
    private Monster monster;
    /**
     * Type of this area.
     */
    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @PrimaryKeyJoinColumn(name = "AREAID", referencedColumnName = "id")
    private Area area;
    /**
     * Number of monsters of particular type living in this area.
     */
    private int monsterQuantity;

    /**
     * Gets monster quantity.
     *
     * @return Returns quantity of this type of a monster on this area.
     */
    public int getMonsterQuantity() {
        return monsterQuantity;
    }

    /**
     * Sets monster quantity.
     *
     * @param monsterQuantity new quantity
     */
    public void setMonsterQuantity(int monsterQuantity) {
        this.monsterQuantity = monsterQuantity;
    }

//    /**
//     * Gets id.
//     *
//     * @return id of this connection.
//     */
//    public Long getId() {
//        return id;
//    }
//
//    /**
//     * Sets id.
//     *
//     * @param id new id
//     */
//    public void setId(Long id) {
//        this.id = id;
//    }
    /**
     * Gets type of a monster from this monster-area connection.
     *
     * @return type of a monster.
     */
    public Monster getMonster() {
        return monster;
    }

    /**
     * Sets new type of a monster for this monster-area connection.
     *
     * @param monster new monster to be set
     */
    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    /**
     * Gets area from this monster-area connection.
     *
     * @return area
     */
    public Area getArea() {
        return area;
    }

    /**
     * Sets new area for this monster-area connection.
     *
     * @param area
     */
    public void setArea(Area area) {
        this.area = area;
    }

   
}
