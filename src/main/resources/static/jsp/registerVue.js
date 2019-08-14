let vm=new Vue({
				el:'#userLogin',
			data:{
				uname:"",
			    upassword:"",
				disabled:"true",
				submit:"submit",
				submitchangColor:"submitchangColor"
			   
			},
			computed:{
				<!--計算backgroundcolor-->
				compClass:function(){
				if(this.uname&&this.upassword){
					return this.submitchangColor;
				}else{
					return this.submit;
				}
				}
			}
			});
			