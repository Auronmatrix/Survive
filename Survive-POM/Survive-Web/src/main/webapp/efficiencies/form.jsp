<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<s:errors/> 


                      
       <div class="form-group">
            <s:label for="efficiency" class="col-sm-2 control-label" name="monsterWeapon.efficiency" />
            <div class="col-sm-10">
                <s:text class="form-control" id="efficiency" name="monsterWeapon.efficiency"/>
            </div>
        </div>
        <div class="form-group">
            <s:label for="hitRate" class="col-sm-2 control-label"  name="monsterWeapon.hitRate"/>
            <div class="col-sm-10">
                <s:text  class="form-control" id="hitRate" name="monsterWeapon.hitRate"/>
            </div>
        </div>
        <div class="form-group">
            <s:label for="damage" class="col-sm-2 control-label" name="monsterWeapon.damage"/>
            <div class="col-sm-10">
                <s:text  class="form-control" id="damage" name="monsterWeapon.damage"/>
            </div>
        </div>
            <div class="form-group">
            <s:label for="description" class="col-sm-2 control-label" name="monsterWeapon.description"/>
            <div class="col-sm-10">
                <s:textarea class="form-control" name="monsterWeapon.description" rows="3" id="description"/>
            </div>
        </div>

    </div>