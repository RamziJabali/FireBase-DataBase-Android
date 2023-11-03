package ramzi.eljabali.firebasedatabase.tables

data class HabitValue(
    var isFullFilled: Boolean = false,
    var creationDate: String = "" // TODO use dateformat to go back and forth from string to datedformat
)
