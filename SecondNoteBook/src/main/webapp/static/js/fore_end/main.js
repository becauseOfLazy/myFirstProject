$(document).ready(function(){
	doGetMainPage();
	
})

//加载主业图片信息
function doGetMainPage(){
	var url = "togetIndexImg.do";

	$.post(url,function(result){
		if(result.state){
			doLoadImgs(result.data);
		}
	});
}
//加载显示图片
function doLoadImgs(data){
	//line1
	$("#line1_1").attr("src",data[0].img_1);
	$("#line1_2").attr("src",data[0].img_2);
	$("#line1_3").attr("src",data[0].img_3);
	$("#line1_4").attr("src",data[0].img_4);
	$("#line1_5").attr("src",data[0].img_1);
	//line2
	$("#line2_1").attr("src",data[1].img_1);
	$("#line2_2").attr("src",data[1].img_2);
	$("#line2_3").attr("src",data[1].img_3);
	//line3
	$("#line3_1").attr("src",data[2].img_1);
	$("#line3_2").attr("src",data[2].img_2);
	$("#line3_3").attr("src",data[2].img_3);
	//line4
	$("#line4_1").attr("src",data[3].img_1);
	$("#line4_2").attr("src",data[3].img_2);
	$("#line4_3").attr("src",data[3].img_3);
	$("#line4_4").attr("src",data[3].img_4);
	//line5
	$("#line5_1").attr("src",data[4].img_1);
	$("#line5_2").attr("src",data[4].img_2);
	$("#line5_3").attr("src",data[4].img_3);
	$("#line5_4").attr("src",data[4].img_4);
}














