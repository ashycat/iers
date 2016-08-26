<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title page-title></title>
    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <!--<link rel="shortcut icon" type="image/ico" href="favicon.ico" />-->

    <!-- build:css(.) styles/vendor.css -->
    <!-- bower:css -->

    <link rel="stylesheet" href="bower_components/angular-notify/dist/angular-notify.min.css" />
    <link rel="stylesheet" href="bower_components/fontawesome/css/font-awesome.css" />
    <link rel="stylesheet" href="bower_components/metisMenu/dist/metisMenu.css" />
    <link rel="stylesheet" href="bower_components/animate.css/animate.css" />
    <link rel="stylesheet" href="bower_components/sweetalert/lib/sweet-alert.css" />
    <link rel="stylesheet" href="bower_components/fullcalendar/dist/fullcalendar.min.css" />
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.css" />
    <link rel="stylesheet" href="bower_components/summernote/dist/summernote.css" />
    <link rel="stylesheet" href="bower_components/ng-grid/ng-grid.min.css" />
    <link rel="stylesheet" href="bower_components/angular-ui-tree/dist/angular-ui-tree.min.css" />
    <link rel="stylesheet" href="bower_components/angular-ui-select/dist/select.css" />
    <link rel="stylesheet" href="bower_components/angular-bootstrap-datetimepicker/src/css/datetimepicker.css"/>
    <link rel="stylesheet" href="bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css" />
    <link rel="stylesheet" href="bower_components/datatables_plugins/integration/bootstrap/3/dataTables.bootstrap.css" />
    <link rel="stylesheet" href="bower_components/angular-xeditable/dist/css/xeditable.css" />
    <link rel="stylesheet" href="bower_components/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.css" />
    <link rel="stylesheet" href="bower_components/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" />
    <link rel="stylesheet" href="bower_components/blueimp-gallery/css/blueimp-gallery.min.css" />
    <link rel="stylesheet" href="bower_components/footable/css/footable.core.css" />
    <link href="bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
    <!-- Morris Charts CSS -->
    <!-- <link href="bower_components/morrisjs/morris.css" rel="stylesheet"> -->
    <!-- Custom Fonts -->
    <link href="bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">


    <!-- endbower -->
    <!-- endbuild -->

    <!-- build:css({.tmp,app}) styles/style.css -->
    <link rel="stylesheet" href="css/timeline.css" />
    <link rel="stylesheet" href="css/sb-admin-2.css" />
    <!--endbuild -->

</head>

<!-- Body -->
<body landing-scrollspy>
<!-- Simple splash screen-->
<div class="splash"> <div class="color-line"></div><div class="splash-title"><h1>보안예외 모니터링</h1><p>대쉬보드</p> </div> </div>
<!--[if lt IE 7]>
<p class="alert alert-danger">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->
    <!-- Page view wrapper -->
    <div ui-view autoscroll="true"></div>
    
<script data-main="js/app-init" src="bower_components/requirejs/require.js"></script>
</body>
</html>
