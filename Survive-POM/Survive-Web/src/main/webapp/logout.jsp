<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<s:layout-render name="/layout.jsp" titlekey="index.title">
    <s:layout-component name="body">

        <h1 style="text-align: center"><f:message key="logout.title"/></h1>
        <div style="text-align: center">         
            <p><f:message key="logout.headline1"/></p>
            <p><f:message key="logout.headline2"/></p>
            
        </div>
            


    </s:layout-component>
</s:layout-render>

