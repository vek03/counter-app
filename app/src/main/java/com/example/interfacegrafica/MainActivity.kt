// Vek Histories
// Victor Cardoso

package com.example.interfacegrafica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {

    private lateinit var myViewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myViewModel = ViewModelProvider(this)[ViewModel::class.java]

        setContent {
            MainScreen(myViewModel)
        }
    }
}

@Composable
fun MainScreen(exmpViewModel: ViewModel){
    // Resolvi o problema de alteração do valor dos contadores ao virar o celular
    // usando como valor inicial o da própria classe ViewModel, sem precisar declarar o valor 0
    // duas vezes

    var contadorView by remember {
        mutableStateOf(exmpViewModel.getContadorViewModel())
    }

    val contadorProvModelView by exmpViewModel.contadorView.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF32383D)), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        Row {
            Text(text = "CONTADOR", fontSize = 40.sp, color = Color(0xFFFFD700), fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            contadorView += 1
            exmpViewModel.incrementContador()
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0, 10, 255, 180)
            )
        ){
            Text(text = "INCREMENTAR CONTADOR")
        }

        Button(onClick = {
            contadorView -= 1
            exmpViewModel.decrementContador()
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(255, 10, 10, 180)
            )
        ){
            Text(text = "DECREMENTAR CONTADOR")
        }
        Text(text = "Valor do Contador Controlado pela View = $contadorView", color = Color(0xFFFFD700))
        Text(text = "Valor do Contador Controlado pela ViewModel = $contadorProvModelView", color = Color(0xFFFFD700))

        Spacer(modifier = Modifier.height(20.dp))

        BottomAppBar(
            containerColor = Color(0xFF282B2E),
            contentColor = Color(0xFFFFD700),
            contentPadding = PaddingValues(7.dp),
            content = {
                Text("VICTOR NOVAES CARDOSO", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(130.dp))
                Text("RM: 22303", fontWeight = FontWeight.Bold)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    //MainScreen()
}