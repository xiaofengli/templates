<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Test2Prod_Wizard</title>
  <link rel="stylesheet" href="/resources/css/jquery-ui-1.12.1/jquery-ui.css">
  <link rel="stylesheet" href="/resources/css/bulma-0.7.1/css/bulma.css">
  <link rel="stylesheet" href="/resources/css/tpw_style.css">
  <script src="/resources/js/jquery-3.3.1.min.js"></script>
  <script src="/resources/css/jquery-ui-1.12.1/jquery-ui.js"></script>

  <script>
  $( function() {
    $("#login_group_from" ).datepicker();
    $("#login_group_to" ).datepicker();
    
    $("#search_lock_from" ).datepicker();
    $("#search_lock_to" ).datepicker();
    
    $("#email_templates_from" ).datepicker();
    $("#email_templates_to" ).datepicker();
    
    $("#formula_fields_from" ).datepicker();
    $("#formula_fields_to" ).datepicker();
  } );
  
  
  <!--- form validation in js -->
  function submit() {
	
  }
  
  function display() {
	  
	  alert("display");
  }
  
  $(function() {
	  $("#test_server").focusout(function(){
	    $.ajax(
	    		{
	    			url: "customers", 
	    			headers: {
	    			        'Content-Type': 'application/x-www-form-urlencoded'
	    			},
	    			type: "GET", /* or type:"GET" or type:"PUT" */
	    			dataType: "json",
	    			success: function(result){
	    				    var str= "<p>" + result["ProdDBCustName"] + "</p><p>" +result["ProdDBURL"] + "</p>"
	    						$("#prod_server").html(str);
	    					 }
	    		}
	    );
	  });
  });
  </script>
</head>
<body>
 
 <div class="container  is-widescreen">
 
<section class="hero is-primary">
  <div class="hero-body">
    <div class="container">
      <h1 class="title">
        TestToProd Wizard
      </h1>
      <h2 class="subsubtitle">
      This is to eliminate tedious manual copying of Fields/Configurations/Settings/Templates from Customer's test site to the prod site
      </h2>
    </div>
  </div>
</section>
 
 
 <section class="center">
 <form action="/customers/form" method="post">
      <!-- ReactJS TODO call endpoint -->
      
      <div class="field">
 	  <div class="control">
      	<input type="text" id="test_server" placeholder="test server">
      		<div id="prod_server"><div>
      </div>
      </div>


      <div class="field">
  	  <div class="control has-icons-left has-icons-right">
  	  <input type="checkbox" id="datepicker" />
      <label class="checkbox">  Login Group </label>
        <input type="text" id="login_group_from" name="login_group_from" />
        <input type="text" id="login_group_to" name="login_group_to" />
      </div>
      </div>
      
       <div class="field">
  		<div class="control has-icons-left has-icons-right">
  		<input type="checkbox" id="datepicker" /> 
        <label class="checkbox">Search Locks</label>
        <input type="text" id="search_lock_from" name="search_lock_from" />
        <input type="text" id="search_lock_to" name="search_lock_to" />
      </div>
      </div>
      
        
       <div class="field">
  		<div class="control has-icons-left has-icons-right">
  		<input type="checkbox" id="datepicker" />
        <label class="checkbox">Email Templates</label>
        <input type="text" id="email_templates_from" name="email_templates_from" />
        <input type="text" id="email_templates_to" name="email_templates_to" />
       </div>
       </div>
       
        <div class="field">
		<div class="control has-icons-left has-icons-right">
		<input type="checkbox" id="datepicker" /> 
        <label class="checkbox">Formula Fields</label>
        <input type="text" id="formula_fields_from" name="formula_fields_from" />
        <input type="text" id="formula_fields_to" name="formula_fields_to" />
        </div>
        </div>
       
       <div class="field is-grouped">
  <p class="control">
    <input type="submit" value="submit" class="button is-primary">
     
  </p>
  <p class="control">
    <input type="cancel" value="cancel" class="button is-light">
     
    
  </p>
</div>
 </form>
</section>
 </div>
 
</body>
</html>