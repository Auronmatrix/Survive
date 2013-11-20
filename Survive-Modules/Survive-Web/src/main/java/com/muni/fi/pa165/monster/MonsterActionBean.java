package com.muni.fi.pa165.monster;

import com.muni.fi.pa165.base.BaseActionBean;
import static com.muni.fi.pa165.base.BaseActionBean.escapeHTML;
import com.muni.fi.pa165.dao.service.MonsterService;
import com.muni.fi.pa165.dto.MonsterDto;
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
 * Stripes ActionBean for handling monster operations.
 *
 * @author Martin Kuba makub@ics.muni.com
 */
@UrlBinding("/monster/{$event}/{monster.id}")
public class MonsterActionBean extends BaseActionBean implements ValidationErrorHandler {

    final static Logger log = LoggerFactory.getLogger(MonsterActionBean.class);

    @SpringBean //Spring can inject even to private and protected fields
    protected MonsterService monsterService;

    //--- part for showing a list of monsters ----
    private List<MonsterDto> monsters;
    
   @SpringBean
    private MonsterDto monster;

    @DefaultHandler
    public Resolution list() {
        log.debug("list()");
        monsters = monsterService.findAll();
        return new ForwardResolution("/monster/list.jsp");
    }
    
    public Resolution MonsterActionBean()
    {
        log.debug("default or constructor()");
        monsters = monsterService.findAll();
        return new ForwardResolution("/monster/list.jsp");
    }

    public List<MonsterDto> getMonsters() {
        return monsters;
    }

    //--- part for adding a monster ----

    @ValidateNestedProperties(value = {
            @Validate(on = {"add", "save"}, field = "author", required = true),
            @Validate(on = {"add", "save"}, field = "title", required = true),
            @Validate(on = {"add", "save"}, field = "year", required = true, minvalue = 800)
    })
    
    

    public Resolution add() {
        log.debug("add() monster={}", monster);
        monsterService.save(monster);
        getContext().getMessages().add(new LocalizableMessage("monster.add.message",escapeHTML(monster.getName()),escapeHTML(monster.getAgility().toString())));
        return new RedirectResolution(this.getClass(), "list");
    }

    @Override
    public Resolution handleValidationErrors(ValidationErrors errors) throws Exception {
        //fill up the data for the table if validation errors occured
        monsters = monsterService.findAll();
        //return null to let the event handling continue
        return null;
    }

    public MonsterDto getMonster() {
        return monster;
    }

    public void setMonster(MonsterDto monster) {
        this.monster = monster;
    }

    //--- part for deleting a monster ----

    public Resolution delete() {
        log.debug("delete({})", monster.getId());
        //only id is filled by the form
        monster = monsterService.findById(monster.getId());
        monsterService.delete(monster);
        getContext().getMessages().add(new LocalizableMessage("monster.delete.message",escapeHTML(monster.getName()),escapeHTML(monster.getAgility().toString())));
        return new RedirectResolution(this.getClass(), "list");
    }

    //--- part for editing a monster ----

    @Before(stages = LifecycleStage.BindingAndValidation, on = {"edit", "save"})
    public void loadMonsterFromDatabase() {
        String ids = getContext().getRequest().getParameter("monster.id");
        if (ids == null) return;
        monster = monsterService.findById(Long.parseLong(ids));
    }

    public Resolution edit() {
        log.debug("edit() monster={}", monster);
        return new ForwardResolution("/monster/edit.jsp");
    }

    public Resolution save() {
        log.debug("save() monster={}", monster);
        monsterService.update(monster);
        return new RedirectResolution(this.getClass(), "list");
    }
    
    public Resolution cancel() 
    {
        log.debug("cancel");
        return new RedirectResolution("/monster/list.jsp");
    }
}
