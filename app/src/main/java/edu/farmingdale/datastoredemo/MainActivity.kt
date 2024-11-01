package edu.farmingdale.datastoredemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import edu.farmingdale.datastoredemo.ui.EmojiReleaseApp
import edu.farmingdale.datastoredemo.ui.theme.DataStoreDemoTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.farmingdale.datastoredemo.ui.UserPreferencesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Initialize UserPreferencesViewModel to observe dark theme setting
            val userPreferencesViewModel: UserPreferencesViewModel = viewModel()
            val isDarkTheme by userPreferencesViewModel.isDarkTheme.collectAsState()

            DataStoreDemoTheme(darkTheme = isDarkTheme) {
                EmojiReleaseApp(userPreferencesViewModel = userPreferencesViewModel)
            }
        }
    }
}
