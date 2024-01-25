package contacts.invoker

import contacts.command.Command
import contacts.record.Record

class Invoker {
    fun execute(command: Command) {
        command.execute()
    }

    fun executeAndReturn(command: Command): List<Record> {
        return command.executeAndReturn()
    }
}
