package eu.example.holidaynew.ui.theme.homeScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.intl.Locale
import androidx.lifecycle.ViewModel
import java.time.LocalDateTime
import java.util.*

class HomeScreenViewModel() : ViewModel() {

	// Creating an Instance of FirebaseRepository, so I can call access members from there
	// var repository = FirebaseRepository()

	// State for firestore name
	var fireStoreName by mutableStateOf("")

	// Creating an instance of Calender, so I can use methods form there to show, and calculate date
	var calender = Calendar.getInstance()

	// I should observe this from the HomeScreen
	// var currentDate = mutableStateOf(Date)


	var currentDateTest = mutableStateOf("")

	// correct imports ??
	private fun Date.toString(
		format: String,
		locale: Locale = Locale.current
	): String {
		// val formatter = SimpleDateFormat(format, locale.toString())
		return locale.toString()
	}

	fun getCurrentDateTime(): Date {
		currentDateTest = Calendar.getInstance().time
		// return Calendar.getInstance().time
	}

	// get localeTime
	val c = Calendar.getInstance()

	val year = c.get(Calendar.YEAR)
	val month = c.get(Calendar.MONTH)
	val day = c.get(Calendar.DAY_OF_MONTH)

	val hour = c.get(Calendar.HOUR_OF_DAY)
	val minute = c.get(Calendar.MINUTE)

	val myLdt = LocalDateTime.of(year, month, day, hour, minute)


	// This should be observed from the view to show the total savings
	// The value should be obtained from a field in a firestore document
	var totalSavings by mutableStateOf("")


}
