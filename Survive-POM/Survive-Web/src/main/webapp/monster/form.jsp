<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<s:errors/> 


 
            
    <div class="form-group">
        <div class="form-group">
            <s:label for="name"  class="col-sm-2 control-label" name="monster.name" />
            <div class="col-sm-10">
                <s:text class="form-control" id="name" name="monster.name"/>
            </div>
        </div>
        <div class="form-group">
            <s:label for="stamina" class="col-sm-2 control-label" name="monster.stamina" />          
            <div class="col-sm-10">
                <!--<s:text class="form-control" id="stamina" name="monster.stamina"/>-->
                <input type="number" class="form-control" id="stamina" name="monster.stamina" placeholder="Please enter numeric value from 0 till 100"/>
            </div>
        </div>
        <div class="form-group">
            <s:label for="height" class="col-sm-2 control-label"  name="monster.height"/>
            <div class="col-sm-10">
                <!--<s:text  class="form-control" id="height" name="monster.height"/>-->
                <input type="number" class="form-control" id="height" name="monster.height" placeholder="Please enter numeric value from 0 till 100"/>
            </div>
        </div>
        <div class="form-group">
            <s:label for="strength" class="col-sm-2 control-label" name="monster.strength"/>
            <div class="col-sm-10">
               <!-- <s:text  class="form-control" id="strength" name="monster.strength"/>-->
               <input type="number" class="form-control" id="strength" name="monster.strength" placeholder="Please enter numeric value from 0 till 100"/>
            </div>
        </div>
        <div class="form-group">
            <s:label for="agility" class="col-sm-2 control-label" name="monster.agility"/>
            <div class="col-sm-10">
               <!-- <s:text  class="form-control" id="agility" name="monster.agility"/>-->
               <input type="number" class="form-control" id="agility" name="monster.agility" placeholder="Please enter numeric value from 0 till 100"/>
            </div>
        </div>
        <div class="form-group">
            <s:label for="dangerLevel" class="col-sm-2 control-label" name="monster.dangerLevel"/>
            <div class="col-sm-10">
                <!--<s:text  class="form-control" id="dangerLevel" name="monster.dangerLevel"/>-->
                <input type="number" class="form-control" id="dangerLevel" name="monster.dangerLevel" placeholder="Please enter numeric value from 0 till 100"/>
            </div>
        </div>
        <div class="form-group">
            <s:label for="weight" class="col-sm-2 control-label" name="monster.weight"/>
            <div class="col-sm-10">
                <!--<s:text class="form-control" id="weight"  name="monster.weight"/>-->
                <input type="number" class="form-control" id="weight" name="monster.weight" placeholder="Please enter numeric value from 0 till 100"/>
            </div>
        </div>
        <div class="form-group">
            <s:label for="monsterClass" class="col-sm-2 control-label" name="monster.class"/>
            <div class="col-sm-10">
                <s:select class="form-control"   id="monsterClass" name="monster.monsterClass"><s:options-enumeration  enum="com.muni.fi.pa165.enums.MonsterClass"/></s:select>
                </div>
            </div>

            <div class="form-group">
            <s:label for="description" class="col-sm-2 control-label" name="monster.description"/>
            <div class="col-sm-10">
                <s:textarea class="form-control" name="monster.description" rows="3" id="description"/>
            </div>
        </div>

        <div class="form-group">
            <s:label for="imagePath" class="col-sm-2 control-label" name="monster.image"/>
            <div class="col-sm-10">
                <s:text name="monster.imagePath" class="form-control" id="imagePath" />
            </div>
        </div>
    </div>