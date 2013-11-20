<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<s:errors/>
<table>
    <tr>
        <th><s:label for="b1" name="monster.name"/></th>
        <td><s:text id="b1" name="monster.name"/></td>
    </tr>
    <tr>
        <th><s:label for="b2" name="monster.agility"/></th>
        <td><s:text id="b2" name="monster.agility"/></td>
    </tr>
    <tr>
        <th><s:label for="b3" name="monster.strength"/></th>
        <td><s:checkbox id="b3" name="monster.strength"/></td>
    </tr>
    <tr>
        <th><s:label for="b4" name="monster.class"/></th>
        <td><s:select id="b4" name="monster.class"><s:options-enumeration enum="com.muni.fi.pa165.enums.MonsterClass"/></s:select></td>
    </tr>
    <tr>
        <th><s:label for="b5" name="monster.size"/></th>
        <td><s:text id="b5" name="monster.size" size="4"/></td>
    </tr>
</table>