<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
        <link rel="apple-touch-icon" sizes="180x180" href="KJH_logo_icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="KJH_logo_icon.png">
        <link rel="icon" type="image/png" sizes="16x16" href="KJH_logo_icon.png">
        <link rel="manifest" href="https://i.morioh.com/favicon/site.webmanifest">
        <link rel="mask-icon" href="KJH_logo_icon.png" color="#262521">
        <link rel="shortcut icon" href="KJH_logo_icon.png">
        <meta name="msapplication-TileColor" content="#faa700">
        <meta name="theme-color" content="#ffffff">
    
        <meta property="og:title" content="Morioh Responsive Template with Bootstrap 4, HTML5 and Vue.js">
        <meta property="og:image" content="KJH_logo_icon.png">
        <meta property="og:description" content="Morioh Theme is Bootstrap responsive template free download">
        <meta property="og:image:width" content="1280">
        <meta property="og:image:height" content="720">
    
        <title>관리자 페이지</title>
        <meta itemprop="description" content="Morioh Theme is Bootstrap responsive template free download">
        <meta itemprop="image" content="KJH_logo_icon.png">
    
        <meta name="description" content="Morioh Theme is Bootstrap responsive template free download">
        <meta name="image" content="KJH_logo_icon.png">
    
    
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.11.2/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/perfect-scrollbar@1.4.0/css/perfect-scrollbar.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@mdi/font@4.7.95/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/animate.css@3.7.2/animate.min.css">
    
        <link rel="stylesheet" href="../../css/morioh.css">
    
    
    </head>
    
    <body class="menubar-enabled navbar-top-fixed">
    
        <div class="wrapper">
    
            <div class="main-navbar navbar-expand-md navbar-light bg-white fixed-top shadow-sm">
    
                <button class="btn d-md-none" type="button" data-toggle="collapse" data-target="#main-menu"
                    aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fas fa-bars"></i>
                </button>
    
    
                <img src="/Study_Platform/Admin_page/img/KJH_logo.png" title="Morioh" class="navbar-logo d-md-none"
                    style="height: 36px;">
    
    
                <button class="btn d-md-none" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fas fa-bars"></i>
                </button>
    
    
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto hidden-sm-down">
    
                        <li class="nav-item mr-5">
                            <a href="javascript://" class="nav-icon font-2xl" id="navbar-toggler">
    
                                <i class="mdi mdi-menu"></i>
                            </a>
                        </li>
    
                        <li class="nav-item">
                            <form class="form-inline">
                                <div class="input-group">
                                    <input class="form-control" type="search" placeholder="Search" aria-label="Search">
    
                                    <button class="btn btn-outline-primary" type="button">
                                        <i class="fas fa-search"></i>
                                    </button>
                            </form>
                        </li>
    
                    </ul>
    
    
                    <ul class="navbar-nav my-2 my-lg-0">
    
                        <li class="nav-item mr-10 dropdown">
                            <a href="#" class="nav-icon avatar rounded-circle" id="PJXN7R" role="button"
                                data-toggle="dropdown" aria-expanded="false">
                                <i class="mdi mdi-account"></i>
                            </a>
    
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="PJXN7R">
                                <a class="dropdown-item" href="#">
                                    <i class="mdi mdi-account-circle-outline"></i>내 정보</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#"><i class="mdi mdi-exit-to-app"></i>로그아웃</a>
                            </div>
                        </li>
    
                        <li class="nav-item dropdown">
                            <a class="nav-icon font-2xl rounded-circle" href="#" id="WJIK6R" role="button"
                                data-toggle="dropdown" aria-expanded="false">
    
                                <i class="mdi mdi-dots-horizontal"></i>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="WJIK6R">
                                <a class="dropdown-item" href="#">회원페이지 이동</a>
                            </div>
                        </li>
                    </ul>
    
                </div>
            </div>
    
            <div class="menubar menubar-dark" id="main-menu">
    
                <div class="menubar-header text-center bg-dark">
                    <a class="menubar-brand" href="https://morioh.com">
                        <img src="/Study_Platform/Admin_page/img/KJH_logo.png" title="BTMClass" class="menubar-logo"
                            style="height: 50px;">
                    </a>
                </div>
    
                <div class="menubar-body">
                    <ul class="menu accordion">
                        <li class="menu-item">
                            <a href="javascript://" class="menu-link" data-toggle="collapse" data-target="#menu-90ba1a"
                                aria-expanded="true" aria-controls="menu-90ba1a">
                                <i class="menu-icon mdi mdi-movie"></i>
                                <span class="menu-label">강좌 정보</span>
                                <i class="menu-arrow mdi mdi-chevron-right"></i>
                            </a>
    
                            <ul class="menu collapse" data-parent="#main-menu" id="menu-90ba1a">
                                <li class="menu-item">
                                    <a href="/Study_Platform/Admin_page/preview/light/summary_Information.jsp" class="menu-link">
                                        <i class="menu-icon mdi mdi-circle-slice-3"></i>
                                        <span class="menu-label">요약 정보</span>
                                    </a>
                                </li>
    
                                <li class="menu-item">
                                    <a href="/Study_Platform/Admin_page/preview/light/course_Settings.jsp" class="menu-link">
                                        <i class="menu-icon mdi mdi-cogs"></i>
                                        <span class="menu-label">강좌 설정</span>
                                    </a>
                                </li>
    
                                <li class="menu-item">
                                    <a href="/Study_Platform/Admin_page/preview/light/activity_Record.jsp" class="menu-link">
                                        <i class="menu-icon mdi mdi-file-cabinet"></i>
                                        <span class="menu-label">강좌 활동 기록</span>
                                    </a>
                                </li>
                            </ul>
    
                        </li>
    
                        <li class="menu-item">
                            <a href="javascript:void(0)" class="menu-link" data-toggle="collapse" data-target="#menu-1fc88e"
                                aria-expanded="true" aria-controls="menu-1fc88e">
                                <i class="menu-icon mdi mdi-view-split-vertical"></i>
                                <span class="menu-label">수업 컨텐츠</span>
                                <i class="menu-arrow mdi mdi-chevron-right"></i>
                            </a>
                            <ul class="menu collapse" data-parent="#main-menu" id="menu-1fc88e">
    
    
                                <li class="menu-item">
                                    <a href="/Study_Platform/Admin_page/preview/light/chapter_Pages.jsp" class="menu-link">
                                        <i class="menu-icon mdi mdi-format-list-bulleted-square"></i>
                                        <span class="menu-label">교육과정</span>
                                    </a>
                                </li>
    
                                <li class="menu-item">
                                    <a href="/Study_Platform/Admin_page/preview/light/lecture_QA.jsp" class="menu-link">
                                        <!-- <i class="menu-icon fas fa-magic"></i> -->
                                        <i class="menu-icon mdi mdi-help-circle"></i>
                                        <span class="menu-label">Q&A</span>
                                        <span class="menu-badge">
                                            <span class="badge bg-info">3</span>
                                        </span>
            
                                    </a>
                                </li>
                            </ul>
                        </li>
    
                        <li class="menu-item">
                            <a href="javascript://" class="menu-link" data-toggle="collapse" data-target="#menu-96b24e"
                                aria-expanded="true" aria-controls="menu-96b24e">
                                <!-- <i class="menu-icon fas fa-tasks"></i> -->
                                <i class="menu-icon mdi mdi-format-float-left"></i>
                                <span class="menu-label">문제 및 시험관리</span>
                                <i class="menu-arrow mdi mdi-chevron-right"></i>
                            </a>
    
                            <ul class="menu collapse" data-parent="#main-menu" id="menu-96b24e">
    
                                <li class="menu-item">
                                    <a href="/Study_Platform/Admin_page/preview/light/problem_Manage.jsp" class="menu-link">
                                        <i class="menu-icon mdi mdi-file-document-edit-outline"></i>
                                        <span class="menu-label">문제 관리</span>
                                    </a>
                                </li>
    
                                <li class="menu-item">
                                    <a href="/Study_Platform/Admin_page/preview/light/update.jsp" class="menu-link">
                                        <i class="menu-icon mdi mdi-format-list-numbered"></i>
                                        <span class="menu-label">시험/과제 목록</span>
                                    </a>
                                </li>
    
                                <li class="menu-item">
                                    <a href="/Study_Platform/Admin_page/preview/light/update2.jsp" class="menu-link">
                                        <i class="menu-icon mdi mdi-file-document-outline"></i>
                                        <span class="menu-label">시험/과제 결과 관리</span>
                                    </a>
                                </li>
    
                                <li class="menu-item">
                                    <a href="/Study_Platform/Admin_page/preview/light/update3.jsp" class="menu-link">
                                        <i class="menu-icon mdi mdi-monitor"></i>
                                        <span class="menu-label">실시간 시험 현황</span>
                                    </a>
                                </li>
    
                            </ul>
                        </li>
    
                        <li class="menu-item">
                            <a href="#" class="menu-link" data-toggle="collapse" data-target="#menu-62d0a7"
                                aria-expanded="true" aria-controls="menu-62d0a7">
                                <i class="menu-icon mdi mdi-account-multiple"></i>
    
                                <span class="menu-label">수강자 관리</span>
                                <i class="menu-arrow mdi mdi-chevron-right"></i>
                            </a>
    
                            <ul class="menu collapse" data-parent="#main-menu" id="menu-62d0a7">
    
                                <li class="menu-item">
                                    <a href="./MemberListController.me" class="menu-link">
                                        <i class="menu-icon mdi mdi-school"></i>
                                        <span class="menu-label">수강자 관리</span>
                                    </a>
                                </li>
    
                                <li class="menu-item">
                                    <a href="/Study_Platform/Admin_page/preview/light/update5.jsp" class="menu-link">
                                        <i class="menu-icon mdi mdi-hand"></i>
                                        <span class="menu-label">출석 관리</span>
                                    </a>
                                </li>
    
                                <li class="menu-item">
                                    <a href="/Study_Platform/Admin_page/preview/light/update.jsp" class="menu-link">
                                        <i class="menu-icon mdi mdi-monitor"></i>
                                        <span class="menu-label">온라인 튜터링</span>
                                    </a>
                                </li>
    
                            </ul>
                        </li>
    
    
                        <li class="menu-item">
                            <a href="javascript://" class="menu-link" data-toggle="collapse" data-target="#menu-40ebea"
                                aria-expanded="true" aria-controls="menu-40ebea">
                                <i class="menu-icon mdi mdi-pencil"></i>
                                <!-- <i class="menu-icon fas fa-vector-square"></i> -->
                                <span class="menu-label">성적 관리</span>
                                <i class="menu-arrow mdi mdi-chevron-right"></i>
                            </a>
    
                            <ul class="menu collapse" data-parent="#main-menu" id="menu-40ebea">
                                <li class="menu-item">
                                    <a href="/Study_Platform/Admin_page/preview/light/update.jsp" class="menu-link">
                                        <i class="menu-icon mdi mdi-flag-variant"></i>
                                        <span class="menu-label">성취도 보기</span>
                                    </a>
                                </li>
    
                                <li class="menu-item">
                                    <a href="/Study_Platform/Admin_page/preview/light/update.jsp" class="menu-link">
                                        <i class="menu-icon mdi mdi-clipboard"></i>
                                        <span class="menu-label">성적 보고서</span>
                                    </a>
                                </li>
    
                            </ul>
                        </li>
    
                    </ul>
                </div>
    
                <div class="menubar-footer bg-dark p-10">
                    <a href="#" class="d-block text-truncate">&copy KJHClass <span id="version"></span></a>
                </div>
    
            </div>


        <div class="container-fluid mt-15">

            <div class="card mb-15">
                <div class="card-body">
                    <h4 class="card-title"><b>업데이트 준비중...</b></h4>
                    <div class="row">
                        <div class="col-12">
                                <div class="col-12">
                                      <div class="row no-gutters">
                                        <div class="col-12">
                                          <div class="card-body">
                                          </div>
                                        </div>
                                      </div>
                                  </div>
                              </div>
                        </div>
               </div>
              </div>
        </div>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.min.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/perfect-scrollbar@1.4.0/dist/perfect-scrollbar.min.js"></script>


    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-50750921-19"></script>
    <script>
        window.dataLayer = window.dataLayer || [];
        function gtag() { dataLayer.push(arguments); }
        gtag('js', new Date());

        gtag('config', 'UA-50750921-19');
    </script>



    <script src="../../js/morioh.js"></script>


</body>

</html>