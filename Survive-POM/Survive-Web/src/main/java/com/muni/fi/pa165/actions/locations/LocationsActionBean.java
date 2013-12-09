package com.muni.fi.pa165.actions.locations;

import com.muni.fi.pa165.actions.locations.*;
import com.muni.fi.pa165.actions.base.BaseActionBean;
import com.muni.fi.pa165.dto.MonsterDto;
import com.muni.fi.pa165.service.MonsterAreaService;
import com.muni.fi.pa165.dto.MonsterAreaDto;
import com.muni.fi.pa165.dto.AreaDto;
import com.muni.fi.pa165.service.MonsterService;
import com.muni.fi.pa165.service.AreaService;
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
 * Stripes ActionBean for handling monsterMonsterArea operations.
 *
 * @author Aubrey Oosthuizen
 */
@UrlBinding("/locations/{$event}/{monsterArea.area.id}")
public class LocationsActionBean extends BaseActionBean implements ValidationErrorHandler {

    final static Logger log = LoggerFactory.getLogger(LocationsActionBean.class);
    @SpringBean //Spring can inject even to private and protected fields
    protected MonsterAreaService service;
    
    @SpringBean
    protected AreaService areaService;
    
    @SpringBean
    protected MonsterService monsterService;
    //--- part for showing a list of monsterMonsterAreas ----
    private List<MonsterAreaDto> locations;
    private List<AreaDto> areas;
    private List<MonsterDto> monsters;
    


    //@DontValidate
    @DefaultHandler
    public Resolution list() {
        log.debug("list()");
        locations = service.findAll();
        
        
        return new ForwardResolution("/locations/list.jsp");
    }

    public List<MonsterAreaDto> getLocations() {
        return locations;
    }
   
    public void setLocations(List<MonsterAreaDto> locations) {
        this.locations = locations;
    }

    public List<AreaDto> getAreas() {
         areas = areaService.findAll();
        return areas;
    }

    public void setAreas(List<AreaDto> areas) {
        this.areas = areas;
    }

    public List<MonsterDto> getMonsters() {
        monsters = monsterService.findAll();
        return monsters;
    }

    public void setMonsters(List<MonsterDto> monsters) {
        this.monsters = monsters;
    }
    
    


    public List<MonsterAreaDto> getMonsterAreas() {
        return locations;
    }

     
        @ValidateNestedProperties(value = {
        @Validate(on = {"add", "save"}, field = "monster.id", required = true),
        @Validate(on = {"add", "save"}, field = "area.id", required = true), 
        @Validate(on = {"add", "save"}, field = "monsterQuantity", required = true, minvalue=1)})
    
        private MonsterAreaDto monsterArea;

    public Resolution add() {
        log.debug("add() monsterMonsterArea={}", monsterArea);
        getContext().getMessages().add(new SimpleMessage("Called method add"));
        try {
            MonsterDto monster = monsterService.findById(Long.parseLong(getContext().getRequest().getParameter("monsterArea.monster.id")));
            AreaDto area = areaService.findById(Long.parseLong(getContext().getRequest().getParameter("monsterArea.area.id")));
            monsterArea.setMonster(monster);
            monsterArea.setArea(area);
            monsterArea = service.save(monsterArea);
        } catch (Exception ex) {
            getContext().getMessages().add(new SimpleMessage(ex.getMessage()));
            // getContext().getMessages().add(new LocalizableMessage("add.message", escapeHTML(monsterMonsterArea.getName()), escapeHTML(monsterMonsterArea.getDescription().toString())));

        }
        return new RedirectResolution(this.getClass(), "list");
    }

    @Override
    public Resolution handleValidationErrors(ValidationErrors errors) throws Exception {
        //fill up the data for the table if validation errors occured
        locations = service.findAll();
        //return null to let the event handling continue
        return null;
    }

    public MonsterAreaDto getMonsterArea() {
        return monsterArea;
    }

    public void setMonsterArea(MonsterAreaDto monsterMonsterArea) {
        this.monsterArea = monsterMonsterArea;
    }

    //--- part for deleting a monsterMonsterArea ----
    public Resolution delete() {
        getContext().getMessages().add(new SimpleMessage("Called method delete"));
        log.debug("delete({})", monsterArea.getMonster());
        //only id is filled by the form
        try {
            Long monsterId = Long.parseLong(getContext().getRequest().getParameter("monsterArea.monster.id"));
            Long areaId = Long.parseLong(getContext().getRequest().getParameter("monsterArea.area.id"));

            service.delete(service.getCompositeKey(monsterId, areaId));
        } catch (Exception ex) {
            getContext().getMessages().add(new SimpleMessage(ex.getMessage()));
        }
        return new RedirectResolution(this.getClass(), "list");
    }

    //--- part for editing a monsterMonsterArea ----
    @Before(stages = LifecycleStage.BindingAndValidation, on = {"edit", "save"})
    public void loadMonsterAreaFromDatabase() {
        String monsterId = getContext().getRequest().getParameter("monsterArea.monster.id");
        String areaId = getContext().getRequest().getParameter("monsterArea.area.id");
        if (monsterId == null || areaId == null) {
            return;
        }
        
        try {
            monsterArea = service.findById(Long.parseLong(monsterId), Long.parseLong(areaId));
        } catch (Exception ex) {
            getContext().getMessages().add(new SimpleMessage(ex.getMessage()));
        }
        getContext().getMessages().add(new SimpleMessage("Loaded monsterMonsterArea from DB"));
    }

    public Resolution findByMonster() {
        String monsterId = getContext().getRequest().getParameter("filter.monster.id");
        if (monsterId == null) {
            return new RedirectResolution(this.getClass(), "list");
        }
        locations = service.findByMonsterId(Long.parseLong(monsterId));
        return new ForwardResolution("/locations/list.jsp");
    }

    public Resolution findByArea() {
        String areaId = getContext().getRequest().getParameter("filter.area.id");
        if (areaId == null) {
            return new RedirectResolution(this.getClass(), "list");
        }
        locations = service.findByAreaId(Long.parseLong(areaId));
        return new ForwardResolution("/locations/list.jsp");
    }
    
     public Resolution clearFilters() {
        log.debug("edit() monsterMonsterArea={}", monsterArea);
        getContext().getMessages().add(new SimpleMessage("Called method edit"));
        locations = service.findAll();
        return new ForwardResolution("/locations/edit.jsp");
    }


    public Resolution edit() {
        log.debug("edit() monsterMonsterArea={}", monsterArea);
        getContext().getMessages().add(new SimpleMessage("Called method edit"));
        return new ForwardResolution("/locations/edit.jsp");
    }

    public Resolution save() {
        getContext().getMessages().add(new SimpleMessage("Called method save"));
        try {

            monsterArea =  service.update(monsterArea);
            
            
        } catch (Exception ex) {
            getContext().getMessages().add(new SimpleMessage(ex.getMessage()));
          
        }
        log.debug("save() monsterMonsterArea={}", monsterArea);
       
        return new RedirectResolution(this.getClass(), "list");
    }

    public Resolution cancel() {
        getContext().getMessages().add(new SimpleMessage("Called method cancel"));
        log.debug("cancel");
        return new RedirectResolution(this.getClass(), "list");
    }
}
