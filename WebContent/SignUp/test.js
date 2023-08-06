
        $(document).ready(function(){
		
             
            $('#test').hide();	// 초깃값 설정
                
            $("input[name='classType']").change(function(){
                
                if($("input[name='classType']:checked").val() == '관리자'){
              
                    $('#test').show();
                }	
               
                else if($("input[name='classType']:checked").val() == '고객'){
                    $('#test').hide();
                  
                }
               
              
            });
                
        });