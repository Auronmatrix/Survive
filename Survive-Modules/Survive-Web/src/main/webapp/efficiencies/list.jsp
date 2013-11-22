<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<s:layout-render name="/layout.jsp" titlekey="monsterWeapon.title">
    <s:layout-component name="body">
        <h1><f:message key="monster.title"/></h1>

        <s:useActionBean beanclass="com.muni.fi.pa165.actions.monster.MonsterWeaponActionBean" var="actionBean"/>

        <p><f:message key="monsterWeapon.list.allmonsterWeapons"/></p>
        <div class="table-responsive">
            <table class="table">
                <tr>                    
                    <th><f:message key="monsterWeapon.monsterID"/></th>                
                    <th><f:message key="monsterWeapon.weaponID"/></th>                    
                    <th><f:message key="monsterWeapon.hitRate"/></th>
                    <th><f:message key="monsterWeapon.damage"/></th>
                    <th><f:message key="monsterWeapon.efficiency"/></th>                   
                    <th><f:message key="monsterWeapon.description"/></th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${actionBean.monsterWeapons}" var="monsterWeapon">
                    <tr>
                       
                        <td>${monsterWeapon.monster.id}</td>
                        <td><c:out value="${monsterWeapon.weapon.id}" /></td>
                        <td><c:out value="${monsterWeapon.hitRate}" /></td>
                        <td><c:out value="${monsterWeapon.damage}" /></td>
                        <td><c:out value="${monsterWeapon.efficiency}" /></td>
                        <td><c:out value="${monsterWeapon.description}" /></td>   
                        <td>         
                            <s:form beanclass="com.muni.fi.pa165.actions.monsterWeapon.MonsterWeaponActionBean" action="edit">
                                <s:hidden name="monsterWeapon.monster.id" value="${monsterWeapon.monster.id}"/>
                                 <s:hidden name="monsterWeapon.weapon.id" value="${monsterWeapon.weapon.id}"/>
                                <s:submit class="btn btn-warning" name="edit"><f:message key="forms.edit"/></s:submit>
                            </s:form>
                        </td>
                        <td>                            
                            <s:form beanclass="com.muni.fi.pa165.actions.monsterWeapon.MonsterWeaponActionBean" action="delete">
                                <s:hidden name="monsterWeapon.monster.id" value="${monsterWeapon.monster.id}"/>
                                 <s:hidden name="monsterWeapon.weapon.id" value="${monsterWeapon.weapon.id}"/>
                                <s:submit class="btn btn-danger" name="delete"><f:message key="forms.delete"/></s:submit>
                            </s:form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <s:form beanclass="com.muni.fi.pa165.actions.monsterWeapon.MonsterWeaponActionBean"  action="add" class="form-horizontal">
            <fieldset><legend><f:message key="monsterWeapon.list.newmonsterWeapon"/></legend>
             
                <s:submit class="btn btn-info" name="add"><f:message key="forms.save" /></s:submit>
                </fieldset>
        </s:form>
    </s:layout-component>
</s:layout-render>
