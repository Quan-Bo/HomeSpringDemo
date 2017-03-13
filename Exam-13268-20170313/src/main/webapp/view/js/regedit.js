function wol(){
var mydateInput = document.getElementById("mydate");
var date = new Date();
var month=date.getMonth()+1;
var day=date.getDate();
if((date.getMonth()+1)<10){
	month="0"+month;
}
if((date.getDate())<10){
	day="0"+day;
}


function DateTranForm(email){
	var date=email;
	var day=date.getDate();
	var month=date.getMonth()+1;
	if((date.getMonth()+1)<10){
		month="0"+month;
	}
	if((date.getDate())<10){
		day="0"+day;
	}
	var date=date.getYear()+"-"+month+"-"+day;
	return date;
}

var dateString = date.getFullYear()+"-"+month+"-"+day;
mydateInput.value=dateString;
}


function showDesc(obj)
{  
   var id= obj.name;
   document.getElementById(id).innerHTML="";
}
//输入框失去焦点时检验输入内容是否有效
function checkText(obj)
{
   //获取输入框的id值
   var id= obj.name;
   var text=obj.value;
   //判断是否为空
   if(text==""||text==null)
   {
     document.getElementById(id).style.display="inline";
     document.getElementById(id).innerHTML="<font color='red'>输入不能为空</font>";
      return false;
   }
   else
   {
     var firstChar=id.charAt(0).toString().toUpperCase();
     var strsub=id.substring(1,id.length);
     var strMethod="check"+firstChar+strsub+"()";
     var isTrue = eval(strMethod);
     if(isTrue)
     {
        document.getElementById(id).innerHTML="";
        return true;
     }
     else{
        return false;
     }
   }   
} 

function checkUsername()
{
    //只简单的判断用户名的长度
    var id = document.getElementById("userNm");
    var expr=/^[A-Za-z0-9_]{6,15}$/;
    var username=id.value; 
    if(!expr.test(username))
    {
      document.getElementById(id.name).innerHTML = "<font color='red'>由字母、数字或“-”组成的6-15位字符</font>";
      return false;
    } 
    else{
    	if(username.length>15){
    		 document.getElementById(id.name).innerHTML = "<font color='red'>由字母、数字或“-”组成的6-15位字符</font>";
    	      return false;
    	}else{
    		openAjax();
    	     if(usernameFlag){
    	      return true;
    	     }
    	     else{
    	      return false;
    	     }
    	}
    }
}

function checkRealName(){
  var id = document.getElementById("rname");
  var realname=id.value;
  var expr=/^[0-9]*$/;
  if(!expr.test(realname)){
      var len = 0;  
      for (var i=0; i<realname.length; i++) {  
        if (realname.charCodeAt(i)>127 || realname.charCodeAt(i)==94) {  
          len += 2;  
          }
        else {  
          len ++;  
          }  
       }  
       if(len<=8){
        return true;
       }
       else{
           document.getElementById(id.name).innerHTML ="<font color='red'>最多四个汉字或8个字符的非数字字符串</font>";
           return false;
       }
  }
  else{
    document.getElementById(id.name).innerHTML ="<font color='red'>最多四个汉字或8个字符的非数字字符串</font>";
    return false;
  }
}


function checkPassword()
{
	  var id=document.getElementById("pwd1");
	  var password1=id.value;
	  if(password1.length<15){
		  if(password1.length>5){
			  document.getElementById(id.name).innerHTML="";
			  return true;
		  }
		  else{
			  document.getElementById(id.name).innerHTML="<font color='red'>密码长度在5~10中间的数字和字母的组合</font>";
			  return false;
		  }
	  }
	  else{
		  document.getElementById(id.name).innerHTML="<font color='red'>密码长度在5~10中间的数字和字母的组合</font>";
		  return false;
	  }
	  
    return true;
}

function checkPassword2()
{
     var id=document.getElementById("pwd1");
     var id2=document.getElementById("pwd2");
     var password = id.value;    
     var password2 = id2.value;
     if(password==password2)
     {
       document.getElementById(id.name).innerHTML="";
        return true;
     }else{
       document.getElementById(id.name).innerHTML="<font color='red'>密码不一致</font>";
      return false;  
     }      
}

