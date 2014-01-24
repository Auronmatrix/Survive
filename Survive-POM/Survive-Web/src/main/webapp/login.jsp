<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:layout-render name="/layout.jsp" titlekey="index.title">
    <s:layout-component name="body">


          
<c:if test="${not empty error}">
		<div>
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
        <div style="width: 440px; margin-left: auto; margin-right: auto">
            <form  class="form-signin" name='f' action="<c:url value='j_spring_security_check' />" method='POST'>
                <h4 class="form-signin-heading"><f:message key="logon.header"/></h4>
                <input type="text" class="form-control" placeholder="Username" required autofocus name='j_username' value=''>
                <br/>
                <input type="password" class="form-control" placeholder="Password" required type='password' name='j_password'>
                <br/>
                <button class="btn btn-lg btn-primary btn-block" name="submit" type="submit"
					value="submit" >Sign in</button>
            </form>
        </div>
	
 
	
 
        
    </s:layout-component>
</s:layout-render>