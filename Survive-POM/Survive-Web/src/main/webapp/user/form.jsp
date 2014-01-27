<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<s:errors/> 


    <div class="form-group">
        <div class="form-group">
            <s:label for="username"  class="col-sm-2 control-label" name="user.username" />
            <div class="col-sm-10">
                <s:text class="form-control" id="username" name="user.username"/>
            </div>
        </div>
                <div class="form-group">
            <s:label for="password" class="col-sm-2 control-label" name="user.password"/>
            <div class="col-sm-10">
                <s:password class="form-control" id="password" name="user.password"/> </div>
            </div>

                    <div class="form-group">
            <s:label for="accessLevel" class="col-sm-2 control-label" name="user.accessLevel"/>
            <div class="col-sm-10">
               <s:text class="form-control" id="accessLevel" name="user.accessLevel"/> </div>
            </div>


    </div>