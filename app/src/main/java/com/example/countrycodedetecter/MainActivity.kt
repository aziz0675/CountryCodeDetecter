package com.example.countrycodedetecter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.car_number)
        textView = findViewById(R.id.errortext)

        editText.cardNumber(textView)

    }

    private fun getCountryCode():String?{
        var countryId: String?
        var countryCode: String? = null

         val telephonyManager = this.getSystemService(Context.TELEPHONY_SERVICE)
                 as TelephonyManager
        countryId = telephonyManager.simCountryIso.uppercase() // Davlatlarning nomlarini bosh harfini olib beradi va katta harf qiladi
        val arrCountryCode = this.resources.getStringArray(R.array.DialingCountryCode) // Davlatlarni telefon raqamlarini ID
        // sini olib beradi

        for (i in arrCountryCode.indices){
            var arrDial = arrCountryCode[i].split(",").toTypedArray()
            if (arrDial[1].trim() == countryId.trim()){
                countryCode == arrDial[0]
                break
            }
        }
        return countryCode
    }
}