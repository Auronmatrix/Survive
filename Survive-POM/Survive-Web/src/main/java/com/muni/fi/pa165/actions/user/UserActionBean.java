package com.muni.fi.pa165.actions.user;

import com.muni.fi.pa165.actions.base.BaseActionBean;
import com.muni.fi.pa165.dto.SystemUserDto;
import com.muni.fi.pa165.service.SystemUserService;
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
 * Stripes ActionBean for handling user operations.
 *
 * @author Aubrey Oosthuizen
 */
@UrlBinding("/user/{$event}/{user.username}")
public class UserActionBean extends BaseActionBean implements ValidationErrorHandler {

    final static Logger log = LoggerFactory.getLogger(UserActionBean.class);
    /**
     *
     */
    @SpringBean
    protected SystemUserService userService;
    private List<SystemUserDto> users;

    /**
     *
     * @return
     */
    //@DefaultHandler
    public Resolution list() {
        log.debug("list()");
        users = userService.findAll();
        return new ForwardResolution("/user/list.jsp");
    }

    /**
     *
     * @return
     */
    public List<SystemUserDto> getUsers() {
        return users;
    }
    @ValidateNestedProperties(value = {
        @Validate(on = {"add", "save"}, field = "username", required = true, maxlength = 255),
        @Validate(on = {"add", "save"}, field = "password", required = true),
        @Validate(on = {"add", "save"}, field = "accesslevel", required = true),
       
    })
    private SystemUserDto user;

    /**
     *
     * @return
     */
    public Resolution add() {
        log.debug("add() user={}", user);
        try {
            user = userService.save(user);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return new RedirectResolution(this.getClass(), "list");
    }

    /**
     *
     * @param errors
     * @return
     * @throws Exception
     */
    @Override
    public Resolution handleValidationErrors(ValidationErrors errors) throws Exception {
        users = userService.findAll();
        return null;
    }

    /**
     *
     * @return
     */
    public SystemUserDto getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(SystemUserDto user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    public Resolution delete() {

        log.debug("delete({})", user.getUsername());
        try {
  
          //  userService.delete(user.getUsername());
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return new RedirectResolution(this.getClass(), "list");
    }

    /**
     *
     */
    @Before(stages = LifecycleStage.BindingAndValidation, on = {"edit", "save"})
    public void loadUserFromDatabase() {
        String ids = getContext().getRequest().getParameter("user.name");
        if (ids == null) {
            return;
        }
        user = userService.findById(Long.parseLong(ids));
    }

    /**
     *
     * @return
     */
    public Resolution edit() {
        log.debug("edit() user={}", user);
        return new ForwardResolution("/user/edit.jsp");
    }

    /**
     *
     * @return
     */
    public Resolution save() {

        log.debug("save() user={}", user);
        userService.update(user);
        return new RedirectResolution(this.getClass(), "list");
    }

    /**
     *
     * @return
     */
    public Resolution cancel() {

        log.debug("cancel");
        return new RedirectResolution(this.getClass(), "list");
    }
}
