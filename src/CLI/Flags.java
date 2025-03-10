package CLI;
import DB.Database;

public class Flags {
    public static Arguments table() {
        String name = "table";
        String[] ali = {"--table", "--table-name", "-T"};
        String desc = "table name";
        return new Flag(name, ali, desc);
    }
    public static Arguments task() {
        String name = Database.TASK_NAME;
        String[] ali = {"--name", "--title", "-n", "-t"};
        String desc = "Task title";
        // String[] assoc = {"add-task", "print", "update-tasks", "assign-user", "delete-task" };
        return new Flag(name, ali, desc);
    }
    
    public static Arguments due() {
        String name = Database.DUE_DATE;
        String[] ali = {"--due", "--due-date", "--deadline", "-d"};
        String desc = "Task Due Date: must be in 'YYYY-MM-DD: HH:MM:SS' format";
        return new Flag(name, ali ,desc);
    }
    
    public static Arguments assignedUsers() {
        String name = Database.ASSIGNED_USER;
        String[] ali = {"--user-assign", "-u"};
        String desc = "Username to assign to task. User must already exists.";
        return new Flag(name, ali, desc);
    }
    
    public static Arguments status() {
        String name = Database.STATUS;
        String[] ali = {"--status", "--stat", "-s"};
        String desc = "Set status for task.";
        return new Flag(name, ali, desc);
    }

    public static Arguments priority() {
        String name = Database.PRIORITY;
        String[] ali = {"--priority", "-p"};
        String desc = "Set priority for task.";
        return new Flag(name, ali, desc);
    }
    
    public static Arguments username() {
        String name = Database.USERNAME;
        String[] ali = {"--username", "-U"};
        String desc = "Set username: required for new user";
        return new Flag(name, ali, desc);
    }

    public static Arguments first_name() {
        String name = Database.FIRST_NAME;
        String[] ali = {"--first-name", "--first", "-f"};
        String desc = "Set first name for user.";
        return new Flag(name, ali, desc);
    }
    
    public static Arguments last_name() {
        String name = Database.LAST_NAME;
        String[] ali = {"--last-name", "--last", "-l"};
        String desc = "Set last name for user.";
        return new Flag(name, ali, desc);
    }
    
    public static Arguments password() {
        String name = Database.PASSWORD;
        String[] ali = {"--password", "--pass"};
        String desc = "Set password for user. Required for new user";
        return new Flag(name, ali, desc);
    }

    public static Arguments where() {
        String name = "where";
        String[] ali = {"--where", "-w"};
        String desc = "Filter by this field. Use with --is-this";
        return new Flag(name, ali, desc);
    }

    private static Arguments isThis() {
        String name = "isThis";
        String[] ali = {"--is-this"};
        String desc = "Filtering field value equals this. Use with --where";
        return new Flag(name, ali, desc);
    }

    private static Arguments field() {
        String name = "field";
        String[] ali = {"--field"};
        String desc = "Field you want to update. Use with --value";
        return new Flag(name, ali, desc);
    }

    private static Arguments value() {
        String name = "value";
        String[] ali = {"--value"};
        String desc = "Value you want to update in field. Use with --field";
        return new Flag(name, ali, desc);
    }

    public static Arguments[] getAll() {
        return new Arguments[]{table(), task(), due(), assignedUsers(), status(), priority(), username(), first_name(), last_name(), password(), where(), isThis(), field(), value()};
    }
}
