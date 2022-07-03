package eu.example.holidaynew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import eu.example.holidaynew.ui.theme.HolidayNewTheme
import eu.example.holidaynew.ui.theme.homeScreen.HomeScreen
import eu.example.holidaynew.ui.theme.homeScreen.HomeScreenViewModel

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			HolidayNewTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					HomeScreen(viewModel = HomeScreenViewModel())
				}
			}
		}
	}
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	HolidayNewTheme {

	}
}