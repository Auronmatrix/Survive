<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<s:errors/> 


        <div class="form-group">
            <div class="form-group">
                <s:label for="inputName"  class="col-sm-2 control-label" title="monster.name" />
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="ienputPassword3" placeholder="Add monster name">
                </div>
            </div>
            <div class="form-group">
                <s:label for="inputStamina" class="col-sm-2 control-label" title="monster.stamina" />
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="inputStamina"  min="0" max="100" step="1">
                </div>
            </div>
            <div class="form-group">
                <s:label for="inputHeight" class="col-sm-2 control-label"  title="monster.height"/>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="inputHeight"   min="0" max="100" step="1">
                </div>
            </div>
            <div class="form-group">
                <s:label for="inputStrength" class="col-sm-2 control-label" title="monster.strength"/>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="inputStrength"  min="0" max="100" step="1">
                </div>
            </div>
            <div class="form-group">
                <s:label for="inputAgility" class="col-sm-2 control-label" title="monster.agility"/>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="inputAgility"  min="0" max="100" step="1">
                </div>
            </div>
            <div class="form-group">
                <s:label for="inputDangerLevel" class="col-sm-2 control-label" title="monster.dangerLevel"/>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="inputDangerLevel"  min="0" max="100" step="1">
                </div>
            </div>
            <div class="form-group">
                <s:label for="inputWeight" class="col-sm-2 control-label" title="monster.weight"/>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="inputWeight"  min="0" max="100" step="1">
                </div>
            </div>
            <div class="form-group">
                <s:label for="inputClass" class="col-sm-2 control-label" title="monster.class"/>
                <div class="col-sm-10">
                    <s:select id="inputClass" name="monster.class"><s:options-enumeration enum="com.muni.fi.pa165.enums.MonsterClass"/></s:select>
                    </div>
                </div>

                <div class="form-group">
                <s:label for="inputDescription" class="col-sm-2 control-label" title="monster.description"/>
                <div class="col-sm-10">
                    <textarea class="form-control" rows="3" id="inputDescription"></textarea>
                </div>
            </div>

            <div class="form-group">
                <s:label for="inputImage" class="col-sm-2 control-label" title="monster.image"/>
                <div class="col-sm-10">
                    <input type="url" class="form-control" id="inputImage" >
                </div>
            </div>
        </div>



