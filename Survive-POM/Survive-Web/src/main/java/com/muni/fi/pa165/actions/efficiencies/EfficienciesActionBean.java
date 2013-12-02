package com.muni.fi.pa165.actions.efficiencies;

import com.muni.fi.pa165.actions.base.BaseActionBean;
import com.muni.fi.pa165.dto.MonsterDto;
import com.muni.fi.pa165.service.MonsterWeaponService;
import com.muni.fi.pa165.dto.MonsterWeaponDto;
import com.muni.fi.pa165.dto.WeaponDto;
import com.muni.fi.pa165.service.MonsterService;
import com.muni.fi.pa165.service.WeaponService;
import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.controller.LifecycleStage;
import net.sourceforge.stripes.integration.spring.SpringBean;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationErrorHandler;
import net.sourceforge.stripes.validation.ValidationErrors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Stripes ActionBean for handling monsterMonsterWeapon operations.
 *
 * @author Aubrey Oosthuizen
 */
@UrlBinding("/efficiencies/{$event}/{monsterWeapon.weapon.id}")
public class EfficienciesActionBean extends BaseActionBean implements ValidationErrorHandler {

    final static Logger log = LoggerFactory.getLogger(EfficienciesActionBean.class);
    @SpringBean //Spring can inject even to private and protected fields
    protected MonsterWeaponService service;
    
    @SpringBean
    protected WeaponService weaponService;
    
    @SpringBean
    protected MonsterService monsterService;
    //--- part for showing a list of monsterMonsterWeapons ----
    private List<MonsterWeaponDto> efficiencies;
    private List<WeaponDto> weapons;
    private List<MonsterDto> monsters;
    


    //@DontValidate
    @DefaultHandler
    public Resolution list() {
        log.debug("list()");
        efficiencies = service.findAll();
        
        
        return new ForwardResolution("/efficiencies/list.jsp");
    }

    public List<MonsterWeaponDto> getEfficiencies() {
        return efficiencies;
    }
   
    public void setEfficiencies(List<MonsterWeaponDto> efficiencies) {
        this.efficiencies = efficiencies;
    }

    public List<WeaponDto> getWeapons() {
         weapons = weaponService.findAll();
        return weapons;
    }

    public void setWeapons(List<WeaponDto> weapons) {
        this.weapons = weapons;
    }

    public List<MonsterDto> getMonsters() {
        monsters = monsterService.findAll();
        return monsters;
    }

    public void setMonsters(List<MonsterDto> monsters) {
        this.monsters = monsters;
    }
    
    

//    public Resolution EfficienciesActionBean()
//    {
//        log.debug("default or constructor()");
//        monsterMonsterWeapons = service.findAll();
//        return new ForwardResolution("/monsterMonsterWeapon/lolololol.jsp");
//    }
    public List<MonsterWeaponDto> getMonsterWeapons() {
        return efficiencies;
    }
    //--- part for adding a monsterMonsterWeapon ----
//    @ValidateNestedProperties(value = {
//        @Validate(on = {"add", "save"}, field = "name", required = true, maxlength = 255),
//     @Validate(on = {"add", "save"}, field = "damage", required = true, maxlength = 10),
//        @Validate(on = {"add", "save"}, field = "efficiency", required = true, maxlength = 10),
//         @Validate(on = {"add", "save"}, field = "description", required = false, maxlength = 255)})
    private MonsterWeaponDto monsterWeapon;

    public Resolution add() {
        log.debug("add() monsterMonsterWeapon={}", monsterWeapon);
        getContext().getMessages().add(new SimpleMessage("Called method add"));
        try {
            MonsterDto monster = monsterService.findById(Long.parseLong(getContext().getRequest().getParameter("monsterWeapon.monster.id")));
            WeaponDto weapon = weaponService.findById(Long.parseLong(getContext().getRequest().getParameter("monsterWeapon.weapon.id")));
            monsterWeapon.setMonster(monster);
            monsterWeapon.setWeapon(weapon);
            monsterWeapon = service.save(monsterWeapon);
        } catch (Exception ex) {
            getContext().getMessages().add(new SimpleMessage(ex.getMessage()));
            // getContext().getMessages().add(new LocalizableMessage("add.message", escapeHTML(monsterMonsterWeapon.getName()), escapeHTML(monsterMonsterWeapon.getDescription().toString())));

        }
        return new RedirectResolution(this.getClass(), "list");
    }

