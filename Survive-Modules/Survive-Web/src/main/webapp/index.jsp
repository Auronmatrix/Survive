<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<s:layout-render name="/layout.jsp" titlekey="index.title">
    <s:layout-component name="body">

        <h1 style="text-align: center">Post Apocalyptic 2165 - Systems Utility for Recording and Virtual Indexing of Violent Enemies</h1>
        <div style="text-align: center">
            <p>A handful of survivals must defend themselves against these creatures. There are available various kinds of weapons, each weapon has different usability against some monster. This system should enable storing information about monsters (name, height, weight, agility, ...), areas where the monsters live (name, description, area) and available weapons (name, gun-reach, ammunition used).</p>
            <p>Administrator of the system should be able to perform CRUD operations on all entities. Ordinary user will use this system to record his experience which weapon could be efficiently used against the monster as well as to assign areas where the creature has been spotted.</p>
        </div>

       

        <!-- Main jumbotron for a primary marketing message or call to action -->
<!--        <div >
            <p><a href="#" class="btn btn-primary btn-lg" role="button">Help human kind survive, log in and contribute today &raquo;</a></p>
        </div>-->
        
         <div class="row">
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <img src="docs-assets/images/monsters.png" alt="Monsters" width="400" height="400"/>
                    <div class="caption">
                        <h3>Monster Management</h3>
                        <p>Access monster logs and classification files. Update spotted monsters</p>
                        <p><s:link beanclass="com.muni.fi.pa165.monster.MonsterActionBean" class="btn btn-primary">Access Monster Files</s:link></p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <img src="docs-assets/images/areas.png" alt="Area" width="400" height="400"/>
                    <div class="caption">
                        <h3>Area Management</h3>
                        <p>Access current humanly safe locations and their respective threat analysis/p>
                        <p><a href="#" class="btn btn-primary" role="button">Access Area Files</a></p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <img src="docs-assets/images/weapons.png" alt="Weapons" width="400" height="400"/>
                    <div class="caption">
                        <h3>Weapon Management</h3>
                        <p>Access custom built weapons and efficiency logs to see which weapons kicks a punch</p>
                        <p><a href="#" class="btn btn-primary" role="button">Access Weapon Files</a></p>
                    </div>
                </div>
            </div>
        </div>

    </s:layout-component>
</s:layout-render>
