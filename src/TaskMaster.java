import CLI.HelpOutput;
import CLI.Parser;
import DB.Database;
import java.util.HashMap;

public class TaskMaster {
	public static void main(String[] args) {
		if (args.length == 0) {
			HelpOutput.printHelp();
			System.exit(1);
		}
		Parser psr = new Parser();
		psr.parse(args);
		HashMap<String, String> map = psr.getMap();
		String where = map.get("where");
		String isThis = map.get("isThis");
		String field = map.get("field");
		String value = map.get("value");

		switch (map.get("command")) {
			case "init":
				Database.init();
				break;

			case "printTable":
				if (args.length == 3) {
					Database.printTable(map.get("table"));
				} else {
					Database.printTable(map.get("table"), where, isThis);
				}
				break;

			case "addTask":
				Database.addTask(map.get(Database.TASK_NAME), map.get(Database.DUE_DATE), map.get(Database.ASSIGNED_USER), map.get(Database.STATUS), map.get(Database.PRIORITY));
				break;

			case "updateTasks":
				Database.updateTasks(where, isThis, field, value);
				break;

			case "assignUser":
				Database.assignUser(where, isThis, map.get(Database.ASSIGNED_USER));
				break;

			case "deleteTask":
				Database.deleteTask(map.get(Database.TASK_NAME));
				break;

			case "addUser":
				Database.addUser(map.get(Database.USERNAME), map.get(Database.PASSWORD), map.get(Database.FIRST_NAME), map.get(Database.LAST_NAME));
				break;

			case "updateUser":
				Database.updateUser(map.get(Database.USERNAME), field, value);
				break;

			case "removeUser":
				Database.removeUser(map.get(Database.USERNAME));
				break;

			default:
				HelpOutput.printHelp();
		}
	}
}
