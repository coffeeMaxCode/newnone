package mvc3;

import org.apache.log4j.Logger;

public class ControllerMappingVer3 {
	static Logger logger = Logger.getLogger(ControllerMappingVer3.class);
	static String crud ="";
	/**
	 * @param command /mySNS/test.hh?work=mySNS
	 * @param crud = smsgList
	 * @return
	 */
	public static ControllerVer3 getController(String command, String crud) {
		logger.info("ControllerMappingVer3.ControllerVer3 호출 성공");
		ControllerMappingVer3.crud = crud;
		ControllerVer3 controller = null;
		String commands[] = command.split("/");
		//		test.hh?work=mySNS
		String work = commands[0];
		//		work=mySNS
		String requestName = commands[1];
		//test.hh?work=mySNS
		if("mySNS".equals(work)) {
			controller = new SNSController(requestName,ControllerMappingVer3.crud);
		}
		return controller;
	}
}