    @Override
    public Resolution handleValidationErrors(ValidationErrors errors) throws Exception {
        //fill up the data for the table if validation errors occured
        efficiencies = service.findAll();
        //return null to let the event handling continue
        return null;
    }

    public MonsterWeaponDto getMonsterWeapon() {
        return monsterWeapon;
    }

    public void setMonsterWeapon(MonsterWeaponDto monsterMonsterWeapon) {
        this.monsterWeapon = monsterMonsterWeapon;
    }

    //--- part for deleting a monsterMonsterWeapon ----
    public Resolution delete() {
        getContext().getMessages().add(new SimpleMessage("Called method delete"));
        log.debug("delete({})", monsterWeapon.getMonster());
        //only id is filled by the form
        try {
            Long monsterId = Long.parseLong(getContext().getRequest().getParameter("monsterWeapon.monster.id"));
            Long weaponId = Long.parseLong(getContext().getRequest().getParameter("monsterWeapon.weapon.id"));
          service.delete(monsterId, weaponId);
        } catch (Exception ex) {
            getContext().getMessages().add(new SimpleMessage(ex.getMessage()));
        }
        return new RedirectResolution(this.getClass(), "list");
    }

    //--- part for editing a monsterMonsterWeapon ----
    @Before(stages = LifecycleStage.BindingAndValidation, on = {"edit", "save"})
    public void loadMonsterWeaponFromDatabase() {
        String monsterId = getContext().getRequest().getParameter("monsterWeapon.monster.id");
        String weaponId = getContext().getRequest().getParameter("monsterWeapon.weapon.id");
        if (monsterId == null || weaponId == null) {
            return;
        }
        
        try {
            monsterWeapon = service.findById(Long.parseLong(monsterId), Long.parseLong(weaponId));
        } catch (Exception ex) {
            getContext().getMessages().add(new SimpleMessage(ex.getMessage()));
        }
        getContext().getMessages().add(new SimpleMessage("Loaded monsterMonsterWeapon from DB"));
    }

    public Resolution findByMonster() {
        String monsterId = getContext().getRequest().getParameter("monster.id");
        if (monsterId == null) {
            return new RedirectResolution(this.getClass(), "list");
        }
        efficiencies = service.findByMonsterId(Long.parseLong(monsterId));
        return new ForwardResolution("/efficiencies/list.jsp");
    }

    public Resolution findByWeapon() {
        String weaponId = getContext().getRequest().getParameter("weapon.id");
        if (weaponId == null) {
            return new RedirectResolution(this.getClass(), "list");
        }
        efficiencies = service.findByWeaponId(Long.parseLong(weaponId));
        return new ForwardResolution("/efficiencies/list.jsp");
    }
    
     public Resolution clearFilters() {
        log.debug("edit() monsterMonsterWeapon={}", monsterWeapon);
        getContext().getMessages().add(new SimpleMessage("Called method edit"));
        efficiencies = service.findAll();
        return new ForwardResolution("/efficiencies/edit.jsp");
    }


    public Resolution edit() {
        log.debug("edit() monsterMonsterWeapon={}", monsterWeapon);
        getContext().getMessages().add(new SimpleMessage("Called method edit"));
        return new ForwardResolution("/efficiencies/edit.jsp");
    }

    public Resolution save() {
        getContext().getMessages().add(new SimpleMessage("Called method save"));
        try {
            MonsterDto monster = monsterService.findById(Long.parseLong(getContext().getRequest().getParameter("monster.id")));
           WeaponDto weapon = weaponService.findById(Long.parseLong(getContext().getRequest().getParameter("weapon.id")));
            monsterWeapon.setMonster(monster);
            monsterWeapon.setWeapon(weapon);
            
            monsterWeapon =  service.update(monsterWeapon);
            
            
        } catch (Exception ex) {
            getContext().getMessages().add(new SimpleMessage(ex.getMessage()));
            // getContext().getMessages().add(new LocalizableMessage("add.message", escapeHTML(monsterMonsterWeapon.getName()), escapeHTML(monsterMonsterWeapon.getDescription().toString())));

        }
        log.debug("save() monsterMonsterWeapon={}", monsterWeapon);
       
        return new RedirectResolution(this.getClass(), "list");
    }

    public Resolution cancel() {
        getContext().getMessages().add(new SimpleMessage("Called method cancel"));
        log.debug("cancel");
        return new RedirectResolution(this.getClass(), "list");
    }
}
