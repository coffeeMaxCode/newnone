/** 윈도우 팝업창 처리 구현

 * @parm1:화면에 띄울 페이지 url
 * @parm2:팝업창 가로
 * @parm3:팝업창 세로
 * @parm4:팝업창 이름
 							**/
function cmm_window_popup(url,popupwidth,popupheight,popupname){
	Top		=	(window.screen.height-popupheight)/3;
	Left	=	(window.screen.width-popupwidth)/2;
	if(Top<0)	Top =0;
	if(Left<0)	Left =0;
	options = "location=no, fullscreen=no, status=no";
	options +=",left="+Left+",top="+Top;
	options +=",width="+popupwidth+",height="+popupheight;
	popupname=window.open(url,popupname,options);
}