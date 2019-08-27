package part7_2_networrk2;

import java.util.List;
import java.util.Vector;

public class RoomSimulation {

	public static void main(String[] args) {
		List<Room> roomList = new Vector<>();
		Room room = new Room("자바52기",0);
		roomList.add(room);
		room = new Room("자바51기",3);
		String n1 = "김유신";
		String n2 = "김춘추";
		String n3 = "강감찬";
		room.nameList.add(n1);
		room.nameList.add(n2);
		room.nameList.add(n3);
		roomList.add(room);
		room = new Room("자바50기",15);
		roomList.add(room);
		for(int i=0;i<roomList.size();i++) {
			Room rm = roomList.get(i);
			if("자바51기".equals(rm.title)) {
				System.out.println(rm.current);
				//insert here
				for(int j=0;j<rm.nameList.size();j++) {
					System.out.println(rm.nameList.get(j));
				}
			}
		}
	}
}
