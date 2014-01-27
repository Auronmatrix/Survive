<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<s:errors/> 


    <div class="form-group">
        <div class="form-group">
            <s:label for="name"  class="col-sm-2 control-label" name="weapon.name" />
            <div class="col-sm-10">
                <s:text class="form-control" id="name" name="weapon.name"/>
            </div>
        </div>
                <div class="form-group">
            <s:label for="weaponClass" class="col-sm-2 control-label" name="weapon.weaponClass"/>
            <div class="col-sm-10">
                <s:select class="form-control"  id="weaponClass" name="weapon.weaponClass"><s:options-enumeration enum="com.muni.fi.pa165.enums.WeaponClass"/></s:select>
                </div>
            </div>

                    <div class="form-group">
            <s:label for="weaponType" class="col-sm-2 control-label" name="weapon.weaponType"/>
            <div class="col-sm-10">
                <s:select class="form-control"  id="weaponType" name="weapon.weaponType"><s:options-enumeration enum="com.muni.fi.pa165.enums.WeaponType"/></s:select>
                </div>
            </div>


        <div class="form-group">
            <s:label for="range" class="col-sm-2 control-label" name="weapon.range" />
            <div class="col-sm-10">
               <input type="number" class="form-control" id="dangerLevel" name="weapon.range" value="${actionBean.weapon.range}" placeholder="Please enter numeric value"/>
            </div>
        </div>
        <div class="form-group">
            <s:label for="caliber" class="col-sm-2 control-label"  name="weapon.caliber"/>
            <div class="col-sm-10">
                <s:text class="form-control" id="caliber"  name="weapon.caliber"/>
            </div>
        </div>
        <div class="form-group">
            <s:label for="rounds" class="col-sm-2 control-label" name="weapon.rounds"/>
            <div class="col-sm-10">
               <input type="number" class="form-control" id="dangerLevel" name="weapon.rounds" value="${actionBean.weapon.rounds}" placeholder="Please enter numeric value"/>
            </div>
        </div>
        

            <div class="form-group">
            <s:label for="description" class="col-sm-2 control-label" name="weapon.description"/>
            <div class="col-sm-10">
                <s:textarea class="form-control" name="weapon.description" rows="3" id="description"/>
            </div>
        </div>
    </div>