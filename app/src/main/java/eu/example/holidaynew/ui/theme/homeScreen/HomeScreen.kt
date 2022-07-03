package eu.example.holidaynew.ui.theme.homeScreen

import eu.example.holidaynew.R
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.LocalTime
import java.util.*
import eu.example.holidaynew.utils.AppColors


@Composable
fun HomeScreen(viewModel: HomeScreenViewModel) {

	Scaffold(
		modifier = Modifier
			.fillMaxSize(),
		topBar = { TopBar() },
		floatingActionButton = { FABContent() },
		backgroundColor = AppColors.mOrangeOne,
		content = {
			HomeScreenContent()
		}
	)


}

@Composable
fun TopBar() {
	TopAppBar(title = {
		Text(
			text = "Holiday Savings",
			color = AppColors.mOffWhite
		)
	}, backgroundColor = AppColors.mBlue)
}

@Composable
fun FABContent() {
	FloatingActionButton(
		onClick = { /*TODO*/ },
		backgroundColor = AppColors.mBlue,
		contentColor = AppColors.mOffWhite,
	) {
		Text(modifier = Modifier.padding(12.dp), text = "New Entry")
	}
}

@Composable
fun HomeScreenContent() {
	Surface(
		modifier = Modifier
			.fillMaxSize()
			.background(AppColors.mOrangeOne)
	) {
		Column(
			modifier = Modifier.background(AppColors.mOrangeOne),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			ShowTimeToDepart(HomeScreenViewModel())
			// EnterData()
			DestinationPicture()
		}
	}
}

@RequiresApi(Build.VERSION_CODES.O) // Not sure what this is ??
@Composable
fun ShowTimeToDepart(viewModel: HomeScreenViewModel/*needs a state for countdown timer*/) {

	// Experimenting with dates - not used yet
	// This should be in the viewModel, and observed here from the viewModel
	var currentDate = LocalDate.now()
	var currentTime = LocalTime.now()
	var departureDate = LocalDate.parse("2022-06-30")

	var currentCalenderDate = Calendar.getInstance()


	////////////////////
	Card(
		modifier = Modifier
			.fillMaxWidth()
			.height(240.dp)
			.padding(12.dp),
		backgroundColor = AppColors.mOrangeTwo
	) {
		Column(
			modifier = Modifier.padding(8.dp),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.SpaceEvenly
		) {
			Text(
				fontSize = 20.sp,
				text = "Time to departure",
				color = AppColors.mBlue
			)
			Text(
				// show current date Timer state", // Should get this value by observing a state
				// text = currentDate.toString(),
				// text = currentCalenderDate.time.toString()
				text = viewModel.getCurrentDateTime().toString(),
				fontSize = 20.sp,
				color = AppColors.mBlue
			)

			Text(
				fontSize = 20.sp,
				text = "Total savings for next Holiday",
				color = AppColors.mBlue
			)
			Text(
				fontSize = 20.sp,
				text = "Total savings amount - state", // Should get this value by observing a state
				color = AppColors.mBlue
			)

			// Button to adjust totalSavings for next holiday
			Button(
				onClick = { /*TODO*/ },
				colors = ButtonDefaults.buttonColors(
					backgroundColor = AppColors.mBlue,
					contentColor = AppColors.mOffWhite
				)
			) {
				Text(text = "Edit data")

			}
		}
	}
}

@Composable
fun EnterData() {
	Card(
		modifier = Modifier
			.fillMaxWidth()
			.height(240.dp)
			.padding(12.dp),
		backgroundColor = AppColors.mOrangeTwo
	) {
		Column(
			modifier = Modifier.padding(12.dp),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.SpaceEvenly
		) {
			Text(
				modifier = Modifier.padding(12.dp),
				fontSize = 20.sp,
				text = "Enter new Amount",
				color = AppColors.mBlue
			)
			OutlinedTextField(value = "New Amount - state", onValueChange = {})
			Text(
				modifier = Modifier.padding(12.dp),
				fontSize = 20.sp,
				text = "Enter Departure date",
				color = AppColors.mBlue
			)
			OutlinedTextField(value = "Enter date - state", onValueChange = {})
		}
	}
}

@Composable
fun DestinationPicture() {
	Card(
		modifier = Modifier
			.fillMaxWidth()
			.height(240.dp)
			.padding(12.dp),
		backgroundColor = AppColors.mOrangeTwo,
		shape = RoundedCornerShape(16.dp),
		border = BorderStroke(4.dp, AppColors.mOrangeTwo)
	) {
		Image(
			painter = painterResource(id = R.drawable.michael_thailand),
			contentDescription = "Next destination picture"
		)

	}

}

@Preview
@Composable
fun HomeScreenPreview() {
	HomeScreen(viewModel = HomeScreenViewModel())
}
