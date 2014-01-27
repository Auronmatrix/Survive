package com.muni.fi.pa165.dto;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *Data transfer object for the {@link Systemuser}.
 * 
 * @author irina
 */
@XmlRootElement
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private Integer accessLevel;

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public Integer getAccessLevel() {
        return accessLevel;
    }

    /**
     *
     * @param accessLevel
     */
    public void setAccessLevel(Integer accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof UserDto)) {
            return false;
        }
        UserDto other = (UserDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }
}
