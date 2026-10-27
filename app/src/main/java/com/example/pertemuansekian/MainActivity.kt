package com.example.pertemuansekian

import android.os.Bundle
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
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pertemuansekian.ui.theme.PertemuanSekianTheme
class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PertemuanSekianTheme() {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "Halaman_utama",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("Halaman_utama"){
                            TampilanUtama(
                                
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TampilanUtama(modifier: Modifier = Modifier){
    val context = LocalContext.current
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
            onClick = {
                Toast.makeText(context, "Tombol berhasil diKlik", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "Klik Sayaasda")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TampilanUtamaPreview(){
    PertemuanSekianTheme() {
        TampilanUtama()
    }
}