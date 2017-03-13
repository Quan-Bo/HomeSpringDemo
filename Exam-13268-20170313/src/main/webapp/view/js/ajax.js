 var xmlHttp = null;
 var usernameFlag=false;
 var mailFlag=false;
 var telFlag=false;
 function createXMLHttpRequest() {
   if (xmlHttp == null) {
     if (window.XMLHttpRequest) {
        //Mozilla 浏览器
        xmlHttp = new XMLHttpRequest();
        } else if (window.ActiveXObject) {
           // IE浏览器
          try {
             xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
              } catch (e) {
                 try {
                     xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e) {
                     //alert('创建失败');
             }
         }
       }
   }
}
function openAjax() {
   if (xmlHttp == null) {
      createXMLHttpRequest();
      if (xmlHttp == null) {
          return;
       }
    }
   var val = document.getElementById("userNm").value;
   xmlHttp.open("get", "RegeditManager?Uname=" + val, true);
   xmlHttp.onreadystatechange = xmlHttpChange;
   xmlHttp.send(null);
   
}
function xmlHttpChange() {
  if (xmlHttp.readyState == 4) {
     if (xmlHttp.status == 200) {
        var res = xmlHttp.responseText;
        if (res ==1) {
          document.getElementById("username").innerHTML = "<font color='red'>该用户名已存在</font>";
         }
        else{
        	   document.getElementById("username").innerHTML = "";
          usernameFlag=true;
        }
      }
    }
  } 

function MailAjax() {
	   if (xmlHttp == null) {
	      createXMLHttpRequest();
	      if (xmlHttp == null) {
	          return;
	       }
	    }
	  
	   var val = document.getElementById("email").value;
	   xmlHttp.open("get", "RegeditManager?mailAjax=" + val, true);
	   xmlHttp.onreadystatechange = xmlHttpChangeMail;
	   xmlHttp.send(null);
	}
function xmlHttpChangeMail() {
	  if (xmlHttp.readyState == 4) {
	     if (xmlHttp.status == 200) {
	        var res = xmlHttp.responseText;
	        if (res ==1) {
	            document.getElementById("mail").innerHTML = "<font color='red'>该邮箱已被注册</font>";
	        	mailFlag=false;
	         }
	        else{
	        	 document.getElementById("mail").innerHTML = "";
	        	mailFlag=true;
	        }
	      }
	    }
	  } 

function TelAjax() {
		   if (xmlHttp == null) {
		      createXMLHttpRequest();
		      if (xmlHttp == null) {
		          return;
		       }
		    }
		   var val = document.getElementById("tel").value;
		   xmlHttp.open("get", "RegeditManager?TelAjax=" + val, true);
		   xmlHttp.onreadystatechange = xmlHttpChangeTel;
		   xmlHttp.send(null);
		}
	
function xmlHttpChangeTel() {
		  if (xmlHttp.readyState == 4) {
		     if (xmlHttp.status == 200) {
		        var res = xmlHttp.responseText;
		        if (res ==1) {
		          document.getElementById("phoneNumber").innerHTML = "<font color='red'>该手机号已存在</font>";
		         }
		        else{
		         document.getElementById("phoneNumber").innerHTML = "";
		         telFlag=true;
		        }
		      }
		    }
		  } 



function IsNullMailAjax() {
	   if (xmlHttp == null) {
	      createXMLHttpRequest();
	      if (xmlHttp == null) {
	          return;
	       }
	    }
	   var val = document.getElementById("email").value;
	   xmlHttp.open("get", "RegeditManager?mailAjax=" + val, true);
	   xmlHttp.onreadystatechange = xmlHttpChangeIsNullMail;
	   xmlHttp.send(null);
	}
function xmlHttpChangeIsNullMail() {
	  if (xmlHttp.readyState == 4) {
	     if (xmlHttp.status == 200) {
	        var res = xmlHttp.responseText;
	        if (res ==1) {
	            document.getElementById("mail").innerHTML = "";
	        	mailFlag=true;
	         }
	        else{
	        	document.getElementById("mail").innerHTML = "<font color='red'>该邮箱在本系统不存在</font>";
	        	mailFlag=false;
	        }
	      }
	    }
	  } 