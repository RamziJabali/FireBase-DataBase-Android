package ramzi.eljabali.firebasedatabase.viewstate

import ramzi.eljabali.firebasedatabase.data.Area
import ramzi.eljabali.firebasedatabase.data.Focus
import ramzi.eljabali.firebasedatabase.data.Habit
import ramzi.eljabali.firebasedatabase.data.HabitValue
import ramzi.eljabali.firebasedatabase.data.JournalPrompt
import ramzi.eljabali.firebasedatabase.data.Measurement
import ramzi.eljabali.firebasedatabase.data.MeasurementValue
import ramzi.eljabali.firebasedatabase.data.Note
import ramzi.eljabali.firebasedatabase.data.User

data class AddDataViewState(
    var user: User = User(),
    var area: Area = Area(),
    var focus: Focus = Focus(),
    var habit: Habit = Habit(),
    var habitValue: HabitValue = HabitValue(),
    var journalPrompt: JournalPrompt = JournalPrompt(),
    var measurement: Measurement = Measurement(),
    var measurementValue: MeasurementValue = MeasurementValue(),
    var note: Note = Note(),
)
