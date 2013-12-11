package com.muni.fi.pa165.dao.service.impl;

import com.muni.fi.pa165.service.impl.MonsterWeaponServiceImpl;
import com.muni.fi.pa165.dao.MonsterWeaponDao;
import com.muni.fi.pa165.dto.MonsterDto;
import com.muni.fi.pa165.service.AbstractServiceIntegrationTest;
import com.muni.fi.pa165.dto.MonsterWeaponDto;
import com.muni.fi.pa165.dto.WeaponDto;
import com.muni.fi.pa165.entities.Monster;
import com.muni.fi.pa165.entities.Monsterweapon;
import com.muni.fi.pa165.entities.MonsterweaponPK;
import com.muni.fi.pa165.entities.Weapon;
import com.muni.fi.pa165.enums.MonsterClass;
import com.muni.fi.pa165.enums.WeaponClass;
import com.muni.fi.pa165.enums.WeaponType;
import javax.inject.Inject;
import org.dozer.Mapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

/**
 *
 * @author irina
 */
public class MonsterWeaponServiceImplTest extends AbstractServiceIntegrationTest {

    @Inject
    private MonsterWeaponDao mockDAO;
    private MonsterWeaponServiceImpl service;
    @Inject
    private Mapper mapper;
    private MonsterDto monsterDto;
    private WeaponDto weaponDto;
    private MonsterWeaponDto monsterWeaponDto;

    @Before
    public void setUp() {
        service = new MonsterWeaponServiceImpl();
        mockDAO = mock(MonsterWeaponDao.class);
        service.setDao(mockDAO);
        service.setMapper(mapper);

        monsterDto = new MonsterDto();
        monsterDto.setId(Long.MIN_VALUE);
        monsterDto.setAgility(11.0);
        monsterDto.setDangerLevel(22.4);
        monsterDto.setDescription("Headless Zombie");
        monsterDto.setHeight(11.4);
        monsterDto.setImagePath("C:\\image.png");
        monsterDto.setMonsterClass(MonsterClass.Zombie);
        monsterDto.setStamina(11.5);
        monsterDto.setStrength(11.8);
        monsterDto.setWeight(11.2);
        monsterDto.setName("HeadlessNick");

        weaponDto = new WeaponDto();
        weaponDto.setId(Long.MIN_VALUE);
        weaponDto.setName("TESTAK47");
        weaponDto.setCaliber(Double.MIN_NORMAL);
        weaponDto.setDescription("Africa's favourite");
        weaponDto.setRounds(44);
        weaponDto.setRange(100);
        weaponDto.setWeaponClass(WeaponClass.Ranged);
        weaponDto.setWeaponType(WeaponType.Gun);
        
       // MonsterweaponPK pk = new MonsterweaponPK();
       // pk.setMonsterid(monster.getId());
       // pk.setWeaponid(weapon.getId());

        monsterWeaponDto = new MonsterWeaponDto();
        monsterWeaponDto.setWeapon(weaponDto);
        monsterWeaponDto.setMonster(monsterDto);
        monsterWeaponDto.setHitRate(5);
        monsterWeaponDto.setDamage(12);
        monsterWeaponDto.setEfficiency(55);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class MonsterWeaponServiceImpl.
     */
    
    //TEST NEEDS TO BE CHANGED TO IMPLEMENT PK (MONSTERWEAPONPK)
    
    
    @Test
    public void testSave() {

        Monsterweapon entity = mapper.map(monsterWeaponDto, Monsterweapon.class);
        when(mockDAO.save(any(Monsterweapon.class))).thenReturn(entity);
        MonsterWeaponDto returned = service.save(monsterWeaponDto);
        assertEquals(returned, monsterWeaponDto);
    }

    /**
     * Test of update method, of class MonsterWeaponServiceImpl.
     */
    
    //TEST NEEDS TO BE CHANGED TO IMPLEMENT PK (MONSTERWEAPONPK)
    @Test
    public void testUpdate() {

        Monsterweapon entity = mapper.map(monsterWeaponDto, Monsterweapon.class);
        when(mockDAO.update(any(Monsterweapon.class))).thenReturn(entity);
        MonsterWeaponDto returned = service.update(monsterWeaponDto);
        assertEquals(returned, monsterWeaponDto);
    }

    /**
     * Test of delete method, of class MonsterWeaponServiceImpl.
     */
    @Test
    public void testDelete() {

        Monsterweapon entity = mapper.map(monsterWeaponDto, Monsterweapon.class);
        service.delete(monsterWeaponDto);
        verify(mockDAO, times(1)).delete(entity);
        verifyNoMoreInteractions(mockDAO);

    }
}
