package ramzi.eljabali.firebasedatabase.data

data class User(
    var name: String = "",
    var email: String? = null,
    var hasOnBoarded: Boolean = false,
    var creationDate: String = "" // TODO use dateformat to go back and forth from string to datedformat
)
