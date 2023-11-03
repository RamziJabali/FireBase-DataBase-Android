package ramzi.eljabali.firebasedatabase.data

data class JournalPrompt(
    var prompt: String = "",
    var promptShort: String = "",
    var isMorningPrompt: Boolean = false,
    var order: Int = -1
)
