package com.muni.fi.pa165.actions.weapon;

import com.muni.fi.pa165.actions.base.BaseActionBean;
import com.muni.fi.pa165.dto.WeaponDto;
import com.muni.fi.pa165.service.WeaponService;
import java.util.List;
import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.controller.LifecycleStage;
import net.sourceforge.stripes.integration.spring.SpringBean;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationErrorHandler;
import net.sourceforge.stripes.validation.ValidationErrors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Stripes ActionBean for handling weapon operations.
 *
 * @author Aubrey Oosthuizen
 */
@UrlBinding("/weapon/{$event}/{weapon.id}")
public class WeaponActionBean extends BaseActionBean implements ValidationErrorHandler {

    final static Logger log = LoggerFactory.getLogger(WeaponActionBean.class);
    @SpringBean
    protected WeaponService weaponService;
    private List<WeaponDto> weapons;

    @DefaultHandler
    public Resolution list() {
        log.debug("list()");
        weapons = weaponService.findAll();
        return new ForwardResolution("/weapon/list.jsp");
    }

    public List<WeaponDto> getWeapons() {
        return weapons;
    }
    @ValidateNestedProperties(value = {
        @Validate(on = {"add", "save"}, field = "name", required = true, maxlength = 255),
        @Validate(on = {"add", "save"}, field = "weaponType", required = true),
        @Validate(on = {"add", "save"}, field = "weaponClass", required = true),
        @Validate(on = {"add", "save"}, field = "range", required = false, maxlength = 10, minvalue = 0, maxvalue = 100000),
        @Validate(on = {"add", "save"}, field = "caliber", required = false, maxlength = 10, minvalue = 0, maxvalue = 50),
        @Validate(on = {"add", "save"}, field = "rounds", required = false, maxlength = 10, minvalue = 0, maxvalue = 100000),
        @Validate(on = {"add", "save"}, field = "description", required = false, maxlength = 255)
    })
    private WeaponDto weapon;

    public Resolution add() {
        log.debug("add() weapon={}", weapon);

        try {
            weapon = weaponService.save(weapon);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return new RedirectResolution(this.getClass(), "list");
    }

    @Override
    public Resolution handleValidationErrors(ValidationErrors errors) throws Exception {
        weapons = weaponService.findAll();
        return null;
    }

    public WeaponDto getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponDto weapon) {
        this.weapon = weapon;
    }

    public Resolution delete() {

        log.debug("delete({})", weapon.getId());
        try {
  
            weaponService.delete(weapon.getId());
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return new RedirectResolution(this.getClass(), "list");
    }

    @Before(stages = LifecycleStage.BindingAndValidation, on = {"edit", "save"})
    public void loadWeaponFromDatabase() {
        String ids = getContext().getRequest().getParameter("weapon.id");
        if (ids == null) {
            return;
        }
        weapon = weaponService.findById(Long.parseLong(ids));
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
