/* ------------------------------------------------
 * MonsterWeaponDao.java
 * 
 * ------------------------------------------------
 */
package com.muni.fi.pa165.dao;

import com.muni.fi.pa165.entities.Monsterweapon;
import com.muni.fi.pa165.entities.MonsterweaponPK;
import java.util.List;

/**
 * Interface MonsterWeaponDao. Interface implemented by typed JpaDao objects containing type specific methods.
 *
 * @author Michal Vinkler
 */
public interface MonsterWeaponDao extends GenericDao<Monsterweapon, Long> {
 
    public List<Monsterweapon> getByMonsterId(Long id);
    
    public List<Monsterweapon> getByWeaponId(Long id);
    
    public void delete(MonsterweaponPK id);
    
    public Monsterweapon findById(MonsterweaponPK id);
    
   
    
   
}