function checkPhoneNumber()
{
// 利用正则表达式对输入数据匹配
   var id=document.getElementById("tel");
   var phone = id.value;     
//匹配到一个非数字字符，则返回false 
   var expr = /^1[34578]\d{9}$/;
   if(!expr.test(phone))
   {
      document.getElementById(id.name).innerHTML="<font color='red'>请输入正确的手机号</font>";
      return false;
   }else{
	     TelAjax();
	     if(telFlag){
	      return true;
	     }
	     else{
	      return false;
	     }
	   
//     return true;
   } 
}
function checkMail()
{
// 利用正则表达式对输入数据匹配
   var id = document.getElementById("email");
   var email = id.value;
   var expr = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
   if(!expr.test(email))
   {
      document.getElementById(id.name).innerHTML="<font color='red'>请输入正确的邮箱</font>";
      return false;
   }else{
	     MailAjax();
	     if(mailFlag){
	      return true;
	     }
	     else{
	      return false;
	     }
     }
}

function checkInput(){
  if(checkText(document.getElementById("userNm"))&checkText(document.getElementById("pwd1"))&
    checkText(document.getElementById("pwd2"))&checkText(document.getElementById("rname"))&
    checkText(document.getElementById("tel"))&checkText(document.getElementById("email"))){
    return true;
  }
   return false;
}

function isEmpltyEmail(){
	   var id = document.getElementById("email");
	   var email = id.value;
	   if(email==""||email==null)
	   {
	     document.getElementById(id.name).style.display="inline";
	     document.getElementById(id.name).innerHTML="<font color='red'>输入不能为空</font>";
	      return false;
	   }
	   else
	   {
		   var expr = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		   if(!expr.test(email))
		   {
			   document.getElementById(id.name).innerHTML="<font color='red'>请输入正确的邮箱</font>";
			      return false;
		   }
		   else{
			   IsNullMailAjax();
			   if(mailFlag){
				   document.getElementById("mail").innerHTML = "";
				      return true;
				     }
				     else{
				   document.getElementById("mail").innerHTML = "<font color='red'>该邮箱在本系统不存在</font>";
				      return false;
				     }
		     }
	    }
}

function isEmail(){
	 var id = document.getElementById("email");
	   var email = id.value;
	   if(email==""||email==null)
	   {
	     document.getElementById(id.name).style.display="inline";
	     document.getElementById(id.name).innerHTML="<font color='red'>输入不能为空</font>";
	      return false;
	   }
	   else
	   {
		   var expr = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		   if(!expr.test(email))
		   {
			   document.getElementById(id.name).innerHTML="<font color='red'>请输入正确的邮箱</font>";
			      return false;
		   }
		   else{
			   document.getElementById(id.name).innerHTML="";
			   return true;
		   }
	   }
}

function IsPhoneNumber()
{
// 利用正则表达式对输入数据匹配
   var id=document.getElementById("tel");
   var phone = id.value;     
//匹配到一个非数字字符，则返回false 
   var expr = /^1[34578]\d{9}$/;
   if(!expr.test(phone))
   {
      document.getElementById(id.name).innerHTML="<font color='red'>请输入正确的手机号</font>";
      return false;
   }else{
	   document.getElementById(id.name).innerHTML="";
      return true;
   } 
}

function IsUserName()
{
	 var id = document.getElementById("userNm");
	    var expr=/^[A-Za-z0-9_]{6,30}$/;
	    var username=id.value; 
	    if(!expr.test(username))
	    {
	      document.getElementById(id.name).innerHTML = "<font color='red'>由字母、数字或“-”组成的6-18位字符</font>";
	      return false;
	    } 
	    else{
	    	 document.getElementById(id.name).innerHTML = "";
	      return true;
	    }
}

function checkIsInput(){
	if(IsUserName()&checkText(document.getElementById("rname"))&
			isEmail()&IsPhoneNumber()){
		    return true;
		  }
		   return false;
}

function isNullPwd(){
	if(checkText(document.getElementById("pwd1"))&checkText(document.getElementById("pwd2"))){
		return true;
	}
	else{
		return false;
	}
}


