package com.example.myfibon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


import androidx.compose.foundation.layout.* // Import para Layout
import androidx.compose.material3.* // Import para Material Design 3
import androidx.compose.runtime.* // Import para State
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingPreview() // aonde

            }
        }
    }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    var inputNumber by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Verificar Número na Sequência de Fibonacci",
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        OutlinedTextField(
            value = inputNumber,
            onValueChange = { inputNumber = it },
            label = { Text("Digite um número") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val number = inputNumber.toLongOrNull()
                if (number != null) {
                    result = if (isFibonacci(number)) {
                        "O número $number pertence à sequência de Fibonacci."
                    } else {
                        "O número $number NÃO pertence à sequência de Fibonacci."
                    }
                } else {
                    result = "Por favor, insira um número válido."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Verificar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = result,
            fontSize = 18.sp
        )
    }
}
    fun isFibonacci(number: Long): Boolean {
        if (number == 0L || number == 1L) return true
        var a = 0L
        var b = 1L
        while (b < number) {
            val temp = a + b
            a = b
            b = temp
        }
        return b ==number
    }





