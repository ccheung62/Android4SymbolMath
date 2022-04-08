package com.example.a4symbolmath

import com.parse.Parse
import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseUser

@ParseClassName("Problem")
class Problem: ParseObject() {
    fun getSign():String?{
        return getString(KEY_SIGN)
    }

    fun setSign(sign: String)
    {
        put(KEY_SIGN, sign)
    }

    fun getMax():Int{
        return getInt(KEY_MAX)
    }

    fun setMax(max: Int)
    {
        put(KEY_MAX, max)
    }

    fun getMin():Int{
        return getInt(KEY_MIN)
    }

    fun setMin(min: Int)
    {
        put(KEY_MIN, min)
    }

    fun getAns():Int{
        return getInt(KEY_ANS)
    }

    fun setAns(ans: Int)
    {
        put(KEY_ANS, ans)
    }

    fun getValid():Boolean{
        return getBoolean(KEY_VALID)
    }

    fun setValid(valid: Boolean)
    {
        put(KEY_VALID, valid)
    }

    fun getFave():Boolean{
        return getBoolean(KEY_FAVE)
    }

    fun setFave(fave: Boolean)
    {
        put(KEY_FAVE, fave)
    }

    fun getHist():Boolean{
        return getBoolean(KEY_HIST)
    }

    fun setHist(hist: Boolean)
    {
        put(KEY_HIST, hist)
    }

    fun getFirtry():Boolean{
        return getBoolean(KEY_FIRTRY)
    }

    fun setFirtry(firtry: Boolean)
    {
        put(KEY_FIRTRY, firtry)
    }

    fun getUser():ParseUser?{
        return getParseUser(KEY_USER)
    }

    fun setUser(user: ParseUser)
    {
        put(KEY_USER, user)
    }

    companion object{
        const val KEY_SIGN = "sign"
        const val KEY_MAX = "firstNum"
        const val KEY_MIN = "secondNum"
        const val KEY_ANS = "answer"
        const val KEY_VALID = "isCorrect"
        const val KEY_FAVE = "isFavorite"
        const val KEY_HIST = "isHistory"
        const val KEY_FIRTRY= "isCorrectFirstTry"
        const val KEY_USER = "user"
    }
}