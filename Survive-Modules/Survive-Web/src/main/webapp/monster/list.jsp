<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<s:layout-render name="/layout.jsp" titlekey="index.title">
    <s:layout-component name="body">
        <h1><f:message key="monster.title"/></h1>
    
        <s:useActionBean beanclass="com.muni.fi.pa165.monster.MonsterActionBean" var="actionBean"/>

        <p><f:message key="monster.list.allmonsters"/></p>

        <table class="basic">
            <tr>
                <th>id</th>
                <th><f:message key="monster.id"/></th>
                <th><f:message key="monster.class"/></th>
                <th><f:message key="monster.height"/></th>
                <th><f:message key="monster.agility"/></th>
                <th><f:message key="monster.strength"/></th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${actionBean.monsters}" var="monster">
                <tr>
                    <td>${monster.id}</td>
                    <td><c:out value="${monster.id}"/></td>
                    <td><c:out value="${monster.dangerLevel}"/></td>
                    <td><c:out value="${monster.height}"/></td>
                    <td><c:out value="${monster.agility}"/></td>
                    <td>
                     <s:link beanclass="com.muni.fi.pa165.monster.MonsterActionBean" event="edit"><s:param name="monster.id" value="${monster.id}"/>edit</s:link>
                    </td>
                    <td>
                        <s:form beanclass="com.muni.fi.pa165.monster.MonsterActionBean">
                            <s:hidden name="monster.id" value="${monster.id}"/>
                            <s:submit name="delete"><f:message key="monster.list.delete"/></s:submit>
                        </s:form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <s:form beanclass="com.muni.fi.pa165.monster.MonsterActionBean">
            <fieldset><legend><f:message key="monster.list.newmonster"/></legend>
                <%@include file="form.jsp"%>
                <s:submit name="add">Save new monster</s:submit>
            </fieldset>
        </s:form>
    </s:layout-component>
</s:layout-render>
        