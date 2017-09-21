$(document).ready(function(){
	$("#pro").hide();
	$(".warnning").hide();
	$(".tishi1").show();
	$(".tishi2").hide();
	// 智能联想
	$("#dep").hide();
	$("input[type='text'][name='Centralized']").keyup(function(){
	       $("#dep").show();
	       var Centralized=$("#Centralized").val(); 
	       if(Centralized != null&&Centralized != "")
	       {
	    	   $.ajax({
			   type: "POST",
			   url:"showCentralized",
			   async:false,
			   data:{"Centralized":Centralized},
			   success: function(msg) 
			   {
				   $("#dep").html("");
				   var tagvalue=msg.split(" ");
				   if(tagvalue!="")
					{
				   		$(tagvalue).each(function(i, dom){
					    	$("#dep").append("<li value='"+dom+"' class='list'>" + dom + "</li>");
				   		});
					}
				   
				}
			});
	    	}
	       else
	    	   {
	    	   	$("#dep").hide();
	    	   }
	   });
	$("#dep").on("click","li", function() {
     	var text=$(this).html();
     	$("#Centralized").val(text);
     	$("#dep").hide();
 	});
	$("#Centralized").blur(function(){
		setTimeout(function(){
			$("#dep").hide();
		},150);
	});
	// 所在地域
	$.ajax({
		   url:"showregional",
		   type:"GET",
		   datatype:"text",
		   success:function(data)
		   { 
		   	var str=data.split(",");
		   	var select=$("#regional");
		   	$(str).each(function(i,dom){
		   		select.append("<option value="+"'"+dom+"'"+">"+dom+"</option>");
		   	})
		   }
	   })
	// 经济三级菜单
	$.ajax({
		   url:"showfirstgdp",
		   type:"GET",
		   datatype:"text",
		   success:function(data)
		   { 
		   	var str=data.split(",");
		   	var select1=$("#tech1");
		   	$(str).each(function(i,dom){
		   		select1.append("<option value="+"'"+dom+"'"+">"+dom+"</option>");
		   	})
		   }
	   })
	$("#tech1").change(function(){
		  $("#tech2").html("").append("<option>"+"请选择"+"</option>")
		  $("#tech3").html("").append("<option>"+"请选择"+"</option>")
	      var str1 = $(this).val();
	      $.ajax({
	      	url:"showsecondgdp",
	      	type:"GET",
	      	data:{"tech1":str1},
	      	datatype:"text",
	      	success:function(data){
	      		var str=data.split(",");
	      		var select2=$("#tech2")
	      		$(str).each(function(i,dom){
	      			select2.append("<option value="+"'"+dom+"'"+">"+dom+"</option>");
	      		})
	      	}
	      })
	})
	$("#tech2").change(function(){
		 $("#tech3").html("").append("<option>"+"请选择"+"</option>")
	      var str1 = $(this).val();
	      $.ajax({
	      	url:"showthirdgdp",
	      	type:"GET",
	      	data:{"tech2":str1},
	      	datatype:"text",
	      	success:function(data){
	      		var str=data.split(",");
	      		var select3=$("#tech3")
	      		$(str).each(function(i,dom){
	      			select3.append("<option value="+"'"+dom+"'"+">"+dom+"</option>");
	      		})
	      	}
	      })
	})
	// 学科三级菜单
	$.ajax({
		   url:"showfirstSub",
		   type:"GET",
		   datatype:"text",
		   success:function(data)
		   { 
		   	var str=data.split(",");
		   	var select1=$("#subjectClassfied1");
		   	$(str).each(function(i,dom){
		   		select1.append("<option value="+"'"+dom+"'"+">"+dom+"</option>");
		   	})
		   }
	   })
	$("#subjectClassfied1").change(function(){
		  $("#subjectClassfied2").html("").append("<option>"+"请选择"+"</option>")
		  $("#subjectClassfied3").html("").append("<option>"+"请选择"+"</option>")
	      var str1 = $(this).val();
	      $.ajax({
	      	url:"showsecondSub",
	      	type:"GET",
	      	data:{"title":str1},
	      	datatype:"text",
	      	success:function(data){
	      		var str=data.split(",");
	      		var select2=$("#subjectClassfied2")
	      		$(str).each(function(i,dom){
	      			select2.append("<option value="+"'"+dom+"'"+">"+dom+"</option>");
	      		})
	      	}
	      })
	})
	$("#subjectClassfied2").change(function(){
		 $("#subjectClassfied3").html("").append("<option>"+"请选择"+"</option>")
	      var str1 = $(this).val();
	      $.ajax({
	      	url:"showthirdSub",
	      	type:"GET",
	      	data:{"title1":str1},
	      	datatype:"text",
	      	success:function(data){
	      		var str=data.split(",");
	      		var select3=$("#subjectClassfied3")
	      		$(str).each(function(i,dom){
	      			select3.append("<option value="+"'"+dom+"'"+">"+dom+"</option>");
	      		})
	      	}
	      })
	})
	
	/* ......................警告提示.............. */
	// 1机构名称
	$("#OrganizationName").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning1").show();
	      }
	      if(isChinese($(this).val())==false)
	      {
	      	  $(".tishi1-OrganizationName").hide();
	      	  $(".tishi2-OrganizationName").show();
	      }
	})
	$("#OrganizationName").focus(function(){
	      $("#warnning1").hide();
	      $(".tishi1-OrganizationName").show();
	      $(".tishi2-OrganizationName").hide();
	})
	// 2归口管理部门
	
	// 3通讯地址
	$("#adress").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning3").show();
	      }
	})
	$("#adress").focus(function(){
	      $("#warnning3").hide();
	})
	// 4所在地域
	$("#regional").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning4").show();
	      }
	})
	$("#regional").focus(function(){
	      $("#warnning4").hide();
	})
	// 5单位网址
	$("#website").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning5").show();
	      }
	})
	$("#website").focus(function(){
	      $("#warnning5").hide();
	})
	// 6电子邮箱
	$("#mail").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning6").show();
	      }
	      if(isEmail($(this).val())==false)
	      {
	      	  $(".tishi1-mail").hide();
      	      $(".tishi2-mail").show();
	      }
	})
	$("#mail").focus(function(){
	      $("#warnning6").hide();
	      $(".tishi1-mail").show();
	      $(".tishi2-mail").hide();
	})
	// 7法人代表
	$("#legalPerson").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning7").show();
	      }
	})
	$("#legalPerson").focus(function(){
	      $("#warnning7").hide();
	})
	// 8邮政编码
	
	// 9联系人
	$("#connectionPerson").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning9").show();
	      }
	})
	$("#connectionPerson").focus(function(){
	      $("#warnning9").hide();
	})
	// 10固话
	
	// 11手机
	$("#phone").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning11").show();
	      }
	})
	$("#phone").focus(function(){
	      $("#warnning11").hide();
	})
	// 12传真
	
	// 13机构属性
	$("#property").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning13").show();
	      }
	})
	$("#property").focus(function(){
	      $("#warnning13").hide();
	})
	// 14机构简介
	$("#info").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning14").show();
	      }
	})
	$("#info").focus(function(){
	      $("#warnning14").hide();
	})
	// 15技术需求名称
	$("#requestName").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning15").show();
	      }
	})
	$("#requestName").focus(function(){
	      $("#warnning15").hide();
	})
	// 16需求时限
	$("#beginyear").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning16").show();
	      }
	})
	$("#beginyear").focus(function(){
	      $("#warnning16").hide();
	})
	$("#lastyear").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning16").show();
	      }
	})
	$("#lastyear").focus(function(){
	      $("#warnning16").hide();
	})
	// 17重大需求概述
	$("#requestInfo1").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning17").show();
	      }
	})
	$("#requestInfo1").focus(function(){
	      $("#warnning17").hide();
	})
	$("#requestInfo2").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning17").show();
	      }
	})
	$("#requestInfo2").focus(function(){
	      $("#warnning17").hide();
	})
	$("#requestInfo3").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning17").show();
	      }
	})
	$("#requestInfo3").focus(function(){
	      $("#warnning17").hide();
	})
	// 18关键字
	$("#keyword1").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning18").show();
	      }
	})
	$("#keyword1").focus(function(){
	      $("#warnning18").hide();
	})
	// 19投资总额
	$("#projectSum").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning19").show();
	      }
	})
	$("#projectSum").focus(function(){
	      $("#warnning19").hide();
	})
	// 20技术需求解决方式
	$("#cooperation").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning20").show();
	      }
	})
	$("#cooperation").focus(function(){
	      $("#warnning20").hide();
	})
	// 21科技活动类型
	$("#studyClassfied").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning21").show();
	      }
	})
	$("#studyClassfied").focus(function(){
	      $("#warnning21").hide();
	})
	// 22学科分类
	$("#subjectClassfied1").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning22").show();
	      }
	})
	$("#subjectClassfied1").focus(function(){
	      $("#warnning22").hide();
	})
	//23需求技术所属领域
	$("#techArea").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning23").show();
	      }
	})
	$("#techArea").focus(function(){
	      $("#warnning23").hide();
	})
	//24需求技术应用行业
	$("#subjectClassfied").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning24").show();
	      }
	})
	$("#subjectClassfied").focus(function(){
	      $("#warnning24").hide();
	})
	/* ......................表内的限制.............. */
	
	$("#jichu").hide();
	$("#feijichu1").hide();
	$("#feijichu2").hide();
	$("input[name='studyClassfied']").click(function(){
		var str=$("input[name='studyClassfied']:checked").val();
	     if((str.trim())!=("基础研究"))
	     {
	     	 $("#jichu").hide();
	     	 $("#subjectClassfied1 option[value='请选择']").prop("selected",true);
	     	 $("#subjectClassfied2").html("").append("<option value='请选择'>"+"请选择"+"</option>")
	     	 $("#subjectClassfied3").html("").append("<option value='请选择'>"+"请选择"+"</option>")
	     	 $("#feijichu1").show();    
	     	 $("#feijichu2").show();
	     }
	     if((str.trim())==("基础研究"))
	     {
	     	 $("#jichu").show();
	     	 $("#feijichu1").hide();
	     	 $("#feijichu2").hide();
	     	 $("input[name='techArea']").each(function(){
	     	 	if($(this).prop("checked")==true)
	     	 	{
	     	        $(this).prop("checked",false);
	     	 	}
	     	 });
	     	 $("#tech1 option[value='请选择']").prop("selected",true);
	     	 $("#tech2").html("").append("<option value='请选择'>"+"请选择"+"</option>")
	     	 $("#tech3").html("").append("<option value='请选择'>"+"请选择"+"</option>")
	     }
	})
	/* ....................保存提交..................... */
	$("input[name='submitornot']").click(function() {
					var str = $("input[name='submitornot']:checked").val();
					if ((str.trim()) == "是") {
						$("#btn").val("提交");
					} else {
						$("#btn").val("保存");
					}
					// 获取被选中的值
				});
	/* ....................提交验证..................... */
	$("#btn").click(function(){
		
	      var OrganizationName=$("#OrganizationName").val();
	      var Centralized=$("#Centralized").val();
	      var adress=$("#adress").val();
	      var regional=$("#regional").val();
	      var website=$("#website").val();
	      var mail=$("#mail").val();
	      var legalPerson=$("#legalPerson").val();
	      var postcode=$("#postcode").val();
	      var connectionPerson=$("#connectionPerson").val();
	      var tel=$("#tel").val();
	      var phone=$("#phone").val();
	      var fax=$("#fax").val();
	      var inputproperty=$("input[name='property']:checked").val();
	      var info=$("#info").val();
	      var requestName=$("#requestName").val();
	      var beginyear=$("#beginyear").val();
	      var lastyear=$("#lastyear").val();
	      var requestInfo1=$("#requestInfo1").val();
	      var requestInfo2=$("#requestInfo2").val();
	      var requestInfo3=$("#requestInfo3").val();
	      var inputstudyClassfied=$("input[name='studyClassfied']:checked").val();
	      var inputtechArea=$("input[name='techArea']:checked").val();
	      var inputcooperation=$("input[name='cooperation']:checked")
	      var cooperativeUnit=$("#cooperativeUnit").val();
	      var projectSum=$("#projectSum").val();
	      var submitornot=$("input[name='submitornot']:checked").val();
	      var subjectClassfied1 = $("#subjectClassfied1").val();
	      var subjectClassfied2 = $("#subjectClassfied2").val();
	      var inputcooperation=$("input[name='techArea']:checked").val();
	      var str="";
          $("input[name='techArea']:checkbox").each(function(){ 
              if($(this).prop("checked")){
                  str += $(this).val()+","
              }
          })
          var tech1 = $("#tech1").val();
	      var tech2 = $("#tech2").val();
	      
	      var mydate = new Date();
	      var yearnow = mydate.getFullYear(); //获取完整的年份(4位,1970-????)
	      
	      if(OrganizationName==null||OrganizationName=="")
	      {
	      	alert("机构名称输入为空请重新输入！");
	      	return false;
	      }
	      else if(adress==null||adress=="")
	      {
	      	alert("通讯地址输入为空，请重新输入！");
	      	return false;
	      }
	      else if(regional=="请选择"||regional==""||regional==null)
	     {
	    	  alert("所在地域选择为空，请重新选择！");
		      return false;
	     }
	      else if(mail==null||mail=="")
	      {
	      	alert("电子邮箱输入为空，请重新输入！");
	      	return false;
	      }
	      else if(legalPerson==null||legalPerson=="")
	      {
	      	alert("法人代表输入为空，请重新输入！");
	      	return false;
	      }
	      else if(connectionPerson==null||connectionPerson=="")
	      {
	      	alert("联系人输入为空，请重新输入！");
	      	return false;
	      }
	      else if(tel==null||tel=="")
	      {
	      	alert("固话输入为空，请重新输入！");
	      	return false;
	      }
	      else if(phone==null||phone=="")
	      {
	      	alert("手机输入为空，请重新输入！");
	      	return false;
	      }
	      else if(inputproperty==null||inputproperty=="")
	      {
	      	alert("机构属性选择为空，请重新选择！");
	      	return false;
	      }
	      else if(info==null||info=="")
	      {
	      	alert("机构简介输入为空，请重新输入！");
	      	return false;
	      }
	      else if(requestName==null||requestName=="")
	      {
	      	alert("技术需求名称输入为空，请重新输入！");
	      	return false;
	      }
	      else if(beginyear==null||beginyear=="")
	      {
	    	alert("开始年限输入为空，请重新输入！");
		    return false;
	  	  }
	      else if(lastyear==null||lastyear=="")
	      {
	    	alert("截止年限输入为空，请重新输入！");
		    return false;
	  	  }
	      else if(beginyear<yearnow)
	      {
	    	alert("开始年限小于当前年份，请重新输入！");
		    return false;
	  	  }
	      else if(lastyear<beginyear)
	      {
	    	alert("截止年限小于开始年限，请检查！");
		    return false;
	  	  }
	      else if(requestInfo1==null||requestInfo1=="")
	      {
	    	alert("1111！");
	      	alert("技术需求概述输入为空，请重新输入！");
	      	return false;
	      }
	      else if(requestInfo2==null||requestInfo2=="")
	      {
	    	  alert("1221！");
	      	alert("技术需求概述输入为空，请重新输入！");
	      	return false;
	      }
	      else if(requestInfo3==null||requestInfo3=="")
	      {
	    	  alert("1331！");
	      	alert("技术需求概述输入为空，请重新输入！");
	      	return false;
	      }
	      else if(inputstudyClassfied==null||inputstudyClassfied=="")
	      {
	      	alert("科技活动类型选择为空，请重新选择！");
	      	return false;
	      }
	      else if((inputstudyClassfied.trim())==("基础研究"))
	      {
	    	  if(subjectClassfied1==null||subjectClassfied1=="请选择")
		      {
		      	alert("学科分类一级菜单未选择或选择错误，请重新选择！");
		      	return false;
		      }
	    	  else if(subjectClassfied2==null||subjectClassfied2=="请选择")
		      {
		      	alert("学科分类二级菜单未选择或选择错误，请重新选择！！");
		      	return false;
		      }
	      }
	      else if((inputstudyClassfied.trim())!=("基础研究")&&inputstudyClassfied !=null&&inputstudyClassfied !="")
	      {
	    	  if(str==null||str=="")
		      {
		      	alert("需求技术所属领域至少选择一项，请重新选择！");
		      	return false;
		      }
	    	  else if(tech1==null||tech1=="请选择")
		      {
		      	alert("需求技术应用行业一级菜单未选择或选择错误，请重新选择！！");
		      	return false;
		      }
	    	  else if(tech2==null||tech2=="请选择")
		      {
		      	alert("需求技术应用行业一级菜单未选择或选择错误，请重新选择！！");
		      	return false;
		      }
	      }
	      else if(inputcooperation==null||inputcooperation=="")
	      {
	      	alert("技术需求解决方式选择为空，请重新选择！");
	      	return false;
	      }
	      else if(projectSum==null||projectSum=="")
	      {
	      	alert("计划总投资输入为空，请重新输入！");
	      	return false;
	      }
	      else if(submitornot==null||submitornot=="")
	      {
	      	alert("请选择是否提交！");
	      	return false;
	      }
	      else{
	    	  var bool = true;
				if($("#btn").val()=="提交")
				{
					var msg = "需求信息审核后不能修改！ 确定提交吗？";
					if (confirm(msg) == true) 
					{
						
					}
					else
					{
						return false;
					}
				}
	      }
	     
	})
	
	/* ......................键盘操作......................... */
	var ss = $("input");
	$("input:first").focus();
	$("input").keydown(function(){
		if(event.keyCode==13)
		{
			event.preventDefault();
			var nxtIdx=ss.index(this);
	        nxtIdx++;
	        if(nxtIdx==15)
	        {
	        	$("textarea:eq(0)").focus();
	        }
	        else if(nxtIdx==16)
	        {
	        	$("textarea:eq(1)").focus();
	        }
	        else
	        {
			    $("input:eq("+nxtIdx+")").focus();
	        }
		}
	})
	
	/* ......................关键字限制...................................... */
	$("#keyword-input").find("input").attr("disabled",true);
	$("#keyword-input").children(":first").attr("disabled",false);
	
	$("#keyword1").keyup(function(){
		if($("#keyword1").val().length>0)
		{
	      $("#keyword-input").children("#keyword2").attr("disabled",false);
		}
		else
		{
		  $("#keyword-input").children("#keyword2").attr("disabled",true);
		  $("#keyword-input").children("#keyword3").attr("disabled",true);
		  $("#keyword-input").children("#keyword4").attr("disabled",true);
		  $("#keyword-input").children("#keyword5").attr("disabled",true);
		  $("#keyword-input").children("#keyword2").val("");
		  $("#keyword-input").children("#keyword3").val("");
		  $("#keyword-input").children("#keyword4").val("");
		  $("#keyword-input").children("#keyword5").val("");
		}
	})
	$("#keyword2").keyup(function(){
		if($("#keyword2").val().length>0)
		{
	      $("#keyword-input").children("#keyword3").attr("disabled",false);
		}
		else
		{
			$("#keyword-input").children("#keyword3").attr("disabled",true);
			$("#keyword-input").children("#keyword4").attr("disabled",true);
			$("#keyword-input").children("#keyword5").attr("disabled",true);
			$("#keyword-input").children("#keyword3").val("");
			$("#keyword-input").children("#keyword4").val("");
			$("#keyword-input").children("#keyword5").val("");
		}
	})
	$("#keyword3").keyup(function(){
		if($("#keyword3").val().length>0)
		{
	      $("#keyword-input").children("#keyword4").attr("disabled",false);
		}
		else
		{
			$("#keyword-input").children("#keyword4").attr("disabled",true);
			$("#keyword-input").children("#keyword5").attr("disabled",true);
			$("#keyword-input").children("#keyword4").val("");
		    $("#keyword-input").children("#keyword5").val("");
		}
	})
	$("#keyword4").keyup(function(){
		if($("#keyword4").val().length>0)
		{
	      $("#keyword-input").children("#keyword5").attr("disabled",false);
		}
		else
		{
			$("#keyword-input").children("#keyword5").attr("disabled",true);
			$("#keyword-input").children("#keyword5").val("");
		}
	})	
	
	/** ******************************字数限制******************************************* */
	
	$("#info").keyup(function(){
	    var zishu=$(this).val();
	    $("#zishu").text(zishu.length);
	    if(zishu.length>500)
	    {
	    	alert("字数超过限制！");
	    	var value=zishu.substring(0,500);
	    	$("#info").val(value);
	    }
	})
	
	$("#requestInfo1").keyup(function(){
	    var zishu=$(this).val();
	    $("#zishu1").text(zishu.length);
	    if(zishu.length>500)
	    {
	    	alert("字数超过限制！");
	    	var value=zishu.substring(0,500);
	    	$("#requestInfo1").val(value);
	    }
	})
	
	$("#requestInfo2").keyup(function(){
	    var zishu=$(this).val();
	    $("#zishu2").text(zishu.length);
	    if(zishu.length>500)
	    {
	    	alert("字数超过限制！");
	    	var value=zishu.substring(0,500);
	    	$("#requestInfo2").val(value);
	    }
	})
	
	$("#requestInfo3").keyup(function(){
	    var zishu=$(this).val();
	    $("#zishu3").text(zishu.length);
	    if(zishu.length>500)
	    {
	    	alert("字数超过限制！");
	    	var value=zishu.substring(0,500);
	    	$("#requestInfo3").val(value);
	    }
	})
	
	
	
})
