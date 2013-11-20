<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<s:layout-definition>
    <!DOCTYPE html>
    <html lang="${pageContext.request.locale}">
        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta name="description" content="">
            <meta name="author" content="">
            <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

            <title><f:message key="${titlekey}"/></title>
            <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript">
                $(document).ready(function() {
                    $('ul.nav > li').click(function(e) {
                        e.preventDefault();
                        $('ul.nav > li').removeClass('active');
                        $(this).addClass('active');
                    });
                }
            </script>

            <!-- Bootstrap core CSS -->
            <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
            <!-- Bootstrap theme -->
            <link href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" rel="stylesheet">

            <!-- Custom styles for this template -->
            <link href="theme.css" rel="stylesheet">

            <!-- Just for debugging purposes. Don't actually copy this line! -->
            <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

            <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
            <!--[if lt IE 9]>
              <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
              <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
            <![endif]-->


            <s:layout-component name="header"/>

        </head>


        <body>

            <!-- Fixed navbar -->
            <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">PROJECT SURVIVE</a>
                    </div>
                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">

                            <!-- Aubrey: If there is time, try to fix the active LI item to highlight which menu is currently active. Do do so set li class="active" -->
                            <li ><a href="index.jsp"><f:message key="navigation.index"/></a></li>
                            <li ><a href="template.jsp"><f:message key="navigation.template"/></a></li>
                            <li ><a href="signin.jsp"><f:message key="navigation.signin"/></a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><f:message key="navigation.dropdown"/><b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><s:link beanclass="com.muni.fi.pa165.monster.MonsterActionBean"><f:message key="navigation.monstermanagement"/></s:link></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li class="divider"></li>
                                    <li class="dropdown-header">Nav header</li>
                                    <li><a href="#">Separated link</a></li>
                                    <li><a href="#">One more separated link</a></li>
                                </ul>
                            </li>
                        </ul>
<!--                                Aubrey: Could be form for login-->
<!--                        <form class="navbar-form navbar-left" role="search">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Search">
                            </div>
                            <button type="submit" class="btn btn-default">Submit</button>
                        </form>-->
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="logout.jsp"><span class="glyphicon glyphicon-off"></span>&nbsp;<f:message key="navigation.logout"/></a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>

            <div class="container theme-showcase">

                <!-- Main jumbotron for a primary marketing message or call to action -->
                <div class="jumbotron">
                    <!--        <h1>Post Apocalyptic 2165 - Systems Utility for Recording and Virtual Indexing of Violent Enemies</h1>
                            <p><a href="#" class="btn btn-primary btn-lg" role="button">Help human kind survive, contribute today &raquo;</a></p>-->
                </div>


                <div id="content">
                    <s:messages/>
                    <s:layout-component name="body"/>
                </div>

            </div> <!-- /container -->


            <!-- Bootstrap core JavaScript
            ================================================== -->
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="../docs-assets/js/holder.js"></script>
        </body>
    </html>
</s:layout-definition>