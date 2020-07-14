<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">


    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>NEM Construction : Home</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"
        integrity="sha384-PmY9l28YgO4JwMKbTvgaS7XNZJ30MK9FAZjjzXtlqyZCqBY6X6bXIkM++IkyinN+" crossorigin="anonymous">

    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="/images/Logo.png">
    <!-- Font Awesome -->
    <link href="/css/font-awesome.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="/css/slick.css" />
    <!-- Fancybox slider -->
    <link rel="stylesheet" href="/css/jquery.fancybox.css" type="text/css"
        media="screen" />
    <!-- Animate css -->
    <link rel="stylesheet" type="text/css" href="/css/animate.css" />
    <!-- Progress bar -->
    <link rel="stylesheet" type="text/css" href="/css/bootstrap-progressbar-3.3.4.css" />
    <!-- Theme color -->
    <link id="switcher" href="/css/theme-color/default-theme.css" rel="stylesheet">

    <!-- Main Style -->
    <link href="/css/style.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="/css/font-awesome.min.css" rel='stylesheet'
        type='text/css'>
    <!-- Open Sans for body font -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
    <!-- Lato for Title -->
    <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>

</head>

<style>
.callout {
    position: fixed;
    bottom: 75%;
    right: 40%;
    max-width: 300px;

}

.callout-header {
    padding: 25px 15px;
    background: #555;
    font-size: 30px;
    color: white;
}

.callout-container {
    padding: 15px;
    font-size: 16px;
}

.closebtn {
    position: absolute;
    top: 5px;
    right: 15px;
    color: white;
    font-size: 24px;
    cursor: pointer;
}

.closebtn:hover {
    color: lightgrey;
}
.
</style>

<body>

    <!-- BEGAIN PRELOADER -->
    <div id="preloader">
        <div id="status">&nbsp;</div>
    </div>
    <!-- END PRELOADER -->

    <!-- SCROLL TOP BUTTON -->
    <a class="scrollToTop"><i class="fa fa-angle-up"></i></a>
    <!-- END SCROLL TOP BUTTON -->

    <!-- Start login modal window -->
    <div aria-hidden="false" role="dialog" tabindex="-1" id="login-form" class="modal leread-modal fade in">
        <div class="modal-dialog">

            <!-- Start login section -->

            <div id="login-content" class="modal-content">
                <div class="modal-header">
                    <button aria-label="Close" data-dismiss="modal" class="close" type="button">
                    <span aria-hidden="true">×</span></button>
                    <h4 class="modal-title"><i class="fa fa-unlock-alt"></i>Login</h4>
                </div>
                <div class="modal-body">
                    <form method="POST" action="/login" accept-charset="utf-8">
                    <span>${message}</span>
	                    <div class="form-group">
	                        <input type="text" placeholder="User Name" class="form-control" name="username" required>
	                    </div>
	                    <div class="form-group">
	                        <input type="password" placeholder="Password" class="form-control" name="password" required>
	                    </div>
	                    <span>${error}</span>
	                    <div class="loginbox">
	                        <button class="btn signin-btn" type="submit">SIGN IN</button>
	                    </div>
                    </form>               
                </div>

            </div>
            
            <!-- End login section -->

        </div>
    </div>
    <!-- End login modal window -->

    <!-- BEGIN MENU -->
    <section id="menu-area">
        <nav class="navbar navbar-default" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <!-- FOR MOBILE VIEW COLLAPSED BUTTON -->
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    </button>
                </div>

            </div>
        </nav>
    </section>
    <!-- END MENU -->

    <!-- Start slider -->
    <section id="slider">
        <div class="main-slider">
            <div class="single-slide">
                <img src="/images/Poster.jpg" alt="img">
                <div class="slide-content">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-6 col-sm-6">
                                <div class="slide-article">
                                    <h1 class="wow fadeInUp" data-wow-duration="0.7s" data-wow-delay="0.5s">
                                    	<font size="6">Welcome to the Insurance & Guarantee Document Management System</font></h1>
                                    <p class="wow fadeInUp" data-wow-duration="0.7s" data-wow-delay="0.75s">Powered by
                                        NEM-ERP Engineering & Research Unit
                                        <br>
                                        <br>
                                        <a style="color:#ff9900; font-size:26px" class="login modal-form"
                                            data-target="#login-form" data-toggle="modal"
                                            href="#login-form">
                                            ENTRY
                                        </a>

                                    </p>
                                </div>

                            </div>
                            <div class="col-md-6 col-sm-6">
                                <div class="slider-img wow fadeInUp">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- End slider -->

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <!-- Bootstrap -->
    <script src="/js/bootstrap.js"></script>
    <!-- Slick Slider -->
    <script type="text/javascript" src="/js/slick.js"></script>
    <!-- mixit slider -->
    <script type="text/javascript" src="/js/jquery.mixitup.js"></script>
    <!-- Add fancyBox -->
    <script type="text/javascript" src="/js/jquery.fancybox.pack.js"></script>
    <!-- counter -->
    <script src="/js/waypoints.js"></script>
    <script src="/js/jquery.counterup.js"></script>
    <!-- Wow animation -->
    <script type="text/javascript" src="/js/wow.js"></script>
    <!-- progress bar   -->
    <script type="text/javascript" src="/js/bootstrap-progressbar.js"></script>


    <!-- Custom js -->
    <script type="text/javascript" src="/js/custom.js"></script>

    <script>
    var timeout = 2000; // in miliseconds (3*1000)

    $('.callout').delay(timeout).fadeOut(1000);
    </script>

</body>

</html>
