package ramzi.eljabali.firebasedatabase.data

data class Measurement(
    var title: String = "",
    var unit: String? = null,
    var additive: Boolean = false,
    var creationDate: String = "" // TODO use dateformat to go back and forth from string to datedformat
)
