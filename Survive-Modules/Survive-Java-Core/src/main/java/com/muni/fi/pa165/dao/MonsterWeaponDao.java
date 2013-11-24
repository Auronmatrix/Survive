/* ------------------------------------------------
 * MonsterWeaponDao.java
 * 
 * ------------------------------------------------
 */
package com.muni.fi.pa165.dao;

import com.muni.fi.pa165.entities.MonsterweaponPK;
import java.util.List;

/**
 * Interface MonsterWeaponDao. Interface implemented by typed JpaDao objects containing type specific methods.
 *
 * @author Michal Vinkler
 */
public interface MonsterWeaponDao extends GenericDao<MonsterweaponPK, Long> {
 
    public List<MonsterweaponPK> getByMonsterId(Long id);
    
    public List<MonsterweaponPK> getByWeaponId(Long id);
    
   
    
   
}
