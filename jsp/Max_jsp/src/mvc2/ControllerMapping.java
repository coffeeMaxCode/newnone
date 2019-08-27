package mvc2;

import org.apache.log4j.Logger;

import mvc3.RestController;

public class ControllerMapping {
	static Logger logger = Logger.getLogger(ControllerMapping.class);
	static String crud ="";
	/**
	 * @param command /onLineTest/getSubjectList.mil?work=onLineTest
	 * @param command /onLineTest/test.mil?work=onLineTest
	 * @param crud = select
	 * @return
	 */
	public static Controller getController(String command, String crud) {
		logger.info("Controller 호출 성공");
		ControllerMapping.crud = crud;
		Controller controller = null;
		String commands[] = command.split("/");
		//onLineTest2
		String work = commands[0];
		//test.mil?work=select
		String requestName = commands[1];
		if("onLineTest2".equals(work)) {
			controller = new Test2Controller(requestName,ControllerMapping.crud);
		}
		else if("member".equals(work)) {
			controller = new Member2Controller(requestName,ControllerMapping.crud);
		}
		else if("Board".equals(work)) {
			controller = new BoardController(requestName,ControllerMapping.crud);
		}
		else if("json".equals(work)) {
			controller = new RestController(requestName,ControllerMapping.crud);
		}
		else {
			//logger.info("미작동 : crud 미지정");
		}
		return controller;
	}
}
