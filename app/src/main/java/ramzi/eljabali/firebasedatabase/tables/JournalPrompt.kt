package ramzi.eljabali.firebasedatabase.tables

data class JournalPrompt(
    var prompt: String = "",
    var promptShort: String = "",
    var isMorningPrompt: Boolean = false,
    var order: Int = -1
)
