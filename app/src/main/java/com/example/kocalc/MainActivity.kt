package com.example.kocalc

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var num1 by remember {
                mutableStateOf("")
            }
            var num2 by remember {
                mutableStateOf("")
            }

            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(254,251,234))
                    .padding(10.dp)
            )
            {
                TextField(
                    value =num1 ,
                    onValueChange ={
                    num1 = it
                } )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(value =num2 ,
                    onValueChange ={
                    num2 = it
                } )
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    Spacer(modifier = Modifier.width(20.dp))
                    OutlinedButton(
                        onClick = {
                            if (num1.isEmpty() && num2.isEmpty()){
                                Toast.makeText(applicationContext, "Fill in please", Toast.LENGTH_SHORT).show()
                            }
                            else{
                                val result = num1.toDouble() + num2.toDouble()
                                Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                            }
                    },
                        shape = RoundedCornerShape(16.dp)
                    )
                    {
                        Text(text = "Add")
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    OutlinedButton(onClick = {
                        val result = num1.toInt() - num2.toInt()
                        Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Subtract")
                    }

            }
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Spacer(modifier = Modifier.width(10.dp))
                    OutlinedButton(onClick = {
                        val result = num1.toInt() * num2.toInt()
                        Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Multiply")
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    OutlinedButton(onClick = {
                        val result = num1.toInt()/num2.toInt()
                        Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Divide")
                    }
                }

            }

        }
    }
}

