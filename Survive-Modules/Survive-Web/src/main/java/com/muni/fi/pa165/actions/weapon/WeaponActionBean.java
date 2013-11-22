package com.muni.fi.pa165.actions.weapon;

import com.muni.fi.pa165.actions.base.BaseActionBean;
import static com.muni.fi.pa165.actions.base.BaseActionBean.escapeHTML;
import com.muni.fi.pa165.dao.service.WeaponService;
import com.muni.fi.pa165.dto.WeaponDto;
import java.util.ArrayList;
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
 * Stripes ActionBean for handling weapon operations.
 *
 * @author Aubrey Oosthuizen
 */
@UrlBinding("/weapon/{$event}/{weapon.id}")
public class WeaponActionBean extends BaseActionBean implements ValidationErrorHandler {

    final static Logger log = LoggerFactory.getLogger(WeaponActionBean.class);
    
    @SpringBean //Spring can inject even to private and protected fields
    protected WeaponService weaponService;
    
    //--- part for showing a list of weapons ----
    private List<WeaponDto> weapons;

    //@DontValidate
    @DefaultHandler
    public Resolution list() {
        log.debug("list()");
        weapons = weaponService.findAll();
        return new ForwardResolution("/weapon/list.jsp");
    }

//    public Resolution WeaponActionBean()
//    {
//        log.debug("default or constructor()");
//        weapons = weaponService.findAll();
//        return new ForwardResolution("/weapon/lolololol.jsp");
//    }
    public List<WeaponDto> getWeapons() {
        return weapons;
    }
    //--- part for adding a weapon ----
    @ValidateNestedProperties(value = {
        @Validate(on = {"add", "save"}, field = "name", required = false),
        @Validate(on = {"add", "save"}, field = "stamina", required = false), 
        @Validate(on = {"add", "save"}, field = "height", required = false, minvalue = 0),
        @Validate(on = {"add", "save"}, field = "strength", required = false, minvalue = 0),
         @Validate(on = {"add", "save"}, field = "agility", required = false, minvalue = 0),
         @Validate(on = {"add", "save"}, field = "dangerLevel", required = false, minvalue = 0),
         @Validate(on = {"add", "save"}, field = "weight", required = false, minvalue = 0),
         @Validate(on = {"add", "save"}, field = "description", required = false, minvalue = 0),    
         @Validate(on = {"add", "save"}, field = "imagePath", required = false, minvalue = 0)
            
    })
    private WeaponDto weapon;
    

    public Resolution add() {
        log.debug("add() weapon={}", weapon);
        try {
            weapon = weaponService.save(weapon);
        } catch (Exception ex) {
            getContext().getMessages().add(new SimpleMessage(ex.getMessage()));
        }
        getContext().getMessages().add(new LocalizableMessage("weapon.add.message", escapeHTML(weapon.getName()), escapeHTML(weapon.getDescription().toString())));
        return new RedirectResolution(this.getClass(), "list");
    }

    @Override
    public Resolution handleValidationErrors(ValidationErrors errors) throws Exception {
        //fill up the data for the table if validation errors occured
        weapons = weaponService.findAll();
        //return null to let the event handling continue
        return null;
    }

    public WeaponDto getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponDto weapon) {
        this.weapon = weapon;
    }

    //--- part for deleting a weapon ----
    public Resolution delete() {
        log.debug("delete({})", weapon.getId());
        //only id is filled by the form
        weapon = weaponService.findById(weapon.getId());
        try {
            weaponService.delete(weapon.getId());
       } catch (Exception ex) {
           getContext().getMessages().add(new SimpleMessage(ex.getMessage()));
            getContext().getMessages().add(new LocalizableMessage("weapon.delete.message", escapeHTML(weapon.getName()), escapeHTML(weapon.getDescription().toString())));        
        }
        return new RedirectResolution(this.getClass(), "list");
    }

    //--- part for editing a weapon ----
    @Before(stages = LifecycleStage.BindingAndValidation, on = {"edit", "save"})
    public void loadWeaponFromDatabase() {
        String ids = getContext().getRequest().getParameter("weapon.id");
        if (ids == null) return;
        weapon = weaponService.findById(Long.parseLong(ids));        
        getContext().getMessages().add(new SimpleMessage("Loaded weapon from DB"));
    }

    public Resolution edit() {
        log.debug("edit() weapon={}", weapon);
        return new ForwardResolution("/weapon/edit.jsp");
    }

    public Resolution save() {
        log.debug("save() weapon={}", weapon);
        weaponService.update(weapon);
        return new RedirectResolution(this.getClass(), "list");
    }

    public Resolution cancel() {
        log.debug("cancel");
        return new RedirectResolution(this.getClass(), "list");
    }
}
