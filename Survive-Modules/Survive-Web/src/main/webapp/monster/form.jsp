<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<s:errors/> 

<div class="form-group">
        <div class="form-group">
            <div class="form-group">
                <s:label for="name"  class="col-sm-2 control-label" name="monster.name" />
                <div class="col-sm-10">
                    <s:text class="form-control" id="name" name="monster.name"/>
                </div>
            </div>
            <div class="form-group">
                <s:label for="stamina" class="col-sm-2 control-label" title="monster.stamina" />
                <div class="col-sm-10">
                    <s:text class="form-control" id="stamina" name="monster.stamina"/>
                </div>
            </div>
            <div class="form-group">
                <s:label for="height" class="col-sm-2 control-label"  title="monster.height"/>
                <div class="col-sm-10">
                    <s:text  class="form-control" id="height" name="monster.height"/>
                </div>
            </div>
            <div class="form-group">
                <s:label for="strength" class="col-sm-2 control-label" title="monster.strength"/>
                <div class="col-sm-10">
                    <s:text  class="form-control" id="strength" name="monster.strength"/>
                </div>
            </div>
            <div class="form-group">
                <s:label for="agility" class="col-sm-2 control-label" title="monster.agility"/>
                <div class="col-sm-10">
                    <s:text  class="form-control" id="agility" name="monster.agility"/>
                </div>
            </div>
            <div class="form-group">
                <s:label for="dangerLevel" class="col-sm-2 control-label" title="monster.dangerLevel"/>
                <div class="col-sm-10">
                    <s:text  class="form-control" id="dangerLevel" name="monster.dangerLevel"/>
                </div>
            </div>
            <div class="form-group">
                <s:label for="weight" class="col-sm-2 control-label" title="monster.weight"/>
                <div class="col-sm-10">
                    <s:text class="form-control" id="weight"  name="monster.weight"/>
                </div>
            </div>
            <div class="form-group">
                <s:label for="monsterClass" class="col-sm-2 control-label" title="monster.class"/>
                <div class="col-sm-10">
                    <s:select  id="monsterClass" name="monster.class"><s:options-enumeration enum="com.muni.fi.pa165.enums.MonsterClass"/></s:select>
                    </div>
                </div>

                <div class="form-group">
                <s:label for="description" class="col-sm-2 control-label" title="monster.description"/>
                <div class="col-sm-10">
                    <s:textarea class="form-control" name="monster.description" rows="3" id="description"/>
                </div>
            </div>

            <div class="form-group">
                <s:label for="imagePath" class="col-sm-2 control-label" title="monster.image"/>
                <div class="col-sm-10">
                    <s:text name="monster.imagePathx" class="form-control" id="imagePath" />
                </div>
            </div>
        </div>