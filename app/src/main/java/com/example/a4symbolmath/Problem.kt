package com.example.a4symbolmath

import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseUser

@ParseClassName("Problem")
class Problem: ParseObject() {

    fun getSign():String? {
        return getString(KEY_SIGN)
    }
    fun setSign(sign: String) {
        put(KEY_SIGN, sign)
    }
    fun getFirstNum():Int {
        return getInt(KEY_FIRST)
    }
    fun setFirstNum(first: Int) {
        put(KEY_FIRST, first)
    }
    fun getSecondNum():Int {
        return getInt(KEY_SECOND)
    }
    fun setSecondNum(second: Int) {
        put(KEY_SECOND, second)
    }
    fun getFave():Boolean{
        return getBoolean(KEY_FAVE)
    }
    fun setFave(fave: Boolean) {
        put(KEY_FAVE, fave)
    }
    fun getUser():ParseUser?{
        return getParseUser(KEY_USER)
    }
    fun setUser(user: ParseUser) {
        put(KEY_USER, user)
    }
    fun getTotalAttempts(): Int {
        return getInt(KEY_ATTEMPT)
    }
    fun setTotalAttempts(attempts : Int){
        put(KEY_ATTEMPT, attempts)
    }
    fun getAnswer() : Int {
        return getInt(KEY_ANSWER)
    }
    fun setAnswer(answer : Int) {
        put(KEY_ANSWER, answer)
    }

    companion object{
        const val KEY_SIGN = "sign"
        const val KEY_FIRST = "firstNum"
        const val KEY_SECOND = "secondNum"
        const val KEY_FAVE = "isFavorite"
        const val KEY_USER = "user"
        const val KEY_ATTEMPT = "totalAttempts"
        const val KEY_ANSWER = "answer"
    }
}