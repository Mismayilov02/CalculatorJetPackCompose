package com.master.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.master.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.cardiev_color)
                ) {
                    calculatorBottomDesign()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun calculatorBottomDesign() {

    val viewModel: CalculatorViewModel = viewModel()
//    var historys = viewModel.

    var baseValue = viewModel.ansverText.observeAsState(listOf<String>())

    var value = viewModel.dataText.observeAsState(listOf<String>())

    val buttonColor: Color = colorResource(id = R.color.button_color_black)

    Box(
        modifier = Modifier/*.fillMaxHeight(0.6f)*/
            .fillMaxSize()
            .padding(20.dp)
//        .aspectRatio(0.6f)
            .background(colorResource(id = R.color.cardiev_color))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box( modifier = Modifier
                .clip(
                    shape = RoundedCornerShape(
                        15.dp
                    )
                )
                .background(
                    colorResource(id = R.color.light_black)
                )
            ) {
                Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.moon),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(12.dp)
                            .height(25.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.brightness),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(12.dp)
                            .height(25.dp)
                    )
                }
            }


            Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier.fillMaxSize()) {


                Text(
                    text = value.value.toString(), modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp), fontSize = 36.sp, textAlign = TextAlign.End
                )
                Text(
                    text = baseValue.value.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End
                )


                Row(modifier = Modifier.fillMaxWidth()) {
                    buttonOperator(
                        symbol = "c", modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .clickable { viewModel.operator("AC") }
                            .background(
                                buttonColor
                            )
                    )
                    buttonOperator(
                        symbol = "±", modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .clickable { viewModel.btnClick("+-") }
                            .background(
                                buttonColor
                            )
                    )
                    buttonOperator(
                        symbol = "%", modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .clickable { viewModel.operator("/") }
                            .background(
                                buttonColor
                            )
                    )
                    buttonOperator(
                        symbol = "÷", modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .clickable { viewModel.operator("/") }
                            .background(
                                buttonColor
                            )
                    )

                }


                Row(modifier = Modifier.fillMaxWidth()) {
                    buttonNumber(
                        symbol = "7", modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .clickable { viewModel.btnClick("7") }
                            .background(
                                buttonColor
                            )
                    )
                    buttonNumber(
                        symbol = "8", modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .clickable { viewModel.btnClick("8") }
                            .background(
                                buttonColor
                            )
                    )
                    buttonNumber(
                        symbol = "9", modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .clickable { viewModel.btnClick("9") }
                            .background(
                                buttonColor
                            )
                    )
                    buttonOperator(
                        symbol = "x", modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .clickable { viewModel.operator("*") }
                            .background(
                                buttonColor
                            )
                    )

                }


                Row(modifier = Modifier.fillMaxWidth()) {
                    buttonNumber(
                        symbol = "4", modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .clickable { viewModel.btnClick("4") }
                            .background(
                                buttonColor
                            )
                    )
                    buttonNumber(
                        symbol = "5", modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .clickable { viewModel.btnClick("5") }
                            .background(
                                buttonColor
                            )
                    )
                    buttonNumber(
                        symbol = "6", modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .clickable { viewModel.btnClick("6") }
                            .background(
                                buttonColor
                            )
                    )
                    buttonOperator(
                        symbol = "-", modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .clickable { viewModel.operator("-") }
                            .background(
                                buttonColor
                            )
                    )

                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    buttonNumber(
                        symbol = "1", modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .clickable { viewModel.btnClick("1") }
                            .background(
                                buttonColor
                            )
                    )
                    buttonNumber(
                        symbol = "2", modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .clickable { viewModel.btnClick("2") }
                            .background(
                                buttonColor
                            )
                    )
                    buttonNumber(
                        symbol = "3", modifier = Modifier
                            .weight(1f)
                            .clickable { viewModel.btnClick("3") }
                            .aspectRatio(1f)
                            .background(
                                buttonColor
                            )
                    )
                    buttonOperator(
                        symbol = "+", modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .clickable { viewModel.operator("+") }
                            .background(
                                buttonColor
                            )
                    )

                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    buttonNumber(
                        symbol = " ", modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .background(
                                buttonColor
                            )
                    )
                    buttonNumber(
                        symbol = "0", modifier = Modifier
                            .weight(1f)
                            .clickable { viewModel.btnClick("0") }
                            .aspectRatio(1f)
                            .background(
                                buttonColor
                            )
                    )
                    buttonNumber(
                        symbol = ".", modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .clickable { viewModel.btnClick(".") }
                            .background(
                                buttonColor
                            )
                    )
                    buttonOperator(
                        symbol = "=", modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .clickable { viewModel.operator("=") }
                            .background(
                                buttonColor
                            )
                    )

                }
            }
        }

    }
}

@Composable
fun buttonNumber(symbol: String, modifier: Modifier) {
    Box(
        modifier = Modifier
//            .height(80.dp)
            .padding(10.dp)
            .clip(CircleShape)
            .then(modifier),
        contentAlignment = Alignment.Center
//        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
//        col = color
    ) {
        Text(
            text = symbol,
            fontSize = 28.sp,
            color = Color.White,
//            textAlign = TextAlign.Center,
//            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun buttonOperator(symbol: String, modifier: Modifier) {
    Box(
        modifier = Modifier
//            .height(80.dp)
            .padding(10.dp)
            .clip(CircleShape)
            .then(modifier),
        contentAlignment = Alignment.Center
//        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
//        col = color
    ) {
        Text(
            text = symbol,
            fontSize = 36.sp,
            color = colorResource(id = R.color.button_color_purple),
//            textAlign = TextAlign.Center,
//            modifier = Modifier.fillMaxSize()
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculatorTheme {
        calculatorBottomDesign()
    }
}