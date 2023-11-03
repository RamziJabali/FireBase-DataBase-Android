package ramzi.eljabali.firebasedatabase.data

data class Habit(
    var title: String = "",
    var recurrence: Int = -1,
    var creationDate: String = "" // TODO use dateformat to go back and forth from string to datedformat
)
