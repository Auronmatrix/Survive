<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<s:layout-render name="/layout.jsp" titlekey="index.title">
    <s:layout-component name="body">
        <h1><f:message key="monster.title"/></h1>

        <s:useActionBean beanclass="com.muni.fi.pa165.monster.MonsterActionBean" var="actionBean"/>

        <p><f:message key="monster.list.allmonsters"/></p>
        <div class="table-responsive">
            <table class="table">
                <tr>
                    <th><f:message key="monster.res.image"/></th>
                    <th><f:message key="monster.res.id"/></th>
                    <th><f:message key="monster.res.name"/></th>                
                    <th><f:message key="monster.res.stamina"/></th>                    
                    <th><f:message key="monster.res.height"/></th>
                    <th><f:message key="monster.res.strength"/></th>
                    <th><f:message key="monster.res.agility"/></th>
                    <th><f:message key="monster.res.dangerLevel"/></th>
                    <th><f:message key="monster.res.weight"/></th>
                    <th><f:message key="monster.res.class"/></th>
                    <th><f:message key="monster.res.description"/></th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${actionBean.monsters}" var="monster">
                    <tr>
                        <td>
                            <s:form beanclass="com.muni.fi.pa165.monster.MonsterActionBean" action="select">
                                <s:hidden name="monster.id" value="${monster.id}"/>                                   
                                <s:image src="${monster.imagePath}" class="img img-circle" name="${monster.id}.image" style="width: 60px; height: 60px" />
                            </s:form>
                        </td> 
                        <td><c:out value="${monster.id}" /></td>
                        <td><c:out value="${monster.name}" /></td>
                        <td><c:out value="${monster.stamina}" /></td>

                        <td><c:out value="${monster.height}" /></td>
                        <td><c:out value="${monster.strength}" /></td>
                        <td><c:out value="${monster.agility}" /></td>
                        <td><c:out value="${monster.dangerLevel}" /></td>
                        <td><c:out value="${monster.weight}" /></td>
                        <td><c:out value="${monster.monsterClass}" /></td>
                        <td><c:out value="${monster.description}" /></td>                 

                        <td>         
                             <s:form beanclass="com.muni.fi.pa165.monster.MonsterActionBean" action="edit">
                                <s:hidden name="monster.id" value="${monster.id}"/>
                                <s:submit class="btn btn-warning" name="edit"><f:message key="monster.list.edit"/></s:submit>
                            </s:form>
                        </td>
                        <td>                            
                            <s:form beanclass="com.muni.fi.pa165.monster.MonsterActionBean" action="delete">
                                <s:hidden name="monster.id" value="${monster.id}"/>
                                <s:submit class="btn btn-danger" name="delete"><f:message key="monster.list.delete"/></s:submit>
                            </s:form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
                    <s:form beanclass="com.muni.fi.pa165.monster.MonsterActionBean" class="form-horizontal" action="add">
            <fieldset><legend><f:message key="monster.list.newmonster"/></legend>
                <s:hidden id="_sourcePage" name="_sourcePage" />
                <s:hidden  name="monster.id" value="${monster.id}" />
                <%@include file="form.jsp"%>
                <s:submit class="btn btn-info" name="add">Save new monster</s:submit>
                
            </fieldset>
    </s:form>
</s:layout-component>
</s:layout-render>
