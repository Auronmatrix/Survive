package com.muni.fi.pa165.actions.area;

import com.muni.fi.pa165.actions.base.BaseActionBean;
import static com.muni.fi.pa165.actions.base.BaseActionBean.escapeHTML;
import com.muni.fi.pa165.service.AreaService;
import com.muni.fi.pa165.dto.AreaDto;
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
 * Stripes ActionBean for handling area operations.
 *
 * @author Irina Sedyukova
 */
@UrlBinding("/area/{$event}/{area.id}")
public class AreaActionBean extends BaseActionBean implements ValidationErrorHandler {

    final static Logger log = (Logger) LoggerFactory.getLogger(AreaActionBean.class);
    private List<AreaDto> areas;

    @DefaultHandler
    public Resolution list() {
        log.debug("list()");
        areas = areaService.findAll();
        return new ForwardResolution("/area/list.jsp");
    }

    public List<AreaDto> getAreas() {
        return areas;
    }
    @SpringBean
    protected AreaService areaService;
    @ValidateNestedProperties(value = {
        @Validate(on = {"add", "save"}, field = "name", required = true, maxlength = 25),
        @Validate(on = {"add", "save"}, field = "terrain", required = true),
        @Validate(on = {"add", "save"}, field = "description", required = false, maxlength = 255)})
    private AreaDto area;

    public Resolution add() {
        log.debug("add() area={}", area);
        try {
            area = areaService.save(area);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
         log.debug("area.add.message", escapeHTML(area.getName()));
        return new RedirectResolution(this.getClass(), "list");
    }

    @Override
    public Resolution handleValidationErrors(ValidationErrors errors) throws Exception {
        areas = areaService.findAll();
        return null;
    }

    public AreaDto getArea() {
        return area;
    }

    public void setArea(AreaDto area) {
        this.area = area;
    }

    public Resolution delete() throws Exception {
        log.debug("delete({})", area.getId());
        areaService.delete(area.getId());
        return new RedirectResolution(this.getClass(), "all");
    }

    @Before(stages = LifecycleStage.BindingAndValidation, on = {"edit", "save"})
    public void loadAreaFromDatabase() {
        String ids = getContext().getRequest().getParameter("area.id");
        if (ids == null) {
            return;
        }
        area = areaService.findById(Long.parseLong(ids));
        log.debug("Loaded area from DB");
    }

    public Resolution edit() {
        log.debug("edit() area={}", area);
        return new ForwardResolution("/area/edit.jsp");
    }

    public Resolution save() {
        log.debug("save() area={}", area);
        areaService.update(area);
        return new RedirectResolution(this.getClass(), "list");
    }

    public Resolution select() {
        log.debug("select() area={}", area);
        this.setArea(areaService.findById(Long.parseLong(getContext().getRequest().getParameter("area.id"))));
        return new RedirectResolution(this.getClass(), "list");
    }

    public Resolution cancel() {
        log.debug("cancel");
        return new RedirectResolution(this.getClass(), "list");
    }
}
