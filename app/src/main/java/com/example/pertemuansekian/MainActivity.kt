package com.example.pertemuansekian

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pertemuansekian.ui.theme.PertemuanSekianTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PertemuanSekianTheme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "Halaman_utama",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("Halaman_utama") {
                            TampilanUtama(
                                onNavigateToKedua = {
                                    navController.navigate("halaman_kedua")
                                }
                            )
                        }

                        composable("halaman_kedua") {
                            HalamanKedua()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TampilanUtama(
    onNavigateToKedua: () -> Unit,
    modifier: Modifier = Modifier ){
    val context = LocalContext.current
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Selamat Datang di Aplikasi Saya",
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Button(
                onClick = { onNavigateToKedua() }
            ) {
                Text(text = "Masuk")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun TampilanUtamaPreview(){
    PertemuanSekianTheme() {
        TampilanUtama(onNavigateToKedua = {})
    }
}