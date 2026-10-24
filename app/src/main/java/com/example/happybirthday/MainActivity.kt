package com.example.happybirthday
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx .compose.ui.graphics.painter.Painter
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.happybirthday.ui.theme.HappybirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HappybirthdayTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color= MaterialTheme.colorScheme.background
                ){
                    GreetingImage(message= stringResource(R.string.happy_birthday_text), from= "From Brothers") //  or getString bhi auto bna ya likh do yha vaise stringResource android studio ne sahi likh hota hai kuki ye +sahi hote hai dono hi hmesa   hmne happy birthday ko bulb pe click krke extract resource pe jaake happy_birthday_text me bdla fir yha pe autochange hoke R.string.happy_birthday_text aaya () isme// yha GreetingText se GreetingImage kia
                }
                }                                               
            }
        }
    }
@Composable
fun GreetingText(message: String ,from:String,  modifier:Modifier=Modifier) {// jo ye messgae hai phle yha name tha uski jgh ye aaya h or iska naam greetintext rkha gya upr bhi bdlav ho ge aage oncreate() function ke baad
    Column(
        verticalArrangement = Arrangement.Center,// ek line bhi impoer krni or iska kaam text ko middle of the page mtlb phone screen ke middle me laa deta hai bss aksro ko ngi pure element ko pahle wale text ke
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Text(
            text = message,
            fontSize = 90.sp,            // ye greeting msg ke font(aksaro) ka size bdhasne ghtane e lie
            lineHeight = 116.sp,
            textAlign = TextAlign.Center// ise krne k lie import kia gya
        )
        Text(
            text = from,                     // ye wala Text jo bnaya h ye from wale text ka size or or from text mtlb kisne wish kia uske lie bna hai
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.End)
        )// ise vhi aksr size bdhta ghta hai or from function upr frun greeting() me pass bhi krna hai
    }
}
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier=Modifier){
    val image= painterResource(R.drawable.greetingbackgroundimage)// yha (.painterResouce) k lie import hua h or ha ye painter resource image ko load krke screen pe draw krne ka kaam krta hai or R.drawable.image us image ka unique address hota hai
    Box(modifier=modifier){                                    //or isme modifie bhi denge  or is function ke last me GreetingText ko call lrege ye add islie hua kuki ye kaam krta hai overlap krne kaa jase ki hme image ke upr text ko dikhana hai
        Image(    // is wale image  lie bhi ek line import hogi or abhi image k niche red line aayegi vo aage content description se theek hogi niche add krege
            painter = image,
            contentDescription=null,  // jo Image red line derha tha isse hi hee hua lgane se
                contentScale= ContentScale.Crop,// ise ye hua ki image ko uske frame ya container ke andar kaise fit ya stretch krna hai ye use control krta hai
                      alpha=0.5F,
                      modifier = Modifier.fillMaxSize()// ksis bhi image ko set krne k lie yha aata hai ye fillmaxsize na ki upr// alphs variable ki value aise di jaati hai isse image ki opacity modify hoti hai mtlb bakground image hlki si blur type
        )
        GreetingText(
            message=message,
            from= from,
            modifier= Modifier
                .fillMaxSize()  //ye kaam krta hai phone scren ko pura bhrne y cover krne k lie
                .padding(8.dp)
        )
    }
}// ye ek image add krega bacgrund me or isme text wala upr a function call kia jayega
@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappybirthdayTheme {
        GreetingImage(message= stringResource(R.string.happy_birthday_text),
            from= stringResource(R.string.signature_text)// ise extract bhi kia string resource se or jra sa modify sirf honey ki jgah text likh ke yja GreetingText ko GreetingImage kia ye image dikha dega design me screen pe or upr greeting text ko call krege tb text ayega ispe
        )
    }// jo sabd jaise likha hai same usi trah likhna hota hai nqa ki 1 space bhi faltu ya km
}// ab ye code all ok run hai coursek hisab se or



