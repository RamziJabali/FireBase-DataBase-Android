package ramzi.eljabali.firebasedatabase.tables

data class Note(
    var title: String = "",
    var creationDate: String = "" // TODO use dateformat to go back and forth from string to datedformat
)